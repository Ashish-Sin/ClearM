package com.clearMechanic.appium.core;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;

public interface IBasePage {


	MobileElement find(By by);

	MobileElement click(By by);

	MobileElement clear(By by);

	MobileElement setText(By by, String text);

	MobileElement appendText(By by, String text);

	String getAttribute(By by, String attribute);

}
