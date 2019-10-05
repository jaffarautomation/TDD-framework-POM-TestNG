package com.crm.qa.util;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.amzon.qa.base.TestBase;

public class utilsTest extends TestBase{

	public utilsTest() throws Throwable {
		super();
		// TODO Auto-generated constructor stub
	}


	public static long PAGE_LOAD_TIMEOUT =30;
	public static long IMPLICIT_WAIT =40;
	
	

	
	public static void takesreen(WebDriver driver, String Screenshotname) throws Throwable
	{
		
		//type casting file
		   TakesScreenshot  ss = (TakesScreenshot)driver;
		   
		   //In below code Screenshot  is in form of file and storing in o reference
		File o = ss.getScreenshotAs(OutputType.FILE);
		

	    //in below code we are copying that o reference to your desired location.
	   FileHandler.copy(o, new File("./Screenshot/"+Screenshotname+".png"));
	}

}
