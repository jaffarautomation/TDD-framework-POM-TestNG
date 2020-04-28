package com.amazon.qa.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.amazon.qa.helper.logger.LoggerHelper;
import com.amzon.qa.base.TestBase;
import com.amzon.qa.pages.HomePage;
import com.amzon.qa.pages.LoginPage;
import com.qa.ExtendreportListerner.TestListener;
import com.crm.qa.util.RetryTestAnalyzer;

import DataProvider.LoginDataUtility;
import junit.framework.Assert;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

@Listeners(com.qa.ExtendreportListerner.TestListener.class)

public class LoginPageTest extends TestBase{

	static Logger log = LoggerHelper.getlogger(LoginPageTest.class);
	LoginPage LoginPage;

	
	public LoginPageTest() throws Throwable   
	{
		super();
	}

	
	@BeforeMethod(groups = {"Regression"})
	public void setup() throws Throwable
	{
		 TestBase.initialization();
		 LoginPage = new LoginPage();
		
		 
	}
	
	
	@Test(priority =1  )
	public void ToVerifyThePageTitle() throws Throwable
	{
		
		String currenttitle =LoginPage.validatetitle();
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
	
	
	//We can also pass values by creating parameter in TestNg.xml file
	//We can provide username and password from config file 
	//In below code we are passing the Username and Password from excel with the help of dataprovider 
/*	@Test(priority=2, enabled =true, dataProvider ="GetData")
	public void loginIntoPage(String userN, String Pass) throws Throwable
	{
		 HomePage homepage = object1.login(userN, Pass);
	}*/
	
	
	@Test(priority=2, enabled =true, groups = {"Regression"})
	public void ToverifyLoginFunctionality() throws Throwable
	{
		
		 LoginPage.login(Config.getUserName(),Config.getPassword());
	}
	
	@AfterMethod(groups = {"Regression"})
	public void close()
	{
	     driver.quit();	
	}
	
	
}
