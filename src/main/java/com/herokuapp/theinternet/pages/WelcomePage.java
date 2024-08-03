package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePageObject {

	private String pageUrl = "https://the-internet.herokuapp.com/";

	private By formAuthenticationLinkLocator = By.linkText("Form Authentication");
	private By checkBoxLinkLocator = By.linkText("Checkboxes");
	private By dropdownLinkLocator = By.linkText("Dropdown");
	private By javaScriptAlertsLinkLocator = By.linkText("JavaScript Alerts");
	private By multipleWindowsLinkLocator = By.linkText("Multiple Windows");
	private By editorLinkLocator = By.linkText("WYSIWYG Editor");
	private By keyPressesLinkLocator = By.linkText("Key Presses");
	private By fileUploadLinkLocator = By.linkText("File Upload");
	private By dragAndDropLinkLocator = By.linkText("Drag and Drop");
	private By hoversLinkLocator = By.linkText("Hovers");

	public WelcomePage(WebDriver driver, Logger log) {
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

	public WindowsPage clickMultipleWindowsLink() {
		log.info("Clicking Multiple Windows link on Welcome Page");
		click(multipleWindowsLinkLocator);
		return new WindowsPage(driver, log);
	}

	public EditorPage clickWYSIWYGEditorLink() {
		log.info("Clicking Multiple Windows link on Welcome Page");
		scrollToBottom();
		click(editorLinkLocator);
		return new EditorPage(driver, log);
	}

	public KeyPressesPage clickKeyPressesLink() {
		log.info("Clicking Key Presses link on Welcome Page");
		click(keyPressesLinkLocator);
		return new KeyPressesPage(driver, log);
	}

	public FileUploaderPage clickFileUploadLink() {
		log.info("Clicking File Upload link on Welcome Page");
		click(fileUploadLinkLocator);
		return new FileUploaderPage(driver, log);
	}

	public DragAndDropPage clickDragAndDropLink() {
		log.info("Clicking Drag and Drop link on Welcome Page");
		click(dragAndDropLinkLocator);
		return new DragAndDropPage(driver, log);
	}

	public HoversPage clickHoversLink() {
		log.info("Clicking Hovers link on Welcome Page");
		click(hoversLinkLocator);
		return new HoversPage(driver, log);
	}
}
