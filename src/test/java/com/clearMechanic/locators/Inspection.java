package com.clearMechanic.locators;

import org.openqa.selenium.By;

public enum Inspection implements ILocator {
	InspectionTab(By.id("com.clearcheck.cmbeta:MainView/tbInspection"));
	
	private final By locator;

	Inspection(By locator) {
		this.locator = locator;
	}

	@Override
	public By toBy() {
		return locator;
	}

}
