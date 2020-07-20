package com.amazon.qa.helper.switchHelper.activeHelper;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.amazon.qa.helper.logger.LoggerHelper;
import com.amazon.qa.helper.switchHelper.alertHelper.AlertHelper;
import com.amzon.qa.base.TestBase;

public class ActiveElementHelper extends TestBase {

	public ActiveElementHelper() throws Throwable {
		super();
		// TODO Auto-generated constructor stub
	}
	
	private static Logger log = LoggerHelper.getlogger(AlertHelper.class);
	
	
	//This method return the focus of active element on web page
	public static WebElement ActiveElementFocus()
	{
		
		return driver.switchTo().activeElement();
	}


}
