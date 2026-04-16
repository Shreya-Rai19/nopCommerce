package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.DriverManager;

public class InvalidLogin extends DriverManager {

    @DataProvider(name = "invalidCredentials")
    public Object[][] invalidCredentials() {
        return new Object[][] {
            // Updated expected messages to match actual site responses
            {"wronguser@example.com", "wrongpassword", "Login was unsuccessful"},
            {"validuser@example.com", "wrongpassword", "Login was unsuccessful"},
            {"wronguser@example.com", "ValidPassword123", "Login was unsuccessful"},
            {"", "somepassword", "Please enter your email"},
            {"user@example.com", "", "Login was unsuccessful"},
            {"", "", "Please enter your email"} // corrected
        };
    }

    @Test(dataProvider = "invalidCredentials")
    public void testInvalidLogin(String email, String password, String expectedMessage) {
        driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");

        // Use the page object created in DriverManager
        invalidPage.enterEmail(email);
        invalidPage.enterPassword(password);
        invalidPage.clickLogin();

        String errorText = invalidPage.getErrorMessage();

        System.out.println("Test case completed for credentials: " + email + " / " + password);
        System.out.println("Error message displayed: " + errorText);

        // Assertion: check if the actual error contains the expected message
        Assert.assertTrue(errorText.contains(expectedMessage),
                "Expected: " + expectedMessage + " but got: " + errorText);
    }
}
