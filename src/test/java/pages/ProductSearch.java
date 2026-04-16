package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductSearch {

    WebDriver driver;
    WebDriverWait wait;

    public ProductSearch(WebDriver driver,WebDriverWait wait) {
        this.driver = driver;
        this.wait= wait;
    }

    By search1 = By.id("small-searchterms");
    By searchButton = By.cssSelector("button[type='submit']");

    public void enterSearchKeyword(String keyword) throws InterruptedException {
        driver.findElement(search1).clear();
        driver.findElement(search1).sendKeys(keyword);
        Thread.sleep(2000);
        
     
    }
    
    public void enterSearchKeyword1(String keyword1) throws InterruptedException {
    	driver.findElement(search1).clear();
        driver.findElement(search1).sendKeys(keyword1);
        Thread.sleep(2000);
     
    }
    
    public void clickSearch() throws InterruptedException {
        driver.findElement(searchButton).click();
        Thread.sleep(2000);
        
    }

}