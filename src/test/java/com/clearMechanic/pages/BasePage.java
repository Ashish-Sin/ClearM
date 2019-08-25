package com.clearMechanic.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.clearMechanic.appium.core.IBasePage;
import com.clearMechanic.util.MobileClient;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public abstract class BasePage extends MobileClient implements IBasePage {

//	protected AppiumDriver<MobileElement> driver;
	public int globalWaitTime = 10;

	public BasePage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}

//	public AppiumDriver<MobileElement> getApiumDriver() {         // Need to find out how it differs from AndroidDriver
//		return driver;
//	}
//
//	public AndroidDriver<MobileElement> getAndroidDriver() {       // Need to move this to MobileClient
//		return (AndroidDriver<MobileElement>) driver;
//	}

	public boolean isElementPresent(String locator) {
		try {
			driver.findElement(ByLocator(locator));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void moveElement(By source, By target) {
		MobileElement elSource = this.find(source);
		MobileElement elDest = this.find(target);
		TouchAction action = new TouchAction(driver);
//		action.longPress(elSource).moveTo(elDest).release().perform();    //Commented due to version mismatch
	}

	@Override
	public String getAttribute(By by, String attribute) {
		MobileElement element = find(by);
		return element.getAttribute(attribute);
	}

	public String getText(By by) {
		MobileElement element = find(by);
		return element.getText();
	}

	public void hideKeyboard() {
		driver.hideKeyboard();
	}

	public void clickOn(By by) {
		driver.findElement(by).click();
	}

	@Override
	public MobileElement click(By by) {
		waitForElementPresent(by);
		MobileElement element = find(by);
		element.click();
		return element;
	}

	public MobileElement click(MobileElement element) {
		element.click();
		return element;
	}

	@Override
	public MobileElement clear(By by) {
		MobileElement element = find(by);
		element.clear();
		return element;
	}

	@Override
	public MobileElement setText(By by, String text) {
		MobileElement element = find(by);
		element.clear();
		element.sendKeys(text);
		return element;
	}

	@Override
	public MobileElement appendText(By by, String text) {
		MobileElement element = find(by);
		element.sendKeys(text);
		return element;
	}

	@Override
	public MobileElement find(By by) {
		waitForElementPresent(by);
		return driver.findElement(by);
	}

	public void waitForElementPresent(By by) {
		WebDriverWait wait = new WebDriverWait(driver, globalWaitTime);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void waitForElementClickable(By by) {
		WebDriverWait wait = new WebDriverWait(driver, globalWaitTime);
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	public void waitForElementNotPresent(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, globalWaitTime);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(ByLocator(locator)));
	}

	public void scrollFormCenter(String direction) {
		Dimension size = driver.manage().window().getSize();
		switch (direction) {

		case "up":
			int x = size.width / 2;
			int endy = (int) (size.height * 0.75);
			int starty = (int) (size.height * 0.20);
//			driver.swipe(x, starty, x, endy, 3000);   //Commented due to version mismatch
			break;

		case "down":
			x = size.width / 2;
			starty = (int) (size.height * 0.75);
			endy = (int) (size.height * 0.20);
//			driver.swipe(x, starty, x, endy, 3000);    //Commented due to version mismatch
			break;

		case "left":
			int y = size.height / 2;
			int startx = (int) (size.width * 0.15);
			int endx = (int) (size.width * 0.75);
//			driver.swipe(startx, y, endx, y, 1000);        //Commented due to version mismatch
			break;

		case "right":
			y = size.height / 2;
			endx = (int) (size.width * 0.15);
			startx = (int) (size.width * 0.75);
//			driver.swipe(startx, y, endx, y, 1000);          //Commented due to version mismatch
			break;

		}

	}

	public void TouchScreen() {
		Dimension size = driver.manage().window().getSize();
		int x = size.width / 2;
		int y = size.height / 2;
//		TouchAction action1 = new TouchAction(driver).longPress(x, y).waitAction(1500);             //Commented due to version mismatch
//		action1.perform();																			//Commented due to version mismatch
	}

	public List<MobileElement> getMobileElements(By by) {
		return driver.findElements(by);
	}

	// Handle locator type
	public By ByLocator(String locator) {
		By result = null;
		if (locator.startsWith("//")) {
			result = By.xpath(locator);
		} else if (locator.startsWith("css=")) {
			result = By.cssSelector(locator.replace("css=", ""));
		} else if (locator.startsWith("#")) {
			result = By.id(locator.replace("#", ""));
		} else if (locator.startsWith("name=")) {
			result = By.name(locator.replace("name=", ""));
		} else if (locator.startsWith("link=")) {
			result = By.linkText(locator.replace("link=", ""));
		} else {
			result = By.className(locator);
		}
		return result;
	}
}
