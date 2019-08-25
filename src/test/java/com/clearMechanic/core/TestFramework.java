package com.clearMechanic.core;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TestFramework extends MobileClient {
	
	private By locateBy;

	public TestFramework(AppiumDriver<MobileElement> driver, By by) {
		this.driver = driver;
		locateBy = by;
	}
	
	protected By getLocatorBy() {
		return locateBy;
	}
	
	public void click() {
		driver.findElement(locateBy).click();
	}
	
	protected MobileElement getMobileElement() {
//		waitForElementPresent(by);
		return driver.findElement(getLocatorBy());
	}
	
}
