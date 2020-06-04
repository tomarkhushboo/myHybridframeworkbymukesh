package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class LoginPage {

	WebDriver driver;
	public LoginPage(WebDriver ldriver) {
		this.driver = ldriver;
	}


	@FindBy(xpath="//input[@id = 'email']") WebElement user;
	@FindBy(xpath="//input[@id = 'passwd']") WebElement passwd;
	@FindBy(xpath="//button[@id = 'SubmitLogin']") WebElement subm;
	By Signout = By.xpath("//a[@title='Log me out']") ;

	public void clickOnSignIn(String uname , String Pass) {
		user.sendKeys(uname);
		passwd.sendKeys(Pass);
		subm.click();

	}//verify sign out
	public void signoutLink() {
		//explicit wait if sign out loading takes time
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(Signout));
		String tex = ele.getText();
		Assert.assertEquals(tex, "Sign out","Sign out link not verified properly");
	}

}
