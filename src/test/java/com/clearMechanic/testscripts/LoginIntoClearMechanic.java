package com.clearMechanic.testscripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.clearMechanic.core.BaseTestCase;
import com.clearMechanic.pages.HistoryPage;
import com.clearMechanic.pages.InspectionPage;
import com.clearMechanic.pages.LogInPage;
import com.clearMechanic.util.TestUtil;

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
//		loginPage.logintoApp();
	}

	@Test
	public void testEnterAndVerifyVehicleDetails() throws Exception {
		String roNumber = "465456";
		String plates = "46545";
		try {

			inspectionPage.goTo();
			inspectionPage.vehicleReception.click();

			String vinNumber = TestUtil.getExcelData("VIN", 1, 0);
			inspectionPage.enterVehicleDetails(roNumber, vinNumber, plates);
			TestUtil.hideKeyboard(getAppiumDriver());
			inspectionPage.done.click();
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
			inspectionPage.inspectionItems.waitForElementClickable();
			inspectionPage.inspectionItems.click();
			inspectionPage.addInspectionItemSearchField.waitForElementClickable();
			inspectionPage.addInspectionItemSearchField.click();
			TestUtil.hideKeyboard(getAppiumDriver());
			inspectionPage.addInspectionItem("\"BAT\" Terminal");
			
		} catch (Exception e) {
			captureScreenshot("cameraTestCase");
			throw e;
		}
	}

//	@AfterMethod
	public void quiteApp() throws Exception {
		destroyAppSession();
	}
}
