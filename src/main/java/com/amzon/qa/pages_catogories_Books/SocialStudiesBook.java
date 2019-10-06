package com.amzon.qa.pages_catogories_Books;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amzon.qa.base.TestBase;

public class SocialStudiesBook extends TestBase {

	
	
	
	//Constructor of this class to init the page factory elements
	public SocialStudiesBook() throws Throwable {
		PageFactory.initElements(driver, this);
		
	}
	
	
	    // pagefactory -> OR
	
	    //This page factory will always select the first book from the page.
	    //This is  Xpath is build as dynamic xpath 
		@FindBy(xpath="//div[@class='s-result-list s-search-results sg-row']/div/div/span/div/div/div[2]/div/div/div/span/a/div/img")
        WebElement SelectFirstBook;	
		
		@FindBy(xpath="//div[@class='s-result-list s-search-results sg-row']/div/div/span/div/div/div[2]/div[2]/div/div/div/div/div/h2/a/span")
        WebElement SelectFirstBookName;	
		
		
		
		//Actions Method
		
		
		//This method return the title of the page, and will be used in the test class to call this method and verify the same
		public String VerifyTheTitle()
		{
				return driver.getTitle();
			
		}
		
		//This method will return the name of the book which is first on the list of page.
		public String getNameOfBook()
		{
			
			return SelectFirstBookName.getText();
		}
		
		
		
		//This method click on the Click on the First book from the page, doesn't matter which book it is. 
		public MoreInformationPageOnBook clickfirstonbook() throws Throwable
		{
			
			SelectFirstBook.click();
			return new MoreInformationPageOnBook();
		}
		
		
}
