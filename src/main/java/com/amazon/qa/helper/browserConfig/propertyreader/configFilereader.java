package com.amazon.qa.helper.browserConfig.propertyreader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.amazon.qa.helper.logger.LoggerHelper;
import com.amzon.qa.base.TestBase;

public class configFilereader extends TestBase implements ConfigReaderInterface {

	public configFilereader() throws Throwable {

		// TODO Auto-generated constructor stub
	}

	static Logger log = LoggerHelper.getlogger(configFilereader.class);

	public int getImplicitWaitTime() {

		return Integer.parseInt(prop.getProperty("implicitWait"));

	}

	public int getexplicitWaitTime() {

		return Integer.parseInt(prop.getProperty("explicitWait"));

	}

	public int getPageLoadTime() {

		return Integer.parseInt(prop.getProperty("pageloadtime"));

	}

	public String getBrowserType() {

		String browser = prop.getProperty("browserType");
		log.info("returned browser type is :" +browser);
		return browser;
	}

	public String getURL() {
		
		 String URL =prop.getProperty("URL");
		 log.info("retured URL is : " +URL);
		 return URL;
	}

	public String getUserName() {
		
		      return  prop.getProperty("username");
	}

	public String getPassword() {
		
		return prop.getProperty("password");
	}

}
