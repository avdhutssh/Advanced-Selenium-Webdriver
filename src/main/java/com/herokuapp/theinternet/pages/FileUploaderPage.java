package com.herokuapp.theinternet.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploaderPage extends BasePageObject {

	private By choseFileFieldLocator = By.id("file-upload");
	private By uploadButtonLocator = By.id("file-submit");
	private By uploadedFilesLocator = By.id("uploaded-files");

	public FileUploaderPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	public void selectFile(String fileName) {
		log.info("Selecting '" + fileName + "' file from Files folder");
		String filePath = System.getProperty("user.dir") + "//src//main//resources//files//" + fileName;
		type(filePath, choseFileFieldLocator);
		log.info("File selected");
	}

	public void selectFileUsingRobotClass(String fileName) throws AWTException {
		log.info("Selecting '" + fileName + "' file from Files folder Using Robot Class");
		String filePath = System.getProperty("user.dir") + "//src//main//resources//files//" + fileName;
		log.info("File upload element displayed: " + find(choseFileFieldLocator).isDisplayed());
		log.info("File upload element enabled: " + find(choseFileFieldLocator).isEnabled());
		Robot robot = new Robot();
		robot.delay(2000);
		System.out.println("here1");
		jsClick(choseFileFieldLocator);
		System.out.println("here2");
		// Enter the file path
		for (char c : filePath.toCharArray()) {
			int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
			if (KeyEvent.CHAR_UNDEFINED == keyCode) {
				throw new RuntimeException("Key code not found for character '" + c + "'");
			}
			robot.keyPress(keyCode);
			robot.keyRelease(keyCode);
		}

		// Press Enter
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		log.info("File selected");
	}

	public void pushUploadButton() {
		log.info("Clicking on upload button");
		click(uploadButtonLocator);
	}

	public String getUploadedFilesNames() {
		String uploadedFileName = find(uploadedFilesLocator).getText();
		log.info("Uploaded files: " + uploadedFileName);
		return uploadedFileName;
	}

}