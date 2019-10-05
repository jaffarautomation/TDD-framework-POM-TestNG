package com.crm.qa.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptMethod {


	//This will scroll the web page till end.
		public static void scroll(WebDriver driver)
	{
			//type casting
		JavascriptExecutor  Js = ((JavascriptExecutor)driver);
		Js.executeScript("window.scrollTo(0, document.body.scrollHeight)");	
		}
	
	
	
	
	//This will scroll the page till the element is found
	public static void scrolltillvisible(WebDriver driver, WebElement Element)
	{
		//type casting
		JavascriptExecutor  Js = ((JavascriptExecutor)driver);
       Js.executeScript("arguments[0].scrollIntoView(true);", Element);
       
		}
	
	
	public static void scrollby(WebDriver driver)
	{
		//type casting
		JavascriptExecutor  Js = ((JavascriptExecutor)driver);
       Js.executeScript("arguments[0].scrollby(0,1000)");
       
		}

}
