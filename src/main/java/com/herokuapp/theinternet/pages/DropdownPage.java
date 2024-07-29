package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePageObject {

	private By dropdownLocator = By.id("dropdown");

	public DropdownPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	/** This method selects given option from dropdown */
	public void selectOption(int i) {
		log.info("Selecting option " + i + " from dropdown");
		getDropdown().selectByIndex(i);

//		other ways
//		getDropdown().selectByValue("" + i);
//		getDropdown().selectByVisibleText("Option " + i);
	}

	/** This method returns selected option in dropdown as a string */
	public String getSelectedOption() {
		String selectedOption = getDropdown().getFirstSelectedOption().getText();
		log.info(selectedOption + " is selected in dropdown");
		return selectedOption;

	}

	/** helper method to get the Select object */
	private Select getDropdown() {
		WebElement dropdownElement = find(dropdownLocator);
		return new Select(dropdownElement);
	}
}
