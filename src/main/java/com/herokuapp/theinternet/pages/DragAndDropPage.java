package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DragAndDropPage extends BasePageObject {

	private By columnA = By.id("column-a");
	private By columnB = By.id("column-b");

	public DragAndDropPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	public void dragAtoB() {
		log.info("Drag and drop A box on B box");
		performDragAndDrop(columnA, columnB);
	}

	public void dragAtoB_Using_JS_Executor() {
		log.info("Drag and drop A box on B box using jse");
		performDragAndDrop_Using_JS(columnA, columnB);
	}
	
	
	public String getColumnAText() {
		String text = find(columnA).getText();
		log.info("Column A Text: " + text);
		return text;
	}

	public String getColumnBText() {
		String text = find(columnB).getText();
		log.info("Column B Text: " + text);
		return text;
	}

}
