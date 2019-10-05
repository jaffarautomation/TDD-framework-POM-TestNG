package com.amzon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amzon.qa.base.TestBase;

public class CustomercarePAge extends TestBase {

	
	
	

	public CustomercarePAge() throws Throwable {
		PageFactory.initElements(driver, this);
		
	}
	
	
	// pagefactory -> OR
	
		@FindBy(xpath="/html/body/div[2]/div[1]/h1")
		WebElement nametext;
		
		
		//Action1 // this method will verify the text on customer care page
		public String nametext_verify()
		{
			return nametext.getText();
		}
		
}
