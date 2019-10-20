package com.clearMechanic.pages;

import org.openqa.selenium.By;

import com.clearMechanic.core.ButtonControl;
import com.clearMechanic.core.IBasePage;
import com.clearMechanic.core.MobileClient;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public abstract class BasePage extends MobileClient implements IBasePage {

//	protected AndroidDriver<MobileElement> driver;

	public BasePage(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
	}

//	public AndroidDriver<MobileElement> getApiumDriver() {         // Need to find out how it differs from AndroidDriver
//		return driver;
//	}
//
//	public AndroidDriver<MobileElement> getAndroidDriver() {       // Need to move this to MobileClient
//		return (AndroidDriver<MobileElement>) driver;
//	}
	
	public ButtonControl back = new ButtonControl(getAndroidDriver(), By.xpath("//*[contains(@resource-id, 'btnLeftButton')]"));
	public ButtonControl done = new ButtonControl(getAndroidDriver(), By.xpath("//*[contains(@resource-id, 'btnRightButton')]"));

}
