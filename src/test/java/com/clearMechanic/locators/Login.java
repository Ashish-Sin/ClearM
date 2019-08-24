package com.clearMechanic.locators;

import org.openqa.selenium.By;

public enum Login implements ILocator{
	
	Login(By.xpath("//*[@text = 'Tap Screen to Log In']")),
	DealerOrShopName(By.xpath("//*[@text = 'Dealer or Shop Name']")),
	Email(By.xpath("//*[@text = 'E-mail']")),
	Password(By.xpath("//*[contains(@resource-id, 'inputPassword')]")),
	LoginButton(By.xpath("//*[contains(@resource-id, 'btnLogIn')]")),
	BackButton(By.xpath("//*[contains(@resource-id, 'btnLeftButton') and text()='Back']")),
	ForgotPassword(By.xpath("//*[contains(@resource-id, 'btnForgotPassword')]"));
	


	
	private final By locator;

	Login(By locator) {
		this.locator = locator;
	}

	@Override
	public By toBy() {
		return locator;
	}

}
