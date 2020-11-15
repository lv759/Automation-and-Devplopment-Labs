package com.prj.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.prj.qa.base.TestBase;
import com.prj.qa.pages.ContactPage;
import com.prj.qa.pages.HomePage;
import com.prj.qa.pages.LoginPage;
import com.prj.qa.util.TestUtil;

public class ContactPageTest extends TestBase {
	LoginPage logpage;
	HomePage homepage;
	ContactPage contactpage;
	
	public String sheetname="Contacts";
	
	public ContactPageTest(){
		super();
	}
	
	@BeforeMethod
	public void Setup() {
		initialization();
		logpage=new LoginPage();
		homepage=new HomePage();
		contactpage=new ContactPage();
		homepage =logpage.ValidateLogin(prop.getProperty("username"),prop.getProperty("password"));
	    TestUtil.Switchtoframe();
	    contactpage=homepage.verifycontacts();
	}
	
	@Test(priority=1)
	public void verifylabel() {
	Assert.assertTrue(contactpage.verifycontacttablename(), "Contact Label is missing");
	}
	
	@Test(priority=2)
	public void SelectbynameTest() {
		contactpage.SelectByName();
	}
	
	@DataProvider()
	public Object[][] testdata(){
		Object[][] data=TestUtil.getdata(sheetname);
		return data;
	}
	
		@Test(priority=3, dataProvider="testdata" )
	public void ContactFormFill(String tit,String Ftname,String Ltname,String Compy) {
		homepage.Newontactwindow();
		//contactpage.FillContactPage("Mr.","Visal","Singh","Judo");
		contactpage.FillContactPage(tit,Ftname,Ltname,Compy);
		
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}
	
}
