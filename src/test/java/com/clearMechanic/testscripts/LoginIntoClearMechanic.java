package com.clearMechanic.testscripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.clearMechanic.appium.core.BaseTestCase;
import com.clearMechanic.pages.HomePage;
import com.clearMechanic.pages.LogInPage;

public class LoginIntoClearMechanic extends BaseTestCase {
	
	private HomePage homePage;
	private LogInPage loginPage;

	@Factory(dataProvider = "listDevices")
	public LoginIntoClearMechanic(String udid, int port) {
		super(udid, port);
		
	}
	@BeforeMethod
	public void LaunchApp() throws Exception {
		setUp();
		homePage = new HomePage(driver);
		loginPage = new LogInPage(driver);
	}

	@Test
	public void testloginIntoApllication() throws Exception {
		
		Thread.sleep(5000);
		loginPage.logintoApp();
		Thread.sleep(5000);
	}
	
	@AfterMethod
	public void quiteApp() throws Exception {
		destropAppSession();
	}
}
