package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amzon.qa.pages.CustomercarePAge;
import com.amzon.qa.pages.HomePage;
import com.amzon.qa.pages.LoginPage;
import com.amzon.qa.pages_catogories_Books.School_Book_page;
import com.amzon.qa.base.TestBase;

public class HomePageTest extends TestBase {

	
	
	LoginPage LoginPage;
	HomePage homepage;
	CustomercarePAge Customercare_variable;
	School_Book_page SchoolsBook;
	
	
	public HomePageTest() throws Throwable
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@BeforeMethod
	public void setup() throws Throwable
	{ 
		
		initialization();
	    LoginPage =new LoginPage();
        homepage =LoginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	
	}

	
	
	//This method verify the Username
	@Test (priority =1)
	public void verifyusername()
	{
		
	String actualname=	homepage.verifyusername();
		
	Assert.assertEquals(actualname, "Hello, Deepika");
	}
	
	
	@Test(priority =4, dependsOnMethods = {"verifyusername"}, enabled =false)
	public void click_on_CC() throws Throwable
	{
		Customercare_variable =homepage.Clickoncustomerservice();
		
	}
	
	
	//This method click on the All categories side bar button
	@Test(priority =2, dependsOnMethods = {"verifyusername"}, enabled =false)
	public void NavigateToAllCatogoriesInAmazon()
	{
		
		homepage.NavigateToAllCatogoriesOptions();
	}
	
	//This method click on the Book category and select the desired category of books options present
	//In NavigateToBook method we can pass the type of books options.
	//For ex: i have passed School textbook type in books category.
	
	@Test(priority =3)
	public void Navigatetobook() throws Throwable
	
	{
		
		SchoolsBook  = homepage.NavigateToBook();
	}
	
	
	//We cant use below method because this method is present on customercare page. and this is home page class
	//so we need to use this method on customercare page
	/*
	@Test(priority =3)
	public void textverification() throws Throwable
	{
		
		homepage.Clickoncustomerservice();
		String actualname =Customercare_variable.nametext_verify();
		Assert.assertEquals(actualname, "Hi, Deepika. What can we help you with?", "Incorrect message is display, method failed");
	}*/
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
