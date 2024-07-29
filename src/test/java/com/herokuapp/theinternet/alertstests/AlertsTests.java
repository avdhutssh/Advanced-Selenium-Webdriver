package com.herokuapp.theinternet.alertstests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.JavaScriptAlertsPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;

public class AlertsTests extends TestUtilities {

	@Test
	public void jsAlertTest() {
		log.info("Starting jsAlertTest");
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
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
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
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
}