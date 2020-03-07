package steps;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition {
	public static WebDriver driver;
	public WebDriverWait wait;
	
	@Given("^user is on homepage$")
    public void user_is_on_homepage() throws Throwable {     
    	System.setProperty("webdriver.chrome.driver","drivers//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://automationbykrishna.com/");
    }
    
    @When("^user navigates to registration Page$")
    public void user_navigates_to_Registration_Page() throws Throwable {
        driver.findElement(By.xpath("//a[@id='registration2']")).click();
    }
    
    @And("^user enters \"(.*)\" and \"(.*)\"$")
    public void user_enters_username_and_Password(String username, String password) throws Throwable {
    	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnsubmitdetails")));
        driver.findElement(By.id("unameSignin")).sendKeys(username);
        driver.findElement(By.id("pwdSignin")).sendKeys(password);
        driver.findElement(By.id("btnsubmitdetails")).click();
    }
    
 
	@Then("^message \"(.*)\" is displayed$")
    public void success_message_is_displayed(String expectedMsg) throws Throwable {
    	Alert alert = driver.switchTo().alert();
    	
    	String actualMsg = alert.getText();
    	Assert.assertEquals(expectedMsg, actualMsg);
    	alert.accept();
        driver.quit();  
    }  
	
	@And("^user enters following credentials$")
    public void user_enters_following_credentials(DataTable dt) throws Throwable {
    	
		List<Map<String,String>> data = dt.asMaps(String.class,String.class);
		
		for(Map<String,String> map : data) {
			driver.findElement(By.id("unameSignin")).clear();
			driver.findElement(By.id("pwdSignin")).clear();
			
			driver.findElement(By.id("unameSignin")).sendKeys(map.get("username"));
	        driver.findElement(By.id("pwdSignin")).sendKeys(map.get("password"));
	       
		}
        
    }
	
	@And("^user clicks on submit$")
    public void user_clicks_on_submit() throws Throwable {
		driver.findElement(By.id("btnsubmitdetails")).click();
        
    }
}
