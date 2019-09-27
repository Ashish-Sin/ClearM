package com.clearMechanic.locators;

import org.openqa.selenium.By;
import io.appium.java_client.MobileBy;

public enum Inspection implements ILocator {
	InspectionTab(MobileBy.AccessibilityId("Inspection")),
	VehicleReception(MobileBy.AccessibilityId("Vehicle Reception")),
	InspectionItems(MobileBy.AccessibilityId("Inspection Items")),
	RO(MobileBy.AccessibilityId("RO")),
	Plates(MobileBy.AccessibilityId("Plates")),
	TextField(MobileBy.ByAccessibilityId.xpath("//*[@type='XCUIElementTypeTextField']")),
	AddInspectionItemSearchField(MobileBy.AccessibilityId("Add inspection item")),
	TypeInVIN(MobileBy.AccessibilityId("Type in VIN")),
	TakePhoto(MobileBy.AccessibilityId("Take Photo")),
	FirstPhoto(MobileBy.AccessibilityId("Photo #1")),
	ClickPhoto(By.xpath("//*[contains(@name, 'camera_icon')]")),
	CloseCamera(By.xpath("//*[contains(@name, 'camera_close_icon')]")),
	OKButton(By.xpath("//*[contains(@name, 'apply')]")),
	DeleteButton(By.xpath("//*[contains(@name, 'camera_close')]")),
	Arrow(By.xpath("//XCUIElementTypeImage[contains(@name, '.jpg')]/following-sibling::XCUIElementTypeOther")),
	AddArrow(By.xpath("//*[contains(@name, 'arrow_overlay.png')]"));
	
	
	private final By locator;

	Inspection(By locator) {
		this.locator = locator;
	}

	@Override
	public By toBy() {
		return locator;
	}

}
