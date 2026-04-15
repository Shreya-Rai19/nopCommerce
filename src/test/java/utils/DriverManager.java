package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pages.HomePage;
import pages.RegisterPage;

public class DriverManager {

	WebDriver driver;
	WebDriverWait wait;
	ConfigReader config = new ConfigReader();
	protected HomePage homepage;
	protected RegisterPage registerpage;
	
	@BeforeClass
	public void setup() {
		config = new ConfigReader();
	    driver = DriverFactory.getDriver(config.getBrowser());
	    driver.manage().window().maximize();
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	    driver.get(config.getBaseUrl());
	}
	
	@BeforeMethod
	public void instantiatePages() {
		homepage = new HomePage(driver,wait);
		registerpage = new RegisterPage(driver,wait);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
