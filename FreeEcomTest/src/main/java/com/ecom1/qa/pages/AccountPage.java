package com.ecom1.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom1.qa.base.TestBase;

public class AccountPage extends TestBase{
	
	@FindBy(xpath="//div[@class='header_user_info']/a[@class='account']/span")
	WebElement loggedUser;
	
	@FindBy(xpath="//form[@id='login_form']//input[@id='email']")
	WebElement loginEmail;
	
	@FindBy(xpath="//form[@id='login_form']//input[@id='passwd']")
	WebElement loginPass;
	
	@FindBy(xpath="//form[@id='login_form']//button[@id='SubmitLogin']")
	WebElement submitBtn;	
	
	public AccountPage() {
		PageFactory.initElements(driver, this);
	}
	

	public String validateLoggedUserName() throws InterruptedException {
		return loggedUser.getText();
	}

}
