package com.amazon.qa.helper.switchHelper.windowHelper;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.amazon.qa.helper.logger.LoggerHelper;
import com.amazon.qa.helper.wait.WaitHelper;



public class WindowHelper {

	private static WebDriver driver;
	private static Logger log = LoggerHelper.getlogger(WindowHelper.class);

	public WindowHelper(WebDriver driver) {
		this.driver = driver;

	}

	/**
	 * This method will switch to main window
	 */
	public static void SwitchToparentwindow()

	{
		log.info("Switching to parent window");
		driver.switchTo().defaultContent();
	}

	/**
	 * This method will switch to window based on index
	 * 
	 * @param index
	 */
	public static void SwitchToWindow(int index) {

		Set<String> window = driver.getWindowHandles();
		int i = 1;
		for (String string : window) {
			if (i == index) {
				driver.switchTo().window(string);
			} else {

				i++;
			}

		}

	}

	/**
	 * This method will close all the window and switch to main window
	 */
	public static void closealltabandSwitchtoMainWindow() {

		Set<String> allwindow = driver.getWindowHandles();
		String mainwindow = driver.getWindowHandle();

		for (String string : allwindow) {
			if (!string.equalsIgnoreCase(mainwindow))

			{
				driver.close();
			}

		}

		driver.switchTo().window(mainwindow);

	}

}
