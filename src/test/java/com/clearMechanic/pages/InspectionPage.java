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
	public ButtonControl inspectionItems = new ButtonControl(getAppiumDriver(), InspectionItems.toBy());
	public InputControl ro = new InputControl(getAppiumDriver(), RO.toBy());
	public InputControl textField = new InputControl(getAppiumDriver(), TextField.toBy());
	public InputControl typeInVIN = new InputControl(getAppiumDriver(), TypeInVIN.toBy());
	public InputControl plates = new InputControl(getAppiumDriver(), Plates.toBy());
	public ButtonControl addInspectionItemSearchField = new ButtonControl(getAppiumDriver(), AddInspectionItemSearchField.toBy());
	public ButtonControl takePhoto = new ButtonControl(getAppiumDriver(), TakePhoto.toBy());
	public ButtonControl clickPhoto = new ButtonControl(getAppiumDriver(), ClickPhoto.toBy());
	public ButtonControl ok = new ButtonControl(getAppiumDriver(), OKButton.toBy());
	public ButtonControl delete = new ButtonControl(getAppiumDriver(), DeleteButton.toBy());
	public ButtonControl done = new ButtonControl(getAppiumDriver(), By.id("com.clearcheck.cmbeta:Controls_CmNavBar_TextTitleText/btnRightButton"));


	@Override
	public void goTo() {
		this.inspectionTab.waitForElementClickable();
		this.inspectionTab.click();
	}
	
	public void enterVehicleDetails(String roNumber, String vinNumber, String plates) {
		enterRoNumberInVehicleDetails(roNumber);
		typeVinNumberInVehicleDetails(vinNumber);
		enterPlatesInVehicleDetails(plates);
	}
	
	public void enterValueUsingAppKeyboard(InputControl fieldName, String fieldValue) {
		fieldName.waitForElementClickable();
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
	
	public void addInspectionItem(String inspectionItem) {
//		TestUtil.sleep(30000);
//		TestUtil.waitforClickableElement(driver, getAppiumDriver().findElement(By.xpath("com.clearcheck.cmbeta:SearchBar/pnlContainer")), 40);
		getAppiumDriver().findElement(By.xpath("com.clearcheck.cmbeta:SearchBar/pnlContainer")).click();
		TestUtil.waitforClickableElement(driver, getAppiumDriver().findElement(By.xpath("com.clearcheck.cmbeta:SearchBar/pnlContainer")), 40);
		MobileElement el = getAppiumDriver().findElement(By.xpath(String.format("//*[@text='%s']", inspectionItem)));
		
		el.click();
		done.click();
//		TestUtil.sleep(2000);
		done.click();
//		TestUtil.sleep(3000);
		MobileElement el1 = getAppiumDriver().findElement(By.xpath(String.format("//*[@text='%s']", inspectionItem)));
		el1.click();
//		TestUtil.sleep(2000);
		takePhoto.waitForElementClickable();
		takePhoto.click();
		clickPhoto.click();
		ok.click();
	}
	
	public void clickOnAddedInspectionItem() {
		
	}

}
