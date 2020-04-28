package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amzon.qa.base.TestBase;
import com.amzon.qa.pages.HomePage;
import com.amzon.qa.pages.LoginPage;
import com.amzon.qa.pages_catogories_Books.School_Book_page;
import com.amzon.qa.pages_catogories_Books.SocialStudiesBook;
import com.crm.qa.util.utilsTest;

public class School_BookTest extends TestBase {


	public School_BookTest() throws Throwable {
		super();
		// TODO Auto-generated constructor stub
	}


	
	//Global Variable declaration
	LoginPage LoginPage;
	HomePage homepage;
	School_Book_page AllBooks;
	SocialStudiesBook SocialStudy;
	
	
	
	
	@BeforeMethod(groups = {"Regression"})
	public void setup() throws Throwable
	{ 
		
		initialization();   // First it will call the init method
	    LoginPage =new LoginPage();   //This is the first class , so creating the object of it.
	    homepage =LoginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	    AllBooks = homepage.NavigateToBook();
	}
	
	
	//This method verify the title of the bookpage
	@Test(priority =1)
	public void verificationOfBookTitlePage() throws Throwable
	{
		
	        String Title= AllBooks.VerifyBooksPageTitle_Page();
	        Assert.assertEquals("School Books:", "School Books:");
	        utilsTest.takesreen(driver, "book");
	}
	
	
	
	//This method navigate to Social science book page
	@Test(priority=2, groups = {"Regression"})
	public void NavigationTOSocailScienceBook_Page() throws Throwable
	{
		SocialStudy=AllBooks.SelectTypesOfBooks();
	}
	
	
	@AfterMethod(groups = {"Regression"})
	public void teardown()
	{
		driver.quit();
	}
	
	

}
