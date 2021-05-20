package com.ecom1.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ecom1.qa.base.TestBase;
import com.ecom1.qa.pages.HomePage;
import com.ecom1.qa.pages.SearchPage;

public class HomePageTest extends TestBase{
	HomePage homePage;
	SearchPage searchPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		searchPage = new SearchPage();
	}
	
	@Test
	public void HomePageTitleTest() {
		String pgTitle = homePage.validateHomePageTitle();
		Assert.assertEquals(pgTitle, "My Store");
	}
	
	@Test
	public void HomePageLogoTest() {
		Assert.assertTrue(homePage.validateHomePageLogo());
	}
	
	@Test
	public void HomePageSearchBox() throws InterruptedException {
		homePage.validateSearchBox();
		//Assert.assertTrue(searchResult.contains("results have been found"));
	}
	
	@Test
	public void validateProductMenu() {
		homePage.clickOnDressMenu();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
