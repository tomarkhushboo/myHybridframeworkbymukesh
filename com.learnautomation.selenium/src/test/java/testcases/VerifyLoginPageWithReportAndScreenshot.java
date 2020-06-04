package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.model.ScreenCapture;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;
import pages.LoginPage;
import utility.Helper;

public class VerifyLoginPageWithReportAndScreenshot {

	WebDriver driver;
	ExtentHtmlReporter reporter;
	ExtentReports extent;
	ExtentTest logger;

	@BeforeMethod()
	public void setup() {

		reporter = new ExtentHtmlReporter("./Reports/login_page_Screenshot_report.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		logger=extent.createTest("VerifyLoginPageWithReportAndScreenshot");

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

		logger.pass("Home Page loaded and verified");
		//login page validate signout
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		home.clickOnSignInLink();
		logger.log(Status.INFO, "click on signoutlink");

		//login.clickOnSignIn("BhavaniSingh11@outlook.com","qwert@12345");

		//lets take data from excel instead of hard coded one	
		login.clickOnSignIn(DataProviderFactory.getExcel().getData("Login",0,0),DataProviderFactory.getExcel().getData("Login",0,1));

		logger.log(Status.INFO, "login to application");
		login.signoutLink();

		logger.log(Status.PASS, "Signout link is present");
	}


	@AfterMethod

	public void teardown(ITestResult result) throws IOException {
		if(result.getStatus() == ITestResult.FAILURE) {
			String tmp = Helper.getScreenshot(driver, "ValidationFail");
			logger.fail(result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(tmp).build());
        
		}
		
		else {
			
			
			System.out.println("Status of testcases is passed");

		}
		
		extent.flush();
		BrowserFactory.closebrowser(driver);
	}
	


}
