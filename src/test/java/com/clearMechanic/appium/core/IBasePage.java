package com.clearMechanic.appium.core;

import io.appium.java_client.MobileElement;

import java.util.List;

import org.openqa.selenium.By;

public interface IBasePage {

	public void clickOn(By by);

	MobileElement find(By by);

	MobileElement click(By by);
//	MobileElement click();

	MobileElement clear(By by);

	MobileElement setText(By by, String text);

	MobileElement appendText(By by, String text);

	boolean isElementPresent(String locator);

	boolean isElementPresent(By by);

	void moveElement(By source, By target);

	String getAttribute(By by, String attribute);

	void scrollFormCenter(String direction);

	void TouchScreen();

	List<MobileElement> getMobileElements(By by);

	By ByLocator(String locator);

	String getText(By by);

	void hideKeyboard();

	MobileElement click(MobileElement element);

	void waitForElementPresent(By by);

	void waitForElementNotPresent(String locator);

	void waitForElementClickable(By by);

}
