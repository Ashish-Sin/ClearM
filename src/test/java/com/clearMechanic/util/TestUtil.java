package com.clearMechanic.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.logging.LogEntry;
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
	
	public static void waitforClickableElement(AppiumDriver<MobileElement> driver, By by, int globalWaitTime) {
		WebDriverWait wait = new WebDriverWait(driver, globalWaitTime);
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}
	
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
	
	public static void sleep(long time, String reason) {
		try {
			Thread.sleep(time);
			ConsoleLog.log(reason);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void getCrashLog(AppiumDriver<MobileElement> driver) {
		List<LogEntry> crashEntries = driver.manage().logs().get("crashlog").getAll();
		
		if (crashEntries.size() > 0) {
			ConsoleLog.log("APPLICATION CRASH DETECTED>>>>>>>>>>>>>>>>>>" + crashEntries.get(0).getMessage());
		}
	}
	
	public static void hideKeyboard(AppiumDriver<MobileElement> driver) {
		driver.hideKeyboard();
		ConsoleLog.log("Hide Keyboard");
		sleep(1000, "Wait till keyboard is hidden");
	}
}
