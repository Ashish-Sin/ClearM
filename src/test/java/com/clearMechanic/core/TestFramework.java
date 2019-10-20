package com.clearMechanic.core;

import org.openqa.selenium.By;

import com.clearMechanic.util.TestUtil;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TestFramework extends MobileClient {
	
	private By locateBy;

	public TestFramework(AndroidDriver<MobileElement> driver, By by) {
		this.driver = driver;
		locateBy = by;
	}
	
	protected By getLocatorBy() {
		return locateBy;
	}
	
	public void click() {
		this.getMobileElement().click();
	}
	
	//Limit use of this
	public void forceClick() {
		try {
			click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
//			TestUtil.sleep(1000);
			this.click();
		}
	}
	
	public boolean isDisplayed() {
		return getMobileElement().isDisplayed();
	}
	
	public String getAttribute(String attribute) {
		return getMobileElement().getAttribute(attribute);
	}
	
	public void waitForElementClickable() {
		TestUtil.waitforClickableElement(getAndroidDriver(), getMobileElement(), 40);
	}
	
	public MobileElement getMobileElement() {
		TestUtil.waitforClickableElement(getAndroidDriver(), getLocatorBy(), 15);
		return getAndroidDriver().findElement(getLocatorBy());
	}
	
}
