package com.clearMechanic.locators;

import org.openqa.selenium.By;

public enum AppSetup implements ILocator {

	MobileNumberInputField(By.id("com.myclearMechanicapp:id/et_input_box")),
	OTPInputField(By.id("com.myclearMechanicapp:id/btn_send_otp")),
	ContinuePOPUP(By.id("com.myclearMechanicapp:id/contiue_button")), ;

	private final By locator;

	AppSetup(By locator) {
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
