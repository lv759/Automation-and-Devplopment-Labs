package com.prj.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.prj.qa.base.TestBase;
import com.prj.qa.pages.HomePage;
import com.prj.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage logpage;
	HomePage homepage;
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void Setup() {
		initialization();
		logpage=new LoginPage();
	}
	
	@Test(priority=1)
	public void validateTitleTest() {
		String title=logpage.validateTitle();
	Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.","Title not Matched");
	}
	
	@Test(priority=2)
	public void validateLogoTest() {
		boolean flag=logpage.validateLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void ValidateLoginTest() {
	homepage =logpage.ValidateLogin(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
