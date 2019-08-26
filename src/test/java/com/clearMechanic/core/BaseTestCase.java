package com.clearMechanic.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

import com.clearMechanic.util.FileReader;
import com.clearMechanic.core.MobileClient;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BaseTestCase extends MobileClient{

	public AppiumDriver<MobileElement> driver;
	private static final Logger logger = LoggerFactory.getLogger(BaseTestCase.class);
	protected int timeOut = 20;
	private int port = 0;
	private final String udid;
	
	public BaseTestCase(String udid, int port) {
		this.udid = udid;
		this.port = port;
	}

	public void setUp() throws Exception {
		// setup port
		if (port == 0)
			port = Integer.parseInt(FileReader.readData("Port"));
		String host = FileReader.readData("Host");
		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://" + host + ":" + port + "/wd/hub"), getDesiredCapabilities(this.getAppAbsoultePath(), this.getAndroidVersion()));

		} catch (Exception e) {
			logger.debug("appium server not stated");
			throw new Exception(e);
		}
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
		setTheAppiumDriver(driver);
//		setWebDriver(driver);
	}

	public void destropAppSession() throws Exception {
		driver.quit();
	}

	/**
	 * @author Get absolute path of android application apk file. Apk file is
	 *         under the app folder
	 * @param no parameter
	 * @return absolute path.
	 * @throws Exception
	 */
	public String getAppAbsoultePath() throws Exception {
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "/app");
		File app = new File(appDir, FileReader.readData("APKFileName") + ".apk");
		String appName = app.getAbsolutePath();
		return appName;
	}
	
	public String getAndroidVersion() {
		return FileReader.readData("AndroidVersion");
	}

	/**
	 * @author Setup configuration in DesiredCapabilities which appium used to run test
	 * @param appPath application absolute path
	 * @return object of DesiredCapabilities.
	 */
	public DesiredCapabilities getDesiredCapabilities(String appPath, String androidVersion) throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "Appium");
		capabilities.setCapability("platformVersion", androidVersion);
		capabilities.setCapability("appPackage", "com.clearcheck.cmbeta");
		capabilities.setCapability("appActivity", "md5e047583c9ad193c8c022c6c9ad74d95b.HostActivity");
//		capabilities.setCapability("app", appPath);
		capabilities.setCapability("autoGrantPermissions", "true");
		if (StringUtils.isNoneBlank(udid)) {
			capabilities.setCapability("udid", udid);
		}

		return capabilities;
	}

	public void relaunchApp() {
		driver.closeApp();
		driver.launchApp();
	}

	public String getAppName() {
		String fileName = "";
		File folder = new File("app");
		File[] listOfFiles = folder.listFiles();
		if (listOfFiles == null) {
			throw new NullPointerException("app directory is null");
		}
		for (File listFile : listOfFiles) {
			String fileExtension = FilenameUtils.getExtension(listFile.getAbsolutePath());
			if (fileExtension.equals("apk")) {
				fileName = listFile.getName();
				break;
			}
		}
		return fileName;
	}

	public static List<String> getAttachedDevicesList() {

		List<String> devicesID = new ArrayList<String>();
		try {
			Process process = Runtime.getRuntime().exec(getAndroidPath() + "//platform-tools//adb devices");
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String s;
			while ((s = reader.readLine()) != null) {

				if (s.contains("device") && !s.contains("attached")) {
					String[] device = s.split("\t");
					devicesID.add(device[0]);
				}
			}

		} catch (IOException e) {
			logger.debug("adb command not executed to capture devices");
		}
		return devicesID;
	}

	@DataProvider(name = "listDevices", parallel = true)
	public static Object[][] listDevices() {

		Object obj[][] = new Object[getAttachedDevicesList().size()][2];
		List<String> devicesList = getAttachedDevicesList();
		for (int i = 0; i < devicesList.size(); i++) {
			obj[i][0] = devicesList.get(i);
			obj[i][1] = 4723 + i;
		}
		return obj;
	}

	public static String getAndroidPath() {
		String androidHome = System.getProperty("ANDROID_HOME");
		if (androidHome == null) {
			androidHome = System.getenv("ANDROID_HOME");
		}

		if (StringUtils.isEmpty(androidHome)) {
			throw new NullPointerException("Android Home path not set in machine");
		}
		return androidHome;
	}

	public void appReset() {
		driver.resetApp();
	}

	public void createFolder(String folderPath) {
		File file = new File(folderPath);
		if (!file.exists()) {
			file.mkdir();
		}
	}

	// capturing screenshot
	public void captureScreenshot(String fileName) {
		String folderPath = "build/outputs/screenshots/";
		createFolder("build/outputs");
		createFolder(folderPath);
		try {

			FileOutputStream out = new FileOutputStream(folderPath + fileName + ".jpg");
			out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
			out.close();

		} catch (Exception e) {

		}
	}

	public void reportLog(String message) {
		Reporter.log(message + "<br>");
	}

	public void switchWebView(String view) {
		Set<String> contextNames = driver.getContextHandles();
		for (String contextName : contextNames) {
			if (StringUtils.contains(contextName.toLowerCase(), view.toLowerCase())) {
				System.out.println("switched");
				driver.context(contextName);
			}

		}
	}

}
