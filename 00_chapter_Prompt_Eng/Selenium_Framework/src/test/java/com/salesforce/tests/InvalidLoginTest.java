package com.salesforce.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.salesforce.base.BaseTest;

public class InvalidLoginTest extends BaseTest {

    @DataProvider(name = "invalidCredentials")
    public Object[][] invalidCredentials() {
        return new Object[][] {
                {"invalid.user@salesforce.com", "WrongPassword123"},
                {"not-an-email", "SomePassword123"},
                {"", ""}
        };
    }

    @Test(groups = "invalid", dataProvider = "invalidCredentials",
            description = "Verify login is rejected and an error is shown for invalid credentials")
    public void shouldRejectInvalidCredentials(String username, String password) {
        try {
            loginPage.login(username, password);
            Assert.assertTrue(loginPage.isErrorDisplayed(),
                    "An error message must be displayed for invalid credentials");
            Assert.assertFalse(loginPage.getErrorMessage().isEmpty(),
                    "The displayed error message must not be empty");
        } catch (RuntimeException exception) {
            Assert.fail("Invalid login verification failed unexpectedly: " + exception.getMessage(), exception);
        }
    }
}
