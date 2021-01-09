package Pages_POM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import TestPages_POM.POM_homepage;
import TestPages_POM.POM_loginpage;
import io.cucumber.java.en.*;

public class loginpagedefinition {
	WebDriver driver;
	POM_loginpage login;
	POM_homepage home;
     
	@Given("browser has opened")
	public void browser_has_opened() {
		System.setProperty("webdriver.chrome.driver", "D://EclipseWorkspace1//selfpractice//POMcucumber//driver87//chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://example.testproject.io/web/");
	}
	
	@When("^user enters (.*) and (.*)$")
	public void user_enters_username_and_password(String user,String pass) {
		login =new POM_loginpage(driver);
		login.enterusername(user);
		login.enterpassword(pass);
	}

	@And("clicks on login button")
	public void clicks_on_login_button() {
		login.button();
	}

	@Then("user is navigated to homepage")
	public POM_homepage user_is_navigated_to_homepage() {
		home=new POM_homepage(driver);
		home.Hit_logout();
		
		return new POM_homepage(driver);
		
	}
}
