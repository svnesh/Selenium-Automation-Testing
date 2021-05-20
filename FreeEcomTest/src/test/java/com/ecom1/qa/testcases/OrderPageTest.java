package com.ecom1.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ecom1.qa.base.TestBase;
import com.ecom1.qa.pages.HomePage;
import com.ecom1.qa.pages.OrderPage;
import com.ecom1.qa.pages.ProductPage;

public class OrderPageTest extends TestBase{
	
	HomePage homePage;
	ProductPage productPage;
	OrderPage orderPage;
	
	public OrderPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		homePage = new HomePage();
		productPage = homePage.clickOnDressMenu();
		orderPage = productPage.AddCartFeature();
	}
	
	@Test
	public void validateCheckOutProcess() throws InterruptedException {
		String finalMessage = orderPage.checkOutProcess(prop.getProperty("username"), prop.getProperty("passwrd"));
		Assert.assertEquals(finalMessage, "");//need to fill the end confirmation message
	}
}
