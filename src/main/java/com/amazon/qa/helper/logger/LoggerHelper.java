package com.amazon.qa.helper.logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;



public class LoggerHelper {
	
	
	private static boolean root = false;

	public static Logger getlogger(Class cls) {

		if (root) {

			return Logger.getLogger(cls);
		}

		PropertyConfigurator.configure(
				"C:\\Users\\ADMIN\\eclipse-workspace1\\Amzontest\\src\\main\\resources\\Configuration\\log4j.properties");
		root = true;

		return Logger.getLogger(cls);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Logger log = LoggerHelper.getlogger(LoggerHelper.class);
		log.info("Logger");
	}

}
