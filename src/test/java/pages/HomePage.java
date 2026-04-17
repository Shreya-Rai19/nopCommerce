package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public HomePage(WebDriver driver,WebDriverWait wait){
		this.driver = driver;
		this.wait = wait;
	}
	
	By register = By.xpath("//a[@href='/register?returnUrl=%2F']");
	By logout = By.className("ico-logout");
	
	public void clickRegister() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(register)).click();
	}
	
	public void clickLogout() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(logout)).click();
	}
}
