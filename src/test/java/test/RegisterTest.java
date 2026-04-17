package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.DriverManager;

public class RegisterTest extends DriverManager {
	
	@Test
	public void test1() throws InterruptedException{
		homepage.clickRegister();
		registerpage.clickOnMale();
		registerpage.enterFirstName("Admin");
		registerpage.enterLastName("admin");
		String uniqueEmail = "admin9@gmail.com";
		registerpage.enterEmail(uniqueEmail);
		registerpage.enterPassword("password");
		registerpage.enterConfirmedPassword("password");
		registerpage.clickRegister();
		Assert.assertTrue(registerpage.getSuccessMessage().toLowerCase().equals("your registration completed"));
		registerpage.clickContinueButton();
	}
}
