package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePageObject extends BasePageObject {

	private String pageUrl = "https://the-internet.herokuapp.com/";

	private By formAuthenticationLinkLocator = By.linkText("Form Authentication");
	private By checkBoxLinkLocator = By.linkText("Checkboxes");
	private By dropdownLinkLocator = By.linkText("Dropdown");
	private By javaScriptAlertsLinkLocator = By.linkText("JavaScript Alerts");

	public WelcomePageObject(WebDriver driver, Logger log) {
		super(driver, log);
	}

	/** Open WelcomePage with it's url */
	public void openPage() {
		log.info("Opening page: " + pageUrl);
		openUrl(pageUrl);
		log.info("Page opened!");
	}

	/** Open LoginPage by clicking on Form Authentication Link */
	public LoginPage clickFormAuthenticationLink() {
		log.info("Clicking Form Authentication link on Welcome Page");
		click(formAuthenticationLinkLocator);
		return new LoginPage(driver, log);
	}

	/** Open CheckboxesPage by clicking on Checkboxes Link */
	public CheckboxesPage clickCheckBoxesLink() {
		log.info("Clicking Checkboxes link on Welcome Page");
		click(checkBoxLinkLocator);
		return new CheckboxesPage(driver, log);
	}

	/** Open dropdownPage by clicking on dropdown Link */
	public DropdownPage clickDropdownLink() {
		log.info("Clicking dropdown link on Welcome Page");
		click(dropdownLinkLocator);
		return new DropdownPage(driver, log);
	}

	/** Open jsAlertPage by clicking on jsAlert Link */
	public JavaScriptAlertsPage clickJavaScriptAlertsLink() {
		log.info("Clicking JS Alerts link on Welcome Page");
		click(javaScriptAlertsLinkLocator);
		return new JavaScriptAlertsPage(driver, log);
	}
}
