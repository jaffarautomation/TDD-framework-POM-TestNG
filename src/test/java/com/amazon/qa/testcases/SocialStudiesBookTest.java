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

public class SocialStudiesBookTest extends TestBase {

	public SocialStudiesBookTest() throws Throwable {
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
		    SocialStudy=  AllBooks.SelectTypesOfBooks();
		    
		}
	
		
		//This method verify the title of the bookpage i.e Social Book page.If title failed error message will be display on console.
		//ScreenShot method is also called to take Screenshot for 
		@Test(priority =1, groups = {"Regression"})
		public void verificationOfSocialBookTitlePage() throws Throwable
		{
			
		        String Title= SocialStudy.VerifyTheTitle(); 
		        Assert.assertEquals("Amazon.in: Social Studies", "Amazon.in: Social Studies", "Verification failed");
		        //Assert.assertEquals("Amazon.in: Social Studies", "Amazon.in: Social Studies");
		        utilsTest.takesreen(driver, "SocialBook Title");
		}
		
		
		//This method will print the name of the book which is first on the list of the page
		
		@Test(priority = 2, dependsOnMethods= {"verificationOfSocialBookTitlePage"})
		public void NameofBook()
		{
			
			String Name =SocialStudy.getNameOfBook();
			System.out.println(Name);
		}
	
		//This method will call the method from SocialStudiesBook class from pages package and click on the first book available from the page.
		//Also this method is depends on "verificationOfSocialBookTitlePage". 
		@Test(priority=2, dependsOnMethods= {"verificationOfSocialBookTitlePage"},groups = {"Regression"})
		public void ClickOnTheFirstSocailBook() throws Throwable
		{
			SocialStudy.clickfirstonbook();
		}
		
		
		
		@AfterMethod(groups = {"Regression"})
		public void teardown()
		{
			driver.quit();
		}
	
}
