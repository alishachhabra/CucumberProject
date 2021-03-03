package pages;

import dataProviders.CustomerDataBean;

public interface ILoginPage {

	void verifyNavigatedToLoginPage();

	void fillCustomerData(CustomerDataBean customerData);
	void verifyLoginButtonDisabled();
	void clickOnLoginButton();
	void userLogout();
	void verifyNavigatedToTwitterHome();

}
