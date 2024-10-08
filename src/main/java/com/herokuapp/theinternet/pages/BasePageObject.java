package com.herokuapp.theinternet.pages;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class BasePageObject {

	protected WebDriver driver;
	protected Logger log;

	public BasePageObject(WebDriver driver, Logger log) {
		this.driver = driver;
		this.log = log;
	}

	/** Open page with given URL */
	protected void openUrl(String url) {
		driver.get(url);
	}

	/** Find element using given locator */
	protected WebElement find(By locator) {
		return driver.findElement(locator);
	}

	/** Find all elements using given locator */
	protected List<WebElement> findAll(By locator) {
		return driver.findElements(locator);
	}

	/** Get title of current page */
	public String getCurrentPageTitle() {
		return driver.getTitle();
	}

	/** Click on element with given locator when its visible */
	protected void click(By locator) {
		waitForVisibilityOf(locator, 5);
		find(locator).click();
	}

	/** Get source of current page */
	public String getCurrentPageSource() {
		return driver.getPageSource();
	}

	/** Type given text into element with given locator */
	protected void type(String text, By locator) {
		waitForVisibilityOf(locator, 5);
		find(locator).sendKeys(text);
	}

	/** Get URL of current page from browser */
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	/**
	 * Wait for specific ExpectedCondition for the given amount of time in seconds
	 */
	private void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds) {
		timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 30;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
		wait.until(condition);
	}

	/**
	 * Wait for given number of seconds for element with given locator to be visible
	 * on the page
	 */
	protected void waitForVisibilityOf(By locator, Integer... timeOutInSeconds) {
		int attempts = 0;
		while (attempts < 2) {
			try {
				waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
						(timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null));
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
	}

	/** Wait for element to be displayed */
	public boolean waitForElementToBeDisplayed(By locator, int timeoutInSeconds) {
		log.info("Waiting for element to be displayed: " + locator);
		int attempts = 0;
		while (attempts < timeoutInSeconds) {
			try {
				if (driver.findElement(locator).isDisplayed()) {
					log.info("Element is displayed: " + locator);
					return true;
				}
			} catch (NoSuchElementException e) {
				log.debug("Element not found: " + locator + ", attempt: " + attempts);
			}
			try {
				Thread.sleep(1000); // Wait for 1 second before next attempt
			} catch (InterruptedException e) {
				log.error("InterruptedException during wait", e);
				Thread.currentThread().interrupt(); // Restore interrupted status
			}
			attempts++;
		}
		log.error("Element not displayed after " + timeoutInSeconds + " seconds: " + locator);
		return false;
	}

	public WebElement fluentWait(final By locator, int timeoutInSeconds, int pollingInMillis) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeoutInSeconds))
				.pollingEvery(Duration.ofMillis(pollingInMillis)).ignoring(NoSuchElementException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});
		return element;
	}

	/** Wait for alert present and then switch to it */
	protected Alert switchToAlert() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.alertIsPresent());
		return driver.switchTo().alert();
	}

	/** Switching to new window */
	public void switchToWindowWithTitle(String expectedTitle) {
		String parentWindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();

		Iterator<String> windowsIterator = allwindows.iterator();
		while (windowsIterator.hasNext()) {
			String windowHandle = windowsIterator.next().toString();
			if (!windowHandle.equals(parentWindow)) {
				driver.switchTo().window(windowHandle);
				if (getCurrentPageTitle().equals(expectedTitle)) {
					break;
				}
			}
		}
	}

	/** Switch to iFrame using it's locator */
	public void switchToFrame(By frameLocator) {
		driver.switchTo().frame(find(frameLocator));
	}

	/** Press Key on locator */
	public void pressing(By locator, Keys key) {
		find(locator).sendKeys(key);
	}

	/** Press Key using Actions class */
	public void pressKeyWithActions(Keys key) {
		log.info("Pressing " + key.name() + " using Actions class");
		Actions act = new Actions(driver);
		act.sendKeys(key).perform(); // no need of build()
	}

	/** Press Key on locator */
	public void pressKey(By locator, Keys key) {
		find(locator).sendKeys(key);
	}

	/** Click using javascript executor */
	public void jsClick(By locator) {
		WebElement element = find(locator);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", element);
	}

	/** Click using action class */
	public void actionClick(By locator) {
		waitForVisibilityOf(locator, 5);
		Actions act = new Actions(driver);
		act.moveToElement(find(locator)).click().build().perform();
	}

	/** Scroll to bottom of the page */
	public void scrollToBottom() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	/** Drag 'from' element to 'to' element */
	public void performDragAndDrop(By from, By to) {
		Actions act = new Actions(driver);
		act.dragAndDrop(find(from), find(to)).perform();
	}

	/** Drag 'from' element to 'to' element using JS executor */
	public void performDragAndDrop_Using_JS(By from, By to) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript(
				"function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
						+ "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n"
						+ "data: {},\n" + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
						+ "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n"
						+ "return event;\n" + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
						+ "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
						+ "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
						+ "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n"
						+ "}\n" + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
						+ "var dragStartEvent =createEvent('dragstart');\n"
						+ "dispatchEvent(element, dragStartEvent);\n" + "var dropEvent = createEvent('drop');\n"
						+ "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
						+ "var dragEndEvent = createEvent('dragend');\n"
						+ "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
						+ "var source = arguments[0];\n" + "var destination = arguments[1];\n"
						+ "simulateHTML5DragAndDrop(source,destination);",
				find(from), find(to));
	}

	/** Perform mouse hover over element */
	public void hoverOverElement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	/** Perform mouse hover over element Using JSE */
	public void hoverOverElementJS(WebElement element) {
		String script = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', \n"
				+ "\n"
				+ "true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript(script, element);
	}
	
	/** Add cookie */
	public void setCookie(Cookie ck) {
		log.info("Adding cookie " + ck.getName());
		driver.manage().addCookie(ck);
		log.info("Cookie added");
	}
	
	/** Get cookie value using cookie name */
	public String getCookie(String name) {
		log.info("Getting value of cookie " + name);
		return driver.manage().getCookieNamed(name).getValue();
	}
}
