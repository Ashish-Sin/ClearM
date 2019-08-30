package com.clearMechanic.testscripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.clearMechanic.core.BaseTestCase;
import com.clearMechanic.pages.HistoryPage;
import com.clearMechanic.pages.HomePage;
import com.clearMechanic.pages.InspectionPage;
import com.clearMechanic.pages.LogInPage;
import com.clearMechanic.util.TestUtil;

public class LoginIntoClearMechanic extends BaseTestCase {

	private LogInPage loginPage;
	private InspectionPage inspectionPage;
	private HistoryPage historyPage;

	@Factory(dataProvider = "listDevices")
	public LoginIntoClearMechanic(String udid, int port) {
		super(udid, port);

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
			TestUtil.sleep(4000);
			inspectionPage.enterVehicleDetails(roNumber, vinNumber, plates);
			TestUtil.hideKeyboard(getAppiumDriver());
			inspectionPage.done.click();
			TestUtil.sleep(4000);
			
			historyPage.goTo();
			historyPage.verifyRONumberPresent(roNumber);
			
		} catch (Exception e) {
			captureScreenshot("testloginIntoApllication");
			throw e;
		}
	}
	
	@Test
	public void dusraTestCase() throws Exception {
		
		try {
			
			inspectionPage.goTo();
			TestUtil.sleep(4000);
			inspectionPage.inspectionItems.click();
			TestUtil.sleep(4000);
			inspectionPage.addInspectionItemSearchField.click();
			TestUtil.hideKeyboard(getAppiumDriver());
			inspectionPage.addInspectionItem("\"BAT\" Terminal");
			
		} catch (Exception e) {
			captureScreenshot("dusraTestCase");
			throw e;
		}
	}

//	@AfterMethod
	public void quiteApp() throws Exception {
		destropAppSession();
	}
}
