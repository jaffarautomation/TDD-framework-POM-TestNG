package com.amazon.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amzon.qa.base.TestBase;
import com.amzon.qa.pages.LoginPage;
import com.amzon.qa.pages.SignupPage;

import junit.framework.Assert;

public class SignupPageTest extends TestBase {

	public SignupPageTest() throws Throwable {
		super();
		
	}

	
	SignupPage SignupPageReference;
	LoginPage LoginPageReference;
	
	@BeforeMethod
	public void setup() throws Throwable
	{
		initialization();
		
		 LoginPageReference =new LoginPage();
		
	}
	
	
	
	
	
	@Test(priority =1)
	public void fillform() throws Throwable
	{

		SignupPageReference = LoginPageReference.Registration();
		
		String errormessage = SignupPageReference.form();
		Assert.assertTrue(errormessage.contains("but an account already exists with the mobile phone number +918087184935 Details"));
	}
	
	
	
	
	
	
	@AfterMethod
	public void Teardown()
	{
		
		driver.quit();
	}

}
