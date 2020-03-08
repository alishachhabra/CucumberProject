package steps;

import cucumber.api.java.en.And;
import dataProviders.CustomerDataBean;
import managers.FileReaderManager;
import managers.PageObjectManager;
import managers.WebDriverManager;
import pages.IShoppingCartPage;

public class ShoppingCartSteps {

	PageObjectManager pageObjectManager = new PageObjectManager(WebDriverManager.getDriver());
	IShoppingCartPage shoppingCartPage = pageObjectManager.getShoppingCartPage();

	@And("^user should be navigated to Shopping Cart$")
	public void user_should_be_navigated_to_shopping_cart() {

		shoppingCartPage.verifyNavigatedToShoppingCart();
	}
	
	@And("^user enters customer details$")
	public void user_enters_customer_details() {
		CustomerDataBean customerData = FileReaderManager.getInstance().getJsonReader().getCustomerData("CustomerDetails.json");
		shoppingCartPage.fillCustomerData(customerData);
	}
}
