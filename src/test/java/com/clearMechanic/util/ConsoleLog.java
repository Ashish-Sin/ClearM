package com.clearMechanic.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.testng.Reporter;

public class ConsoleLog {

	public static Logger LOGGER;

	static {

		InputStream stream = ConsoleLog.class.getClassLoader().getResourceAsStream("logging.properties");
		try {
			LogManager.getLogManager().readConfiguration(stream);

		} catch (IOException e) {
			e.printStackTrace();
		}

		LOGGER = Logger.getLogger(ConsoleLog.class.getName());
	}

	public static void log(String str) {
		try {

			LOGGER.info(str);
			Reporter.log(str);
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}