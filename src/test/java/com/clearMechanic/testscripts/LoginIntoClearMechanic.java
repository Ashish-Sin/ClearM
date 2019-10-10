package com.clearMechanic.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.clearMechanic.core.BaseTestCase;
import com.clearMechanic.pages.HistoryPage;
import com.clearMechanic.pages.InspectionPage;
import com.clearMechanic.pages.LogInPage;
import com.clearMechanic.util.ConsoleLog;
import com.clearMechanic.util.TestListener;
import com.clearMechanic.util.TestUtil;

@Listeners(TestListener.class)
public class LoginIntoClearMechanic extends BaseTestCase {

	private LogInPage loginPage;
	private InspectionPage inspectionPage;
	private HistoryPage historyPage;

//	@Factory(dataProvider = "listDevices")
	public LoginIntoClearMechanic() {
		super("", 0);

	}

	@BeforeMethod
	public void LaunchApp() throws Exception {
		setUp();
		loginPage = new LogInPage(getAppiumDriver());
		inspectionPage = new InspectionPage(getAppiumDriver());
		historyPage = new HistoryPage(getAppiumDriver());
		loginPage.logintoApp();
	}

	@Test
	@TestCaseInfo(testCaseID = "10072", title = "createNewCubeGroupAndAccounts", description = "AccountAdmin_CreateCubeAccount&Group")
	public void testEnterAndVerifyVehicleDetails() throws Exception {
		String roNumber = "465456";
		String plates = "46545";
		try {

			inspectionPage.goTo();
			inspectionPage.vehicleReception.click();
			ConsoleLog.log("Click on vehicle reception");

			String vinNumber = TestUtil.getExcelData("VIN", 1, 0);
			inspectionPage.enterVehicleDetails(roNumber, vinNumber, plates);
			TestUtil.hideKeyboard(getAppiumDriver());
			
			inspectionPage.done.click();
			ConsoleLog.log("Click on Done");
			inspectionPage.done.click();
			ConsoleLog.log("Click on Done");
			
			historyPage.goTo();
			historyPage.verifyRONumberPresent(roNumber);
			
		} catch (Exception e) {
			captureScreenshot("testloginIntoApllication");
			throw e;
		}
	}
	
	@Test
	public void cameraTestCase() throws Exception {
		
		try {
		
			inspectionPage.goTo();
			inspectionPage.inspectionItems.click();
			ConsoleLog.log("Click on inspection items");
			inspectionPage.addInspectionItemSearchField.waitForElementClickable();
			inspectionPage.addInspectionItemSearchField.click();
			ConsoleLog.log("Click on add inspection item");
			
			TestUtil.hideKeyboard(getAppiumDriver());
			inspectionPage.addInspectionItem("\"BAT\" Terminal");
			ConsoleLog.log("Add BAT Terminal");
			
			inspectionPage.firstPhoto.click();
			ConsoleLog.log("Click on add photo");
			inspectionPage.addArrow.click();
			
			Assert.assertTrue(inspectionPage.figure.getMobileElement().isDisplayed());
			ConsoleLog.log("Verified that photo is visible and arrow is added");
			
		} catch (Exception e) {
			captureScreenshot("cameraTestCase");
			throw e;
		}
	}

	@AfterMethod
	public void quitApp() throws Exception {
		destroyAppSession();
	}
}
