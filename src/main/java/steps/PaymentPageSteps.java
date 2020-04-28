package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import dataProviders.CustomerDataBean;
import managers.FileReaderManager;
import managers.PageObjectManager;
import managers.WebDriverManager;
import pages.IPaymentPage;

public class PaymentPageSteps {

	PageObjectManager pageObjectManager = new PageObjectManager(WebDriverManager.getDriver());
	IPaymentPage paymentPage = pageObjectManager.getPaymentPage();
	String totalOrderAmount;
	static CustomerDataBean cardData;

	@And("^user should be navigated to payment page$")
	public void user_navigate_to_payment_page() {

		paymentPage.verifyNavigatedToPaymentPage();
	}

	@Then("^user selects payment method as \"(.*)\"$")
	public void user_navigate_to_payment_page(String paymentType) {

		paymentPage.selectPaymentType(paymentType);
		totalOrderAmount = paymentPage.getTotalOrderAmount();
		FileReaderManager.getInstance().getConfigReader().setProperty("TotalOrderAmount", totalOrderAmount);
	}

	@And("^user navigated to payment type page$")
	public void user_navigate_to_payment_type_page() {

		paymentPage.verifyNavigatedToPaymentTypePage();
	}

	@And("^user enter card details from file \"([^\"]*)\"$")
	public void user_enter_card_details(String fileName) {
		cardData = FileReaderManager.getInstance().getJsonReader().getCustomerData(fileName);
		paymentPage.enterCardDetails(cardData);
	}

	@Then("^user clicks on paynow button$")
	public void user_clicks_on_pay_now() {
		paymentPage.uncheckPromo();
		paymentPage.clickOnPayNow();
	}

	@And("^user navigated to payment processing page$")
	public void user_navigate_to_payment_processing_page() {

		paymentPage.verifyNavigatedToPaymentProcessingPage();
	}
	
	
	@And("^user enters otp after verifying total amount$")
	public void user_enters_otp_after_verifying_total_amount() {

		paymentPage.enterOtp(cardData.otp,totalOrderAmount);
	}
	
	@Then("^verify payment completed$")
	public void verify_payment_completed() {

		paymentPage.verifyPaymentCompletion();
	}
}
