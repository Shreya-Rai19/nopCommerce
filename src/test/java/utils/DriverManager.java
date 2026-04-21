package utils;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import pages.AddToCart;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.InvalidPage;
import pages.LoginPage;
import pages.ProductSearch;
import pages.RegisterPage;
import pages.ProfilePage;

public class DriverManager {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected ConfigReader config = new ConfigReader();

    // Page objects
    protected HomePage homepage;
    protected RegisterPage registerpage;
    protected LoginPage loginpage;
    protected InvalidPage invalidPage;
    protected ProductSearch productsearch;
    protected AddToCart addtocart;
    protected CartPage cart;
    protected CheckoutPage checkoutpage;
    protected ProfilePage profilepage;

    @BeforeClass
    public void setup() {
        config = new ConfigReader();
        driver = DriverFactory.getDriver(config.getBrowser());
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(config.getBaseUrl());
    }

    @BeforeClass
    public void instantiatePages() {
        homepage = new HomePage(driver, wait);
        registerpage = new RegisterPage(driver, wait);
        invalidPage = new InvalidPage(driver, wait);
        productsearch= new ProductSearch(driver,wait);
        addtocart= new AddToCart(driver,wait);
        cart = new CartPage(driver,wait);
        loginpage = new LoginPage(driver,wait);
        checkoutpage = new CheckoutPage(driver,wait);
        profilepage = new ProfilePage(driver, wait);
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
