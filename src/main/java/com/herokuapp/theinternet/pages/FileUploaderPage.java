package com.herokuapp.theinternet.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploaderPage extends BasePageObject {

	private String newPageUrl = "https://testpages.eviltester.com/styled/file-upload-test.html";
	private By choseFileLocatorNew = By.id("fileinput");
	private By uploadButtonLocatorNew = By.xpath("//input[@value='Upload']");
	private By uploadedFilesLocatorNew = By.id("uploadedfilename");

	private By choseFileFieldLocator = By.id("file-upload");
	private By uploadButtonLocator = By.id("file-submit");
	private By uploadedFilesLocator = By.id("uploaded-files");

	public FileUploaderPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	/** Open FileUploaderPage with it's url */
	public void openPage() {
		log.info("Opening page: " + newPageUrl);
		openUrl(newPageUrl);
		log.info("Page opened!");
	}

	public void selectFile(String fileName) {
		log.info("Selecting '" + fileName + "' file from Files folder");
		String filePath = System.getProperty("user.dir") + "//src//main//resources//files//" + fileName;
		type(filePath, choseFileFieldLocator);
		log.info("File selected");
	}

	public void selectFileUsingRobotClass(String fileName) throws AWTException {
		log.info("Selecting '" + fileName + "' file from Files folder Using Robot Class");
		actionClick(choseFileFieldLocator);
		String filePath1 = System.getProperty("user.dir") + "\\src\\main\\resources\\files\\" + fileName;
		StringSelection filePath = new StringSelection(filePath1);
		log.info("Selecting From filepath1" + filePath1);
		Robot robot = new Robot();
		robot.setAutoDelay(2000);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		log.info("File selected");
	}

	public void pushUploadButton() {
		log.info("Clicking on upload button");
		waitForElementToBeDisplayed(choseFileFieldLocator, 10);
		actionClick(uploadButtonLocator);
	}

	public String getUploadedFilesNames() {
		String uploadedFileName = find(uploadedFilesLocator).getText();
		log.info("Uploaded files: " + uploadedFileName);
		return uploadedFileName;
	}

}