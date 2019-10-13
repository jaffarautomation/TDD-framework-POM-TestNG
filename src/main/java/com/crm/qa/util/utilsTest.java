package com.crm.qa.util;

import java.io.File;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.amzon.qa.base.TestBase;

public class utilsTest extends TestBase{
	
	
	
	static String  ParentWindow;

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

	
	
	//This method will return the parent window ID
	public static void ParentWindow()
	{
		 ParentWindow = driver.getWindowHandle();
		System.out.println("Parent Window or Current Open TAB ID is : " +ParentWindow);
	}
	
	
	//This method is design to switch from parent window to child window
	public static void ChildWindow()
	{
	Set<String> NoofWindow =	driver.getWindowHandles();
	System.out.println(NoofWindow);
	System.out.println(NoofWindow.size());
	
	for (String childwindow : NoofWindow) {
		
		if(!ParentWindow.equals(childwindow))
		{
			
			driver.switchTo().window(childwindow);
			System.out.println("Switch to New Tab or Child window was successfull");
			break;
		}
	}}
	
	
	//This method will switchto the initial or parent window
	public static void DefaultWindow()
	{
		
		driver.switchTo().window(ParentWindow);
		System.out.println("Switch to parent window again successfully");
	}
	
}
