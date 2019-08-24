package com.clearMechanic.appium.core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage implements IBasePage {

	protected AppiumDriver<MobileElement> driver;
	public int globalWaitTime = 10;

	public BasePage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}

	public AppiumDriver<MobileElement> getApiumDriver() {
		return driver;
	}

	public AndroidDriver<MobileElement> getAndroidDriver() {
		return (AndroidDriver<MobileElement>) driver;
	}

	@Override
	public boolean isElementPresent(String locator) {
		try {
			driver.findElement(ByLocator(locator));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public void moveElement(By source, By target) {
		WebElement elSource = this.find(source);
		WebElement elDest = this.find(target);
		TouchAction action = new TouchAction(driver);
//		action.longPress(elSource).moveTo(elDest).release().perform();    //Commented due to version mismatch
	}

	@Override
	public String getAttribute(By by, String attribute) {
		WebElement element = find(by);
		return element.getAttribute(attribute);
	}

	@Override
	public String getText(By by) {
		WebElement element = find(by);
		return element.getText();
	}

	@Override
	public void hideKeyboard() {
		driver.hideKeyboard();
	}

	@Override
	public void clickOn(By by) {
		driver.findElement(by).click();
	}

	@Override
	public WebElement click(By by) {
		waitForElementPresent(by);
		WebElement element = find(by);
		element.click();
		return element;
	}

	@Override
	public WebElement click(WebElement element) {
		element.click();
		return element;
	}

	@Override
	public WebElement clear(By by) {
		WebElement element = find(by);
		element.clear();
		return element;
	}

	@Override
	public WebElement setText(By by, String text) {
		MobileElement element = find(by);
		element.clear();
		element.sendKeys(text);
		return element;
	}

	@Override
	public WebElement appendText(By by, String text) {
		WebElement element = find(by);
		element.sendKeys(text);
		return element;
	}

	@Override
	public MobileElement find(By by) {
		waitForElementPresent(by);
		return driver.findElement(by);
	}

	@Override
	public void waitForElementPresent(By by) {
		WebDriverWait wait = new WebDriverWait(driver, globalWaitTime);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	@Override
	public void waitForElementClickable(By by) {
		WebDriverWait wait = new WebDriverWait(driver, globalWaitTime);
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	@Override
	public void waitForElementNotPresent(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, globalWaitTime);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(ByLocator(locator)));
	}

	@Override
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

	@Override
	public void TouchScreen() {
		Dimension size = driver.manage().window().getSize();
		int x = size.width / 2;
		int y = size.height / 2;
//		TouchAction action1 = new TouchAction(driver).longPress(x, y).waitAction(1500);             //Commented due to version mismatch
//		action1.perform();																			//Commented due to version mismatch
	}

	@Override
	public List<MobileElement> getMobileElements(By by) {
		return driver.findElements(by);
	}

	// Handle locator type
	@Override
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
