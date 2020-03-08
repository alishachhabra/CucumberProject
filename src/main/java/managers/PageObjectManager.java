package managers;

import org.openqa.selenium.WebDriver;

import pages.HomePageImpl;
import pages.IHomePage;
import pages.IOrderSummaryPopUp;
import pages.IPaymentPage;
import pages.IShoppingCartPage;
import pages.OrderSummaryPopUpImpl;
import pages.PaymentPageImpl;
import pages.ShoppingCartPageImpl;

public class PageObjectManager {
	private IHomePage homePage;
	private WebDriver driver;
	private IShoppingCartPage shoppingCartPage;
	private IOrderSummaryPopUp orderSummaryPopUp;
	private IPaymentPage paymentPage;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;

	}

	public IHomePage getHomePage() {

		return (homePage == null) ? homePage = new HomePageImpl(driver) : homePage;

	}
	
	public IShoppingCartPage getShoppingCartPage() {

		return (shoppingCartPage == null) ? shoppingCartPage = new ShoppingCartPageImpl(driver) : shoppingCartPage;

	}
	
	public IOrderSummaryPopUp getOrderSummaryPopUp() {

		return (orderSummaryPopUp == null) ? orderSummaryPopUp = new OrderSummaryPopUpImpl(driver) : orderSummaryPopUp;

	}
	
	public IPaymentPage getPaymentPage() {

		return (paymentPage == null) ? paymentPage = new PaymentPageImpl(driver) : paymentPage;

	}
}
