package com.prj.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.prj.qa.base.TestBase;

public class LoginPage extends TestBase {

	//PageFactory 
	@FindBy(name="username")
	WebElement usern;
	
	@FindBy(name="password")
	WebElement passw;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginbutton;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement logo;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement Signupbutton;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public  String validateTitle() {
		return driver.getTitle();
	}
	
	public  boolean  validateLogo() {
		 return logo.isDisplayed();
	}
	public HomePage ValidateLogin(String un,String pwd) {
		usern.sendKeys(un);
		passw.sendKeys(pwd);
		loginbutton.click();
		return new HomePage();
	}

}
