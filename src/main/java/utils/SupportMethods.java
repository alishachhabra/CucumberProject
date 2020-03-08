package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import managers.WebDriverManager;

public class SupportMethods {

	public static WebElement waitForElementToBeClickable(WebElement element, long timeOut) {
		try {
			WebDriverWait wait = new WebDriverWait(WebDriverManager.getDriver(), timeOut);
			element = wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
		}
		return element;
	}

	public static WebElement waitForElementToBeDisplayed(WebElement element, long timeOut) {
		try {
			WebDriverWait wait = new WebDriverWait(WebDriverManager.getDriver(), timeOut);
			element = wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
		}
		return element;
	}
}
