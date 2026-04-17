package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import utils.DriverFactory;
import utils.DriverManager;

public class LoginTest extends DriverManager{
	
    @Test
    public void validLoginTest(){

        // Perform actions
        homepage.clickLogout();
        loginpage.clickLogin();
        loginpage.enterEmail("admin9@gmail.com");
        loginpage.enterPassword("password");
        loginpage.clickLoginButton();

        // Validation
        Assert.assertTrue(loginpage.isLoginSuccessful(), "Login Failed");

    }
}