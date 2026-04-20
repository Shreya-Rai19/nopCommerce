package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
	WebDriver driver;
	WebDriverWait wait;
	
	public CheckoutPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	By button;
	By agreement = By.xpath("//input[@id='termsofservice']");
	By countryDropDown = By.id("BillingNewAddress_CountryId");
	By stateDropDown = By.id("BillingNewAddress_StateProvinceId");
	By cityField = By.id("BillingNewAddress_City") ;
	By address1Field = By.id("BillingNewAddress_Address1");
	By pinCodeField = By.id("BillingNewAddress_ZipPostalCode");
	By phoneNumberField = By.id("BillingNewAddress_PhoneNumber");
	By billingContinue = By.cssSelector("button.new-address-next-step-button");
	
	By shippingContinue = By.cssSelector("button.shipping-method-next-step-button");

	By paymentContinue = By.cssSelector("button.payment-method-next-step-button");

	By paymentInfoContinue = By.xpath("//*[@id=\"payment-info-buttons-container\"]/button");
	
	By finalContinue = By.xpath("//*[@id=\"confirm-order-buttons-container\"]/button");

	
	
	By shippingMethod; 
	By paymentBy = By.xpath("//input[@name='paymentmethod']");
	By confirmationMessage = By.xpath("//*[@id=\"main\"]/div/section/div/div[2]/div/h2");
	By orderNumber = By.tagName("strong");
			
	public void setButton(String name) {
		button = By.xpath("//button[contains(text(),'"+name+"')]");
	}
	
	public void clickButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(button)).click();
	}
	
	public void clickAgreement() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(agreement)).click();
	}
	
	public void setCountry(String country) {
		Select select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(countryDropDown)));
		select.selectByVisibleText(country);
	}
	
	public void setState(String state) {
		Select select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(stateDropDown)));
		select.selectByVisibleText(state);
	}
	
	public void setCity(String city) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(cityField)).sendKeys(city);
	}
	
	public void setAddress(String address) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(address1Field)).sendKeys(address);
	}
	
	public void setPin(String pin) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(pinCodeField)).sendKeys(pin);
	}
	
	public void setPhoneNo(String phoneNo) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumberField)).sendKeys(phoneNo);
	}
	
	public void clickShippingContinue() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(shippingContinue)).click();
	}
	
	public void clickPaymentInfoContinue() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(paymentInfoContinue)).click();
	}
	
	public void clickBillingContinue() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(billingContinue)).click();
	}
	
	public void clickpaymentContinue() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(paymentContinue)).click();
	}
	
	public void clickFinalContinue(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(finalContinue)).click();
	}
	
	public void clickCheckoutMethod(String method) {
		switch(method.toLowerCase()) {
		case "ground" :
			shippingMethod = By.id("shippingoption_0");
			break;
		case "next day air":
			shippingMethod = By.id("shippingoption_1");
			break;
		case "2nd day air":
			shippingMethod = By.id("shippingoption_2");
			break;
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(shippingMethod)).click();
	}
	
	public void selectPaymentMethod(String paymentMethod) {
		List<WebElement> methods = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(paymentBy));
		if(paymentMethod.equalsIgnoreCase("check") ||paymentMethod.equalsIgnoreCase("money order") )
			methods.get(0).click();
		if(paymentMethod.equalsIgnoreCase("credit card"))
			methods.get(1).click();
	}
	
	public String getConfirmationMessage() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMessage)).getText();
	}
	
	public String getOrderNumberText() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(orderNumber)).getText();
	}
}
