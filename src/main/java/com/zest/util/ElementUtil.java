package com.zest.util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	WebDriver driver;
	WebDriverWait wait;

	public ElementUtil(WebDriver driver) {

		this.driver = driver;
		wait = new WebDriverWait(driver, AppConstants.defaultTimeout);
	}

	/**
	 * This method is used to create a webelement on the basis of locator
	 * 
	 * @param locator
	 * @return element
	 */

	public boolean waitfortitlePresent(String title) {
		wait.until(ExpectedConditions.titleIs(title));
		return true;

	}

	public boolean waitforelementtobepresent(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return true;

	}

	public boolean waitforelementVisible(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return true;

	}

	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			// give a condition for waiting for the element to be present and check if it is
			// present
			// if(waitforelementtobepresent(locator))
			element = driver.findElement(locator);
		} catch (Exception e) {
			System.out.println("Some exception got occured while creating web element");
		}
		return element;
	}

	public void doclick(By locator) {
		try {
			getElement(locator).click();
		} catch (Exception e) {
			System.out.println("Some exception got occured while clicking the element");
		}
	}

	public void doActionsClick(By locator) {
		Actions action = new Actions(driver);
		action.click(getElement(locator)).perform();
	}

	public void doActionsdoubleclick(By locator) {
		Actions action = new Actions(driver);
		action.doubleClick(getElement(locator)).build().perform();
	}
	
	public void doActionsSendKeys(By locator, String value) {
		Actions action = new Actions(driver);
		action.sendKeys(getElement(locator), value).perform();
	}

	public void doClickWithMoveToElement(By locator) {
		Actions action = new Actions(driver);
		action.moveToElement(getElement(locator)).click().build().perform();
	}

	public void sendKeys(By locator, String value) {
		try {
			WebElement ele = getElement(locator);
			ele.clear();
			ele.sendKeys(value);
		} catch (Exception e) {
			System.out.println("Some exception got occured entering values in the feild");
		}
	}

	public boolean doisDisplayed(By locator) {
		try {
			return getElement(locator).isDisplayed();
		} catch (Exception e) {
			System.out.println("Some exception got occured....");
		}
		return false;
	}

	public String dogetText(By locator) {
		try {
			return getElement(locator).getText();
		} catch (Exception e) {
			System.out.println("Some exception got occured while getting text from elelemt");
		}
		return null;
	}

	public String doGetPageTitle() {
		try {
			return driver.getTitle();
		} catch (Exception e) {
			System.out.println("some exception got occured while getting the title");
		}
		return null;
	}

	public List<WebElement> dogetElements(By locator) {
		List<WebElement> element = null;
		try {
			element = driver.findElements(locator);
		} catch (Exception e) {
			System.out.println("Some exception got occured while creating web element");
		}
		return element;
	}

	public String doGetPageTitle(String title) {
		wait.until(ExpectedConditions.titleIs(title));
		return driver.getTitle();
	}

	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	
	public WebElement waitForElementToBeLocated(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	
	
	

}
