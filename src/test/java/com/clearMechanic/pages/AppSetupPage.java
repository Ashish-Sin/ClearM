package com.clearMechanic.pages;

import static com.clearMechanic.locators.AppSetup.ContinuePOPUP;
import static com.clearMechanic.locators.AppSetup.MobileNumberInputField;
import static com.clearMechanic.locators.AppSetup.OTPInputField;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import com.clearMechanic.pages.BasePage;
import com.clearMechanic.util.FileReader;

public class AppSetupPage extends BasePage {

	public AppSetupPage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	public AppSetupPage verifyMobileNumber() throws Exception {
		String value = FileReader.readData("MobileNumber");
		appendText(MobileNumberInputField.toBy(), value);
		hideKeyboard();
		return this;
	}

	public AppSetupPage enterOTP() {
		click(OTPInputField.toBy());
		return this;
	}

	public HomePage clickContinuePOPUP() {
		click(ContinuePOPUP.toBy());
		return new HomePage(driver);
	}
}
