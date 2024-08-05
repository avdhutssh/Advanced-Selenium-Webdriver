package com.herokuapp.theinternet.base;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
		return (new SimpleDateFormat("yyyyMMdd").format(new Date(0)));
	}

	private static String getSystemTime() {
		return (new SimpleDateFormat("HHmmssSSS").format(new Date(0)));
	}
}
