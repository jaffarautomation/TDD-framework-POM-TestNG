package com.amzon.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.amazon.qa.helper.browserConfig.propertyreader.configFilereader;
import com.amazon.qa.helper.logger.LoggerHelper;
import com.amazon.qa.helper.seleniumHelperUtility.window.WindowHelper;
import com.amazon.qa.helper.wait.WaitHelper;
import com.crm.qa.util.WebEventListener;
import com.crm.qa.util.utilsTest;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener e_eventdriver;
	public static configFilereader Config;

	static Logger log = LoggerHelper.getlogger(TestBase.class);

	/***
	 * This Constructor is used to initialize the properties class
	 * 
	 * @throws Throwable
	 */
	public TestBase() throws Throwable {

		prop = new Properties();
		FileInputStream file = new FileInputStream(
				"C:\\Users\\ADMIN\\eclipse-workspace1\\Amzontest\\src\\main\\resources\\Configuration\\config.properties");
		prop.load(file);

	}

	public static void initialization() {

		log.info("Browser Initialization is started");
		try {
			Config = new configFilereader();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String Browser = Config.getBrowserType();
		if (Browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "F:\\selenium driver\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (Browser.equals("firefox"))

		{
			System.setProperty("webdriver.gecko.driver", "F:\\Software\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

	/*	e_driver = new EventFiringWebDriver(driver);
		try {
			e_eventdriver = new WebEventListener();
		} catch (Throwable e) {
			e.printStackTrace();
		}

		e_driver.register(e_eventdriver);

		driver = e_driver;
*/
		WindowHelper.MaximizeWindow();
		// driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		// driver.manage().timeouts().pageLoadTimeout(utilsTest.PAGE_LOAD_TIMEOUT,
		// TimeUnit.SECONDS);
		// driver.manage().timeouts().implicitlyWait(utilsTest.IMPLICIT_WAIT,
		// TimeUnit.SECONDS);
		WaitHelper.SetImplicitWait(Config.getImplicitWaitTime(), TimeUnit.SECONDS);
		WaitHelper.SetpageloadTimeout(Config.getPageLoadTime(), TimeUnit.SECONDS);
		driver.get(Config.getURL());
		log.info("Browser Initialization ended");

	}

	// We have created a screenshot method which will take screenshot for only
	// failed testcases.
	// In other word we are only calling this method under failed method of custom
	// lister testng class which is implements the ItestListners interface
	public static void failed(String MethodName) throws IOException {

		// type casting file
		TakesScreenshot ss = (TakesScreenshot) driver;

		// In below code Screenshot is in form of file and storing in o reference
		File o = ss.getScreenshotAs(OutputType.FILE);

		// in below code we are copying that o reference to your desired location.
		FileHandler.copy(o, new File(
				"C:\\Users\\ADMIN\\eclipse-workspace1\\Amzontest\\FailedTestCases\\" + MethodName + "_" + ".png"));
	}

}