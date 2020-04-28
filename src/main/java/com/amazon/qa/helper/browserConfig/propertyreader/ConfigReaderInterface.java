package com.amazon.qa.helper.browserConfig.propertyreader;

public interface ConfigReaderInterface {

	public int getImplicitWaitTime();

	public int getexplicitWaitTime();

	public int getPageLoadTime();
	
	public String getBrowserType();
	
	public String getURL();
	
	public String getUserName();
	
	public String getPassword();

}
