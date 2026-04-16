package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCart {
	WebDriver driver;
	WebDriverWait wait;
	
	public AddToCart(WebDriver driver,WebDriverWait wait){
		this.driver = driver;
		this.wait = wait;
	}
	By electronics=By.xpath("//img[@alt='Picture for category Electronics']");
	By camera=By.xpath("//img[@alt='Picture for category Camera & photo']");
	By apple=By.xpath("//img[@alt='Picture of Apple iCam']");
	
	By addApple=By.id("add-to-cart-button-17");
	
	By home=By.xpath("//span[text()='Home']");
	By apparel=By.xpath("//img[@alt='Picture for category Apparel']");
	By accessories=By.xpath("//img[@alt='Picture for category Accessories']");
	By glass=By.xpath("//img[@alt='Picture of Ray Ban Aviator Sunglasses']");
	By addGlass=By.xpath("//*[@id=\"add-to-cart-button-35\"]");
	By header = By.tagName("h1");
	
	By book=By.linkText("Books");
	By pieBook=By.xpath("//img[@alt='Picture of First Prize Pies']");
	By addBook=By.id("add-to-cart-button-37");
	By close=By.xpath("//p[@class='content']");
	By cart=By.xpath("//a[@class='ico-cart']");
	public void selectElectronics()
	{
		driver.findElement(home).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(electronics)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(camera)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(apple)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(addApple)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".bar-notification.success")));

	}
	
	public void selectApparel()
	{
		//driver.findElement(home).click();
		Actions action = new Actions(driver);
		driver.findElement(apparel).click();
		driver.findElement(accessories).click();
		driver.findElement(glass).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(header));
		wait.until(ExpectedConditions.visibilityOfElementLocated(addGlass));
		WebElement addToCart = wait.until(ExpectedConditions.visibilityOfElementLocated(addGlass));
		addToCart.click();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(addGlass)).click();
		action.click(addToCart).build().perform();
		System.out.println(addToCart.getText());
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".bar-notification.success")));
	}
	
	public void selectBooks()
	{
		driver.findElement(book).click();
		driver.findElement(pieBook).click();
		driver.findElement(addBook).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".bar-notification.success")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(close)).click();
	}
	public void displayCart()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(cart)).click();
	}
	

}
