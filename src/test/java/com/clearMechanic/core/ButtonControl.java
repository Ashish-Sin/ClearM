package com.clearMechanic.core;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ButtonControl extends TestFramework {

	public ButtonControl(AndroidDriver<MobileElement> driver, By by) {
		  super(driver, by);
	}
	
	public String getText() {
		return this.getMobileElement().getText();
	}
}
