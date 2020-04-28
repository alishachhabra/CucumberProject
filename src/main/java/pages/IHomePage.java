package pages;

import org.openqa.selenium.WebDriver;

public interface IHomePage {

	public void verifyNavigatedToHomePage();

	void navigateToHomePage(WebDriver driver, String url);

	void clickOnBuyNowButton();
	

	
}
