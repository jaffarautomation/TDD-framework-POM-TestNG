	package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amzon.qa.base.TestBase;
import com.amzon.qa.pages.HomePage;
import com.amzon.qa.pages.LoginPage;
import com.amzon.qa.pages_catogories_Books.MoreInformationPageOnBook;
import com.amzon.qa.pages_catogories_Books.School_Book_page;
import com.amzon.qa.pages_catogories_Books.SocialStudiesBook;
import com.crm.qa.util.JavaScriptMethod;
import com.crm.qa.util.utilsTest;

public class MoreInformationOnbookTest extends TestBase {

	public MoreInformationOnbookTest() throws Throwable {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	//Global Variable declaration
			LoginPage LoginPage;
			HomePage homepage;
			School_Book_page AllBooks;
			SocialStudiesBook SocialStudy;
			MoreInformationPageOnBook MoreBookInformation;
			
			
			
			@BeforeMethod(groups = {"Regression"})
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
			}
			
			
		/*	This method verify the given title of the pages
			Scenario : When first book appears in the SocialBook page in amazon, it get clicked.
			Then a new page opens up with more information on that book, such as Addto cart options, buy now options, Add quantity options.
			Catch is the title of the page is dynamic, it contain a)Name of the book b)A standard static message
			
			For this purpose a method is created in SocialStudiesBook to get the name of the book and that method is now called in below method for verification of title of the current page
*/
			@Test(priority=1, enabled= true)
			public void Verificationoftitle()
			{
				String title =MoreBookInformation.VerifyTitle();
				System.out.println("The Title of the URL is :" + title);
				
				//Below method switch to parent window
				 utilsTest.DefaultWindow();
				 String Nameofthebook =	SocialStudy.getNameOfBook();
				 System.out.println("The title of the book is : "+ Nameofthebook);
				 
				 //Again switch to child window(Note : In this case switch to child window is not necessary)
				 utilsTest.ChildWindow();
				 
				boolean Value = title.contains(Nameofthebook);
		        Assert.assertEquals(Value, true, "Verification failed");
				
			}
			
	/*		
			This method is partially dynamic method because we are passing the value in method parameter in this class manually.
			I mean we are manipulating values in testcase method which is not a good practices
			But again said that this method can be truly dynamic, if we pass value from config file.
			For Ex: We can pass value like [prop.getproperty("key name in config file")]                      */
		
			@Test(priority=2, dependsOnMethods= {"Verificationoftitle"}, enabled= true, alwaysRun = true)
			public void SelectionOfQauntity()
			{
				MoreBookInformation.SelectQauntity(3);
			}
			
			
			@Test(priority =3)
			public void AddToCart() throws Throwable
			{
				
				MoreBookInformation.SelectQauntity(3);
				MoreBookInformation.ClickOnAddToCart();
				
			}
			
			
}
