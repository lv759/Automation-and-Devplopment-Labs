package TestPages_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class POM_homepage {
	WebDriver driver;
	 public POM_homepage(WebDriver driver) {
    	 this.driver=driver;
     }
	 By logoutbttun=By.id("logout");
	 
	 public void Hit_logout() {
		 driver.findElement(logoutbttun);
	 }
}
