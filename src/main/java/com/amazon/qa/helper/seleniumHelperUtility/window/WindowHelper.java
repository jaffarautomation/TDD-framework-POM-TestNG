package com.amazon.qa.helper.seleniumHelperUtility.window;

import org.openqa.selenium.Dimension;

import com.amzon.qa.base.TestBase;

public class WindowHelper extends TestBase {

	public WindowHelper() throws Throwable {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public static void MaximizeWindow()
	{
		
		
		driver.manage().window().maximize();
	}
	
	public static void FullScreen()
	{
		
		
		driver.manage().window().fullscreen();
	}
	
	public static void SetWindowSize(int width,int height)
	{
		
		Dimension r = new Dimension(width, height);
		driver.manage().window().setSize(r);
	}
	
	

}
