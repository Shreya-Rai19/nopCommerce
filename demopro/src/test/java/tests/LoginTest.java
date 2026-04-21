package tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.Loginpage;
import pages.Loginpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

    @Test
    public void testLogin() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");

        Loginpage login = new Loginpage(driver);
        login.login("standard_user", "secret_sauce");

Assert.assertTrue(login.getCurrentUrl().contains("inventory"));
        // ✅ ADD HERE
        String currentUrl = driver.getCurrentUrl();

        if(currentUrl.contains("inventory")) {
            System.out.println("Login Passed");
        } else {
            System.out.println("Login Failed");
        }
        //driver.quit();
    }
}