package genericLibrary;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class seleniumUtility {
	public WebDriver driver = null;
	public Actions action = new Actions(driver);

	/**
	 * This is a generic method to maximize window
	 * 
	 * @author Nikhil A
	 */
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

	/**
	 * This is a generic method for implicit wait
	 */
	public void implicitWait(int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}

	/*--------------------ActionsClassMethods---------------------*/
	 /**
	 * This is a generic method to move the cursor to an element
	 */
	public void moveCursorToAnElement(WebElement element) {
		action.moveToElement(element).perform();
	}

	/**
	 * This is generic method to right click
	 */
	public void rightClick(WebElement element) {
		action.contextClick(element).perform();
	}
	

	/**
	 * This is a generic method to drag and drop
	 */
	public void dragAndDropAnElement(WebElement src, WebElement target) {
		action.dragAndDrop(src, target).perform();
	}

	/**
	 * This is a generic method to handle a pointer
	 */
	public void dragAndDropAPointer(WebElement src, int xOffset, int yOffset) {
		action.dragAndDropBy(src, xOffset, yOffset).perform();
	}

	/**
	 * This is a generic method to click and hold an element
	 */
	public void clickAndHoldElement(WebElement element) {
		action.clickAndHold(element).perform();
	}

	/**
	 * This is a generic method to perform scroll down operation
	 */
	public void scrollToaParticularElement(WebElement element) {
		action.scrollToElement(element).perform();
	}

	/**
	 * This is generic method to release an element
	 */
	public void releaseAnElement(WebElement element) {
		action.release(element).perform();
	}
	/*--------------------Alert Method-------------------*/
	/*
	 * This is a generic method to accept the alert
	 */
	public void acceptAlert()
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * This is a generic method to dismiss the alert
	 */
	public void cancelAlert()
	{
		driver.switchTo().alert().dismiss();
	}
}
