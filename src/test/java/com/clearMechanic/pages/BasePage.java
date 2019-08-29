package com.clearMechanic.pages;

import org.openqa.selenium.By;

import com.clearMechanic.core.ButtonControl;
import com.clearMechanic.core.IBasePage;
import com.clearMechanic.core.MobileClient;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public abstract class BasePage extends MobileClient implements IBasePage {

//	protected AppiumDriver<MobileElement> driver;

	public BasePage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}

//	public AppiumDriver<MobileElement> getApiumDriver() {         // Need to find out how it differs from AndroidDriver
//		return driver;
//	}
//
//	public AndroidDriver<MobileElement> getAndroidDriver() {       // Need to move this to MobileClient
//		return (AndroidDriver<MobileElement>) driver;
//	}
	
	public ButtonControl back = new ButtonControl(getAppiumDriver(), By.xpath("//*[contains(@resource-id, 'btnLeftButton')]"));
	public ButtonControl done = new ButtonControl(getAppiumDriver(), By.xpath("//*[contains(@resource-id, 'btnRightButton')]"));

}
