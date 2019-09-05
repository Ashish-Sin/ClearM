package com.clearMechanic.locators;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;

public enum Login implements ILocator{
	
	Login(MobileBy.AccessibilityId("Tap Screen to Log In")),
	DealerOrShopName(MobileBy.ByAccessibilityId.xpath("//*[@value = 'Dealer or Shop Name']")),
	Email(MobileBy.ByAccessibilityId.xpath("//*[@value = 'E-mail']")),
	Password(MobileBy.ByAccessibilityId.xpath("//*[@value = 'Password']")),
	LoginButton(MobileBy.AccessibilityId("Log In!")),
//	BackButton(By.xpath("//*[contains(@resource-id, 'btnLeftButton') and text()='Back']")),
//	ForgotPassword(By.xpath("//*[contains(@resource-id, 'btnForgotPassword')]"));
	;


	
	private final By locator;

	Login(By locator) {
		this.locator = locator;
	}

	@Override
	public By toBy() {
		return locator;
	}

}
