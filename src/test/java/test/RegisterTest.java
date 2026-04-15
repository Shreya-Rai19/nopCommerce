package test;

import org.testng.annotations.Test;

import utils.DriverManager;

public class RegisterTest extends DriverManager {
	
	@Test
	public void test1(){
		homepage.clickRegister();
		registerpage.clickOnMale();
		registerpage.enterFirstName("Admin");
		registerpage.enterLastName("admin");
		registerpage.enterEmail("admin@gmail.com");
		registerpage.enterPassword("password");
		registerpage.enterConfirmedPassword("password");
	}
}
