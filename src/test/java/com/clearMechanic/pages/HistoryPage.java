package com.clearMechanic.pages;

import static com.clearMechanic.locators.History.*;
import static com.clearMechanic.locators.Inspection.TextField;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.clearMechanic.core.ButtonControl;
import com.clearMechanic.core.InputControl;
import com.clearMechanic.util.ConsoleLog;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class HistoryPage extends BasePage{

	public HistoryPage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	
	public InputControl textField = new InputControl(getAppiumDriver(), TextField.toBy());
	public ButtonControl historyTab = new ButtonControl(getAppiumDriver(), HistoryTab.toBy());
	public InputControl searchByRONumber = new InputControl(getAppiumDriver(), SearchByRONumber.toBy());
	
	
	public void verifyRONumberPresent(String ro) {
		MobileElement el = getAppiumDriver().findElement(By.xpath(String.format("//*[contains(@value, 'RO #%s')]", ro)));
		searchByRONumber.waitForElementClickable();
		searchByRONumber.click();
		searchByRONumber.setText(ro);
		ConsoleLog.log("Enter RO number");
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
