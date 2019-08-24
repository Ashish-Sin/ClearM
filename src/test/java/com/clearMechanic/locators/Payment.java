package com.clearMechanic.locators;

import org.openqa.selenium.By;

public enum Payment implements ILocator {

	NewCardRadioButton(By.xpath("//android.widget.TextView[contains(@resource-id,'com.myclearMechanicapp:id/pay_item_tv1') and @text='New Card']")),
	DebitCardRadioButton(By.id("com.myclearMechanicapp:id/radio_opt2")),
	CardNumberInputField(By.id("com.myclearMechanicapp:id/et_card_number")),
	CardUserNameInputField(By.id("com.myclearMechanicapp:id/et_card_name")),
	ExpiryDateInputField(By.id("com.myclearMechanicapp:id/et_expiry")),
	CVVInputField(By.id("com.myclearMechanicapp:id/et_cvv")),
	PayNowButton(By.id("com.myclearMechanicapp:id/btn_pay_now")),
	clearMechanicMoneyWallet(By.xpath("//android.widget.TextView[contains(@resource-id,'com.myclearMechanicapp:id/pay_item_tv1') and @text='clearMechanic Money']")),
	MPINTextbox(By.id("com.myclearMechanicapp:id/pay_item_et_code")),
	ProceedButton(By.id("com.myclearMechanicapp:id/pay_item_btn_proceed"));

	private final By locator;

	Payment(By locator) {
		this.locator = locator;
	}

	@Override
	public By toBy() {
		return locator;
	}

	public static By getManuLocator(int index) {
		return By.xpath(String.format("//*[@id='com.myclearMechanicapp:id/et_input_box']['%s']", index));
	}

}
