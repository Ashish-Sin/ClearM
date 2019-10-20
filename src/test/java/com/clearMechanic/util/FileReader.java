package com.clearMechanic.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

public class FileReader {

	private static final String configFile = "Config.properties";

	/**
	 * It load the configuration file and read data
	 * 
	 * @param by
	 *            String properties file key
	 * @return the found value from properties file.
	 */
	public static String readData(String key) {
//		if (StringUtils.isEmpty(key)) {
//			throw new Exception("key name is null");
//		}

		String value = "";
		try {

			Properties properties = new Properties();
			File file = new File(configFile);
			if (file.exists()) {
				properties.load(new FileInputStream(file));
				value = properties.getProperty(key);
			}
		} catch (Exception e) {
//			logger.debug("file not found");
		}
		return value;
	}

	public static String readTestData(String key) throws Exception {
		return getData("src\\test\\resources\\testdata\\TestDataFile.properties", key);
	}

	public static String getData(String fileName, String key) throws Exception {
		if (StringUtils.isEmpty(key)) {
			throw new Exception("key name is null");
		}
		String value = "";
		try {

			Properties properties = new Properties();
			File file = new File(fileName);
			if (file.exists()) {
				properties.load(new FileInputStream(file));
				value = properties.getProperty(key);
			}
		} catch (Exception e) {
//			logger.debug(fileName + " file not found");
		}
		return value;
	}

	/**
	 * It write data in configuration file
	 * 
	 * @param by
	 *            String key
	 * @param by
	 *            String value
	 */
	public void setData(String key, String val) throws Exception {

		if (StringUtils.isEmpty(key))
			throw new Exception("key name is null");
		try {
			File file = new File(configFile);
			Properties properties = new Properties();
			properties.load(new FileInputStream(file));
			FileOutputStream obj = new FileOutputStream(file);
			properties.setProperty(key, val);
			properties.store(obj, "Update data into file ");
			// prop.save(ob, "");

		} catch (IOException ex) {
//			logger.debug(" file not found");
		}
	}

}
