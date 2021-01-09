package Pages_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class SearchPage {
	WebDriver driver=null;
	@Given("browser is open")
	public void browser_is_open() {
		System.setProperty("webdriver.chrome.driver", "D://EclipseWorkspace1//selfpractice//POMcucumber//driver87//chromedriver.exe");
		driver=new ChromeDriver();
	}

	@And("Webpage has open")
	public void webpage_has_open() {
		driver.navigate().to("https://www.google.com/");
	}

	@When("User enters the text")
	public void user_enters_the_text() {
		driver.findElement(By.name("q")).sendKeys("vishal lokhande");
	}

	@And("Clicks on search button")
	public void clicks_on_search_button() {
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}

	@Then("User is navigated to nextpage")
	public void user_is_navigated_to_nextpage() {
	    driver.getPageSource().contains("Vishal Lokhande Profiles | Facebook");
	    driver.close();
	}
}
