<h1 align="center">jellyfin-apiclient-java</h1>
<h3 align="center">Part of the <a href="https://jellyfin.media">Jellyfin Project</a></h3>

<p align="center">
<a href="https://github.com/jellyfin/jellyfin-apiclient-java/blob/master/LICENSE.md"><img alt="MIT license" src="https://img.shields.io/github/license/jellyfin/jellyfin-apiclient-java.svg"></a>
<a href="https://jitpack.io/#jellyfin/jellyfin-apiclient-java"><img alt="Current Release" src="https://jitpack.io/v/jellyfin/jellyfin-apiclient-java.svg"></a>
<a href="https://dev.azure.com/jellyfin-project/jellyfin/_build/latest?definitionId=6&branchName=master"><img alt="Azure DevOps builds" src="https://dev.azure.com/jellyfin-project/jellyfin/_apis/build/status/Jellyfin%20API%20Client%20Java%20CI?branchName=master"></a>
</p>

---

This library allows Android clients to easily access the Jellyfin API. It is built with Volley, OkHttp, Boon, and Robolectric. The dependencies are modular and can easily be swapped out with alternate implementations when desired.

## Single Server Example

This is an example of connecting to a single server using a fixed address from an app that has requires a user login.

``` java
// Developers should create their own logger implementation
logger = new NullLogger();

// The underlying http stack. Developers can inject their own if desired
IAsyncHttpClient httpClient = new VolleyHttpClient(logger, getApplicationContext());

// The JSON serializer. Developers can inject their own if desired.
IJsonSerializer jsonSerializer = new GsonJsonSerializer();

// Android developers should use AndroidDevice
IDevice device = new Device("deviceId", "deviceName");

ApiClient apiClient = new ApiClient(httpClient, jsonSerializer, logger, "http://localhost:8096", "My app name", "app version 123", device, new ApiEventListener());

apiClient.AuthenticateUserAsync("username", "password", new Response<AuthenticationResult>() {
    @Override
    public void onResponse(AuthenticationResult result) {
        // Authentication succeeded
    }

    @Override
    public void onError() {
        // Authentication failed
    }
});
```

The **ServerLocator** class can be used to discover servers on the local network, although it is recommended to handle that via a **ConnectionManager**, which is discussed later on in this document.

## Service Apps

If your app is some kind of service or utility (e.g. Sickbeard), you should construct ApiClient with an API key supplied by your users.

``` java
// Developers should create their own logger implementation
logger = new NullLogger();

// The underlying http stack. Developers can inject their own if desired
IAsyncHttpClient httpClient = new VolleyHttpClient(logger, getApplicationContext());

// The JSON serializer. Developers can inject their own if desired.
IJsonSerializer jsonSerializer = new GsonJsonSerializer();

// Services should just authenticate using their api key
ApiClient apiClient = new ApiClient(httpClient, jsonSerializer, logger, "http://localhost:8096", "apikey", new ApiEventListener());
```

## Web Socket

Once you have an ApiClient instance you can easily connect to the server's web socket using the following command.

``` java
ApiClient.OpenWebSocket();
```

This will open a connection in a background thread, and periodically check to ensure it's still connected. The web socket provides various events that can be used to receive notifications from the server. Simply override the methods in ApiEventListener:

``` java
@Override
public void onSetVolumeCommand(int value) {
}
```

## Multi-Server Usage

The above examples are designed for cases when your app always connects to a single server, and you always know the address. If your app is designed to support multiple networks and/or multiple servers, then **IConnectionManager** should be used in place of the above example.

IConnectionManager features:

- Supports connection to multiple servers
- Automatic local server discovery
- Wake on Lan
- Automatic LAN to WAN failover

``` java
// Android developer should use AndroidCredentialProvider
ICredentialProvider credentialProvider = new CredentialProvider();

INetworkConnection networkConnection = new NetworkConnection(logger);

// The JSON serializer. Developers can inject their own if desired.
IJsonSerializer jsonSerializer = new GsonJsonSerializer();

// Developers are encouraged to create their own ILogger implementation
ILogger logger = new NullLogger();

IServerLocator serverLocator = new ServerLocator(logger);

// The underlying http stack. Developers can inject their own if desired
IAsyncHttpClient httpClient = new VolleyHttpClient(logger, getApplicationContext());

// Android developers should use AndroidDevice
IDevice device = new Device("deviceId", "deviceName");

// This describes the device capabilities
ClientCapabilities capabilities = new ClientCapabilities();

ApiEventListener eventListener = new ApiEventListener();

// Android developers should use AndroidConnectionManager
IConnectionManager connectionManager = new ConnectionManager(credentialProvider,
    networkConnection,
    logger,
    serverLocator,
    httpClient,
    "My app name"
    "1.0.0.0",
    device,
    capabilities,
    eventListener);
```

## Multi-Server Startup Workflow

After you've created your instance of IConnectionManager, simply call the Connect method. It will return a result object with three properties:

- State
- ServerInfo
- ApiClient

ServerInfo and ApiClient will be null if State == Unavailable. Let's look at an example.

``` java
connectionManager.Connect(new Response<ConnectionResult>() {
    @Override
    public void onResponse(ConnectionResult result) {
        switch (result.getState()) {
            case ConnectionState.ConnectSignIn:
                // Connect sign in screen should be presented
                // Authenticate using LoginToConnect, then call Connect again to start over
            case ConnectionState.ServerSignIn:
                // A server was found and the user needs to login.
                // Display a login screen and authenticate with the server using result.ApiClient
            case ConnectionState.ServerSelection:
                // Multiple servers available
                // Display a selection screen by calling GetAvailableServers
                // When a server is chosen, call the Connect overload that accept either a ServerInfo object or a String url.
            case ConnectionState.SignedIn:
                // A server was found and the user has been signed in using previously saved credentials.
                // Ready to browse using result.ApiClient
        }
    }
);
```

When the user wishes to logout of the individual server simply call apiClient.Logout() with no special parameters. If the user will to connect to a new server use the Connect overload which accepts an address for the new server.

``` java
String address = "http://192.168.1.174:8096";
connectionManager.Connect(address, new Response<ConnectionResult>() {
    @Override
    public void onResponse(ConnectionResult result) {
        switch (result.State) {
            case ConnectionState.Unavailable:
                // Server unreachable
            case ConnectionState.ServerSignIn:
                // A server was found and the user needs to login.
                // Display a login screen and authenticate with the server using result.ApiClient
            case ConnectionState.SignedIn:
                // A server was found and the user has been signed in using previously saved credentials.
                // Ready to browse using result.ApiClient
        }
    }
);
```

If at anytime the RemoteLoggedOut event is fired, simply start the workflow all over again by calling connectionManager.Connect().

ConnectionManager will handle opening and closing web socket connections at the appropiate times. All your app needs to do is use an ApiClient instance to subscribe to individual events.

``` java
@Override
public void onSetVolumeCommand(int value) {
}
```

With multi-server connectivity it is not recommended to keep a global ApiClient instance, or pass an ApiClient around the application. Instead keep a factory that will resolve the appropriate ApiClient instance depending on context. In order to help with this, ConnectionManager has a GetApiClient method that accepts a BaseItemDto and returns an ApiClient from the server it belongs to.

## Android Usage

Android is fully supported, and special subclasses are provided for it:

- AndroidConnectionManager
- AndroidApiClient

AndroidApiClient includes a getImageLoader() method that will return a Volley ImageLoader.

At minimum, this library requires the following permissions declared in AndroidManifest.xml:

- INTERNET
- ACCESS_NETWORK_STATE
- READ_EXTERNAL_STORAGE

Special thanks to [Tangible Software Solutions](http://www.tangiblesoftwaresolutions.com/ "Tangible Software Solutions") for donating a license to our project.
