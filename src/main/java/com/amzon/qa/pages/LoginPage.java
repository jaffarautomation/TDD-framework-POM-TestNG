package com.amzon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amzon.qa.base.TestBase;

//In page object model we dont use findelement method, we use findby method

public class LoginPage extends TestBase {

	
	// pagefactory -> OR
	@FindBy(xpath="//a[@id='nav-link-accountList']")
	WebElement signin;
	
	@FindBy(xpath="//input[@type='email']")
	WebElement mobile;
	
	@FindBy(xpath="//input[@id='continue']")
	WebElement continuebutton;
	
	
	@FindBy(xpath="//input[@type='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='signInSubmit']")
	WebElement login;
	

	@FindBy(xpath="//a[@id='createAccountSubmit']")
	WebElement signup;

	
	public LoginPage() throws Throwable {
		PageFactory.initElements(driver, this);
		
	}

	
	//Actions
	public  String validatetitle()
	{
		
		return driver.getTitle();
	}
	
	
	
	public  HomePage login(String usernamevalue, String passwordvalue) throws Throwable
	{
		
		signin.click();
		mobile.sendKeys(usernamevalue);
		continuebutton.click();
		password.sendKeys(passwordvalue);
		login.click();
		
		return new HomePage();
	}
	
	
	public SignupPage Registration() throws Throwable
	{
		
		
		signin.click();
		signup.click();
		return new SignupPage();
		
	}
}
