package com.clearMechanic.pages;

import static com.clearMechanic.locators.Home.MobileNumberInputField;

import com.clearMechanic.util.FileReader;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class HomePage extends BasePage {

	public HomePage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	public void goTo() {
		
	}

	public HomePage enterMobileNumberToRecharge() throws Exception {
		String value = FileReader.readTestData("MobileNumber");
		appendText(MobileNumberInputField.toBy(), value);
		hideKeyboard();
		return this;
	}
}
