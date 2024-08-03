package com.herokuapp.theinternet.hoverstests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.HoversPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class HoversTests extends TestUtilities {

	int userNumber = 2;

	@Test
	public void userProfileTest() {
		log.info("Starting user2ProfileTest");
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();
		HoversPage hoversPage = welcomePage.clickHoversLink();
		hoversPage.openUserProfile(userNumber);
		Assert.assertTrue(hoversPage.getCurrentUrl().contains("/users/" + userNumber),
				"Url of opened page is not expected User 1 page url");
	}
}
