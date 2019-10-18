package com.clearMechanic.pages;

import static com.clearMechanic.locators.Login.DealerOrShopName;
import static com.clearMechanic.locators.Login.Email;
import static com.clearMechanic.locators.Login.Login;
import static com.clearMechanic.locators.Login.LoginButton;
import static com.clearMechanic.locators.Login.Password;
import static com.clearMechanic.locators.Login.ForgotPassword;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.clearMechanic.core.ButtonControl;
import com.clearMechanic.core.InputControl;
import com.clearMechanic.core.Log;
import com.clearMechanic.reporter.ExtentTestManager;
import com.clearMechanic.util.ConsoleLog;
import com.clearMechanic.util.FileReader;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LogInPage extends BasePage {
	private static final Logger logger = LoggerFactory.getLogger(LogInPage.class);
	
	private final static String DEALER_NAME = FileReader.readData("DealerName");
	private final static String EMAIL = FileReader.readData("Email");
	private final static String PASSWORD = FileReader.readData("Password");

	public LogInPage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	public ButtonControl tapToLogin = new ButtonControl(getAppiumDriver(), Login.toBy());
	public InputControl dealerName = new InputControl(getAppiumDriver(), DealerOrShopName.toBy());
	public InputControl email = new InputControl(getAppiumDriver(), Email.toBy());
	public InputControl password = new InputControl(getAppiumDriver(), Password.toBy());
	public ButtonControl loginButton = new ButtonControl(getAppiumDriver(), LoginButton.toBy());
	public ButtonControl forgotPassword = new ButtonControl(getAppiumDriver(), ForgotPassword.toBy());

	public void goTo() {	
		tapToLogin.click();
		ConsoleLog.log("Click on login button");
		Log.info("Click on login button");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on login button");
	}

	private void enterDetails() throws Exception {
		dealerName.setText(DEALER_NAME);
		Log.info("Enter Dealer name");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Dealer name as : " + DEALER_NAME);

		email.setText(EMAIL);
		Log.info("Enter user email");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter user email address : " + EMAIL);

		password.setText(PASSWORD);
		Log.info("Set password in Login form");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Set password in Login form");
	}

	public void logintoApp() throws Exception {
		this.goTo();
		enterDetails();
		loginButton.click();
		ConsoleLog.log("User has logged in Successfully");
	}

}
