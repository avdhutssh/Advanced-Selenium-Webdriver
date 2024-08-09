package com.herokuapp.theinternet.base;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserDriverFactory {

	private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	private String browser;
	private Logger log;

	public BrowserDriverFactory(String browser, Logger log) {
		this.browser = browser.toLowerCase();
		this.log = log;
	}

	public WebDriver createDriver() {
		// Create driver
		log.info("Create driver: " + browser);

		switch (browser) {
		case "chrome":
			driver.set(new ChromeDriver(getChromeOptions()));
			break;

		case "firefox":
			driver.set(new FirefoxDriver());
			break;

		case "chromeheadless":
			log.info("Starting Chrome in Headless mode");
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--headless");
			driver.set(new ChromeDriver(chromeOptions));
			break;

		case "firefoxheadless":
			log.info("Starting Firefox in Headless mode");
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.addArguments("--headless");
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			driver.set(new FirefoxDriver(firefoxOptions));
			break;

		default:
			log.info("Do not know how to start: " + browser + ", starting chrome.");
			driver.set(new ChromeDriver(getChromeOptions()));
			break;
		}

		driver.get().manage().window().maximize();
		return driver.get();
	}

	public WebDriver createChromeWithProfile(String profile) {
		log.info("Starting chrome driver with profile: " + profile);
		ChromeOptions chromeOptions = getChromeOptions();
		chromeOptions.addArguments("user-data-dir=src/main/resources/Profiles/" + profile);
		driver.set(new ChromeDriver(chromeOptions));
		return driver.get();
	}

	public WebDriver createChromeWithMobileEmulation(String deviceName) {
		log.info("Starting driver with " + deviceName + " emulation]");
		Map<String, String> mobileEmulation = new HashMap<>();
		mobileEmulation.put("deviceName", deviceName);
		ChromeOptions chromeOptions = getChromeOptions();
		chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
		driver.set(new ChromeDriver(chromeOptions));
		return driver.get();
	}

	private ChromeOptions getChromeOptions() {
		ChromeOptions options = new ChromeOptions();
		return options;
	}
}
