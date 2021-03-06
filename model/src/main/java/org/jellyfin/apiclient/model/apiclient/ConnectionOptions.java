package org.jellyfin.apiclient.model.apiclient;

public class ConnectionOptions
{
	/** 
	 Gets or sets a value indicating whether [enable web socket].
	 
	 <value><c>true</c> if [enable web socket]; otherwise, <c>false</c>.</value>
	*/
	private boolean EnableWebSocket;
	public final boolean getEnableWebSocket()
	{
		return EnableWebSocket;
	}
	public final void setEnableWebSocket(boolean value)
	{
		EnableWebSocket = value;
	}
	/** 
	 Gets or sets a value indicating whether [report capabilities].
	 
	 <value><c>true</c> if [report capabilities]; otherwise, <c>false</c>.</value>
	*/
	private boolean ReportCapabilities;
	public final boolean getReportCapabilities()
	{
		return ReportCapabilities;
	}
	public final void setReportCapabilities(boolean value)
	{
		ReportCapabilities = value;
	}
	/** 
	 Gets or sets a value indicating whether [update date last accessed].
	 
	 <value><c>true</c> if [update date last accessed]; otherwise, <c>false</c>.</value>
	*/
	private boolean UpdateDateLastAccessed;
	public final boolean getUpdateDateLastAccessed()
	{
		return UpdateDateLastAccessed;
	}
	public final void setUpdateDateLastAccessed(boolean value)
	{
		UpdateDateLastAccessed = value;
	}

	public ConnectionOptions()
	{
		setEnableWebSocket(true);
		setReportCapabilities(true);
		setUpdateDateLastAccessed(true);
	}
}