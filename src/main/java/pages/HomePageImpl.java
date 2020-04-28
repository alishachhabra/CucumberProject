package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import utils.SupportMethods;

public class HomePageImpl implements IHomePage {

	public HomePageImpl(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='title']")
	private WebElement title;

	@FindBy(xpath = "//a[@class='btn buy']")
	private WebElement buttonBuyNow;

	public WebElement getTitle() {
		return title;
	}

	public WebElement getButtonBuyNow() {
		return buttonBuyNow;
	}

	public void navigateToHomePage(WebDriver driver, String url) {
		driver.get(url);

	}

	public void verifyNavigatedToHomePage() {
		SupportMethods.waitForElementToBeDisplayed(getTitle(),10);
		Assert.assertTrue(getTitle().getText().equalsIgnoreCase("Midtrans Pillow"), "Title is not displaying");
		Reporter.log("User navigated to home page");

	}

	public void clickOnBuyNowButton() {

		SupportMethods.waitForElementToBeClickable(getButtonBuyNow(), 10);
		if (getButtonBuyNow().isDisplayed()) {
			getButtonBuyNow().click();
			Reporter.log("Clicked on Buy Now button");
		} else {
			throw new RuntimeException("Buy Now button not displaying");
		}
	}

	
}
