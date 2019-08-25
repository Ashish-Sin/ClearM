package com.clearMechanic.pages;

import static com.clearMechanic.locators.Login.BackButton;
import static com.clearMechanic.locators.Login.DealerOrShopName;
import static com.clearMechanic.locators.Login.Email;
import static com.clearMechanic.locators.Login.ForgotPassword;
import static com.clearMechanic.locators.Login.Login;
import static com.clearMechanic.locators.Login.LoginButton;
import static com.clearMechanic.locators.Login.Password;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.clearMechanic.util.ButtonControl;
import com.clearMechanic.util.FileReader;
import com.clearMechanic.util.InputControl;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LogInPage extends BasePage {
	private static final Logger logger = LoggerFactory.getLogger(LogInPage.class);

	public LogInPage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	public ButtonControl tapToLogin = new ButtonControl(getWebDriver(), Login.toBy());
	public InputControl dealerName = new InputControl(getWebDriver(), DealerOrShopName.toBy());
	public InputControl email = new InputControl(getWebDriver(), Email.toBy());
	public InputControl password = new InputControl(getWebDriver(), Password.toBy());
	public ButtonControl loginButton = new ButtonControl(getWebDriver(), LoginButton.toBy());

	public void clickOnBackButton() {
		waitForElementClickable(BackButton.toBy());
		click(BackButton.toBy());
		logger.debug("Click on 'BackButton' Button");

	}

	public void clickOnForgotPasswordLink() {
		waitForElementClickable(ForgotPassword.toBy());
		click(ForgotPassword.toBy());
		logger.debug("Click on 'Forgot Password ?' link");

	}

	private void goTo() {
		tapToLogin.click();
	}

	private void enterDetails() throws Exception {
		dealerName.setText(FileReader.readData("DealerName"));
		email.setText(FileReader.readData("Email"));
		password.setText(FileReader.readData("Password"));
	}

	public void logintoApp() throws Exception {
		this.goTo();
		enterDetails();
		loginButton.click();
	}

}
