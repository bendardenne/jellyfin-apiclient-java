package org.jellyfin.apiclient.model.system;

import org.jellyfin.apiclient.model.updates.*;

/** 
 Class SystemInfo
*/
public class SystemInfo extends PublicSystemInfo
{
	private PackageVersionClass SystemUpdateLevel = PackageVersionClass.values()[0];
	public final PackageVersionClass getSystemUpdateLevel()
	{
		return SystemUpdateLevel;
	}
	public final void setSystemUpdateLevel(PackageVersionClass value)
	{
		SystemUpdateLevel = value;
	}

	/** 
	 Gets or sets the display name of the operating system.
	 
	 <value>The display name of the operating system.</value>
	*/
	private String OperatingSystemDisplayName;
	public final String getOperatingSystemDisplayName()
	{
		return OperatingSystemDisplayName;
	}
	public final void setOperatingSystemDisplayName(String value)
	{
		OperatingSystemDisplayName = value;
	}

	/** 
	 Gets or sets a value indicating whether [supports running as service].
	 
	 <value><c>true</c> if [supports running as service]; otherwise, <c>false</c>.</value>
	*/
	private boolean SupportsRunningAsService;
	public final boolean getSupportsRunningAsService()
	{
		return SupportsRunningAsService;
	}
	public final void setSupportsRunningAsService(boolean value)
	{
		SupportsRunningAsService = value;
	}

	/** 
	 Gets or sets the mac address.
	 
	 <value>The mac address.</value>
	*/
	private String MacAddress;
	public final String getMacAddress()
	{
		return MacAddress;
	}
	public final void setMacAddress(String value)
	{
		MacAddress = value;
	}

	private String PackageName;
	public final String getPackageName()
	{
		return PackageName;
	}
	public final void setPackageName(String value)
	{
		PackageName = value;
	}

	/** 
	 Gets or sets a value indicating whether this instance has pending restart.
	 
	 <value><c>true</c> if this instance has pending restart; otherwise, <c>false</c>.</value>
	*/
	private boolean HasPendingRestart;
	public final boolean getHasPendingRestart()
	{
		return HasPendingRestart;
	}
	public final void setHasPendingRestart(boolean value)
	{
		HasPendingRestart = value;
	}

	/** 
	 Gets or sets a value indicating whether [supports library monitor].
	 
	 <value><c>true</c> if [supports library monitor]; otherwise, <c>false</c>.</value>
	*/
	private boolean SupportsLibraryMonitor;
	public final boolean getSupportsLibraryMonitor()
	{
		return SupportsLibraryMonitor;
	}
	public final void setSupportsLibraryMonitor(boolean value)
	{
		SupportsLibraryMonitor = value;
	}

	/** 
	 Gets or sets the web socket port number.
	 
	 <value>The web socket port number.</value>
	*/
	private int WebSocketPortNumber;
	public final int getWebSocketPortNumber()
	{
		return WebSocketPortNumber;
	}
	public final void setWebSocketPortNumber(int value)
	{
		WebSocketPortNumber = value;
	}

	/** 
	 Gets or sets a value indicating whether this instance can self restart.
	 
	 <value><c>true</c> if this instance can self restart; otherwise, <c>false</c>.</value>
	*/
	private boolean CanSelfRestart;
	public final boolean getCanSelfRestart()
	{
		return CanSelfRestart;
	}
	public final void setCanSelfRestart(boolean value)
	{
		CanSelfRestart = value;
	}

	/** 
	 Gets or sets a value indicating whether this instance can self update.
	 
	 <value><c>true</c> if this instance can self update; otherwise, <c>false</c>.</value>
	*/
	private boolean CanSelfUpdate;
	public final boolean getCanSelfUpdate()
	{
		return CanSelfUpdate;
	}
	public final void setCanSelfUpdate(boolean value)
	{
		CanSelfUpdate = value;
	}

	/** 
	 Gets or sets plugin assemblies that failed to load.
	 
	 <value>The failed assembly loads.</value>
	*/
	private java.util.ArrayList<String> FailedPluginAssemblies;
	public final java.util.ArrayList<String> getFailedPluginAssemblies()
	{
		return FailedPluginAssemblies;
	}
	public final void setFailedPluginAssemblies(java.util.ArrayList<String> value)
	{
		FailedPluginAssemblies = value;
	}

	/** 
	 Gets or sets the program data path.
	 
	 <value>The program data path.</value>
	*/
	private String ProgramDataPath;
	public final String getProgramDataPath()
	{
		return ProgramDataPath;
	}
	public final void setProgramDataPath(String value)
	{
		ProgramDataPath = value;
	}

	/** 
	 Gets or sets the items by name path.
	 
	 <value>The items by name path.</value>
	*/
	private String ItemsByNamePath;
	public final String getItemsByNamePath()
	{
		return ItemsByNamePath;
	}
	public final void setItemsByNamePath(String value)
	{
		ItemsByNamePath = value;
	}

	/** 
	 Gets or sets the cache path.
	 
	 <value>The cache path.</value>
	*/
	private String CachePath;
	public final String getCachePath()
	{
		return CachePath;
	}
	public final void setCachePath(String value)
	{
		CachePath = value;
	}

	/** 
	 Gets or sets the log path.
	 
	 <value>The log path.</value>
	*/
	private String LogPath;
	public final String getLogPath()
	{
		return LogPath;
	}
	public final void setLogPath(String value)
	{
		LogPath = value;
	}

	/** 
	 Gets or sets the internal metadata path.
	 
	 <value>The internal metadata path.</value>
	*/
	private String InternalMetadataPath;
	public final String getInternalMetadataPath()
	{
		return InternalMetadataPath;
	}
	public final void setInternalMetadataPath(String value)
	{
		InternalMetadataPath = value;
	}

	/** 
	 Gets or sets the transcoding temporary path.
	 
	 <value>The transcoding temporary path.</value>
	*/
	private String TranscodingTempPath;
	public final String getTranscodingTempPath()
	{
		return TranscodingTempPath;
	}
	public final void setTranscodingTempPath(String value)
	{
		TranscodingTempPath = value;
	}

	/** 
	 Gets or sets the HTTP server port number.
	 
	 <value>The HTTP server port number.</value>
	*/
	private int HttpServerPortNumber;
	public final int getHttpServerPortNumber()
	{
		return HttpServerPortNumber;
	}
	public final void setHttpServerPortNumber(int value)
	{
		HttpServerPortNumber = value;
	}

	/** 
	 Gets or sets a value indicating whether [enable HTTPS].
	 
	 <value><c>true</c> if [enable HTTPS]; otherwise, <c>false</c>.</value>
	*/
	private boolean SupportsHttps;
	public final boolean getSupportsHttps()
	{
		return SupportsHttps;
	}
	public final void setSupportsHttps(boolean value)
	{
		SupportsHttps = value;
	}

	/** 
	 Gets or sets the HTTPS server port number.
	 
	 <value>The HTTPS server port number.</value>
	*/
	private int HttpsPortNumber;
	public final int getHttpsPortNumber()
	{
		return HttpsPortNumber;
	}
	public final void setHttpsPortNumber(int value)
	{
		HttpsPortNumber = value;
	}

	/** 
	 Gets or sets a value indicating whether this instance has update available.
	 
	 <value><c>true</c> if this instance has update available; otherwise, <c>false</c>.</value>
	*/
	private boolean HasUpdateAvailable;
	public final boolean getHasUpdateAvailable()
	{
		return HasUpdateAvailable;
	}
	public final void setHasUpdateAvailable(boolean value)
	{
		HasUpdateAvailable = value;
	}

	/** 
	 Gets or sets a value indicating whether [supports automatic run at startup].
	 
	 <value><c>true</c> if [supports automatic run at startup]; otherwise, <c>false</c>.</value>
	*/
	private boolean SupportsAutoRunAtStartup;
	public final boolean getSupportsAutoRunAtStartup()
	{
		return SupportsAutoRunAtStartup;
	}
	public final void setSupportsAutoRunAtStartup(boolean value)
	{
		SupportsAutoRunAtStartup = value;
	}

	private String EncoderLocationType;
	public final String getEncoderLocationType()
	{
		return EncoderLocationType;
	}
	public final void setEncoderLocationType(String value)
	{
		EncoderLocationType = value;
	}

	private Architecture SystemArchitecture = Architecture.values()[0];
	public final Architecture getSystemArchitecture()
	{
		return SystemArchitecture;
	}
	public final void setSystemArchitecture(Architecture value)
	{
		SystemArchitecture = value;
	}

	/** 
	 Initializes a new instance of the <see cref="SystemInfo" /> class.
	*/
	public SystemInfo()
	{
		setFailedPluginAssemblies(new java.util.ArrayList<String>());
	}
}