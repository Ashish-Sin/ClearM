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
		loginPage.logintoApp();
	}

	@Test
	public void testEnterAndVerifyVehicleDetails() throws Exception {
		String roNumber = "465456";
		String plates = "46545";
		try {

			inspectionPage.goTo();
			inspectionPage.vehicleReception.click();

			String vinNumber = TestUtil.getExcelData("VIN", 1, 1);
			inspectionPage.enterVehicleDetails(roNumber, vinNumber, plates);
			TestUtil.hideKeyboard(getAppiumDriver());
//			TestUtil.sleep(5000);
			inspectionPage.done.forceClick();
			inspectionPage.done.forceClick();
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
			
			TestUtil.sleep(4000);
			System.out.println(getAppiumDriver());
			System.out.println(TestUtil.getAppiumDriver(inspectionPage.inspectionTab.getMobileElement()));
			
			inspectionPage.goTo();
			inspectionPage.inspectionItems.waitForElementClickable();
			inspectionPage.inspectionItems.click();
//			TestUtil.sleep(4000);
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
