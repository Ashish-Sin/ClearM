package com.clearMechanic.locators;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;

public enum History implements ILocator {

	HistoryTab(MobileBy.AccessibilityId("History")),
	SearchByRONumber(MobileBy.AccessibilityId("Search by RO number"));
	
	private final By locator;

	History(By locator) {
		this.locator = locator;
	}

	@Override
	public By toBy() {
		return locator;
	}

}
