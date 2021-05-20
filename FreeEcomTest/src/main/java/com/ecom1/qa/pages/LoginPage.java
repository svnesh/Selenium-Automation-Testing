package com.ecom1.qa.pages;

import java.math.BigDecimal;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ecom1.qa.base.TestBase;

public class LoginPage extends TestBase{
	AccountPage accountPage;
	
	//Page factory
	@FindBy(xpath="//form[@id='login_form']//input[@id='email']")
	WebElement loginEmail;
	
	@FindBy(xpath="//form[@id='login_form']//input[@id='passwd']")
	WebElement loginPass;
	
	@FindBy(xpath="//form[@id='login_form']//button[@id='SubmitLogin']")
	WebElement submitBtn;	
	
	@FindBy(xpath="//form[@id='create-account_form']//input[@id='email_create']")
	WebElement createAccountEmail;
	
	@FindBy(xpath="//form[@id='create-account_form']//button[@id='SubmitCreate']")
	WebElement submitNewAccountBtn;	
	
	@FindBy(xpath="//div[@class='radio-inline']//input[@id='id_gender1']")
	WebElement genderMrRadio;
	
	@FindBy(xpath="//div[@class='radio-inline']//input[@id='id_gender2']")
	WebElement genderMrsRadio;
	
	@FindBy(xpath="//input[@id='customer_firstname']")
	WebElement cusFirstName;
	
	@FindBy(xpath="//input[@id='customer_lastname']")
	WebElement cusLastName;
	
	@FindBy(xpath="//input[@id='passwd']")
	WebElement cusPasswrd;
	
	@FindBy(xpath="//select[@name='days']")
	WebElement dayDOB;
	
	@FindBy(xpath="//select[@name='months']")
	WebElement monthDOB;
	
	@FindBy(xpath="//select[@name='years']")
	WebElement yearDOB;	
	
	@FindBy(xpath="//input[@id='newsletter']")
	WebElement enableNewsLetter;
	
	@FindBy(xpath="//input[@id='optin']")
	WebElement enableOptin;
	
	@FindBy(xpath="//input[@id='firstname']")
	WebElement addFirstName;
	
	@FindBy(xpath="//input[@id='lastname']")
	WebElement addLastName;
	
	@FindBy(xpath="//input[@id='address1']")
	WebElement address1;
	
	@FindBy(xpath="//input[@id='city']")
	WebElement city;
	
	@FindBy(xpath="//select[@id='id_state']")
	WebElement state;
	
	@FindBy(xpath="//input[@id='postcode']")
	WebElement postCode;
	
	@FindBy(xpath="//select[@id='id_country']")
	WebElement country;
	
	@FindBy(xpath="//input[@id='phone_mobile']")
	WebElement mobile;
	
	@FindBy(xpath="//input[@id='alias']")
	WebElement addAlias;
	
	@FindBy(xpath="//button[@id='submitAccount']")
	WebElement btnRegister;
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public AccountPage validateUserLogin(String useremail, String passwrd) throws InterruptedException {
		loginEmail.sendKeys(useremail);
		loginPass.sendKeys(passwrd);
		submitBtn.click();
		Thread.sleep(1000);
		return new AccountPage();
	}
	
	public void cerateNewuserAccount(String cusemail, String gender, String fname, String lname, 
			String passwrd, String dt, String mn, String yr, String addr,
			String cuscity, String cusstate, String pscode, String cusCont,
			String cusMobile, String cusAlias) throws InterruptedException {
		
		createAccountEmail.sendKeys(cusemail);
		submitNewAccountBtn.click();
		Thread.sleep(1000);
		
		//Gender radio
		if(gender.equals("Mr")) {
			genderMrRadio.click();
		}
		else {
			genderMrsRadio.click();
		}
		//First name
		cusFirstName.sendKeys(fname);
		//Last name
		cusLastName.sendKeys(lname);
		//Password
		cusPasswrd.sendKeys(passwrd);
		//date of birth
		Select selectDate = new Select(dayDOB);
		selectDate.selectByValue(dt);
		//month of birth
		Select selectMonth = new Select(monthDOB);
		selectMonth.selectByValue(mn);
		//year of birth
		Select selectYear = new Select(yearDOB);
		selectYear.selectByValue(yr);
		//address
		address1.sendKeys(addr);
		//city
		city.sendKeys(cuscity);
		//state
		Select selectState = new Select(state);
		selectState.selectByVisibleText(cusstate);
		//postal code
		postCode.sendKeys(pscode);
		//country
		Select selectCountry = new Select(country);
		selectCountry.selectByVisibleText(cusCont);
		//mobile
		BigDecimal bdMobileNum = new BigDecimal(cusMobile);
		mobile.sendKeys(bdMobileNum.toString());
		//address alias
		addAlias.clear();
		addAlias.sendKeys(cusAlias);
		//Submit
		btnRegister.click();
	}

}
