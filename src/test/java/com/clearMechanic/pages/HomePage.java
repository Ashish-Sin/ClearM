package com.clearMechanic.pages;

import static com.clearMechanic.locators.Home.MobileNumberInputField;
import static com.clearMechanic.locators.Home.PrepaidRechargeRadioButton;
import static com.clearMechanic.locators.Home.RechargeTab;

import com.clearMechanic.appium.core.BasePage;
import com.clearMechanic.util.FileReader;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class HomePage extends BasePage {

	public HomePage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	public HomePage clickOnNavigation() {
		waitForElementClickable(RechargeTab.toBy());
		click(RechargeTab.toBy());
		return this;
	}
	
	public HomePage clickRechargeTab() {
		waitForElementClickable(RechargeTab.toBy());
		click(RechargeTab.toBy());
		return this;
	}

	public HomePage selectPrepaidRadioButton() {
		click(PrepaidRechargeRadioButton.toBy());
		return this;
	}

	public HomePage enterMobileNumberToRecharge() throws Exception {
		String value = FileReader.readTestData("MobileNumber");
		appendText(MobileNumberInputField.toBy(), value);
		hideKeyboard();
		return this;
	}
}
