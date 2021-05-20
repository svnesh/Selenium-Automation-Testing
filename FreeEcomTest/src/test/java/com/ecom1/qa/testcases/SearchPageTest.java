package com.ecom1.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ecom1.qa.base.TestBase;
import com.ecom1.qa.pages.HomePage;
import com.ecom1.qa.pages.SearchPage;

public class SearchPageTest extends TestBase{
	
	HomePage homePage;
	SearchPage searchPage;
	
	public SearchPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		homePage = new HomePage();
		searchPage = homePage.validateSearchBox();
	}
	
	@Test
	public void SearchPageTitle() throws InterruptedException {
		String sPgTitle = searchPage.validateSearchPageTitle();
		Assert.assertEquals(sPgTitle, "Search - My Store");
	}
	
	@Test
	public void SearchResultText() {
		String sResultText = searchPage.validateSearchResult();
		Assert.assertTrue(sResultText.contains("results have been found"));
	}
	
	@Test
	public void SearchResultImg() {
		String sResultText = searchPage.validateSearchResult();
		int sResultInt = Integer.parseInt(sResultText.substring(0, 1));
		if (sResultInt > 0) {
			int sResultImgInt = searchPage.validateSearchResultImg();
			Assert.assertEquals(sResultInt, sResultImgInt);
		}		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
