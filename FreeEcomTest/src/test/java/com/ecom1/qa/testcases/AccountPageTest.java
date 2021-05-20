package com.ecom1.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ecom1.qa.base.TestBase;
import com.ecom1.qa.pages.AccountPage;
import com.ecom1.qa.pages.HomePage;
import com.ecom1.qa.pages.LoginPage;
import com.ecom1.qa.util.TestUtils;

public class AccountPageTest extends TestBase{
	
	HomePage homePage;
	LoginPage loginPage;
	AccountPage accountPage;
	
	String sheetName = "newuser";
	
	public AccountPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		loginPage = homePage.validateLoginLink();
	}
	
	@DataProvider
	public Object[][] getEcomTestData(){
		Object data[][] = TestUtils.getTestData(sheetName);
		return data;
	}
	
	@Test(dataProvider="getEcomTestData")
	public void validateUserLoggedIn(String title, String firstname, String lastname, String email, 
			String password, String dob, String address, String city, String state, String postalcode, 
			String country, String mobile, String aliasadd) throws InterruptedException {
		accountPage = loginPage.validateUserLogin(email, password);
		String userlabel = accountPage.validateLoggedUserName();
		String toCheck = firstname + " " + lastname;
		Assert.assertEquals(userlabel, toCheck);
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
