package stepdefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.Loginpage;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.Assert;

public class LoginSteps {

    WebDriver driver;
    Loginpage login;

    @Given("user is on login page")
    public void openLoginPage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        login = new Loginpage(driver);
    }

    @When("user enters username and password")
    public void enterCredentials() {
        login.login("standard_user", "secret_sauce");
    }

    @Then("user should see dashboard")
    public void verifyDashboard() {
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
        driver.quit();
    }
    
    @When("user enters invalid username and password")
    public void invalidLogin() {
        login.login("wrong", "wrong");
    }

    @Then("error message should be displayed")
    public void errorMessage() {
        if(driver.getPageSource().contains("Epic sadface")) {
            System.out.println("Error message displayed");
        }
        driver.quit();
    }
}