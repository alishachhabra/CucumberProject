package pages;

import org.openqa.selenium.WebDriver;

public interface IHomePage {

	public void verifyNavigatedToHomePage(WebDriver driver);

	void navigateToHomePage(WebDriver driver, String url);

	void clickOnLoginButton();
	

	
}
