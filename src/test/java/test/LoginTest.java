package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.CredentialUtil;
import utils.DriverManager;

public class LoginTest extends DriverManager{
	
    @Test
    public void validLoginTest(){

        // Perform actions
        homepage.clickLogout();
        loginpage.clickLogin();
        loginpage.enterEmail(CredentialUtil.email);
        loginpage.enterPassword(CredentialUtil.password);
        loginpage.clickLoginButton();

        // Validation
        Assert.assertTrue(loginpage.isLoginSuccessful(), "Login Failed");

    }
}