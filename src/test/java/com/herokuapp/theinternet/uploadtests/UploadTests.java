package com.herokuapp.theinternet.uploadtests;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.FileUploaderPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class UploadTests extends TestUtilities {
	private String fileName = "logo.png";

	@Test
	public void imageUploadTest() {
		log.info("Starting imageUploadTest");
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();
		FileUploaderPage fileUploaderPage = welcomePage.clickFileUploadLink();
		fileUploaderPage.selectFile(fileName);
		fileUploaderPage.pushUploadButton();
		String fileNames = fileUploaderPage.getUploadedFilesNames();
		Assert.assertTrue(fileNames.contains(fileName),
				"Our file (" + fileName + ") is not one of the uploaded (" + fileNames + ")");
	}

	@Test
	public void imageUploadUsingRobotClassTest() throws AWTException {
		log.info("Starting image Upload Using Robot Class Test");
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();
		FileUploaderPage fileUploaderPage = welcomePage.clickFileUploadLink();
		fileUploaderPage.selectFileUsingRobotClass(fileName);
		fileUploaderPage.pushUploadButton();
		String fileNames = fileUploaderPage.getUploadedFilesNames();
		Assert.assertTrue(fileNames.contains(fileName),
				"Our file (" + fileName + ") is not one of the uploaded (" + fileNames + ")");
	}
}
