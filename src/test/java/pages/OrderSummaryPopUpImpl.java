package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import managers.WebDriverManager;
import utils.SupportMethods;

public class OrderSummaryPopUpImpl implements IOrderSummaryPopUp{

	public OrderSummaryPopUpImpl(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//p[@class='text-page-title-content']")
	private WebElement titleOrderSummary;
	
	
	@FindBy(xpath = "//div[@class='order-id-optional']/div")
	private WebElement orderId;
	
	@FindBy(xpath = "//a[@class='button-main-content']")
	private WebElement buttonContinue;

	public WebElement getTitleOrderSummary() {
		return titleOrderSummary;
	}

	public WebElement getOrderId() {
		return orderId;
	}

	public WebElement getButtonContinue() {
		return buttonContinue;
	}
	

	public void verifyNavigatedToOrderSummaryPopUp() {
		WebDriverManager.getDriver().switchTo().frame(0);
		SupportMethods.waitForElementToBeDisplayed(getTitleOrderSummary(), 10);
		Assert.assertTrue(getTitleOrderSummary().getText().contains("Order Summary"),
				"Order Summary title is not displaying");
		Reporter.log("User navigated to order summary popup");

	}

	public void clickOnContinueButton() {
		SupportMethods.waitForElementToBeDisplayed(getButtonContinue(), 10);
		getButtonContinue().click();
		
		Reporter.log("Click on Continue button");
	}
	
}
