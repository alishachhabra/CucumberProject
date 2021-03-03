package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import dataProviders.CustomerDataBean;
import managers.FileReaderManager;
import managers.PageObjectManager;
import managers.WebDriverManager;
import pages.ILoginPage;

public class LoginSteps {

	PageObjectManager pageObjectManager = new PageObjectManager(WebDriverManager.getDriver());
	ILoginPage loginPage = pageObjectManager.getLoginPage();

	@And("^user should be navigated to Login Page$")
	public void user_should_be_navigated_to_Login_page() {

		loginPage.verifyNavigatedToLoginPage();
	}
	
	@And("^user verify login button is disabled$")
	public void user_verify_login_button_is_disabled(){
		loginPage.verifyLoginButtonDisabled();
	}
	
	@And("^user enters username and password from file \"([^\"]*)\"$")
	public void user_enters_customer_details(String fileName) {
		CustomerDataBean customerData = FileReaderManager.getInstance().getJsonReader().getCustomerData(fileName);
		loginPage.fillCustomerData(customerData);
	}
	
	@Then("^user clicks on login button on login page$")
	public void user_clicks_on_login_button_login_page(){
		loginPage.clickOnLoginButton();
	}
	
	@And("^user should navigate to twitter home page$")
	public void user_navigate_to_twitter_home(){
		loginPage.verifyNavigatedToTwitterHome();
	}
	
	@And("^user logout from twitter$")
	public void user_logout_from_twitter(){
		loginPage.userLogout();
	}
}
