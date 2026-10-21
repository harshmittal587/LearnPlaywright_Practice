package com.salesforce.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.salesforce.base.BaseTest;

public class ValidLoginTest extends BaseTest {

    @Test(groups = "valid", description = "Verify login form accepts valid credentials and leaves the login screen")
    public void shouldAuthenticateWithValidCredentials() {
        try {
            loginPage.login("qa.automation@salesforce.com", "Valid@Password123");
            Assert.assertFalse(loginPage.isErrorDisplayed(),
                    "No inline error should be displayed for valid credentials");
        } catch (RuntimeException exception) {
            Assert.fail("Valid login flow failed unexpectedly: " + exception.getMessage(), exception);
        }
    }

    @Test(groups = "valid", description = "Verify valid login with remember me selected")
    public void shouldAuthenticateWithValidCredentialsAndRememberMe() {
        try {
            loginPage.loginWithRememberMe("qa.automation@salesforce.com", "Valid@Password123");
            Assert.assertFalse(loginPage.isErrorDisplayed(),
                    "No inline error should be displayed when remember me is selected");
        } catch (RuntimeException exception) {
            Assert.fail("Valid login with remember me failed unexpectedly: " + exception.getMessage(), exception);
        }
    }
}
