package com.clearMechanic.locators;

import org.openqa.selenium.By;

public enum History implements ILocator {

	HistoryTab(By.id("com.clearcheck.cmbeta:MainView/tbHistory")),
	SearchField(By.xpath("//*[contains(@resource-id, 'txtSearchFilter')]"));
	
	private final By locator;

	History(By locator) {
		this.locator = locator;
	}

	@Override
	public By toBy() {
		return locator;
	}

}
