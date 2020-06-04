package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;
import pages.WomenPage;

public class VerifyWomenPage {

	WebDriver driver;
	@BeforeMethod()
	public void setup() {

		driver =BrowserFactory.getdriver("chrome");

		driver.get(DataProviderFactory.getconfig().getApplicationURL());

	}
	
	@Test
	
	public void testWomenPage() throws InterruptedException {
		WomenPage wmn = PageFactory.initElements(driver, WomenPage.class);
		HomePage hm = PageFactory.initElements(driver, HomePage.class);
		wmn.clickonwomentshirt();
		
		String title = hm.getApplicationTitle();
		Assert.assertTrue(title.contains("T-shirts"));
		System.out.println("my application title is: " +title);
		
	}
	
	@AfterMethod
	
	public void teardown() {
		BrowserFactory.closebrowser(driver);
	}
}
