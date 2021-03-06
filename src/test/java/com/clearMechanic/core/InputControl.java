package com.clearMechanic.core;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class InputControl extends TestFramework {

	public InputControl(AppiumDriver<MobileElement> driver, By by) {
		super(driver, by);
	}

	public void setText(String text) {
		MobileElement element = getMobileElement();
		element.clear();
		element.sendKeys(text);
	}

	public void clearText(String text) {
		MobileElement element = getMobileElement();
		element.clear();
	}
	
	public void appendText(String text) {
		MobileElement element = getMobileElement();
		element.sendKeys(text);
	}
	
	public String getValue() {
		return getMobileElement().getAttribute("value");
		
	}

	public void setTextUsingAppKeyBoard(String text) {

		char[] t = text.toCharArray();
		for (int i = 0; i < text.length(); i++) {
			By by = By.xpath(String.format("//*[contains(@resource-id, 'btn%s')]", t[i]));
			MobileElement key = getAppiumDriver().findElement(by);
			key.click();
			
		}
	}
}
