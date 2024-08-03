package com.herokuapp.theinternet.pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HoversPage extends BasePageObject{

	private By avatarLocator = By.xpath("//div[@class='figure']");
	private By viewProfileLinkLocator = By.xpath(".//a[contains(text(),'View profile')]");

	public HoversPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	public void openUserProfile(int i) {
		 List<WebElement> avatars = findAll(avatarLocator);
		 WebElement specifiedUserAvatar =avatars.get(i-1);
		 hoverOverElement(specifiedUserAvatar);
		 specifiedUserAvatar.findElement(viewProfileLinkLocator).click();	
	}


}
