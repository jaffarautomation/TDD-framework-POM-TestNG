package com.amzon.qa.pages_catogories_Books;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

import com.amzon.qa.base.TestBase;
import com.amzon.qa.pages.CustomercarePAge;
import com.amzon.qa.pages.HomePage;
import com.amzon.qa.pages.LoginPage;
import com.crm.qa.util.JavaScriptMethod;
import com.crm.qa.util.utilsTest;



//This class belongs to the catogory section of books &audio. 

//The object of this class is return from the HomePage class from NavigateToBook method.

public class School_Book_page extends TestBase {

	
	public School_Book_page() throws Throwable {
		PageFactory.initElements(driver, this);
		
	}
	
	
	    // pagefactory -> OR
		@FindBy(xpath="//img[@alt='School books']")
        WebElement TitleName;	
		
		
		@FindBy(xpath="//div[@class='a-row']/div/div/a/div/span")
        List<WebElement> ShopBySubject;	
		
	
		
		
		//This method verify the title of the page
		public String VerifyBooksPageTitle_Page()
		{
			
			return driver.getTitle();
		
			
		}
	
	
		
		//Used  advance for loop to iterate the values.
		//Following values are present inside the list social, physics, biology etc. total 4 values
		//We can make this method more dynamic by passing the parameter in this method.
		//As of now parameter is not been passed
		public SocialStudiesBook SelectTypesOfBooks() throws Throwable
		{
			System.out.println(ShopBySubject.size());
			
            	for (WebElement AllOptions_Book : ShopBySubject) {
				
				String NameofAllCatogories_Book =AllOptions_Book.getText();
				
				if(NameofAllCatogories_Book.contains("SOCIAL"))
				{
					AllOptions_Book.click();
					break;
				}
				
			}
			
			return new SocialStudiesBook();
			
		}

}
