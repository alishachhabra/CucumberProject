package steps;

import cucumber.api.java.en.And;
import managers.PageObjectManager;
import managers.WebDriverManager;
import pages.IOrderSummaryPopUp;

public class OrderSummarySteps {

	PageObjectManager pageObjectManager = new PageObjectManager(WebDriverManager.getDriver());
	IOrderSummaryPopUp orderSummaryPopUp = pageObjectManager.getOrderSummaryPopUp();

	@And("^user should be navigated to order summary popup$")
	public void user_navigate_to_order_summary_popup() {

		orderSummaryPopUp.verifyNavigatedToOrderSummaryPopUp();
	}

	@And("^user clicks on continue button on order summary popup$")
	public void user_clicks_on_continue_button() {

		orderSummaryPopUp.clickOnContinueButton();

	}
}
