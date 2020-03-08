package pages;

import dataProviders.CustomerDataBean;

public interface IShoppingCartPage {

	void verifyNavigatedToShoppingCart();

	void fillCustomerData(CustomerDataBean customerData);

}
