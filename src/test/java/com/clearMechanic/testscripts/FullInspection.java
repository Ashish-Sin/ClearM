package com.clearMechanic.testscripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.clearMechanic.core.BaseTestCase;
import com.clearMechanic.pages.LogInPage;
import com.clearMechanic.util.TestUtil;

public class FullInspection extends BaseTestCase {
	
	private LogInPage loginPage;

	@Factory(dataProvider = "listDevices")
	public FullInspection(String udid, int port) {
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
			String s = TestUtil.getExcelData("VIN", 1, 1);
			System.out.println(s);
		} catch (Exception e) {
			System.out.println("Singh");
			captureScreenshot("testloginIntoApllication");
			System.out.println("Nasim");
			throw e;
		}
	}
	
	@AfterMethod
	public void quiteApp() throws Exception {
		destropAppSession();
	}
}
