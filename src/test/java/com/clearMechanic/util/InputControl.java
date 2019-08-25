package com.clearMechanic.util;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class InputControl extends TestFramework {
	
	public InputControl(AppiumDriver<MobileElement> driver, By by) {
		  super(driver, by);
	}
	
	public MobileElement setText(String text) {
		MobileElement element = getMobileElement(getLocatorBy());
		element.clear();
		element.sendKeys(text);
		return element;
	}

	public MobileElement appendText(String text) {
		MobileElement element = getMobileElement(getLocatorBy());
		element.sendKeys(text);
		return element;
	}
	
	private MobileElement getMobileElement(By by) {
//		waitForElementPresent(by);
		return driver.findElement(getLocatorBy());
	}

}
