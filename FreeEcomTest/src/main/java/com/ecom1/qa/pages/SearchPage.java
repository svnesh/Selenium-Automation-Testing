package com.ecom1.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom1.qa.base.TestBase;

public class SearchPage extends TestBase{
	//HomePage homePage;
	//SearchPage searchPage;
	
	@FindBy(xpath="//span[@class='heading-counter']")
	WebElement searchCountText;
	
	@FindBy(xpath="//ul[@class='product_list grid row']/li")
	List<WebElement> searchCountImg;
	
	public SearchPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateSearchPageTitle() {
		return driver.getTitle();
	}
	
	public String validateSearchResult() {
		return searchCountText.getText();		
	}
	
	public int validateSearchResultImg() {
		return searchCountImg.size();
	}

}
