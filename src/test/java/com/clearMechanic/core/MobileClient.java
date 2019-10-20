package com.clearMechanic.core;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class MobileClient {

public static AndroidDriver<MobileElement> driver = null;
	
	public void setAndroidDriver(AndroidDriver<MobileElement> AndroidDriver) {
		this.driver = AndroidDriver;
	}
	
	public AndroidDriver<MobileElement> getAndroidDriver() {
		if (driver == null) {
			driver = theAndroidDriver;
		}
	//	System.out.println("Intialize driver ="+driver);
		return driver;
	}
	
	private static AndroidDriver<MobileElement> theAndroidDriver;                          // Yet to decide on it's visibility
	
	public void setTheAndroidDriver(AndroidDriver<MobileElement> driver) {
		theAndroidDriver = driver;
	}
	
}
