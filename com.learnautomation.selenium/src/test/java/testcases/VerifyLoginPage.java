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
import pages.LoginPage;

public class VerifyLoginPage {

	WebDriver driver;

	@BeforeMethod()
	public void setup() {

		driver =BrowserFactory.getdriver("chrome");

		driver.get(DataProviderFactory.getconfig().getApplicationURL());

	}
	@Test
	public void testLoginPage() throws Exception {


		HomePage home = PageFactory.initElements(driver, HomePage.class);

		//when you call homepage.class it will return object of the same class

		String title = home.getApplicationTitle();
		Assert.assertTrue(title.contains("My Store"));
		System.out.println("my application title is: " +title);
		//login page validate signout
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		home.clickOnSignInLink();

		//login.clickOnSignIn("BhavaniSingh11@outlook.com","qwert@12345");

		//lets take data from excel instead of hard coded one	
		login.clickOnSignIn(DataProviderFactory.getExcel().getData("Login",0,0),DataProviderFactory.getExcel().getData("Login",0,1));


		login.signoutLink();
	}


	@AfterMethod

	public void teardown() {
		BrowserFactory.closebrowser(driver);
	}


}
