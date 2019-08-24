package com.clearMechanic.locators;

import org.openqa.selenium.By;

public enum Home implements ILocator {

	RechargeTab(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.ImageView")),
	PrepaidRechargeRadioButton(By.id("com.myclearMechanicapp:id/id_radio_opt_prepaid_mobile")),
	MobileNumberInputField(By.id("com.myclearMechanicapp:id/editText_contact")),
	BestOfferButton(By.id("com.myclearMechanicapp:id/best_offers_txt"));

	private final By locator;

	Home(By locator) {
		this.locator = locator;
	}

	@Override
	public By toBy() {
		return locator;
	}

}
