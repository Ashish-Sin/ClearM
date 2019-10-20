package com.clearMechanic.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.clearMechanic.util.ConsoleLog;
import com.clearMechanic.util.FileReader;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseTestCase extends MobileClient {

	public static AndroidDriver<MobileElement> driver;
	private int port = 0;
	private final String udid;

	public BaseTestCase(String udid, int port) {
		this.udid = udid;
		this.port = port;
	}

	public BaseTestCase() {
		this.udid = "";
		this.port = 0;
		System.out.println("In default construc5tor");
	}

//	@BeforeTest
	@Parameters({ "udid", "platform" })
	public void setUp(String udid, String version) throws Exception {
		ConsoleLog.log("Launching Application......");
		// setup port
		if (port == 0)
			port = Integer.parseInt(FileReader.readData("Port"));
		String host = FileReader.readData("Host");
		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://" + host + ":" + port + "/wd/hub"),
					getDesiredCapabilities(udid, version));

		} catch (Exception e) {
			ConsoleLog.log("appium server not stated");
			throw new Exception(e);
		}
		setAndroidDriver(driver);
//		String packageName = driver.getCurrentPackage();
//		String revokeLocationPermission = "adb shell pm revoke " + packageName + " android.permission.RECORD_AUDIO";
//		try {
//			Runtime.getRuntime().exec(revokeLocationPermission);
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

	public void destroyAppSession() throws Exception {
		driver.quit();
	}

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

	public String getOS() {
		return FileReader.readData("OSVersion");
	}

	/**
	 * @author Setup configuration in DesiredCapabilities which appium used to run
	 *         test
	 * @param appPath application absolute path
	 * @return object of DesiredCapabilities.
	 */

	public DesiredCapabilities getDesiredCapabilities(String udid, String version) throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		if (getOS().equals("Android")) {
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("deviceName", "Appium");
			capabilities.setCapability("platformVersion", version);
			capabilities.setCapability("appPackage", "com.clearcheck.cmbeta");
			capabilities.setCapability("appActivity", "md5e047583c9ad193c8c022c6c9ad74d95b.HostActivity");
//			capabilities.setCapability("app", appPath);
			capabilities.setCapability("autoGrantPermissions", "true");
			capabilities.setCapability("clearDeviceLogsOnStart", true);
//			capabilities.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, systemPort);
			if (StringUtils.isNoneBlank(udid)) {
				capabilities.setCapability("udid", udid);
			}
		} else {
			capabilities.setCapability("platformName", "iOS");
			capabilities.setCapability("deviceName", "Imac360'siPhone");
			capabilities.setCapability("udid", "b30234dc24fbb929b400156cb66ca08f176e2f99");
			capabilities.setCapability("platformVersion", "12.4");
			capabilities.setCapability("bundleId", "com.clearcheck.cmbeta");
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
			capabilities.setCapability("agentPath",
					"/usr/local/lib/node_modules/appium/node_modules/appium-xcuitest-driver/WebDriverAgent/WebDriverAgent.xcodeproj");
			capabilities.setCapability("bootstrapPath",
					"/usr/local/lib/node_modules/appium/node_modules/appium-xcuitest-driver/WebDriverAgent");

//			capabilities.setCapability("autoGrantPermissions", "true");
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
			ConsoleLog.log("adb command not executed to capture devices");
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
	public String captureScreenshot() throws Exception {
		String base64Screenshot = null;

		System.out.println("In cature screenshot driverinstace" + getAndroidDriver());
		try {
			base64Screenshot = "data:image/png;base64,"
					+ ((TakesScreenshot) getAndroidDriver()).getScreenshotAs(OutputType.BASE64);
		} catch (Exception e) {
			System.out.println("Error in takinf screenshot" + e.getCause());
		}
		String folderPath = "screenshots//";
//		createFolder("build/outputs");
		createFolder(folderPath);
//		try {
//
//			FileOutputStream out = new FileOutputStream(folderPath + fileName + ".jpg");
//			out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
//			out.close();
//
//		} catch (Exception e) {
//
//		}
		System.out.println("In cature screenshot" + base64Screenshot);
		return base64Screenshot;
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

	public static void captureLog(AndroidDriver<MobileElement> driver, String testID) throws Exception {
		DateFormat df = new SimpleDateFormat("dd_MM_yyyy_HH-mm-ss");
		Date today = Calendar.getInstance().getTime();
		String reportDate = df.format(today);
		String logPath = System.getProperty("user.dir") + "\\Logs\\";
//			Log.info(driver.getSessionId() + ": Saving device log...");
		List<LogEntry> logEntries = driver.manage().logs().get("logcat").getAll();
		File logFile = new File(logPath + reportDate + "_" + testID + ".txt");

		PrintWriter log_file_writer = new PrintWriter(logFile);
		log_file_writer.println(logEntries);
		Scanner sc = new Scanner(logFile);
		while (sc.hasNextLine())
			System.out.println("++++++++++++++++++" + sc.nextLine());
		ConsoleLog.log("<a href=" + logFile + ">Link to logs</a>");
		log_file_writer.flush();
//			Log.info(driver.getSessionId() + ": Saving device log - Done.");
	}

}
