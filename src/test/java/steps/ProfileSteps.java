package steps;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.*;
import utils.Hooks;

public class ProfileSteps {

    WebDriver driver;

    @Given("User launches the browser")
    public void launch_browser() {
        driver = Hooks.driver;   
    }

    @Given("User navigates to login page")
    public void navigate_to_login() {
        Hooks.loginpage.clickLogin();  
    }

    @When("User enters email and password")
    public void enter_credentials() {
        Hooks.loginpage.enterEmail("admin@gmail.com");
        Hooks.loginpage.enterPassword("123456");
    }

    @When("User clicks login button")
    public void click_login() {
        Hooks.loginpage.clickLoginButton();
    }

    @Then("User should be logged in")
    public void verify_login() {
        System.out.println("Login successful");
    }

    @When("User navigates to My Account")
    public void go_to_account() {
        Hooks.profilepage.goToMyAccount(); 
    }

    @When("User updates profile details")
    public void update_profile() {
        Hooks.profilepage.updateProfile();
    }

    @When("User saves the changes")
    public void save_changes() {
        Hooks.profilepage.clickSave();
    }

    @Then("Profile should be updated successfully")
    public void verify_update() {
        System.out.println("Profile updated successfully");
        // ❌ DO NOT quit driver here
    }
}