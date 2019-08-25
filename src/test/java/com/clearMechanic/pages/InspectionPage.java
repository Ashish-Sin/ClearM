package com.clearMechanic.pages;

import org.openqa.selenium.By;

import com.clearMechanic.core.ButtonControl;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class InspectionPage extends BasePage {

	public InspectionPage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	
	ButtonControl vehicleReception = new ButtonControl(getAppiumDriver(), By.id(""));
	ButtonControl inspectionItems = new ButtonControl(getAppiumDriver(), By.id(""));

	@Override
	public void goTo() {
		// TODO Auto-generated method stub
		
	}

}
