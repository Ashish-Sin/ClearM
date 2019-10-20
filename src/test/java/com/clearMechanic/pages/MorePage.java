package com.clearMechanic.pages;

import org.openqa.selenium.By;

import com.clearMechanic.core.ButtonControl;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class MorePage extends BasePage {

	public MorePage(AndroidDriver<MobileElement> driver) {
		super(driver);
	}

	public ButtonControl settings = new ButtonControl(driver, By.id(""));
	public ButtonControl refresh = new ButtonControl(driver, By.id(""));
	public ButtonControl contactUs = new ButtonControl(driver, By.id(""));

	@Override
	public void goTo() {
		// TODO Auto-generated method stub
		
	}
}
