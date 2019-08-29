package com.clearMechanic.pages;

import org.openqa.selenium.By;
import static com.clearMechanic.locators.Inspection.*;

import com.clearMechanic.core.ButtonControl;
import com.clearMechanic.core.InputControl;
import com.clearMechanic.util.TestUtil;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class InspectionPage extends BasePage {

	public InspectionPage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	
	public ButtonControl inspectionTab = new ButtonControl(getAppiumDriver(), InspectionTab.toBy());
	public ButtonControl vehicleReception = new ButtonControl(getAppiumDriver(), VehicleReception.toBy());
	public ButtonControl ro = new ButtonControl(getAppiumDriver(), RO.toBy());
	public InputControl textField = new InputControl(getAppiumDriver(), TextField.toBy());
	public ButtonControl typeInVIN = new ButtonControl(getAppiumDriver(), TypeInVIN.toBy());
	public ButtonControl plates = new ButtonControl(getAppiumDriver(), Plates.toBy());
	public ButtonControl inspectionItems = new ButtonControl(getAppiumDriver(), By.id(""));

	@Override
	public void goTo() {
		TestUtil.sleep(4000);
		inspectionTab.click();
		TestUtil.sleep(4000);
	}
	
	public void enterVehicleDetails() {
		ro.click();
		textField.setTextUsingAppKeyBoard("465456");
		typeInVIN.click();
		textField.setText("465456");
		plates.click();
		textField.setText("46545");
	}

}
