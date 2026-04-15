package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.DriverFactory;

public class LoginTest {

    @Test
    public void validLoginTest() {

        // Driver setup (manual since your network has issues)
        

    	WebDriver driver = DriverFactory.getDriver("edge");
        //WebDriver driver = new EdgeDriver();

        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

        // Create object of LoginPage
        LoginPage lp = new LoginPage(driver);

        // Perform actions
        lp.clickLogin();
        lp.enterEmail("admin@gmail.com");
        lp.enterPassword("password");
        lp.clickLoginButton();

        // Validation
        Assert.assertTrue(lp.isLoginSuccessful(), "Login Failed");

    }
}