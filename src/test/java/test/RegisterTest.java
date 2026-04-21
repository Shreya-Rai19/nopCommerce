package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.CredentialUtil;
import utils.DriverManager;

public class RegisterTest extends DriverManager {
	
	@Test
	public void test1() throws InterruptedException{
		homepage.clickRegister();
		registerpage.clickOnMale();
		registerpage.enterFirstName("Admin");
		registerpage.enterLastName("admin");
		registerpage.enterEmail(CredentialUtil.email);
		registerpage.enterPassword(CredentialUtil.password);
		registerpage.enterConfirmedPassword(CredentialUtil.password);
		registerpage.clickRegister();
		Assert.assertTrue(registerpage.getSuccessMessage().toLowerCase().equals("your registration completed"));
		registerpage.clickContinueButton();
	}
}
