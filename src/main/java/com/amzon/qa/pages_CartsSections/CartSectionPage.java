package com.amzon.qa.pages_CartsSections;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amzon.qa.base.TestBase;

//This class is used to verify that book has been added to cart successfully.

public class CartSectionPage extends TestBase {

	
	
	

	//Constructor of this class to init the page factory elements
	public CartSectionPage() throws Throwable
	{
		PageFactory.initElements(driver, this);
	}
	
	
	    // pagefactory -> OR
		@FindBy(xpath="//*[@id='huc-v2-order-row-confirm-text']/h1")
        WebElement AddedToCart;	
		
		
		
		//This method will verify the title of the current page
		public String VerifyTitle()
		{
			
			return driver.getTitle();
		}
		
		
		//This method will verify the product is added to the cart
		public String ToverifyproductAdded()
		{
			
			return AddedToCart.getText();
		}
		
		

}
