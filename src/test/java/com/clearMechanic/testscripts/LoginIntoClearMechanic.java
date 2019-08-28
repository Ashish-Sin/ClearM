package com.clearMechanic.testscripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.clearMechanic.core.BaseTestCase;
import com.clearMechanic.pages.HomePage;
import com.clearMechanic.pages.InspectionPage;
import com.clearMechanic.pages.LogInPage;
import com.clearMechanic.util.TestUtil;

public class LoginIntoClearMechanic extends BaseTestCase {

	private LogInPage loginPage;
	private HomePage homePage;
	private InspectionPage inspectionPage;

	@Factory(dataProvider = "listDevices")
	public LoginIntoClearMechanic(String udid, int port) {
		super(udid, port);

	}

	@BeforeMethod
	public void LaunchApp() throws Exception {
		setUp();
		loginPage = new LogInPage(getAppiumDriver());
		homePage = new HomePage(getAppiumDriver());
		inspectionPage = new InspectionPage(getAppiumDriver());
		loginPage.logintoApp();
	}

	@Test
	public void testloginIntoApllication() throws Exception {

		try {
			
			inspectionPage.goTo();
			inspectionPage.vehicleReception.click();
			inspectionPage.ro.setText("465456");
			inspectionPage.typeInVIN.setText("5465465");
		} catch (Exception e) {
			captureScreenshot("testloginIntoApllication");
			throw e;
		}
	}

//	@AfterMethod
	public void quiteApp() throws Exception {
		destropAppSession();
	}
}
