package steps;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CredentialUtil;
import utils.DriverManager;
import utils.Hooks;

public class CheckoutSteps{
	@Given("the user has added a product to the shopping cart")
	public void addProductToCart() {
		Hooks.homepage.clickRegister();
		Hooks.registerpage.clickOnMale();
		Hooks.registerpage.enterFirstName("Admin");
		Hooks.registerpage.enterLastName("admin");
		Hooks.registerpage.enterEmail(CredentialUtil.email);
		Hooks.registerpage.enterPassword(CredentialUtil.password);
		Hooks.registerpage.enterConfirmedPassword(CredentialUtil.password);
		Hooks.registerpage.clickRegister();
		
		Hooks.homepage.clickLogout();
		Hooks.loginpage.clickLogin();
        Hooks.loginpage.enterEmail(CredentialUtil.email);
        Hooks.loginpage.enterPassword(CredentialUtil.password);
        Hooks.loginpage.clickLoginButton();
        
        Hooks.addtocart.selectApparel();
	}
	
	@When("the user navigates to the shopping cart")
	public void userNavigatesToCart() {
		Hooks.cart.goToCart();
	}
	
	@When("clicks on {string}")
    public void clicks_on_button(String buttonText) {
		if(buttonText.equalsIgnoreCase("checkout"))
			Hooks.checkoutpage.clickAgreement();
		if(buttonText.equalsIgnoreCase("confirm")) {
			Hooks.checkoutpage.clickPaymentInfoContinue();
			return;
		}
		Hooks.checkoutpage.setButton(buttonText);
		Hooks.checkoutpage.clickButton();
		
    }

    @When("enters valid billing address details")
    public void enters_billing_address() {
    	Hooks.checkoutpage.setCountry("India");
    	Hooks.checkoutpage.setState("Karnataka");
        Hooks.checkoutpage.setCity("Bangalore");
        Hooks.checkoutpage.setAddress("123 Main Road");
        Hooks.checkoutpage.setPin("123456");
        Hooks.checkoutpage.setPhoneNo("111111111");
        Hooks.checkoutpage.clickBillingContinue();
    }
    
    @When("selects {string} as Shipping Method")
    public void selectShippingMethod(String method) {
    	Hooks.checkoutpage.clickCheckoutMethod(method);
    	Hooks.checkoutpage.clickShippingContinue();
    }

    @When("selects {string} as the payment method")
    public void selects_payment_method(String paymentMethod) {
    	Hooks.checkoutpage.selectPaymentMethod(paymentMethod);
    	Hooks.checkoutpage.clickpaymentContinue();
    }
    
    @When("finally clicks on {string}")
    public void clickOnContinue(String message){
    	Hooks.checkoutpage.clickFinalContinue();
    }

    @Then("the system should display an order confirmation message")
    public void system_processes_payment() {
        String confirmation = Hooks.checkoutpage.getConfirmationMessage();
        Assert.assertTrue(confirmation.contains("Your order has been successfully processed!"));
    }

    @Then("show an order number")
    public void show_order_number() {
        String orderNumber = Hooks.checkoutpage.getOrderNumberText();
        Assert.assertTrue(orderNumber.toLowerCase().contains("order number"));
    }

}
