package com.clearMechanic.locators;

import org.openqa.selenium.By;

public enum BestOffer implements ILocator {

	SpecialRechargeTab(By.xpath("//android.widget.TextView[@text='Special Recharge-STV, Combo']")),
	_2GDataRechargeTab(By.xpath("//android.widget.TextView[@text='2G Data Recharge']")),
	_3G4GDataRechargeTab(By.xpath("//android.widget.TextView[@text='3G/4G Data Recharge']")),
	SelectAmountToRecharge(By.id("com.myclearMechanicapp:id/lbl_amount")), ;

	private final By locator;

	BestOffer(By locator) {
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
