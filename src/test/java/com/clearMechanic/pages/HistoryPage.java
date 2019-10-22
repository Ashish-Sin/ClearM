package com.clearMechanic.pages;

import static com.clearMechanic.locators.History.HistoryTab;
import static com.clearMechanic.locators.History.SearchBYRONumber;
import static com.clearMechanic.locators.Inspection.TextField;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.clearMechanic.core.ButtonControl;
import com.clearMechanic.core.InputControl;
import com.clearMechanic.reporter.ExtentTestManager;
import com.clearMechanic.util.ConsoleLog;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class HistoryPage extends BasePage{

	public HistoryPage(AndroidDriver<MobileElement> driver) {
		super(driver);
	}
	
	public InputControl textField = new InputControl(getAndroidDriver(), TextField.toBy());
	public ButtonControl historyTab = new ButtonControl(getAndroidDriver(), HistoryTab.toBy());
	public InputControl searchByRONumber = new InputControl(getAndroidDriver(), SearchBYRONumber.toBy());
	
	
	public void verifyRONumberPresent(String ro) {
		MobileElement el = getAndroidDriver().findElement(By.xpath(String.format("//*[contains(@text, 'RO #%s')]", ro)));
		searchByRONumber.waitForElementClickable();
		searchByRONumber.click();
		searchByRONumber.setTextUsingAppKeyBoard(ro);
		ConsoleLog.log("Enter RO number");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Step: Enter RO number in search field");
		Assert.assertTrue(el.isDisplayed());
		ConsoleLog.log("Verified presence of RO number");
	}
	
	@Override
	public void goTo() {
		// TODO Auto-generated method stub
		historyTab.waitForElementClickable();
		historyTab.click();
		ConsoleLog.log("Go to History tab");
	}
}
