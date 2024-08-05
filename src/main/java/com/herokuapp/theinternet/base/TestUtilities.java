package com.herokuapp.theinternet.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.testng.annotations.DataProvider;

public class TestUtilities extends BaseTest {

	// STATIC SLEEP
	protected void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@DataProvider(name = "getFiles")
	protected Object[][] files() {
		return new Object[][] { { 1, "index.html" }, { 2, "logo.png" }, { 3, "text.txt" } };
	}

	protected void takeScreenshot(String fileName) {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + File.separator + "test-output" + File.separator + "screenshots"
				+ File.separator + getTodaysDate() + File.separator + testSuiteName + File.separator + testName
				+ File.separator + testMethodName + File.separator + getSystemTime() + " " + fileName + ".png";
		try {
			FileUtils.copyFile(srcFile, new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String getTodaysDate() {
		return (new SimpleDateFormat("yyyyMMdd").format(new Date()));
	}

	private static String getSystemTime() {
		return (new SimpleDateFormat("HHmmssSSS").format(new Date()));
	}

	/** Get logs from browser console */
	protected List<LogEntry> getBrowserLogs() {
		LogEntries log = driver.manage().logs().get("browser");
		List<LogEntry> logList = log.getAll();
		return logList;
	}
}
