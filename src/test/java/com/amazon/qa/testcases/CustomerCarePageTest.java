package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amzon.qa.base.TestBase;
import com.amzon.qa.pages.CustomercarePAge;
import com.amzon.qa.pages.HomePage;
import com.amzon.qa.pages.LoginPage;

public class CustomerCarePageTest extends TestBase {

	public CustomerCarePageTest() throws Throwable {
		super();
		
	}

	LoginPage LoginPageReference;
	CustomercarePAge CustomerCarreference;
	HomePage HomePageReference;
	
	@BeforeMethod(groups = {"Regression"})
	public void setup() throws Throwable
	{
		
		initialization();
		 CustomerCarreference = new CustomercarePAge();
	     LoginPageReference = new LoginPage();
	     HomePageReference= LoginPageReference.login(prop.getProperty("username"), prop.getProperty("password")); 
	     HomePageReference.Clickoncustomerservice();
	
	}
	
	@Test(priority =1)
	public void verifytexton_CustomercarePage()
	
	{
	    String actualname= 	CustomerCarreference.nametext_verify();
		Assert.assertEquals(actualname, "Hi, Deepika. What can we help you with?", "Incorrect message is display, method failed");
		
	}
	
	
	
	
	@AfterMethod(groups = {"Regression"})
	public void teardown()
	{
		
		driver.quit();
	}

}
