package com.automation.stepdef;

import org.junit.Assert;

import com.automation.page.LoginPage;
import com.automation.utils.DriverUtils;
import com.automation.utils.PropertyReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * Implementation of cucumber steps for login page
 * 
 * @author Guligeinap
 */
public class LoginSteps {

	LoginPage loginPage = new LoginPage(DriverUtils.getDriver());

	@Given("user open website")
	public void user_open_website() {
		loginPage.openWebsite();
	}

	@Then("verify user is on login page")
	public void verify_user_is_on_login_page() {
		Assert.assertTrue("Login page is not displayed", loginPage.isPageTitleDisplayed());
		Assert.assertTrue("Username is missing from login page", loginPage.isUsernameFieldDisplayed());
		Assert.assertTrue("Password is missing from login page", loginPage.isPasswordFieldDisplayed());
		Assert.assertTrue("Login button is missing from login page", loginPage.isLoginBtnDisplayed());
	}

	@When("user login with username {string} and password {string}")
	public void login_with_username_and_password(String usernameKey, String passwordKey) {
		loginPage.doLogin(usernameKey, passwordKey);
	}

	@When("verify login is successful")
	public void verifyLoginSuccessful() {
		Assert.assertTrue("Login success message is not displayed", loginPage.isLoginSuccessMsgDisplayed());
	}

	@Then("verify invalid login error messsge {string} is displayed")
	public void verify_invalid_login_error_messsge_is_displayed(String errorMsg) {
		Assert.assertTrue("Invalid login error is not displayed", loginPage.isInvalidLoginErrorDisplayed());
		Assert.assertTrue(loginPage.getInvalidLoginErrorMsg().contains(errorMsg));
	}

}
