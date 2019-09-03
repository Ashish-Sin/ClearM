package com.clearMechanic.core;

import org.openqa.selenium.By;

import com.clearMechanic.util.TestUtil;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TestFramework extends MobileClient {
	
	private By locateBy;

	public TestFramework(AppiumDriver<MobileElement> driver, By by) {
		this.driver = driver;
		locateBy = by;
	}
	
	protected By getLocatorBy() {
		return locateBy;
	}
	
	public void click() {
		driver.findElement(locateBy).click();
	}
	
	//Limit use of this
	public void forceClick() {
		try {
			click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			TestUtil.sleep(1000);
			this.click();
		}
	}
	
	public void waitForElementClickable() {
		TestUtil.waitforClickableElement(getAppiumDriver(), getMobileElement(), 40);
	}
	
	public MobileElement getMobileElement() {
		TestUtil.waitforClickableElement(getAppiumDriver(), getLocatorBy(), 15);
		return driver.findElement(getLocatorBy());
	}
	
}
