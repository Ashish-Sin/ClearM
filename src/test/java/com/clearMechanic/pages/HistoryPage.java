package com.clearMechanic.pages;

import static com.clearMechanic.locators.History.*;
import static com.clearMechanic.locators.Inspection.TextField;

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
	public ButtonControl history = new ButtonControl(getAppiumDriver(), History.toBy());
	public InputControl searchField = new InputControl(getAppiumDriver(), SearchField.toBy());
	
	
	public void tapOnAlreadySearchedRO() {
		
	}

	@Override
	public void goTo() {
		// TODO Auto-generated method stub
			TestUtil.sleep(4000);
			history.click();
			TestUtil.sleep(4000);
	}
	
	public void enterValueInSearchField(String searchKeyword) {
		searchField.setText(searchKeyword);
		TestUtil.sleep(2000);
	}
	
	public void searchAndAssertInspectionInHistory(String searchKeyword) {
		searchField.setText(searchKeyword);
		TestUtil.sleep(2000);
	}
	
	

}
