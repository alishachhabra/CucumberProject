package pages;

import dataProviders.CustomerDataBean;

public interface IPaymentPage {

	void verifyNavigatedToPaymentPage();

	void selectPaymentType(String paymentType);

	void verifyNavigatedToPaymentTypePage();

	String getTotalOrderAmount();

	void enterCardDetails(CustomerDataBean cardData);

	void clickOnPayNow();

	void verifyNavigatedToPaymentProcessingPage();

	void enterOtp(String otp, String amount);

	void verifyPaymentCompletion();
	void uncheckPromo();
}
