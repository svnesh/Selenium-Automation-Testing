package com.ecom1.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ecom1.qa.base.TestBase;
import com.ecom1.qa.pages.HomePage;
import com.ecom1.qa.pages.ProductPage;

public class ProductPageTest extends TestBase{
	HomePage homePage;
	ProductPage productPage;
	
	public ProductPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		productPage = homePage.clickOnDressMenu();
	}
	
	//Your order on My Store is complete
	
	@Test
	public void validateAddCartFeature() throws InterruptedException {
		productPage.AddCartFeature();
	}

}
