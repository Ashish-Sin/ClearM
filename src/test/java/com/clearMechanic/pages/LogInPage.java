package com.clearMechanic.pages;

import static com.clearMechanic.locators.Login.DealerOrShopName;
import static com.clearMechanic.locators.Login.Email;
import static com.clearMechanic.locators.Login.Login;
import static com.clearMechanic.locators.Login.LoginButton;
import static com.clearMechanic.locators.Login.Password;
import static com.clearMechanic.locators.Login.ForgotPassword;

import com.clearMechanic.core.ButtonControl;
import com.clearMechanic.core.InputControl;
import com.clearMechanic.reporter.ExtentTestManager;
import com.clearMechanic.util.ConsoleLog;
import com.clearMechanic.util.FileReader;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class LogInPage extends BasePage {
	
	private final static String DEALER_NAME = FileReader.readData("DealerName");
	private final static String EMAIL = FileReader.readData("Email");
	private final static String PASSWORD = FileReader.readData("Password");

	public LogInPage(AndroidDriver<MobileElement> driver) {
		super(driver);
	}

	public ButtonControl tapToLogin = new ButtonControl(getAndroidDriver(), Login.toBy());
	public InputControl dealerName = new InputControl(getAndroidDriver(), DealerOrShopName.toBy());
	public InputControl email = new InputControl(getAndroidDriver(), Email.toBy());
	public InputControl password = new InputControl(getAndroidDriver(), Password.toBy());
	public ButtonControl loginButton = new ButtonControl(getAndroidDriver(), LoginButton.toBy());
	public ButtonControl forgotPassword = new ButtonControl(getAndroidDriver(), ForgotPassword.toBy());

	public void goTo() {	
		tapToLogin.click();
		ConsoleLog.log("Click on login button");
	}

	private void enterDetails() throws Exception {
		dealerName.setText(DEALER_NAME);
		ConsoleLog.log("Enter Dealer name");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Dealer name as : " + DEALER_NAME);

		email.setText(EMAIL);
		ConsoleLog.log("Enter user email");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter user email address : " + EMAIL);

		password.setText(PASSWORD);
		ConsoleLog.log("Set password in Login form");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Set password in Login form");
	}

	public void logintoApp() throws Exception {
		this.goTo();
		enterDetails();
		loginButton.click();
		ConsoleLog.log("User has logged in Successfully");
	}

}
