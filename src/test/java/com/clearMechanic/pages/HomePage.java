package com.clearMechanic.pages;

import static com.clearMechanic.locators.Home.FullInspection;
import static com.clearMechanic.locators.Home.HomeTab;
import static com.clearMechanic.locators.Home.SingleItem;

import com.clearMechanic.core.ButtonControl;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class HomePage extends BasePage {

	public HomePage(AndroidDriver<MobileElement> driver) {
		super(driver);
	}

	public ButtonControl fullInspection = new ButtonControl(getAndroidDriver(), FullInspection.toBy());
	public ButtonControl singleItem = new ButtonControl(getAndroidDriver(), SingleItem.toBy());
	public ButtonControl homeTab = new ButtonControl(getAndroidDriver(), HomeTab.toBy());
	
	
	public void goTo() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		homeTab.click();
	}
}
