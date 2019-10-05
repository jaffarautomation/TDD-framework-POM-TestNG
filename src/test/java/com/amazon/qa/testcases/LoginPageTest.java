package com.amazon.qa.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amzon.qa.base.TestBase;
import com.amzon.qa.pages.HomePage;
import com.amzon.qa.pages.LoginPage;

import junit.framework.Assert;


import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class LoginPageTest extends TestBase{

	LoginPage object1;

	
	public LoginPageTest() throws Throwable {
		super();
		
	}

	
	@BeforeMethod
	public void setup() throws Throwable
	{
		TestBase.initialization();
		 object1 = new LoginPage();
		
		 
	}
	
	
	@Test(priority =1)
	public void titletest() throws Throwable
	{
		String currenttitle =object1.validatetitle();
		System.out.println(currenttitle);
	//	Assert.assertEquals("Amazon Sign In", currenttitle);
		
		
		//Another way to use the assert equals
	boolean s=	currenttitle.contains("Shopping");
		Assert.assertEquals("Title does not match", true, s);
	}
	
	
	@Test(priority=2)
	public void loginIntoPage() throws Throwable
	{
		 HomePage homepage = object1.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void close()
	{
	driver.quit();	
	}
	
	
}
