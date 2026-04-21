package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProfilePage {

    WebDriver driver;
    WebDriverWait wait;

    By myAccount = By.linkText("My account");    
    By firstName = By.id("FirstName");
    By lastName = By.id("LastName");
    By saveBtn = By.id("save-info-button");

    public ProfilePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void goToMyAccount() {
        // click My Account
        wait.until(ExpectedConditions.elementToBeClickable(myAccount)).click();

    }

    public void updateProfile() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys("Test");
        //driver.findElement(firstName).sendKeys("Test");

        wait.until(ExpectedConditions.visibilityOfElementLocated(lastName)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastName)).sendKeys("User");
        //driver.findElement(lastName).sendKeys("User");
    }

    public void clickSave() {
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn)).click();
    }
}