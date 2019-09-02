package com.clearMechanic.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.clearMechanic.core.MobileClient;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TestUtil extends MobileClient{

//	public TestUtil(AppiumDriver<MobileElement> driver, By by) {
//		super(driver, by);
//	}

	public int globalWaitTime = 10;
	
	public static AppiumDriver<MobileElement> getAppiumDriver(MobileElement element) {
		return (AppiumDriver<MobileElement>) element.getWrappedDriver();
	}
	
	public static void waitforClickableElement(AppiumDriver<MobileElement> driver, MobileElement el, int globalWaitTime) {
		WebDriverWait wait = new WebDriverWait(driver, globalWaitTime);
		wait.until(ExpectedConditions.elementToBeClickable(el));
	}
	
//	public void waitforClickableElement(int globalWaitTime) {
//		waitforClickableElement(getAppiumDriver(), getMobileElement(), globalWaitTime);
//	}
	
	public static String getExcelData(String sheetName , int rowNum , int colNum) throws InvalidFormatException, IOException{
		
		Row row = null;

		try {
			String file = getPath() + FileReader.readData("VIN");
		    FileInputStream fis = new FileInputStream(file);
		    Workbook wb = WorkbookFactory.create(fis);
		    Sheet sh = wb.getSheet(sheetName);
		    row = sh.getRow(rowNum);
		    String data = row.getCell(colNum).getStringCellValue();
		    return data;
		} catch (IllegalStateException e) {
			double data = row.getCell(colNum).getNumericCellValue();
			return String.valueOf(data);
		}
	}
	
	public void createFolder(String folderPath) {
		File file = new File(folderPath);
		if (!file.exists()) {
			file.mkdir();
		}
	}
	
	public static String getPath() {
		return System.getProperty("user.dir") + "\\src\\test\\java\\com\\clearMechanic\\data\\";
	}
	
	private static File getLatestFilefromDir(String dirPath) {
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			return null;
		}

		File lastModifiedFile = files[0];
		for (int i = 1; i < files.length; i++) {
			if (lastModifiedFile.lastModified() < files[i].lastModified()) {
				lastModifiedFile = files[i];
			}
		}
		return lastModifiedFile;
	}
	
	public static void sleep(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	public boolean isElementPresent(String locator) {
//		try {
//			driver.findElement(ByLocator(locator));
//			return true;
//		} catch (Exception e) {
//			return false;
//		}
//	}
//
//	public boolean isElementPresent(By by) {
//		try {
//			driver.findElement(by);
//			return true;
//		} catch (Exception e) {
//			return false;
//		}
//	}
//
//	public void moveElement(By source, By target) {
//		MobileElement elSource = this.find(source);
//		MobileElement elDest = this.find(target);
//		TouchAction action = new TouchAction(driver);
////		action.longPress(elSource).moveTo(elDest).release().perform();    //Commented due to version mismatch
//	}
//
//	public String getAttribute(By by, String attribute) {
//		MobileElement element = find(by);
//		return element.getAttribute(attribute);
//	}
//
//	public String getText(By by) {
//		MobileElement element = find(by);
//		return element.getText();
//	}
//
	public static void hideKeyboard(AppiumDriver<MobileElement> driver) {
		driver.hideKeyboard();
	}
//
//	public void clickOn(By by) {
//		driver.findElement(by).click();
//	}
//
//	public MobileElement click(By by) {
//		waitForElementPresent(by);
//		MobileElement element = find(by);
//		element.click();
//		return element;
//	}
//
//	public MobileElement click(MobileElement element) {
//		element.click();
//		return element;
//	}
//
//	public MobileElement clear(By by) {
//		MobileElement element = find(by);
//		element.clear();
//		return element;
//	}
//
//	public MobileElement setText(By by, String text) {
//		MobileElement element = find(by);
//		element.clear();
//		element.sendKeys(text);
//		return element;
//	}
//
//	public MobileElement appendText(By by, String text) {
//		MobileElement element = find(by);
//		element.sendKeys(text);
//		return element;
//	}
//
//	public MobileElement find(By by) {
//		waitForElementPresent(by);
//		return driver.findElement(by);
//	}
//
//	public void waitForElementPresent(By by) {
//		WebDriverWait wait = new WebDriverWait(driver, globalWaitTime);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
//	}
//
//	public void waitForElementClickable(By by) {
//		WebDriverWait wait = new WebDriverWait(driver, globalWaitTime);
//		wait.until(ExpectedConditions.elementToBeClickable(by));
//	}
//
//	public void waitForElementNotPresent(String locator) {
//		WebDriverWait wait = new WebDriverWait(driver, globalWaitTime);
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(ByLocator(locator)));
//	}
//
//	public void scrollFormCenter(String direction) {
//		Dimension size = driver.manage().window().getSize();
//		switch (direction) {
//
//		case "up":
//			int x = size.width / 2;
//			int endy = (int) (size.height * 0.75);
//			int starty = (int) (size.height * 0.20);
////			driver.swipe(x, starty, x, endy, 3000);   //Commented due to version mismatch
//			break;
//
//		case "down":
//			x = size.width / 2;
//			starty = (int) (size.height * 0.75);
//			endy = (int) (size.height * 0.20);
////			driver.swipe(x, starty, x, endy, 3000);    //Commented due to version mismatch
//			break;
//
//		case "left":
//			int y = size.height / 2;
//			int startx = (int) (size.width * 0.15);
//			int endx = (int) (size.width * 0.75);
////			driver.swipe(startx, y, endx, y, 1000);        //Commented due to version mismatch
//			break;
//
//		case "right":
//			y = size.height / 2;
//			endx = (int) (size.width * 0.15);
//			startx = (int) (size.width * 0.75);
////			driver.swipe(startx, y, endx, y, 1000);          //Commented due to version mismatch
//			break;
//
//		}
//
//	}
//
//	public void TouchScreen() {
//		Dimension size = driver.manage().window().getSize();
//		int x = size.width / 2;
//		int y = size.height / 2;
////		TouchAction action1 = new TouchAction(driver).longPress(x, y).waitAction(1500);             //Commented due to version mismatch
////		action1.perform();																			//Commented due to version mismatch
//	}
//
//	public List<MobileElement> getMobileElements(By by) {
//		return driver.findElements(by);
//	}
//
//	// Handle locator type
//	public By ByLocator(String locator) {
//		By result = null;
//		if (locator.startsWith("//")) {
//			result = By.xpath(locator);
//		} else if (locator.startsWith("css=")) {
//			result = By.cssSelector(locator.replace("css=", ""));
//		} else if (locator.startsWith("#")) {
//			result = By.id(locator.replace("#", ""));
//		} else if (locator.startsWith("name=")) {
//			result = By.name(locator.replace("name=", ""));
//		} else if (locator.startsWith("link=")) {
//			result = By.linkText(locator.replace("link=", ""));
//		} else {
//			result = By.className(locator);
//		}
//		return result;
//	}
}
