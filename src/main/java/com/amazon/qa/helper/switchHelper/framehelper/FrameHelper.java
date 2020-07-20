package com.amazon.qa.helper.switchHelper.framehelper;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.amazon.qa.helper.logger.LoggerHelper;
import com.amzon.qa.base.TestBase;

public class FrameHelper extends TestBase {

	public FrameHelper() throws Throwable {
		super();
		// TODO Auto-generated constructor stub
	}

	static WebDriver driver;
	static Logger log = LoggerHelper.getlogger(FrameHelper.class);

	/**
	 * This method will switch to frame based on frame index
	 * 
	 * @param index
	 */

	public static void SwitchtoFrame(int index) {

		driver.switchTo().frame(index);
		log.info("Switch to frame for Indx : " + index);

	}

	/**
	 * This method will switch to frame based on webelement
	 * 
	 * @param element
	 */
	public static void SwitchtoFrame(WebElement element) {

		driver.switchTo().frame(element);
		log.info("Switch to frame with Webelement name : " + element);

	}

	public static void SwitchtoFrame(String FrameName) {

		driver.switchTo().frame(FrameName);
		log.info("Switch to frame with name : " + FrameName);

	}
}
