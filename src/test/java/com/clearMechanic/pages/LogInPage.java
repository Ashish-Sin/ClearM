package com.clearMechanic.pages;

import static com.clearMechanic.locators.Login.DealerOrShopName;
import static com.clearMechanic.locators.Login.Email;
import static com.clearMechanic.locators.Login.Login;
import static com.clearMechanic.locators.Login.Password;
import static com.clearMechanic.locators.Login.LoginButton;
import static com.clearMechanic.locators.Login.ForgotPassword;
import static com.clearMechanic.locators.Login.BackButton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.clearMechanic.appium.core.BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LogInPage extends BasePage {
	private static final Logger logger = LoggerFactory.getLogger(LogInPage.class);
	public LogInPage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	
	public void clickOnLogInButton() {
		waitForElementClickable(LoginButton.toBy());
		click(LoginButton.toBy());
		logger.debug("Click on 'Log In' Button");
		
	}
	
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
	
	public void naviagateTo() {
		waitForElementClickable(Login.toBy());
		click(Login.toBy());
		logger.debug("Click on 'Tap Screen To Log In' link");

	}
	
	public void enterDetails() {
		waitForElementClickable(DealerOrShopName.toBy());
		setText(DealerOrShopName.toBy(), "Demo Repair Shop");
		logger.debug("Enter Dealer Or Shop name");
		setText(Email.toBy(), "test113@test.com");
		logger.debug("Enter User name");
		setText(Password.toBy(), "P@ssw0rd");
		logger.debug("Enter Password");
	}
	
	public void logintoApp() {
		naviagateTo();
		enterDetails();
		clickOnLogInButton();
	}

}
