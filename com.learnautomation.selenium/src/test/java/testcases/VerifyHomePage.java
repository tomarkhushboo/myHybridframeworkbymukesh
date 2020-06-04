package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;

public class VerifyHomePage {

	WebDriver driver;
	@BeforeMethod()
	public void setup() {

		driver =BrowserFactory.getdriver("chrome");

		driver.get(DataProviderFactory.getconfig().getApplicationURL());

	}
	@Test
	public void testHomePage() {


		HomePage home = PageFactory.initElements(driver, HomePage.class);

		//when you call homepage.class it will return object of the same class

		String title = home.getApplicationTitle();
		Assert.assertTrue(title.contains("My Store"));
		System.out.println("my application title is: " +title);


	}

	@AfterMethod

	public void teardown() {
		BrowserFactory.closebrowser(driver);
	}




}
