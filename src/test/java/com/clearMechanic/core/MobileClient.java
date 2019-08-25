package com.clearMechanic.core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MobileClient {

public AppiumDriver<MobileElement> driver = null;
	
	public void setAppiumDriver(AppiumDriver<MobileElement> appiumDriver) {
		this.driver = appiumDriver;
	}
	
	public AppiumDriver<MobileElement> getAppiumDriver() {
		if (driver == null) {
			driver = theAppiumDriver;
		}
		return driver;
	}
	
	private static AppiumDriver<MobileElement> theAppiumDriver;
	
	public void setTheAppiumDriver(AppiumDriver<MobileElement> driver) {
		theAppiumDriver = driver;
	}
	
}
