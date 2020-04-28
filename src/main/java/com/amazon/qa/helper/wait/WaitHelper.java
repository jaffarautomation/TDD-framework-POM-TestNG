package com.amazon.qa.helper.wait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.qa.helper.logger.LoggerHelper;
import com.amzon.qa.base.TestBase;

public class WaitHelper extends TestBase {

	private static Logger log = LoggerHelper.getlogger(WaitHelper.class);

	public WaitHelper() throws Throwable {
		super();
	}

	/**
	 * This method set the implicit wait 
	 * Note: As this class extends TestBase Class, driver reference has already been initialized
	 * 
	 * @param timeout
	 * @param unit
	 */
	public static void SetImplicitWait(long timeout, TimeUnit unit)

	{
		log.info("Implicit wait set to :" + timeout +" "+"SECONDS");
		try {
			driver.manage().timeouts().implicitlyWait(timeout, unit);
		} catch (NullPointerException e) {

			log.info("No Driver Object found ");
			System.out.println(e.fillInStackTrace());

		}

	}

	/**
	 * This method set the PageLoad Timeout wait 
	 * Note: As this class extends TestBase Class, driver reference has already been initialized
	 * 
	 * @param timeout
	 * @param unit
	 */
	public static void SetpageloadTimeout(long timeout, TimeUnit unit)

	{
		log.info("Page Load time set to : " + timeout+ " "+  unit);
		try

		{
			driver.manage().timeouts().pageLoadTimeout(timeout, unit);
		} catch (NullPointerException e) {

			log.info("No Driver Object found ");
			System.out.println(e.fillInStackTrace());

		}

	}

	/**
	 * This method set the Explicit wait 
	 * Note: As this class extends TestBase Class, driver reference has already been initialized
	 * 
	 * @param timeout
	 * @param unit
	 */
	public static WebElement SetExplicitWait(WebDriver driver, long time, WebElement element)

	{
		log.info("Set Explicit Wait to  :" + Duration.ofSeconds(time));
		WebDriverWait r = new WebDriverWait(driver, Duration.ofSeconds(time));
		WebElement status = r.until(ExpectedConditions.visibilityOf(element));
		return status;

	}

	public static Wait<WebDriver> getFluentwait(int Timeoutinsecond, int pollingInterval) {
		Wait<WebDriver> flent = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(Timeoutinsecond))
				.pollingEvery(Duration.ofSeconds(pollingInterval)).ignoring(NoSuchElementException.class);
		return flent;
	}

	public static WebElement WaitforElementwithPollingInterval(WebElement element, int Timeoutinsecond,
			int pollingInterval) {

		Wait<WebDriver> wait = getFluentwait(Timeoutinsecond, pollingInterval);
		WebElement status = wait.until(ExpectedConditions.visibilityOf(element));
		return status;
	}

	public static WebElement WaitforElementwithoutPollingInterval(WebDriver driver, long time, WebElement element) {

		WebElement r = SetExplicitWait(driver, time, element);
		return r;
	}

}
