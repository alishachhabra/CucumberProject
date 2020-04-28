package steps;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import managers.FileReaderManager;
import managers.PageObjectManager;
import managers.WebDriverManager;
import pages.IHomePage;

public class HomePageSteps {

	static WebDriver driver;
	PageObjectManager pageObjectManager = new PageObjectManager(WebDriverManager.getDriver());
	IHomePage homePage = pageObjectManager.getHomePage();

	@Given("^user is able to launch application url$")
	public void user_is_able_to_launch_application_url() {

		homePage.navigateToHomePage(WebDriverManager.getDriver(),
				FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
		homePage.verifyNavigatedToHomePage();
	}

	@When("^user clicks on Buy now button$")
	public void user_clicks_on_Buy_now_button() {

		homePage.clickOnBuyNowButton();
	}
}
