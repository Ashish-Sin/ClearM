package com.clearMechanic.util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MobileClient {

public AppiumDriver<MobileElement> driver = null;
	
	public void setWebDriver(AppiumDriver<MobileElement> webDriver) {
		this.driver = webDriver;
	}
	
	public AppiumDriver<MobileElement> getWebDriver() {
		if (driver == null) {
			driver = theWebDriver;
		}
		return driver;
	}
	
	private static AppiumDriver<MobileElement> theWebDriver;
	
	public void setTheWebDriver(AppiumDriver<MobileElement> driver) {
		theWebDriver = driver;
	}
	
}
