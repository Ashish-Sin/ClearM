package com.clearMechanic.pages;

import static com.clearMechanic.locators.Inspection.AddArrow;
import static com.clearMechanic.locators.Inspection.AddInspectionItemSearchField;
import static com.clearMechanic.locators.Inspection.ClickPhoto;
import static com.clearMechanic.locators.Inspection.CloseCamera;
import static com.clearMechanic.locators.Inspection.DeleteButton;
import static com.clearMechanic.locators.Inspection.Figure;
import static com.clearMechanic.locators.Inspection.FirstPhoto;
import static com.clearMechanic.locators.Inspection.InspectionItems;
import static com.clearMechanic.locators.Inspection.InspectionTab;
import static com.clearMechanic.locators.Inspection.OKButton;
import static com.clearMechanic.locators.Inspection.Plates;
import static com.clearMechanic.locators.Inspection.RO;
import static com.clearMechanic.locators.Inspection.TakePhoto;
import static com.clearMechanic.locators.Inspection.TextField;
import static com.clearMechanic.locators.Inspection.TypeInVIN;
import static com.clearMechanic.locators.Inspection.VehicleReception;

import org.openqa.selenium.By;

import com.clearMechanic.core.ButtonControl;
import com.clearMechanic.core.InputControl;
import com.clearMechanic.reporter.ExtentTestManager;
import com.clearMechanic.util.ConsoleLog;
import com.clearMechanic.util.TestUtil;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class InspectionPage extends BasePage {

	public InspectionPage(AndroidDriver<MobileElement> driver) {
		super(driver);
	}
	
	public ButtonControl inspectionTab = new ButtonControl(getAndroidDriver(), InspectionTab.toBy());
	public ButtonControl vehicleReception = new ButtonControl(getAndroidDriver(), VehicleReception.toBy());
	public ButtonControl inspectionItems = new ButtonControl(getAndroidDriver(), InspectionItems.toBy());
	public InputControl ro = new InputControl(getAndroidDriver(), RO.toBy());
	public InputControl textField = new InputControl(getAndroidDriver(), TextField.toBy());
	public InputControl typeInVIN = new InputControl(getAndroidDriver(), TypeInVIN.toBy());
	public InputControl plates = new InputControl(getAndroidDriver(), Plates.toBy());
	public ButtonControl addInspectionItemSearchField = new ButtonControl(getAndroidDriver(), AddInspectionItemSearchField.toBy());
	public ButtonControl takePhoto = new ButtonControl(getAndroidDriver(), TakePhoto.toBy());
	public ButtonControl firstPhoto = new ButtonControl(getAndroidDriver(), FirstPhoto.toBy());
	public ButtonControl clickPhoto = new ButtonControl(getAndroidDriver(), ClickPhoto.toBy());
	public ButtonControl closeCamera = new ButtonControl(getAndroidDriver(), CloseCamera.toBy());
	public ButtonControl ok = new ButtonControl(getAndroidDriver(), OKButton.toBy());
	public ButtonControl delete = new ButtonControl(getAndroidDriver(), DeleteButton.toBy());
	public ButtonControl done = new ButtonControl(getAndroidDriver(), By.id("com.clearcheck.cmbeta:Controls_CmNavBar_TextTitleText/btnRightButton"));
	public ButtonControl figure = new ButtonControl(getAndroidDriver(), Figure.toBy()); 
	public ButtonControl addArrow = new ButtonControl(getAndroidDriver(), AddArrow.toBy());


	@Override
	public void goTo() {
		this.inspectionTab.waitForElementClickable();
		this.inspectionTab.click();
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
		MobileElement el = getAndroidDriver().findElement(by);
		
		el.click();
		done.click();
		done.click();
		MobileElement el1 = getAndroidDriver().findElement(By.xpath(String.format("//*[@text='%s']", inspectionItem)));
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
