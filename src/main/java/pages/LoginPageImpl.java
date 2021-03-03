package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import dataProviders.CustomerDataBean;
import managers.WebDriverManager;
import utils.SupportMethods;

public class LoginPageImpl implements ILoginPage {

	public LoginPageImpl(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[@role='heading']/span | //h2[@role='heading']/span")
	private WebElement titleLogin;

	public WebElement getTitleLoginPage() {
		return titleLogin;
	}
	
	
	@FindBy(xpath = "//input[@type!='hidden']//ancestor::div[@class='css-1dbjc4n r-ymttw5 r-1f1sjgu']//following-sibling::div//span[text()='Log in']//ancestor::div[@role='button']")
	private WebElement loginButton;

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	
	@FindBy(xpath = "//input[@name='session[username_or_email]' and @type!='hidden']")
	private WebElement emailOrUserName;
	
	@FindBy(xpath = "//input[@name='session[password]' and @type!='hidden']")
	private WebElement password;
	
	@FindBy(xpath = "//div[@role='presentation']//img[@alt='alisha']")
	private WebElement profileButtonHomePage;
	
	
	@FindBy(xpath = "//a[@href='/logout']")
	private WebElement logoutLink;
	
	
	@FindBy(xpath = "//span[text()='Log out']")
	private WebElement logoutButton;
	
	public WebElement getProfileButtonHomePage() {
		return profileButtonHomePage;
	}

	public WebElement getLogoutButton() {
		return logoutButton;
	}
	
	public WebElement getLogoutLink() {
		return logoutLink;
	}

	public WebElement getEmailOrUserName() {
		return emailOrUserName;
	}

	public WebElement getPassword() {
		return password;
	}

	public void verifyNavigatedToLoginPage() {
		SupportMethods.waitForElementToBeDisplayed(getTitleLoginPage(), 10);
		Assert.assertTrue(getTitleLoginPage().getText().contains("Log in"),
				"Login page title is not displaying");
		Reporter.log("User navigated to login page");

	}
	
	public void verifyLoginButtonDisabled(){
		SupportMethods.waitForElementToBeDisplayed(getEmailOrUserName(), 10);
		
		Assert.assertTrue(getLoginButton().getAttribute("aria-disabled").equalsIgnoreCase("true"),
				"Login button is disabled");
		Reporter.log("Login button is disabled");
	}
	
	

	public void fillCustomerData(CustomerDataBean customerData) {
		getEmailOrUserName().sendKeys(customerData.username);
		getPassword().sendKeys(customerData.password);

		Reporter.log("Customer details filled");
		
	}
	
	public void clickOnLoginButton(){
		SupportMethods.waitForElementToBeClickable(getLoginButton(), 10);

		getLoginButton().click();
		Reporter.log("Clicked on login button");

	}
	
	public void verifyNavigatedToTwitterHome() {
		SupportMethods.waitForElementToBeDisplayed(getTitleLoginPage(), 10);
		Assert.assertTrue(getTitleLoginPage().getText().trim().equalsIgnoreCase("Home"), "Title is not displaying");
		Reporter.log("User navigated to twitter home");

	}
	
	public void userLogout(){
		SupportMethods.waitForElementToBeDisplayed(getProfileButtonHomePage(), 10);
		getProfileButtonHomePage().click();
		
		SupportMethods.waitForElementToBeDisplayed(getLogoutLink(), 10);
		getLogoutLink().click();
		
		SupportMethods.waitForElementToBeDisplayed(getLogoutButton(), 10);
		getLogoutButton().click();
	}


}
