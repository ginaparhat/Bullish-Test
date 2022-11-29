package com.automation.page;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.utils.PropertyReader;

/**
 * Page object for login page
 * 
 * @author Guligeinap
 */
public class LoginPage extends BasePage {

	@FindBy(xpath = "//div[@class='example']/h2")
	WebElement pageTitle;

	@FindBy(id = "username")
	WebElement usernameInput;

	@FindBy(id = "password")
	WebElement passwordInput;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginBtn;

	@FindBy(xpath = "//div[@class='flash success']")
	WebElement loginSuccessMsg;

	@FindBy(xpath = "//div[@class='flash error']")
	WebElement invalidLoginError;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void openWebsite() {
		driver.get(PropertyReader.getProperty("ui.baseurl"));
	}

	public void doLogin(String usernmae, String password) {
		commonMethods.waitForElementToBeVisible(usernameInput);
		usernameInput.sendKeys(usernmae);
		passwordInput.sendKeys(password);
		loginBtn.click();
	}

	public boolean isPageTitleDisplayed() {
		return pageTitle.isDisplayed();
	}

	public boolean isUsernameFieldDisplayed() {
		return usernameInput.isDisplayed();
	}

	public boolean isPasswordFieldDisplayed() {
		return passwordInput.isDisplayed();
	}

	public boolean isLoginBtnDisplayed() {
		return loginBtn.isDisplayed();
	}

	public boolean isInvalidLoginErrorDisplayed() {
		return invalidLoginError.isDisplayed();
	}

	public String getInvalidLoginErrorMsg() {
		return invalidLoginError.getText().trim();
	}

	public boolean isLoginSuccessMsgDisplayed() {
		return loginSuccessMsg.isDisplayed();
	}

}
