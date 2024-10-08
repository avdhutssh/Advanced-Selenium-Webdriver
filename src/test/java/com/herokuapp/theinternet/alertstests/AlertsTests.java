package com.herokuapp.theinternet.alertstests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.JavaScriptAlertsPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class AlertsTests extends TestUtilities {

	@Test
	public void jsAlertTest() {
		log.info("Starting jsAlertTest");
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();
		JavaScriptAlertsPage alertsPage = welcomePage.clickJavaScriptAlertsLink();
		alertsPage.openJSAlert();
		sleep(500);
		String alertMessage = alertsPage.getAlertText();
		alertsPage.acceptAlert();
		String result = alertsPage.getResultText();
		sleep(500);
		Assert.assertTrue(alertMessage.equals("I am a JS Alert"),
				"Alert message is not expected. \nShould be 'I am a JS Alert', but it is '" + alertMessage + "'");
		Assert.assertTrue(result.equals("You successfully clicked an alert"),
				"result is not expected. \nShould be 'You successfully clicked an alert', but it is '" + result + "'");
	}

	@Test
	public void jsDismissTest() {
		log.info("Starting jsDismissTest");
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();
		JavaScriptAlertsPage alertsPage = welcomePage.clickJavaScriptAlertsLink();
		alertsPage.openJSConfirm();
		sleep(500);
		String alertMessage = alertsPage.getAlertText();
		alertsPage.dismissAlert();
		String result = alertsPage.getResultText();
		sleep(500);
		Assert.assertTrue(alertMessage.equals("I am a JS Confirm"),
				"Alert message is not expected. \nShould be 'I am a JS Confirm', but it is '" + alertMessage + "'");
		Assert.assertTrue(result.equals("You clicked: Cancel"),
				"result is not expected. \nShould be 'You clicked: Cancel', but it is '" + result + "'");
	}

	@Test
	public void jsPromptTest() {
		log.info("Starting jsPromtTest");
		String alertText = "Hello Alert, it's Avdhut here";
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();
		JavaScriptAlertsPage alertsPage = welcomePage.clickJavaScriptAlertsLink();
		alertsPage.openJSPrompt();
		sleep(500);
		String alertMessage = alertsPage.getAlertText();
		alertsPage.typeTextIntoAlert(alertText);
		String result = alertsPage.getResultText();
		sleep(500);
		Assert.assertTrue(alertMessage.equals("I am a JS prompt"),
				"Alert message is not expected. \nShould be 'I am a JS prompt', but it is '" + alertMessage + "'");
		Assert.assertTrue(result.equals("You entered: " + alertText),
				"result is not expected. \nShould be 'You entered: " + alertText + "', but it is '" + result + "'");
	}
}