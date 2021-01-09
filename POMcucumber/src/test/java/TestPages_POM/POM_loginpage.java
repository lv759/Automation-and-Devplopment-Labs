package TestPages_POM;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class POM_loginpage {
	WebDriver driver;
	By username=By.id("name");
	By password=By.id("password");
	By loginbttn=By.id("login");
	
	public POM_loginpage(WebDriver driver) {
   	 this.driver=driver;
    }
	
	public void enterusername(String uname) {
		driver.findElement(username).sendKeys(uname);
	}
	public void enterpassword(String passw) {
		driver.findElement(password).sendKeys(passw);
	}
	public void button() {
		driver.findElement(loginbttn).click();;
	}
	
}
