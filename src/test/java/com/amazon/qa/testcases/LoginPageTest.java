package com.amazon.qa.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.amzon.qa.base.TestBase;
import com.amzon.qa.pages.HomePage;
import com.amzon.qa.pages.LoginPage;
import com.crm.qa.util.CustomListerTestNG;
import com.crm.qa.util.RetryTestAnalyzer;

import DataProvider.LoginDataUtility;
import junit.framework.Assert;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

@Listeners(CustomListerTestNG.class)

public class LoginPageTest extends TestBase{

	LoginPage object1;

	
	public LoginPageTest() throws Throwable   
	{
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
	
	//Data provider is created to pass value on Loginintopage method
	@DataProvider
	public Iterator<Object[]> GetData()
	{
		ArrayList<Object []> m =LoginDataUtility.getdatafromexcel();
	  return m.iterator();
	}
	
	//In below code we are passing the Username and Password from excel with the help of dataprovider 
	@Test(priority=2, enabled =true, dataProvider ="GetData")
	public void loginIntoPage(String userN, String Pass) throws Throwable
	{
		 HomePage homepage = object1.login(userN, Pass);
	}
	
	
	@AfterMethod
	public void close()
	{
	     driver.quit();	
	}
	
	
}
