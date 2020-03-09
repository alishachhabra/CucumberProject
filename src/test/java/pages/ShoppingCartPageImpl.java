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

public class ShoppingCartPageImpl implements IShoppingCartPage {

	public ShoppingCartPageImpl(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[contains(text(),'Shopping Cart')]")
	private WebElement titleShoppingCart;

	public WebElement getTitleShoppingCart() {
		return titleShoppingCart;
	}

	@FindBy(xpath = "//tr[@class='total']//td[@class='amount']")
	private WebElement totalAmount;

	public WebElement getTotalAmount() {
		return totalAmount;
	}

	@FindBy(xpath = "//td[contains(text(),'Address')]//following-sibling::td/textarea")
	private WebElement customerAddress;

	public WebElement getCustomerAddress() {
		return customerAddress;
	}

	@FindBy(xpath = "//div[@class='cart-checkout']")
	private WebElement buttonCheckout;

	public WebElement getButtonCheckout() {
		return buttonCheckout;
	}

	public void verifyNavigatedToShoppingCart() {
		SupportMethods.waitForElementToBeDisplayed(getTitleShoppingCart(), 10);
		Assert.assertTrue(getTitleShoppingCart().getText().contains("Shopping Cart"),
				"Shopping cart title is not displaying");
		Reporter.log("User navigated to shopping cart page");

	}

	public void fillCustomerData(CustomerDataBean customerData) {
		findCustomerDetailFieldElement("Name").clear();
		findCustomerDetailFieldElement("Name").sendKeys(customerData.name);
		findCustomerDetailFieldElement("Email").clear();
		findCustomerDetailFieldElement("Email").sendKeys(customerData.email);
		findCustomerDetailFieldElement("Phone").clear();
		findCustomerDetailFieldElement("Phone").sendKeys(customerData.phone);
		findCustomerDetailFieldElement("City").clear();
		findCustomerDetailFieldElement("City").sendKeys(customerData.city);
		getCustomerAddress().clear();
		getCustomerAddress().sendKeys(customerData.address);
		// findCustomerDetailFieldElement("Postal").clear();
		// findCustomerDetailFieldElement("Postal").sendKeys(customerData.postalCode);

		Reporter.log("Customer details filled");
		SupportMethods.waitForElementToBeClickable(getButtonCheckout(), 10);

		getButtonCheckout().click();
		Reporter.log("Clicked on Checkout button");

	}

	public WebElement findCustomerDetailFieldElement(String fieldName) {
		WebElement ele = WebDriverManager.getDriver()
				.findElement(By.xpath("//td[contains(text(),'" + fieldName + "')]//following-sibling::td/input"));

		SupportMethods.waitForElementToBeDisplayed(ele, 10);
		if (ele.isDisplayed()) {
			return ele;
		} else {
			throw new RuntimeException("Field " + fieldName + " is not present");
		}

	}

}
