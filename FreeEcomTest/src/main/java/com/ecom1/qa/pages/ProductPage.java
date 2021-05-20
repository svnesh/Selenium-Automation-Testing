package com.ecom1.qa.pages;

import com.ecom1.qa.base.TestBase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends TestBase{
	
	HomePage homePage;
	OrderPage orderPage;
	
	//Page factory
	@FindBy(xpath="//span[@class='heading-counter']")
	WebElement productCount;
	
	@FindBy(xpath="//li[@id='grid']")
	WebElement prodGridIcon;
	
	@FindBy(xpath="//li[@id='list']")
	WebElement prodListIcon;
	
	@FindBy(xpath="//ul[@class='product_list grid row']/li")
	List<WebElement> productsGridList;
	
	@FindBy(xpath="//div[@class='clearfix']//div[@class='button-container']/a[contains(@title, 'Proceed to checkout')]")
	WebElement proceedChkOutBtn;
	
	public ProductPage() {
		PageFactory.initElements(driver, this);
	}
	
	public OrderPage AddCartFeature() throws InterruptedException {
		if (prodGridIcon.getAttribute("class").matches("selected")) {
			if (productsGridList.size() > 0) {
				for (int i=0; i < productsGridList.size(); i++) {
					WebElement selProduct = productsGridList.get(i).findElement(By.xpath("//a[@class='product_img_link']/img"));
					Actions action = new Actions(driver);
					action.moveToElement(selProduct).build().perform();
					WebElement addtoCartBtn = productsGridList.get(i).findElement(By.xpath("//div[@class='right-block']//a/span[contains(text(),'Add to cart')]"));
					addtoCartBtn.click();
				}
				Thread.sleep(2000);
				//Click the "Proceed to Checkout" button
				proceedChkOutBtn.click();
			}			
		}
		else if (prodListIcon.getAttribute("class").matches("selected")) {
			//need to write code for list view of products
		}
		return new OrderPage();
	}
}
