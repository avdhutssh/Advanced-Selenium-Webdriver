package com.herokuapp.theinternet.base;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

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

            default:
                log.info("Do not know how to start: " + browser + ", starting chrome.");
                driver.set(new ChromeDriver(getChromeOptions()));
                break;
        }

        driver.get().manage().window().maximize();
        return driver.get();
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        // Add additional configurations if needed
        return options;
    }
}
