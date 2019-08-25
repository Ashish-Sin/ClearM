package com.clearMechanic.util;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ButtonControl extends TestFramework {

	public ButtonControl(AppiumDriver<MobileElement> driver, By by) {
		  super(driver, by);
	}
}
