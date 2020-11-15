package com.prj.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.prj.qa.base.TestBase;
import com.prj.qa.pages.ContactPage;
import com.prj.qa.pages.HomePage;
import com.prj.qa.pages.LoginPage;
import com.prj.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage logpage;
	HomePage homepage;
	ContactPage contactpage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void Setup() {
		initialization();
		logpage=new LoginPage();
		homepage=new HomePage();
		contactpage=new ContactPage();
		homepage =logpage.ValidateLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	
	@Test(priority=1)
	public void verifyHomepageTitle() {
		String title=homepage.verifyTitle();
		Assert.assertEquals(title, "CRMPRO","Title Not Matched");
	}
	
	@Test(priority=2)
	public void verifyHomepageUsername() {
		TestUtil.Switchtoframe();
		Assert.assertTrue(homepage.verifyUsername());
	}
	
	@Test(priority=3)
	public void verifyContactsTest(){
		TestUtil.Switchtoframe();
		contactpage=homepage.verifycontacts();
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
