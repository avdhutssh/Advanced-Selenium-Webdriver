package com.herokuapp.theinternet.loginpagetests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.CsvDataProviders;
import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class NegativeLogInTests extends TestUtilities {

	@Test(dataProvider = "csvFileReader", dataProviderClass = CsvDataProviders.class )
	public void negativeLogInTest(Map<String, String> testData) {
		
		String no = testData.get("no");
		String username  = testData.get("username");
		String password = testData.get("password");
		String expectedErrorMessage = testData.get("expectedMessage");
		String description = testData.get("description");
		
		log.info("Starting negativeLogInTest #" + no + " for " + description);
		
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();
		LoginPage loginPage = welcomePage.clickFormAuthenticationLink();
		loginPage.negativeLogIn(username, password);
		loginPage.waitForErrorMessage();
		String message = loginPage.getErrorMessageText();
		Assert.assertTrue(message.contains(expectedErrorMessage), "Message doesn't contain expected text.");
	}
}
