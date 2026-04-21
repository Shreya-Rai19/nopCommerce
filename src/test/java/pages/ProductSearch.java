package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
    By searchResults = By.className("item-box");

    public void enterSearchKeyword(String keyword) throws InterruptedException {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(search1)).clear();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(search1)).sendKeys(keyword);
    }
    
    public void clickSearch() throws InterruptedException {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(searchButton)).click();
        
    }
    
    public int numberOfItems() {
    	List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(searchResults));
    	return elements.size();
    }

}