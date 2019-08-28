package com.clearMechanic.locators;

import org.openqa.selenium.By;

public enum Home implements ILocator {

	HomeTab(By.id("com.clearcheck.cmbeta:MainView/tbHome")),
	FullInspection(By.xpath("//*[contains(@resource-id, 'btnFullInspection')]")),
	SingleItem(By.xpath("//*[contains(@resource-id, 'btnSingleItem')]"));
	
	private final By locator;

	Home(By locator) {
		this.locator = locator;
	}

	@Override
	public By toBy() {
		return locator;
	}

}
