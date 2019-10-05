package com.amzon.qa.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.WebEventListener;
import com.crm.qa.util.utilsTest;

public class TestBase {


	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener e_eventdriver;
	
	//creating the constructor of this class
	public TestBase() throws Throwable 
	{
		
         prop =new Properties();
	    FileInputStream file = new FileInputStream("C:\\Users\\ADMIN\\eclipse-workspace1\\Amzontest\\src\\main\\java\\com\\amzon\\qa\\config\\config.properties");
		prop.load(file);
	}
	
	
	public static void initialization() 
	{
		
	String Browser=	prop.getProperty("browser");
	if(Browser.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver","F:\\selenium driver\\chromedriver.exe");
		 driver = new ChromeDriver();
	}else if(Browser.equals("ff"))
		
	{  System.setProperty("webdriver.gecko.driver","F:\\Software\\geckodriver.exe");
			driver =new FirefoxDriver();
	}
	
	

	e_driver = new EventFiringWebDriver(driver);
	try {
		e_eventdriver = new WebEventListener();
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	e_driver.register(e_eventdriver);
	
	driver=e_driver;
	
	
	
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(utilsTest.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(utilsTest.IMPLICIT_WAIT,TimeUnit.SECONDS);
	
	driver.get(prop.getProperty("URL"));
	
	
	
	
	
	}
	
	
	

}