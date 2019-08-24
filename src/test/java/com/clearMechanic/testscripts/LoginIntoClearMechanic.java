package com.clearMechanic.testscripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.clearMechanic.appium.core.BaseTestCase;
import com.clearMechanic.pages.HomePage;
import com.clearMechanic.pages.LogInPage;

public class LoginIntoClearMechanic extends BaseTestCase {
	
	private LogInPage loginPage;

	@Factory(dataProvider = "listDevices")
	public LoginIntoClearMechanic(String udid, int port) {
		super(udid, port);
		
	}
	@BeforeMethod
	public void LaunchApp() throws Exception {
		setUp();
		loginPage = new LogInPage(driver);
		loginPage.logintoApp();
	}

	@Test
	public void testloginIntoApllication() throws Exception {
		
		
	}
	
//	@AfterMethod
	public void quiteApp() throws Exception {
		destropAppSession();
	}
}
