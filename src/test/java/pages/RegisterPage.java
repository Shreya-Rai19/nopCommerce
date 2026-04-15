package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
	WebDriver driver;
	WebDriverWait wait;
	
	public RegisterPage(WebDriver driver,WebDriverWait wait){
		this.driver = driver;
		this.wait = wait;
	}
	
	By male = By.xpath("//input[@value='M']");
	By female = By.xpath("//input[@value='F']");
	By firstNameField = By.id("FirstName");
	By lastNameField = By.id("LastName");
	By emailField = By.id("Email");
	By passwordField = By.id("Password");
	By confirmpasswordField = By.id("ConfirmPassword");
	By registerButton = By.xpath("//Button[@type='submit']");
	By successMessage = By.cssSelector("div.result");
	By continueButton = By.cssSelector(".button-1.register-continue-button");
	
	 public void clickOnMale() {
	        wait.until(ExpectedConditions.elementToBeClickable(male)).click();
	    }

	    public void clickOnFemale() {
	        wait.until(ExpectedConditions.elementToBeClickable(female)).click();
	    }

	    public void enterFirstName(String name) {
	        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).sendKeys(name);
	    }

	    public void enterLastName(String name) {
	        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField)).sendKeys(name);
	    }

	    public void enterEmail(String email) {
	        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
	    }

	    public void enterPassword(String password) {
	        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
	    }

	    public void enterConfirmedPassword(String password) {
	        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmpasswordField)).sendKeys(password);
	    }

	    public void clickRegister() {
	        wait.until(ExpectedConditions.visibilityOfElementLocated(registerButton)).click();
	    }
	    
	    public String getSuccessMessage() {
	    	return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).getText();
	    }
	    
	    public void clickContinueButton() {
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(continueButton)).click();
	    }
}
