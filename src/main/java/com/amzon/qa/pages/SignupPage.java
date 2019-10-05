package com.amzon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amzon.qa.base.TestBase;

public class SignupPage extends TestBase {

	
	
	
	@FindBy(xpath="//input[@type='text']")
	WebElement Yourname;

	

	@FindBy(xpath="//input[@type='tel']")
	WebElement Mobileno;

	

	@FindBy(xpath="//input[@type='password']")
	WebElement Password;

	
	@FindBy(xpath="//span[@class='a-list-item']")
	WebElement MobileErrormessage;

	
	@FindBy(xpath="//input[@id='continue']")
	WebElement ContinueButton;
	
	public SignupPage() throws Throwable {
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	
	
	//This method will verify user receive an error if he/she provide mobile no which is already registered.
	//This method is based on key driven approach i.e taking values from config file
	public  String  form()
	{
		
		Yourname.sendKeys(prop.getProperty("name"));
		Mobileno.sendKeys(prop.getProperty("mobileno"));
		Password.sendKeys(prop.getProperty("password"));
		ContinueButton.click();
		return MobileErrormessage.getText();
	}
	
	
}
