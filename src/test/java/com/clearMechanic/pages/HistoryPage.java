package com.clearMechanic.pages;

import org.openqa.selenium.By;

import com.clearMechanic.core.ButtonControl;
import com.clearMechanic.core.InputControl;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class HistoryPage extends BasePage{

	public HistoryPage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	
	InputControl searchByRONumber = new InputControl(getAppiumDriver(), By.id(""));
	ButtonControl newInspection = new ButtonControl(getAppiumDriver(), By.id(""));
	
	public void tapOnAlreadySearchedRO() {
		
	}

	@Override
	public void goTo() {
		// TODO Auto-generated method stub
		
	}

}
