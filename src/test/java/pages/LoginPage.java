package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public LoginPage(WebDriver driver,WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    // Locators
    By loginLink = By.linkText("Log in");
    By email = By.id("Email");
    By password = By.id("Password");
    By loginButton = By.xpath("//button[text()='Log in']");
    By myAccount = By.linkText("My account");

    // Actions (Methods)
    public void clickLogin() {
        driver.findElement(loginLink).click();
    }

    public void enterEmail(String mail) {
        driver.findElement(email).sendKeys(mail);
    }

    public void enterPassword(String pwd) {
        driver.findElement(password).sendKeys(pwd);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

   public boolean isLoginSuccessful() {
        return driver.findElement(myAccount).isDisplayed();
    }
}