package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	/*this constructor will be used to initialize or create driver
	this constructor will accept driver
	 */



	//1.constructor
	WebDriver driver; //global driver
	public HomePage(WebDriver ldriver)
	{
		this.driver = ldriver; 
	}
	// this.driver will come from test case and we will initialize this driver to our homepage(global) driver

	//2. identify links by using findby

	@FindBy(xpath="//a[@class ='login']") WebElement signInlink;
	@FindBy(xpath="//a[text()='Contact us']") WebElement contactUSlink;

	//3. methods

	public void clickOnSignInLink() {
		signInlink.click();
		
	}
	public void clickOnContatUs() {
		contactUSlink.click();
		
	}
	
	public String getApplicationTitle() {
		return driver.getTitle();
	}
	





}
