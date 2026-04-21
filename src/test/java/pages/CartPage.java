package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.CartPage;

public class CartPage {

	WebDriver driver;
	WebDriverWait wait;
	
	 public CartPage(WebDriver driver,WebDriverWait wait) {
	        this.driver = driver;
	        this.wait =wait;
	    }

	
	 private By cartLink = By.className("ico-cart");
	    private By removeCheckbox = By.name("removefromcart");
	    private By updateCartBtn = By.name("updatecart");
	    private By emptyCartMsg = By.cssSelector(".no-data");
	    
	    public CartPage goToCart() {
	    	wait.until(ExpectedConditions.elementToBeClickable(cartLink)).click();
	        return this;   
	    }

	 
	    public int getItemCount() {

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        wait.until(ExpectedConditions.visibilityOfElementLocated(
	                By.cssSelector(".cart")));

	      
	        List<WebElement> qty = driver.findElements(
	                By.cssSelector("input.qty-input"));

	        return qty.size();
	    }
	    
	    public CartPage removeTwoItems() {

	        for (int i = 0; i < 2; i++) {

	            List<WebElement> checkboxes = driver.findElements(removeCheckbox);

	            if (checkboxes.isEmpty()) {
	                System.out.println("Cart already empty");
	                break;
	            }

	            WebElement checkbox = checkboxes.get(0);

	            int sizeBefore = checkboxes.size();

	            ((JavascriptExecutor) driver).executeScript(
	                    "arguments[0].click();", checkbox);

	            driver.findElement(updateCartBtn).click();

	            wait.until(d -> d.findElements(removeCheckbox).size() < sizeBefore);
	        }
	        return this;
	    }
	    
	    public String getEmptyCartMessage() {

	      
	        wait.until(ExpectedConditions.numberOfElementsToBe(
	                By.cssSelector("input.qty-input"), 0));

	        return wait.until(ExpectedConditions.visibilityOfElementLocated(
	                emptyCartMsg)).getText();
	    }
}