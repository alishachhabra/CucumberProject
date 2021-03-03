package managers;

import org.openqa.selenium.WebDriver;

import pages.HomePageImpl;
import pages.IHomePage;
import pages.ILoginPage;
import pages.IProfilePage;
import pages.LoginPageImpl;
import pages.ProfilePageImpl;

public class PageObjectManager {
	private IHomePage homePage;
	private WebDriver driver;
	private ILoginPage loginPage;
	private IProfilePage profilePage;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;

	}

	public IHomePage getHomePage() {

		return (homePage == null) ? homePage = new HomePageImpl(driver) : homePage;

	}
	
	public ILoginPage getLoginPage() {

		return (loginPage == null) ? loginPage = new LoginPageImpl(driver) : loginPage;

	}
	
	
	
	public IProfilePage getProfilePage() {

		return (profilePage == null) ? profilePage = new ProfilePageImpl(driver) : profilePage;

	}
}
