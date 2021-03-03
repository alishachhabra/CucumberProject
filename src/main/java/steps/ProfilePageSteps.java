package steps;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import dataProviders.CustomerDataBean;
import managers.FileReaderManager;
import managers.PageObjectManager;
import managers.WebDriverManager;
import pages.IProfilePage;

public class ProfilePageSteps {

	static WebDriver driver;
	PageObjectManager pageObjectManager = new PageObjectManager(WebDriverManager.getDriver());
	IProfilePage profilePage = pageObjectManager.getProfilePage();

	@And("^user clicks on profile button$")
	public void user_clicks_on_profile_button() {

		profilePage.clickOnProfileButton();
	}
	
	@And("^user uploads profile picture$")
	public void user_uploads_profile_picture() {

		profilePage.uploadProfilePicture();
	}
	
	@And("^user clicks on edit profile button$")
	public void user_clicks_on_edit_profile_button(){
		profilePage.clickOnEditProfile();
	}
	
	@And("^user enters profile data from file \"([^\"]*)\"$")
	public void user_enters_customer_details(String fileName) {
		CustomerDataBean profileBean = FileReaderManager.getInstance().getJsonReader().getCustomerData(fileName);
		profilePage.updateProfile(profileBean);
	}

	@And("^user verify profile data from file \"([^\"]*)\"$")
	public void user_verify_profile_data(String fileName) {
		CustomerDataBean updatedProfileData = FileReaderManager.getInstance().getJsonReader().getCustomerData(fileName);
		profilePage.verifyProfileDetails(updatedProfileData);
	}
	
	@And("^enter search data from file \"([^\"]*)\"$")
	public void enter_search(String fileName) {
		CustomerDataBean search = FileReaderManager.getInstance().getJsonReader().getCustomerData(fileName);
		profilePage.search(search);
	}
	
	@And("^Fetch tweet details$")
	public void fetch_tweet() {
		profilePage.fetchTwitterDetails(WebDriverManager.getDriver());
	}
	
}
