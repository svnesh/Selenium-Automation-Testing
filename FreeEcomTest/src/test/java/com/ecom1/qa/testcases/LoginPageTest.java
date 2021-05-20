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

public class LoginPageTest extends TestBase{
	HomePage homePage;
	LoginPage loginPage;
	AccountPage accountPage;
	
	String sheetName = "newuser";
	//Object monthMap;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		loginPage = homePage.validateLoginLink();
	}
	
	@Test
	public void LoginPageTitle() {
		String loginPgTitle = loginPage.validateLoginPageTitle();
		Assert.assertEquals(loginPgTitle, "Login - My Store");
	}
	
	@Test
	public void UserLogin() throws InterruptedException {
		accountPage = loginPage.validateUserLogin(prop.getProperty("username"), prop.getProperty("passwrd"));
	}
	
	@DataProvider
	public Object[][] getEcomTestData(){
		Object data[][] = TestUtils.getTestData(sheetName);
		return data;
	}
	
	@Test(dataProvider="getEcomTestData")
	public void newUserRegister(String title, String firstname, String lastname, String email, 
			String password, String dob, String address, String city, String state, String postalcode, 
			String country, String mobile, String aliasadd) throws InterruptedException {
		String[] myDOB = dob.split("-");
		
		loginPage.cerateNewuserAccount(email, title, firstname, lastname, password, myDOB[0], 
				TestUtils.getMonth(myDOB[1]), myDOB[2], address, city, state, postalcode, 
				country, mobile, aliasadd);
		}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
