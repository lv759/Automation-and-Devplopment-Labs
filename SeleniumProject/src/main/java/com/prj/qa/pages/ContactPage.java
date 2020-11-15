package com.prj.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.prj.qa.base.TestBase;

public class ContactPage extends TestBase{

	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement Contacttablename;
		
	@FindBy(id="first_name")
	WebElement firstname;
	
	@FindBy(id="surname")
	WebElement sname;
	
	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement cmp;
	
	@FindBy(xpath="/html/body/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/fieldset/form/table/tbody/tr[1]/td/input[2]")
	WebElement save;
	
	public ContactPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifycontacttablename() {
		return Contacttablename.isDisplayed();
	}
	
	public void SelectByName() {
		driver.findElement(By.xpath("//*[@id=\"vContactsForm\"]/table/tbody/tr[18]/td[2]/a")).click();
	
	}
	
	public void FillContactPage(String title,String ftn,String sur,String compan) {
		Select sel=new Select(driver.findElement(By.name("title")));
		sel.selectByVisibleText(title);
		firstname.sendKeys(ftn);
		sname.sendKeys(sur);
		cmp.sendKeys(compan);
		save.click();
		
	}
	
}
