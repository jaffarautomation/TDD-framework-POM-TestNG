package com.amazon.qa.testcases.CarttestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amzon.qa.base.TestBase;
import com.amzon.qa.pages.HomePage;
import com.amzon.qa.pages.LoginPage;
import com.amzon.qa.pages_CartsSections.CartSectionPage;
import com.amzon.qa.pages_catogories_Books.MoreInformationPageOnBook;
import com.amzon.qa.pages_catogories_Books.School_Book_page;
import com.amzon.qa.pages_catogories_Books.SocialStudiesBook;
import com.crm.qa.util.utilsTest;

public class CartSectionTest extends TestBase {

	public CartSectionTest() throws Throwable {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

	//Global Variable declaration
			LoginPage LoginPage;
			HomePage homepage;
			School_Book_page AllBooks;
			SocialStudiesBook SocialStudy;
			MoreInformationPageOnBook MoreBookInformation;
			CartSectionPage cartsectionpage;
			
			
			@BeforeMethod
			public void setup() throws Throwable
			{ 
				
				initialization();   // First it will call the init method
			    LoginPage =new LoginPage();   //This is the first class , so creating the object of it.
			    homepage =LoginPage.login(prop.getProperty("username"), prop.getProperty("password"));
			    AllBooks = homepage.NavigateToBook();
			    SocialStudy=  AllBooks.SelectTypesOfBooks();
			    
			    //This method will get the current window or parent window ID
			    utilsTest.ParentWindow();
			    MoreBookInformation= SocialStudy.clickfirstonbook();
			    //This method will switch to new tab or child window 
			    utilsTest.ChildWindow();
			    cartsectionpage = MoreBookInformation.ClickOnAddToCart();
			}
			
			
			
			//This method verify that book has or has not been added to cart.
			@Test(priority=1, enabled= true, alwaysRun = true)
			public void CartVerification()
			{  
				String Message =cartsectionpage.ToverifyproductAdded();
				System.out.println(Message);
				boolean value = Message.contains("Added");
				Assert.assertEquals(value, true, "Error occur: item not added to the cart");
				System.out.println("Item has been successfully added to the cart");
			}
			
			
			@AfterMethod
			public void teardown()
			{
				driver.quit();
			}
			
}
