package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HorizontalSliderPage extends BasePageObject {

	private By rangeLocator = By.id("range");
	private By sliderLocator = By.tagName("input");

	public HorizontalSliderPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	public void setSliderTo(String value) {
		log.info("Moving slider to " + value);
		int steps = (int) (Double.parseDouble(value) / 0.5);
		pressKey(sliderLocator, Keys.ENTER);
		for (int i = 1; i <= steps; i++) {
			pressKey(sliderLocator, Keys.ARROW_RIGHT);
		}

	}

	public String getSliderValue() {
		String value = find(rangeLocator).getText();
		log.info("Slider value is " + value);
		return value;
	}

}
