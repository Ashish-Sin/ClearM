package com.clearMechanic.pages;

import static com.clearMechanic.locators.Home.FullInspection;
import static com.clearMechanic.locators.Home.SingleItem;
import static com.clearMechanic.locators.Home.HomeTab;

import com.clearMechanic.core.ButtonControl;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class HomePage extends BasePage {

	public HomePage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	public ButtonControl fullInspection = new ButtonControl(getAppiumDriver(), FullInspection.toBy());
	public ButtonControl singleItem = new ButtonControl(getAppiumDriver(), SingleItem.toBy());
	public ButtonControl homeTab = new ButtonControl(getAppiumDriver(), HomeTab.toBy());
	
	
	public void goTo() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		homeTab.click();
	}
}
