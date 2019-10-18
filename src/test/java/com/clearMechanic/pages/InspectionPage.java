package com.clearMechanic.pages;

import org.openqa.selenium.By;
import static com.clearMechanic.locators.Inspection.*;

import com.clearMechanic.core.ButtonControl;
import com.clearMechanic.core.InputControl;
import com.clearMechanic.core.Log;
import com.clearMechanic.reporter.ExtentTestManager;
import com.clearMechanic.util.ConsoleLog;
import com.clearMechanic.util.TestUtil;
import com.relevantcodes.extentreports.LogStatus;

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
	public ButtonControl firstPhoto = new ButtonControl(getAppiumDriver(), FirstPhoto.toBy());
	public ButtonControl clickPhoto = new ButtonControl(getAppiumDriver(), ClickPhoto.toBy());
	public ButtonControl closeCamera = new ButtonControl(getAppiumDriver(), CloseCamera.toBy());
	public ButtonControl ok = new ButtonControl(getAppiumDriver(), OKButton.toBy());
	public ButtonControl delete = new ButtonControl(getAppiumDriver(), DeleteButton.toBy());
	public ButtonControl done = new ButtonControl(getAppiumDriver(), By.id("com.clearcheck.cmbeta:Controls_CmNavBar_TextTitleText/btnRightButton"));
	public ButtonControl figure = new ButtonControl(getAppiumDriver(), Figure.toBy()); 
	public ButtonControl addArrow = new ButtonControl(getAppiumDriver(), AddArrow.toBy());


	@Override
	public void goTo() {
		this.inspectionTab.waitForElementClickable();
		this.inspectionTab.click();
		Log.info("Go to Inspection tab");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Go to Inspection tab");
		ConsoleLog.log("Go to Inspection tab");
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
//		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter RO Number" + fieldValue);
		ConsoleLog.log("Enter RO Number"+ fieldValue);
	}

	public void typeVinNumberInVehicleDetails(String fieldValue) {
		enterValue(typeInVIN, fieldValue);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter VIN Number" + fieldValue);
		ConsoleLog.log("Enter VIN Number"+ fieldValue);
	}

	public void enterPlatesInVehicleDetails(String fieldValue) {
		enterValue(plates, fieldValue);
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter Plate Number" + fieldValue);
		ConsoleLog.log("Enter Plate Number"+ fieldValue);
	}
	
	public void addInspectionItem(String inspectionItem) {
		By by = By.xpath(String.format("//*[@text='%s']", inspectionItem));
		TestUtil.waitforClickableElement(driver, by, 60);
		MobileElement el = getAppiumDriver().findElement(by);
		
		el.click();
		done.click();
		done.click();
		MobileElement el1 = getAppiumDriver().findElement(By.xpath(String.format("//*[@text='%s']", inspectionItem)));
		el1.click();
		takePhoto.waitForElementClickable();
		takePhoto.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click On capture Photo");
		ConsoleLog.log("click On capture Photo");
		clickPhoto.click();
		ok.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: click On Ok button on Photo");
		ConsoleLog.log(" click On Ok button on Photo");
		closeCamera.waitForElementClickable();
		closeCamera.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Close camera");
		ConsoleLog.log("Close camera");
	}
	
	public void verifyPhoto() {
		firstPhoto.click();
	}
	
	public void clickOnAddedInspectionItem() {
		
	}

}
