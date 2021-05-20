package com.ecom1.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom1.qa.base.TestBase;

public class OrderPage extends TestBase{
	
	ProductPage productPage;
	
	@FindBy(xpath="//p[@class='cart_navigation clearfix']/a[@title='Proceed to checkout']")
	WebElement prodPageCheckOutBtn1;
	
	@FindBy(xpath="//form[@id='login_form']//input[@id='email']")
	WebElement loginEmail;
	
	@FindBy(xpath="//form[@id='login_form']//input[@id='passwd']")
	WebElement loginPass;
	
	@FindBy(xpath="//form[@id='login_form']//button[@id='SubmitLogin']")
	WebElement submitBtn;	
	
	@FindBy(xpath="//p[@class='cart_navigation clearfix']/button[@name='processAddress']")
	WebElement addressPageCheckOutBtn2;
	
	@FindBy(xpath="//p[@class='cart_navigation clearfix']/button[@name='processCarrier']")
	WebElement carrierPageCheckOutBtn3;
	
	@FindBy(xpath="//p[@class='checkbox']//input[@id='cgv']")
	WebElement iagreeChkBox;
	
	@FindBy(xpath="//p[@class='payment_module']/a[@class='bankwire']")
	WebElement paymentBankWireLink;
	
	@FindBy(xpath="//div[@class='box cheque-box']/p[2]/span[@id='amount']")
	WebElement orderAmount;
	
	@FindBy(xpath="//p[@class='cart_navigation clearfix']/button[@class='button btn btn-default button-medium']")
	WebElement confirmOrderButton;
	
	@FindBy(xpath="//div[@class='box']/p[@class='cheque-indent']/strong")
	WebElement orderConfimMessage;
	
	public OrderPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String checkOutProcess(String useremail, String passwrd) throws InterruptedException {
		prodPageCheckOutBtn1.click();
		Thread.sleep(1000);
		loginEmail.sendKeys(useremail);
		loginPass.sendKeys(passwrd);
		submitBtn.click();
		Thread.sleep(1000);
		addressPageCheckOutBtn2.click();
		Thread.sleep(1000);
		iagreeChkBox.click();
		carrierPageCheckOutBtn3.click();
		Thread.sleep(1000);
		paymentBankWireLink.click();
		Thread.sleep(1000);
		confirmOrderButton.click();
		Thread.sleep(1000);
		return orderConfimMessage.getText();
	}

}
