package utils;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import pages.*;

public class Hooks extends DriverManager{
    public static WebDriver driver;
    public static WebDriverWait wait;

    // Page objects accessible to steps
    public static HomePage homepage;
    public static RegisterPage registerpage;
    public static LoginPage loginpage;
    public static InvalidPage invalidPage;
    public static ProductSearch productsearch;
    public static AddToCart addtocart;
    public static CartPage cart;
    public static CheckoutPage checkoutpage;

    @Before
    public void beforeScenario() {
        driver = DriverFactory.getDriver(config.getBrowser());
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(config.getBaseUrl());
        

        // instantiate pages
        homepage = new HomePage(driver, wait);
        registerpage = new RegisterPage(driver, wait);
        loginpage = new LoginPage(driver, wait);
        invalidPage = new InvalidPage(driver, wait);
        productsearch = new ProductSearch(driver, wait);
        addtocart = new AddToCart(driver, wait);
        cart = new CartPage(driver, wait);
        checkoutpage = new CheckoutPage(driver, wait);
    }

    @After
    public void afterScenario() {
        if (driver != null) {
            driver.quit();
        }
    }
}
