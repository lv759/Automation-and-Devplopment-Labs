package com.prj.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.prj.qa.util.TestUtil;

public class TestBase {
public static WebDriver driver;
public static Properties prop;

public TestBase()  {
	try {
		prop=new Properties();
		FileInputStream ip = new FileInputStream("C:\\Users\\VISH\\eclipse-workspace\\SeleniumProject\\src\\main\\java\\com\\prj\\qa"
				+ "\\config\\config.properties");
		prop.load(ip);
	} catch (FileNotFoundException e1) {
		e1.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
 public static void initialization() {
	 String brwname=prop.getProperty("browser");
	 if(brwname.equals("Chrome")) {
		 System.setProperty("webdriver.chrome.driver", "C://Users//VISH//Downloads//chromedriver.exe");
		driver=new ChromeDriver();
	 }else if(brwname.equals("FF")) {
		 System.setProperty("webdriver.gecko.driver", "C://Users//VISH//Downloads//geckodriver.exe");
	 driver=new FirefoxDriver();
	 }else {
		 System.out.println("No browser assigned");
	 }
	 driver.manage().window().maximize();
	 driver.manage().deleteAllCookies();
	 driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);
	 driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load, TimeUnit.SECONDS);
	 
	 driver.get(prop.getProperty("url"));
 }
}
