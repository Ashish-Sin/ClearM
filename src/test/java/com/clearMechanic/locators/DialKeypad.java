package com.clearMechanic.locators;

import org.openqa.selenium.By;

public enum DialKeypad implements ILocator {

	DailKeypadButton(By.id("com.android.dialer:id/floating_action_button")),
	KeyStar(By.id("com.android.dialer:id/star")),
	KeyOne(By.id("com.android.dialer:id/one")),
	KeyTwo(By.id("com.android.dialer:id/two")),
	KeyHash(By.id("com.android.dialer:id/pound")),
	CallButton(By.id("com.android.dialer:id/dialpad_floating_action_button")),
	OkPopupButton(By.id("android:id/button1")),
	CancelPopupButton(By.id("android:id/button2"));

	private final By locator;

	DialKeypad(By locator) {
		this.locator = locator;
	}

	@Override
	public By toBy() {
		return locator;
	}

//	public static By getManuLocator(int index) {
//		return By.xpath(String.format("//*[@id='com.myclearMechanicapp:id/et_input_box']['%s']", index));
//	}

}
