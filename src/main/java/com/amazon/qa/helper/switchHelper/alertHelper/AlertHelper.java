package com.UIFramework.companyname.projectName.helper.alert;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import com.UIFramework.companyname.projectName.helper.logger.LoggerHelper;
import com.UIFramework.companyname.projectName.helper.wait.WaitHelper;

public class AlertHelper {

	private static WebDriver driver;
	private static Logger log = LoggerHelper.getlogger(WaitHelper.class);

	public AlertHelper(WebDriver driver) {
		this.driver = driver;

	}

	public static Alert switchToAlert() {
		log.info("Switch to Alert with name:" + driver.switchTo().alert().getText());
		return driver.switchTo().alert();
	}

	public static void acceptAlert() {

		switchToAlert().accept();
		log.info("Alert accept is done");

	}

	public static void dismissAlert() {

		switchToAlert().dismiss();
		;
		log.info("Alert dismiss is done");

	}

	public static void getAlertText() {

		switchToAlert().getText();
		log.info("Alert text is : " + switchToAlert().getText());

	}

	public static boolean Alertpresent() {
		try {

			driver.switchTo().alert();
			log.info("Alert is present");
			return true;
		} catch (NoAlertPresentException e) {
			log.info(e.getMessage());
			return false;
		}

	}

	public static void AcceptAlertIfpresent() {

		boolean status = Alertpresent();
		if (status) {

			switchToAlert();
		} else {

			log.info("Alert is not present");
		}
	}

	public static void DismissAlertIfpresent() {

		boolean status = Alertpresent();
		if (status) {

			dismissAlert();
		} else {

			log.info("Alert is not present");
		}
	}
	
	
	

}
