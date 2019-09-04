package com.clearMechanic.pages;

import static com.clearMechanic.locators.History.*;
import static com.clearMechanic.locators.Inspection.TextField;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.clearMechanic.core.ButtonControl;
import com.clearMechanic.core.InputControl;
import com.clearMechanic.util.TestUtil;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class HistoryPage extends BasePage{

	public HistoryPage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	
	public InputControl textField = new InputControl(getAppiumDriver(), TextField.toBy());
	public ButtonControl historyTab = new ButtonControl(getAppiumDriver(), HistoryTab.toBy());
	public InputControl searchField = new InputControl(getAppiumDriver(), SearchField.toBy());
	
	
	public void verifyRONumberPresent(String ro) {
		MobileElement el = getAppiumDriver().findElement(By.xpath(String.format("//*[contains(@text, 'RO #%s')]", ro)));
		searchField.waitForElementClickable();
		searchField.click();
		searchField.setTextUsingAppKeyBoard(ro);
		Assert.assertTrue(el.isDisplayed());
	}
	
	

	@Override
	public void goTo() {
		// TODO Auto-generated method stub
		historyTab.waitForElementClickable();
		historyTab.click();
	}
	
	public void enterValueInSearchField(String searchKeyword) {
		searchField.setText(searchKeyword);
//		TestUtil.sleep(2000);
	}
	
	public void searchAndAssertInspectionInHistory(String searchKeyword) {
		searchField.setText(searchKeyword);
//		TestUtil.sleep(2000);
	}
	
}
