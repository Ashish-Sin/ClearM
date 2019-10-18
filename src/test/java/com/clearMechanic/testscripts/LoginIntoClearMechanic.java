package com.clearMechanic.testscripts;

import java.lang.reflect.Method;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.clearMechanic.core.BaseTestCase;
import com.clearMechanic.pages.HistoryPage;
import com.clearMechanic.pages.InspectionPage;
import com.clearMechanic.pages.LogInPage;
import com.clearMechanic.reporter.ExtentTestManager;
import com.clearMechanic.util.ConsoleLog;
import com.clearMechanic.util.TestListener;
import com.clearMechanic.util.TestUtil;
import com.relevantcodes.extentreports.LogStatus;

@Listeners({ TestListener.class })
public class LoginIntoClearMechanic extends BaseTestCase {

	private LogInPage loginPage;
	private InspectionPage inspectionPage;
	private HistoryPage historyPage;

	// @Factory(dataProvider = "listDevices")
	public LoginIntoClearMechanic() {
		super("", 0);

	}

	// @BeforeMethod
	// public void LaunchApp() throws Exception {
	// setUp();
	// loginPage = new LogInPage(getAppiumDriver());
	// inspectionPage = new InspectionPage(getAppiumDriver());
	// historyPage = new HistoryPage(getAppiumDriver());
	//
	// }

	@BeforeMethod
	@Parameters({"udid", "platform"})
	public void BeforeMethod(Method method, ITestContext ctx, String udid, String version) throws Exception {
		DOMConfigurator.configure("log4j.xml");

		setUp(udid, version);
		loginPage = new LogInPage(getAppiumDriver());
		inspectionPage = new InspectionPage(getAppiumDriver());
		historyPage = new HistoryPage(getAppiumDriver());

		if (method.getName().equals("testCreateFullInspectionByEnteringVehicleDetails")) {
			ctx.setAttribute("testName", "Verify_ User is able to create full inspection");
		}
		if (method.getName().equals("testCameraFunctionalityInSingleItem")) {
			ctx.setAttribute("testName", "Verify_Image capture by Camera In Single Item");
		}
		if (method.getName().equals("testUserIsAbleToSearchCreatedInspection")) {
			ctx.setAttribute("testName", "Verify_ User is able to Search the created Inspection In History");
		}

	}

	@Test
	@TestCaseInfo(testCaseID = "1111", title = "Verify_ User is able to create full inspection", description = "This test will enter and verify vehicle details")
	public void testCreateFullInspectionByEnteringVehicleDetails() throws Exception {
		String roNumber = "465456";
		String plates = "46545";
		try {

			loginPage.logintoApp();

			inspectionPage.goTo();
			inspectionPage.vehicleReception.click();
			ConsoleLog.log("Click on vehicle reception");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on vehicle reception");

			String vinNumber = TestUtil.getExcelData("VIN", 1, 0);
			inspectionPage.enterVehicleDetails(roNumber, vinNumber, plates);
			TestUtil.hideKeyboard(getAppiumDriver());

			inspectionPage.done.click();
			ConsoleLog.log("Click on Done");
			inspectionPage.done.click();
			ConsoleLog.log("Click on Done");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Done Button");

			historyPage.goTo();
			historyPage.verifyRONumberPresent(roNumber);

		} catch (Exception e) {
			throw e;
		}
	}

	@Test
	@TestCaseInfo(testCaseID = "2222", title = "Verify_Image capture by Camera In Single Item", description = "This test case will verify the camera functionality")
	public void testCameraFunctionalityInSingleItem() throws Exception {

		try {
			loginPage.logintoApp();
			inspectionPage.goTo();
			inspectionPage.inspectionItems.click();
			ConsoleLog.log("Click on inspection items");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on inspection items");
			inspectionPage.addInspectionItemSearchField.waitForElementClickable();
			inspectionPage.addInspectionItemSearchField.click();
			ConsoleLog.log("Click on add inspection item");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on add inspection item");
			TestUtil.hideKeyboard(getAppiumDriver());
			inspectionPage.addInspectionItem("\"BAT\" Terminal");
			ConsoleLog.log("Add BAT Terminal");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on \"BAT\" Terminal");
			inspectionPage.firstPhoto.click();
			ConsoleLog.log("Click on add photo");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on add photo");
			inspectionPage.addArrow.click();

			Assert.assertTrue(inspectionPage.figure.getMobileElement().isDisplayed());
			ConsoleLog.log("Verified that photo is visible and arrow is added");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Verified that photo is visible and arrow is added");

		} catch (Exception e) {
			throw e;
		}
	}

	@Test
	@TestCaseInfo(testCaseID = "3333", title = "Verify_ User is able to Search the created Inspection In History", description = "User is able to Search the created Inspection In History")
	public void testUserIsAbleToSearchCreatedInspection() throws Exception {
		String roNumber = "5431";
		String plates = "1234";
		String roNumberInvalid = "3333";
		try {

			loginPage.logintoApp();

			inspectionPage.goTo();
			inspectionPage.vehicleReception.click();
			ConsoleLog.log("Click on vehicle reception");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on vehicle reception");

			String vinNumber = TestUtil.getExcelData("VIN", 2, 0);
			inspectionPage.enterVehicleDetails(roNumber, vinNumber, plates);
			TestUtil.hideKeyboard(getAppiumDriver());

			inspectionPage.done.click();
			ConsoleLog.log("Click on Done");
			inspectionPage.done.click();
			ConsoleLog.log("Click on Done");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Click on Done Button");

			historyPage.goTo();
			historyPage.verifyRONumberPresent(roNumberInvalid);
			ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Inspection is available " + roNumberInvalid);
		} catch (Exception e) {
			throw e;
		}
	}

	@AfterMethod
	public void quitApp() throws Exception {
		captureLog(getAppiumDriver(), TestListener.testCaseID);
		destroyAppSession();
	}
}
