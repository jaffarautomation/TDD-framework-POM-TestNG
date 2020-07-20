package com.amzon.qa.pages_catogories_Books;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.amzon.qa.base.TestBase;
import com.amzon.qa.pages_CartsSections.CartSectionPage;
import com.crm.qa.util.JavaScriptMethod;

public class MoreInformationPageOnBook extends TestBase {

	// Constructor of this class to init the page factory elements
	public MoreInformationPageOnBook() throws Throwable {
		PageFactory.initElements(driver, this);

	}

	// pagefactory -> OR
	@FindBy(xpath = "//input[@id='add-to-cart-button']")
	WebElement AddToCart;

	@FindBy(xpath = "//input[@id='buy-now-button']")
	WebElement BuyNow;

	@FindBy(xpath = "//select[@name='quantity'][@id='quantity']")
	WebElement Quanity;

	// Actions Method

	// This method verify the title of the page
	public String VerifyTitle() {

		return driver.getTitle();
	}

	// This method let user to select the no of product Quantity
	// This method is has parameter which is taken from the user

	public void SelectQauntity(int x) {
		JavaScriptMethod.scrolltillvisible(driver, Quanity);
		Select NoofItems = new Select(Quanity);
		NoofItems.selectByIndex(x);
		System.out.println("User has selected " + x + " books");
	}

	// This method click on buynow button
	public void CLickOnBuyNow() {
		BuyNow.click();
	}

	// This method click on AddtoCart button
	public CartSectionPage ClickOnAddToCart() throws Throwable {

		JavaScriptMethod.scrolltillvisible(driver, AddToCart);
		AddToCart.click();
		return new CartSectionPage();
	}

}
