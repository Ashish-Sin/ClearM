package com.clearMechanic.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.clearMechanic.core.BaseTestCase;
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
		
		try {
			System.out.println("Ashish");
			int i = 1/0;
		} catch (Exception e) {
			System.out.println("Singh");
			captureScreenshot("testloginIntoApllication");
			System.out.println("Nasim");
			throw e;
		}
	}
	
//	@AfterMethod
	public void quiteApp() throws Exception {
		destropAppSession();
	}
}
