package pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import dataProviders.CustomerDataBean;
import utils.SupportMethods;

public class ProfilePageImpl implements IProfilePage {

	public ProfilePageImpl(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@aria-label='Profile']")
	private WebElement buttonProfile;

	public WebElement getButtonProfile() {
		return buttonProfile;
	}

	@FindBy(xpath = "//a//span[text()='Set up profile']")
	private WebElement buttonSetupProfile;

	public WebElement getButtonSetupProfile() {
		return buttonSetupProfile;
	}

	
	//div[@aria-label='Add photos or video']/div
	@FindBy(xpath = "//input[@type='file']")
	private WebElement buttonAddPhoto;

	public WebElement getButtonAddPhoto() {
		return buttonAddPhoto;
	}
	
	@FindBy(xpath = "//span[text()='Edit profile']")
	private WebElement editProfileButton;
	
	
	@FindBy(xpath = "//textarea[@name='description']")
	private WebElement addBio;
	
	@FindBy(xpath = "//input[@name='location']")
	private WebElement location;

	@FindBy(xpath = "//input[@name='url']")
	private WebElement website;
	
	@FindBy(xpath = "//div[@role='button']//span[text()='Save']")
	private WebElement saveButton;

	@FindBy(xpath = "//div[@data-testid='UserDescription']/span")
	private WebElement updatedBio;
	
	public WebElement getUpdatedBio() {
		return updatedBio;
	}

	public WebElement getUpdatedLocation() {
		return updatedLocation;
	}

	public WebElement getUpdatedWebsite() {
		return updatedWebsite;
	}

	@FindBy(xpath = "//div[@data-testid='UserProfileHeader_Items']/span/span/span")
	private WebElement updatedLocation;
	
	@FindBy(xpath = "//div[@data-testid='UserProfileHeader_Items']//a")
	private WebElement updatedWebsite;
	
	@FindBy(xpath = "//a[@aria-label='Search and explore']")
	private WebElement searchButton;
	
	@FindBy(xpath = "//input[@data-testid='SearchBox_Search_Input']")
	private WebElement searchBox;
	
	@FindBy(xpath = "//span[text()='Latest']")
	private WebElement latestTweets;
	
	public WebElement getLatestTweets() {
		return latestTweets;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getSearchBox() {
		return searchBox;
	}

	public WebElement getEditProfileButton() {
		return editProfileButton;
	}

	public WebElement getAddBio() {
		return addBio;
	}

	public WebElement getLocation() {
		return location;
	}

	public WebElement getWebsite() {
		return website;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public void clickOnProfileButton() {

		SupportMethods.waitForElementToBeClickable(getButtonProfile(), 10);
		if (getButtonProfile().isDisplayed()) {
			getButtonProfile().click();
			Reporter.log("Clicked on profile button");
		} else {
			throw new RuntimeException("Profile button not displaying");
		}
	}

	public void uploadProfilePicture() {
		SupportMethods.waitForElementToBeClickable(getButtonSetupProfile(), 10);
		getButtonSetupProfile().click();
		SupportMethods.waitForElementToBeClickable(getButtonAddPhoto(), 10);
		getButtonAddPhoto().sendKeys("D:/Java selenium_technocredits/May18/Test image.png");

	}
	
	public void clickOnEditProfile(){
		SupportMethods.waitForElementToBeDisplayed(getEditProfileButton(), 10);
		getEditProfileButton().click();
	}
	
	public void updateProfile(CustomerDataBean profileData){
		
		
		
		SupportMethods.waitForElementToBeDisplayed(getAddBio(), 10);
		getAddBio().sendKeys(profileData.bio);
		
		getLocation().sendKeys(profileData.location);
		getWebsite().sendKeys(profileData.website);
		
		getSaveButton().click();
		
	}

	public void verifyProfileDetails(CustomerDataBean profileData){
		SupportMethods.waitForElementToBeDisplayed(getUpdatedBio(), 10);
		
		Assert.assertTrue(getUpdatedBio().getText().trim().equalsIgnoreCase(profileData.bio), "Bio is not matching");
		Assert.assertTrue(getUpdatedLocation().getText().trim().equalsIgnoreCase(profileData.location), "Location is not matching");
		Assert.assertTrue(getUpdatedWebsite().getText().trim().equalsIgnoreCase(profileData.website), "Website is not matching");
		
	}
	
	public void search(CustomerDataBean searchData){
		SupportMethods.waitForElementToBeDisplayed(getSearchButton(), 10);
		getSearchButton().click();
		
		SupportMethods.waitForElementToBeDisplayed(getSearchBox(), 10);
		getSearchBox().sendKeys("@timesofindia");
		getSearchBox().sendKeys(Keys.ENTER);
	}
	public void fetchTwitterDetails(WebDriver driver){
		
		SupportMethods.waitForElementToBeDisplayed(getLatestTweets(), 10);
		getLatestTweets().click();
		List<WebElement> ele= driver.findElements(By.xpath("//article[@role='article'][1]//time"));
		SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
	    Date tweetDate = null;
	    Calendar calendar = Calendar.getInstance();
	    calendar.add(Calendar.HOUR_OF_DAY, -6);
	    Date date = calendar.getTime();
	    
	    for(WebElement e : ele){
	    	try {
				tweetDate = inputFormat.parse(ele.get(0).getAttribute("datetime"));
				if(tweetDate.compareTo(date)>=1){
					System.out.println(e.getText());
				}
			} catch (ParseException exc) {
				// TODO Auto-generated catch block
				exc.printStackTrace();
			}
	    }
		
	    
	}

	
	
}
