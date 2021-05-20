package com.ecom1.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom1.qa.base.TestBase;

public class HomePage extends TestBase{
	SearchPage searchPage;
	LoginPage loginPage;
	ProductPage productPage;
	
	//PAGE FACTORY
	@FindBy(xpath="//img[@class='logo img-responsive']")
	WebElement hmPgLogo;
	
	@FindBy(xpath="//input[@name='search_query']")
	WebElement hmSearchBox;
	
	@FindBy(xpath="//button[@name='submit_search']")
	WebElement btnSearch;
	
	@FindBy(xpath="//a[@class='login']")
	WebElement loginLink;
	
	@FindBy(xpath="//a[@class='sf-with-ul']")
	WebElement hoverMenuWomen;
	
	@FindBy(xpath="//a[contains(text(),'T-shirts')]")
	WebElement tshirtLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateHomePageLogo() {
		return hmPgLogo.isDisplayed();
	}
	
	public SearchPage validateSearchBox() throws InterruptedException {
		hmSearchBox.sendKeys("dresses");
		btnSearch.click();
		Thread.sleep(1000);
		return new SearchPage();
	}
	
	public LoginPage validateLoginLink() {
		loginLink.click();
		return new LoginPage();
	}
	
	public ProductPage clickOnDressMenu() {
		Actions action = new Actions(driver);
		action.moveToElement(hoverMenuWomen).build().perform();
		tshirtLink.click();
		return new ProductPage();
	}

}
