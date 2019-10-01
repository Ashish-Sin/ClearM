package com.clearMechanic.locators;

import org.openqa.selenium.By;

public enum Inspection implements ILocator {
	InspectionTab(By.id("com.clearcheck.cmbeta:MainView/tbInspection")),
	VehicleReception(By.id("com.clearcheck.cmbeta:Views_Main_Tabs_InspectionFull/lblRepairNumberHeader")),
	InspectionItems(By.xpath("//*[contains(@resource-id, 'lblInspectionItemsHeader')]")),
	RO(By.xpath("//*[contains(@resource-id, 'lblCaption') and contains(@text, 'RO')]")),
	Plates(By.xpath("//*[contains(@resource-id, 'lblCaption') and contains(@text, 'Plates')]")),
	TextField(By.id("com.clearcheck.cmbeta:Controls_CmRow_VehicleReceptionInput/etTextInput")),
	AddInspectionItemSearchField(By.xpath("//*[contains(@resource-id, 'txtSearchPlaceholder')]")),
	TypeInVIN(By.xpath("//*[contains(@resource-id, 'lblCaption') and contains(@text, 'Type in VIN')]")),
	TakePhoto(By.id("com.clearcheck.cmbeta:Views_Inspection_InspectionItemDetails/btnTakePhoto")),
	ClickPhoto(By.id("com.clearcheck.cmbeta:Controls_CmOvalView/rlRoot")),
	OKButton(By.id("com.clearcheck.cmbeta:Views_NewRepairOrder_MediaFiles_EditPhoto/btnOK")),
	DeleteButton(By.id("com.clearcheck.cmbeta:Views_NewRepairOrder_MediaFiles_EditPhoto/btnDelete")),
	FirstPhoto(By.id("com.clearcheck.cmbeta:Views_Inspection_InspectionItemDetails_MediaFileItemTemplate/llRoot")),
	CloseCamera(By.xpath("(//*[@resource-id= 'com.clearcheck.cmbeta:CmOvalViewWithImage/rlRoot'])[2]")),
	Figure(By.xpath("//*[@resource-id='com.clearcheck.cmbeta:Views_NewRepairOrder_MediaFiles_EditPhoto/pnlImageContainer']/android.widget.RelativeLayout/android.widget.RelativeLayout")),
	AddArrow(By.id("com.clearcheck.cmbeta:Views_NewRepairOrder_MediaFiles_EditPhoto/btnArrow"));
	
	private final By locator;

	Inspection(By locator) {
		this.locator = locator;
	}

	@Override
	public By toBy() {
		return locator;
	}

}
