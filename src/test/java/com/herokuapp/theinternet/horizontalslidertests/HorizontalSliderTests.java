package com.herokuapp.theinternet.horizontalslidertests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.HorizontalSliderPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class HorizontalSliderTests extends TestUtilities {
	private String value = "3.5";

	@Test
	public void sliderTest() {
		log.info("Starting sliderTest");
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();
		HorizontalSliderPage horizontalSliderPage = welcomePage.clickHorizontalSliderLink();
		sleep(1000);
		horizontalSliderPage.setSliderTo(value);
		sleep(1000);
		String sliderValue = horizontalSliderPage.getSliderValue();
		Assert.assertTrue(sliderValue.equals(value), "Range is not correct. It is: " + sliderValue);
	}
}
