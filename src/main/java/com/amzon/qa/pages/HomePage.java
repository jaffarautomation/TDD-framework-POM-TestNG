package com.amzon.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import org.openqa.selenium.support.PageFactory;

import com.amzon.qa.base.TestBase;
import com.amzon.qa.pages_catogories_Books.School_Book_page;
import com.crm.qa.util.JavaScriptMethod;

public class HomePage extends TestBase{

	
	public HomePage() throws Throwable {
		PageFactory.initElements(driver, this);
		
	}
	
	
	// pagefactory -> OR
		@FindBy(xpath="//*[@id=\'nav-xshop\']/a[4]")
		WebElement Sell;
		
		@FindBy(xpath="//*[@id=\'nav-xshop\']/a[5]")
		WebElement customercare;
		
		@FindBy(xpath ="//*[@id=\"nav-link-accountList\"]/span[1]")
		WebElement name;
		
		@FindBy(xpath ="//a[@id='nav-hamburger-menu']")
		WebElement sidebar;
		
		@FindBy(xpath ="//a[@data-menu-id='16']")
		WebElement ClickonBooks;
		
		

		@FindBy(xpath ="//ul[@class='hmenu hmenu-visible hmenu-translateX' and @data-menu-id='1']/li/a/child::div")
		List<WebElement> AllCatogories;
		
		
		@FindBy(xpath ="//ul[@class='hmenu hmenu-visible hmenu-translateX']/li/a/div")   
		List<WebElement> AllTypesOfBooks;
		
		//Actions 1 this method will verify the username is reflecting right after login
		public String verifyusername()
		{
			
			return name.getText();
			
		}
		
		//Action2 //this method will navigate to customercare page and return its class object
		
		public CustomercarePAge Clickoncustomerservice() throws Throwable
		{
			
			customercare.click();
			return new CustomercarePAge();
		}
		
		
		//This method click on the side bar to view categories options and iterate all the categories present. 
		public void NavigateToAllCatogoriesOptions()
		{

			sidebar.click();
			
			System.out.println(AllCatogories.size());
			

			for (WebElement AllOptions : AllCatogories) {
				
				String NameofAllCatogories =AllOptions.getText();
				
				if(NameofAllCatogories.contains("Gift Cards &"))
				{
					JavaScriptMethod.scrolltillvisible(driver, AllOptions);
					AllOptions.click();
					break;
				}
				
			}
			
		   /* JavaScriptMethod.scrolltillvisible(driver, ClickonBooks);
            ClickonBooks.click();*/
		}
		
		
		
		//This method navigate to desired book after clicking on the desired categories options
		public School_Book_page NavigateToBook() throws Throwable
		
		{
		
			sidebar.click();
		    JavaScriptMethod.scrolltillvisible(driver, ClickonBooks);
            ClickonBooks.click();
			
			System.out.println(AllTypesOfBooks.size());
			
			for (WebElement AllBooks : AllTypesOfBooks) {
				
				String NameofBook =AllBooks.getText();
				
				if(NameofBook.contains("School"))
				{
					AllBooks.click();
					break;
				}
				
			}
			
			return new School_Book_page();
		}
		
		
		//Again same method as above is created but no return type is provide.
       public void  NavigateToBook1(String name) throws Throwable
		
		{
		
			sidebar.click();
		    JavaScriptMethod.scrolltillvisible(driver, ClickonBooks);
            ClickonBooks.click();
			
			System.out.println(AllTypesOfBooks.size());
			
			for (WebElement AllBooks : AllTypesOfBooks) {
				
				String NameofBook =AllBooks.getText();
				
				if(NameofBook.contains("name"))
				{
					AllBooks.click();
					break;
				}
				
			}
			
			
		}
		
}




