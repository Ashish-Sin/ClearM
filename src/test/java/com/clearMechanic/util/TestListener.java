package com.clearMechanic.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;

import org.testng.ITestListener;

import org.testng.ITestResult;
import org.testng.Reporter;

import com.clearMechanic.pages.LogInPage;
import com.clearMechanic.testscripts.TestCaseInfo;

public class TestListener implements ITestListener {
	
	public static String testCaseID, testCaseDescription, testCaseTitle;

	@Override

	public void onStart(ITestContext arg0) {

		System.out.println("Start Of Execution(TEST)->" + arg0.getName());

	}

	@Override

	public void onTestStart(ITestResult arg0) {
		
		ConsoleLog.LOGGER.toString();

//		System.out.println("Test Started->" + arg0.getName());

//		TestInvok a = new TestInvok();
		TestCaseInfo info=arg0.getMethod().getMethod().getAnnotation(TestCaseInfo.class);

		testCaseID = info.testCaseID().toString();
		testCaseTitle = info.title().toString();
		testCaseDescription = info.description().toString();
	
	}

	@Override

	public void onTestSuccess(ITestResult arg0) {

		System.out.println("Test Pass->" + arg0.getName());

	}

	@Override

	public void onTestFailure(ITestResult arg0) {

		System.out.println("Test Failed->" + arg0.getName());

	}

	@Override

	public void onTestSkipped(ITestResult arg0) {

		System.out.println("Test Skipped->" + arg0.getName());

	}

	@Override

	public void onFinish(ITestContext arg0) {

		System.out.println("END Of Execution(TEST)->" + arg0.getName());

	}

	@Override

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

		// TODO Auto-generated method stub

	}

}