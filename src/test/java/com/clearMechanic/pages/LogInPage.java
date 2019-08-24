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

import com.clearMechanic.pages.BasePage;
import com.clearMechanic.util.FileReader;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LogInPage extends BasePage {
	private static final Logger logger = LoggerFactory.getLogger(LogInPage.class);
	public LogInPage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	
	private void clickOnLogInButton() {
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
	
	private void goTo() {
		waitForElementClickable(Login.toBy());
		click(Login.toBy());
		logger.debug("Click on 'Tap Screen To Log In' link");

	}
	
	public void enterDetails() throws Exception {
		waitForElementClickable(DealerOrShopName.toBy());
		setText(DealerOrShopName.toBy(), FileReader.readData("DealerName"));
		logger.debug("Enter Dealer Or Shop name");
		waitForElementClickable(Email.toBy());
		setText(Email.toBy(), FileReader.readData("Email"));
		logger.debug("Enter User name");
		setText(Password.toBy(), FileReader.readData("Password"));
		logger.debug("Enter Password");
	}
	
	public void logintoApp() throws Exception {
		this.goTo();
		enterDetails();
		clickOnLogInButton();
	}

}
