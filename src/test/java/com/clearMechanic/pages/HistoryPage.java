package com.clearMechanic.pages;

import static com.clearMechanic.locators.History.*;
import static com.clearMechanic.locators.Inspection.TextField;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.clearMechanic.core.ButtonControl;
import com.clearMechanic.core.InputControl;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class HistoryPage extends BasePage{

	public HistoryPage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	
	public InputControl textField = new InputControl(getAppiumDriver(), TextField.toBy());
	public ButtonControl historyTab = new ButtonControl(getAppiumDriver(), HistoryTab.toBy());
	public InputControl searchByRONumber = new InputControl(getAppiumDriver(), SearchBYRONumber.toBy());
	
	
	public void verifyRONumberPresent(String ro) {
		MobileElement el = getAppiumDriver().findElement(By.xpath(String.format("//*[contains(@text, 'RO #%s')]", ro)));
		searchByRONumber.waitForElementClickable();
		searchByRONumber.click();
		searchByRONumber.setTextUsingAppKeyBoard(ro);
		Assert.assertTrue(el.isDisplayed());
	}
	
	@Override
	public void goTo() {
		// TODO Auto-generated method stub
		historyTab.waitForElementClickable();
		historyTab.click();
	}
}
