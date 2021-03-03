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


	@FindBy(xpath = "//a[@href='/login']")
	private WebElement buttonLogin;


	public WebElement getButtonLogin() {
		return buttonLogin;
	}

	@FindBy(xpath = "//span[text()='Happening now']")
	private WebElement title;
	
	
	public WebElement getTitle() {
		return title;
	}

	public void navigateToHomePage(WebDriver driver, String url) {
		driver.get(url);

	}

	public void verifyNavigatedToHomePage(WebDriver driver) {
		SupportMethods.waitForElementToBeClickable(getTitle(), 10);
		Assert.assertTrue(getTitle().getText().equalsIgnoreCase("Happening now"), "Title is not displaying");
		Reporter.log("User navigated to twitter");

	}

	public void clickOnLoginButton() {

		SupportMethods.waitForElementToBeClickable(getButtonLogin(), 10);
		if (getButtonLogin().isDisplayed()) {
			getButtonLogin().click();
			Reporter.log("Clicked on login button");
		} else {
			throw new RuntimeException("Login button not displaying");
		}
	}

	
}
