package com.clearMechanic.listener;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.clearMechanic.core.BaseTestCase;
import com.clearMechanic.reporter.ExtentManager;
import com.clearMechanic.reporter.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;

public class TestListeners extends BaseTestCase implements ITestListener {

	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}

	// Before starting all tests, below method runs.
	public void onStart(ITestContext iTestContext) {
//		Log.info("I am on Start method " + iTestContext.getName());

		iTestContext.setAttribute("WebDriver", this.getAppiumDriver());

		System.out.println("Driver instance in Listemer" + this.getAppiumDriver());
	}

	// After ending all tests, below method runs.
	public void onFinish(ITestContext iTestContext) {
//		Log.info("I am on Finish method " + iTestContext.getName());
		
		// Do tier down operations for extentreports reporting!
		ExtentTestManager.endTest();
		ExtentManager.getReporter().flush();
	}

	public void onTestStart(ITestResult iTestResult) {
//		Log.info("I am on TestStart method " + getTestMethodName(iTestResult) + " start");
		
		// Start operation for extentreports.
		// ExtentTestManager.
//		Log.info("I am in onStart method " + iTestResult.getTestContext().getAttribute("testname"));
		try {
			ExtentTestManager.startTest(iTestResult.getTestContext().getAttribute("testName").toString(), "");
		} catch (Exception e) {
			System.out.println("Error is" + e.getMessage());
		}
	}

	public void onTestSuccess(ITestResult iTestResult) {
//		Log.info("I am on TestSuccess method " + getTestMethodName(iTestResult) + " succeed");
		
		// Extentreports log operation for passed tests.
		ExtentTestManager.getTest().log(LogStatus.PASS,getTestMethodName(iTestResult) + " : Test Method has been passed");
	
		// ExtentTestManager.endTest();
		ExtentManager.getReporter().flush();
	}

	public void onTestFailure(ITestResult iTestResult) {
		ExtentTestManager.getTest().log(LogStatus.FAIL,getTestMethodName(iTestResult) + " : Test Method has been Failed");
		Object testClass = iTestResult.getInstance();

		// Take base64Screenshot screenshot.
		System.out.println("in listener :" + getAppiumDriver());
		String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) getAppiumDriver()).getScreenshotAs(OutputType.BASE64);
		String Message = iTestResult.getThrowable().getMessage() != null? iTestResult.getThrowable().getMessage().toString(): iTestResult.getThrowable().getCause().toString();

		// Extentreports log and screenshot operations for failed tests.
		ExtentTestManager.getTest().log(LogStatus.FAIL,Message + ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
		ExtentManager.getReporter().flush();
	}

	public void onTestError(ITestResult iTestResult) {
//		Log.info("I am on TestSuccess method " + getTestMethodName(iTestResult) + " errored");
		
		// Extentreports log operation for passed tests.
		ExtentTestManager.getTest().log(LogStatus.ERROR, getTestMethodName(iTestResult) + " : Test Method has been errored");
		Object testClass = iTestResult.getInstance();
		
		// Take base64Screenshot screenshot.
		String base64Screenshot = "data:image/png;base64,"+ ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		ExtentManager.getReporter().flush();
	}

	public void onTestSkipped(ITestResult iTestResult) {
//		Log.info("I am in onTestSkipped method " + getTestMethodName(iTestResult) + " skipped");
		
		// Extentreports log operation for skipped tests.
		ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
		ExtentManager.getReporter().flush();
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
//		Log.info("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
		ExtentManager.getReporter().flush();
	}

}