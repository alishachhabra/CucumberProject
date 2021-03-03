package pages;

import org.openqa.selenium.WebDriver;

import dataProviders.CustomerDataBean;

public interface IProfilePage {

	public void clickOnProfileButton();
	void uploadProfilePicture();
	void updateProfile(CustomerDataBean profileData);
	void clickOnEditProfile();
	void verifyProfileDetails(CustomerDataBean updatedProfileData);
	void fetchTwitterDetails(WebDriver driver);
	void search(CustomerDataBean searchData);
	
	

	
}
