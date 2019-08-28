package com.clearMechanic.pages;

import org.openqa.selenium.By;
import static com.clearMechanic.locators.Inspection.*;

import com.clearMechanic.core.ButtonControl;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class InspectionPage extends BasePage {

	public InspectionPage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	
	public ButtonControl inspectionTab = new ButtonControl(getAppiumDriver(), InspectionTab.toBy());
	public ButtonControl vehicleReception = new ButtonControl(getAppiumDriver(), By.id(""));
	public ButtonControl inspectionItems = new ButtonControl(getAppiumDriver(), By.id(""));

	@Override
	public void goTo() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		inspectionTab.click();
		
	}

}
