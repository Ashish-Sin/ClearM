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
	public InputControl ro = new InputControl(getAppiumDriver(), RO.toBy());
	public InputControl textField = new InputControl(getAppiumDriver(), TextField.toBy());
	public InputControl typeInVIN = new InputControl(getAppiumDriver(), TypeInVIN.toBy());
	public InputControl plates = new InputControl(getAppiumDriver(), Plates.toBy());
	public ButtonControl inspectionItems = new ButtonControl(getAppiumDriver(), By.id(""));
	public ButtonControl done = new ButtonControl(getAppiumDriver(), By.xpath("//*[contains(@resource-id, 'btnRightButton')]"));


	@Override
	public void goTo() {
		TestUtil.sleep(4000);
		inspectionTab.click();
		TestUtil.sleep(4000);
	}
	
	public void enterVehicleDetails(String roNumber, String vinNumber, String plates) {
		enterRoNumberInVehicleDetails(roNumber);
		typeVinNumberInVehicleDetails(vinNumber);
		enterPlatesInVehicleDetails(plates);
	}
	
	public void enterValueUsingAppKeyboard(InputControl fieldName, String fieldValue) {
		fieldName.click();
		textField.setTextUsingAppKeyBoard(fieldValue);
	}

	public void enterValue(InputControl fieldName, String fieldValue) {
		fieldName.click();
		textField.setText(fieldValue);
	}

	public void enterRoNumberInVehicleDetails(String fieldValue) {
		enterValueUsingAppKeyboard(ro, fieldValue);
	}

	public void typeVinNumberInVehicleDetails(String fieldValue) {
		enterValue(typeInVIN, fieldValue);
	}

	public void enterPlatesInVehicleDetails(String fieldValue) {
		enterValue(plates, fieldValue);
	}

}
