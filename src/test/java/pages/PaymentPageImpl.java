package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import dataProviders.CustomerDataBean;
import managers.WebDriverManager;
import utils.SupportMethods;

public class PaymentPageImpl implements IPaymentPage {

	public PaymentPageImpl(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[@class='text-page-title-content']")
	private WebElement titlePaymentPage;

	public WebElement getTitlePaymentPage() {
		return titlePaymentPage;
	}

	@FindBy(xpath = "//input[@name='cardnumber']")
	private WebElement textCardNumber;

	public WebElement getTextCardNumber() {
		return textCardNumber;
	}

	@FindBy(xpath = "//input[@placeholder='MM / YY']")
	private WebElement textExpiryDate;

	public WebElement getTextExpiryDate() {
		return textExpiryDate;
	}

	@FindBy(xpath = "//input[@type='tel' and @inputmode='numeric']")
	private WebElement textCVV;

	public WebElement getTextCVV() {
		return textCVV;
	}

	@FindBy(xpath = "//span[@class='text-amount-amount']")
	private WebElement totalAmount;

	public WebElement getTotalAmount() {
		return totalAmount;
	}
	
	@FindBy(xpath = "//input[@type='checkbox' and @value='on']//parent::label[text()='Midtrans Promo']")
	private WebElement checkBoxPromo;

	public WebElement getCheckBoxPromo() {
		return checkBoxPromo;
	}
	
	@FindBy(xpath = "//a[@class='button-main-content']")
	private WebElement buttonPayNow;

	public WebElement getButtonPayNow() {
		return buttonPayNow;
	}

	@FindBy(xpath = "//h1[text()='Issuing Bank']")
	private WebElement titlePaymentProcessing;

	public WebElement getTitlePaymentProcessing() {
		return titlePaymentProcessing;
	}

	@FindBy(xpath = "//input[@id='PaRes']")
	private WebElement textOtp;

	public WebElement getTextOtp() {
		return textOtp;
	}

	@FindBy(xpath = "//p[@id='txn_amount']")
	private WebElement totalTxnAmount;

	public WebElement getTotalTxnAmount() {
		return totalTxnAmount;
	}

	@FindBy(xpath = "//button[@name='ok']")
	private WebElement buttonOk;

	public WebElement getButtonOk() {
		return buttonOk;
	}

	@FindBy(xpath = "//iframe[@id='snap-midtrans']")
	private WebElement frameParent;

	public WebElement getFrameParent() {
		return frameParent;
	}

	@FindBy(xpath = "//iframe[contains(@src,'token')]")
	private WebElement frameChild;

	public WebElement getFrameChild() {
		return frameChild;
	}

	@FindBy(xpath = "//span[contains(text(),'Thank you')]")
	private WebElement textMessagePaymentComplete;

	public WebElement getTextMessagePaymentComplete() {
		return textMessagePaymentComplete;
	}

	public void verifyNavigatedToPaymentPage() {
		SupportMethods.waitForElementToBeDisplayed(getTitlePaymentPage(), 10);
		Assert.assertTrue(getTitlePaymentPage().getText().contains("Select Payment"),
				"Select Payment title is not displaying");
		Reporter.log("User navigated to payment page");

	}

	public void selectPaymentType(String paymentType) {
		findPaymentTypeOptionElement(paymentType).click();

	}

	public WebElement findPaymentTypeOptionElement(String paymentType) {

		WebElement ele = WebDriverManager.getDriver().findElement(
				By.xpath("//div[@id='payment-list']//div[@class='list-title text-actionable-bold' and contains(text(),'"
						+ paymentType + "')]"));

		SupportMethods.waitForElementToBeDisplayed(ele, 10);
		if (ele.isDisplayed()) {
			return ele;
		} else {
			throw new RuntimeException("Payment type " + paymentType + " is not present");
		}

	}

	public void verifyNavigatedToPaymentTypePage() {
		SupportMethods.waitForElementToBeDisplayed(getTitlePaymentPage(), 10);
		Assert.assertTrue(getTitlePaymentPage().getText().contains("Credit Card"),
				"Credit Card title is not displaying");
		Reporter.log("User navigated to payment typr credit card page");

	}

	public String getTotalOrderAmount() {
		SupportMethods.waitForElementToBeDisplayed(getTotalAmount(), 10);
		return getTotalAmount().getText().replace(",", "");
	}

	public void enterCardDetails(CustomerDataBean cardData) {
		SupportMethods.waitForElementToBeDisplayed(getTextCardNumber(), 10);
		getTextCardNumber().sendKeys(cardData.cardNumber);

		if (WebDriverManager.getDriver().findElements(By.xpath("//span[text()='Invalid card number']")).size() != 0) {
			throw new RuntimeException("Invalid Card number!. Enter valid card number");

		} else {
			getTextExpiryDate().sendKeys(cardData.expiryDate);
			getTextCVV().sendKeys(cardData.cvv);
		}

	}

	
	public void uncheckPromo() {
		SupportMethods.waitForElementToBeDisplayed(getCheckBoxPromo(), 10);
		getCheckBoxPromo().click();
		
	}
	
	public void clickOnPayNow() {
		SupportMethods.waitForElementToBeDisplayed(getButtonPayNow(), 10);
		getButtonPayNow().click();
		WebDriverManager.getDriver().switchTo().parentFrame();
	}

	public void verifyNavigatedToPaymentProcessingPage() {
		SupportMethods.waitForElementToBeDisplayed(getFrameParent(), 20);

		WebDriverManager.getDriver().switchTo().frame(getFrameParent());

		SupportMethods.waitForElementToBeDisplayed(getFrameChild(), 20);
		WebDriverManager.getDriver().switchTo().frame(getFrameChild());
		SupportMethods.waitForElementToBeDisplayed(getTitlePaymentProcessing(), 20);
		Assert.assertTrue(getTitlePaymentProcessing().getText().contains("Issuing Bank"),
				"Issuing Bank title is not displaying");
		Reporter.log("User navigated to payment processing page");

	}

	public void enterOtp(String otp, String amount) {

		SupportMethods.waitForElementToBeDisplayed(getTextOtp(), 20);
		getTextOtp().sendKeys(otp);

		getButtonOk().click();

	}

	public void verifyPaymentCompletion() {
		SupportMethods.waitForElementToBeDisplayed(getTextMessagePaymentComplete(), 20);
		Assert.assertTrue(getTextMessagePaymentComplete().getText().contains("Thank you for your purchase."),
				"Payment not completed");
	}
}
