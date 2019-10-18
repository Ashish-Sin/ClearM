package com.clearMechanic.core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MobileClient {

public static AppiumDriver<MobileElement> driver = null;
	
	public void setAppiumDriver(AppiumDriver<MobileElement> appiumDriver) {
		this.driver = appiumDriver;
	}
	
	public AppiumDriver<MobileElement> getAppiumDriver() {
		if (driver == null) {
			driver = theAppiumDriver;
		}
	//	System.out.println("Intialize driver ="+driver);
		return driver;
	}
	
	private static AppiumDriver<MobileElement> theAppiumDriver;                          // Yet to decide on it's visibility
	
	public void setTheAppiumDriver(AppiumDriver<MobileElement> driver) {
		theAppiumDriver = driver;
	}
	
}
