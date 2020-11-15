package com.prj.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.prj.qa.base.TestBase;

public class HomePage extends TestBase{

	//Page Factory Method
	@FindBy(xpath="//td[contains(text(),'User: Demo User')]")
	WebElement usernametitle;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contacts;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement deals;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement task;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyUsername() {
		return usernametitle.isDisplayed();
	}
	public ContactPage verifycontacts() {
		contacts.click();
		return new ContactPage();
	}
	
	public ContactPage Newontactwindow() {
		Actions act=new Actions(driver);
		act.moveToElement(contacts).build().perform();
		contactsLink.click();
		return new ContactPage();
	}
	
	public DealPage verifydeals() {
		deals.click();
		return new DealPage();
	}
	
	public TaskPage verifytask() {
		task.click();
		return new TaskPage();
	}
}
