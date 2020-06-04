package pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import utility.Helper;

public class WomenPage {

	WebDriver driver;

	public WomenPage(WebDriver ldriver) { //constructor
		this.driver = ldriver;
	}


	//2. identify links by using findby

	@FindBy(xpath="//a[@title='Women']") WebElement Women;
	@FindBy(xpath="(//a[@title='Casual Dresses'])[1]") WebElement casualdress;
	@FindBy(xpath="(//a[@title='T-shirts'])[1]") WebElement Tshirt;
	@FindBy(xpath="//a[@title='Tops']") WebElement tops;
	@FindBy(xpath="//a[@title='Blouses']") WebElement blouse;
	@FindBy(xpath="(//a[@title='Evening Dresses'])[2]") WebElement evedress;
	@FindBy(xpath="(//a[@title='Summer Dresses'])[2]") WebElement summdress;

	//3. methods

	public  void clickonwomentshirt() throws InterruptedException {

		Helper m = new Helper();
		m.mousehover(Women,driver);
		Thread.sleep(5000);
		 Tshirt.click();
		

	}

	public  void clickonwomenblouses() throws InterruptedException {

		Helper m = new Helper();
		m.mousehover(Women,driver);
		Thread.sleep(5000);
		blouse.click();

	}
	public  void clickonwomendress() throws InterruptedException {

		Helper m = new Helper();
		m.mousehover(Women,driver);
		Thread.sleep(5000);
		casualdress.click();

	}
	public  void clickonwomensummdress() throws InterruptedException {

		Helper m = new Helper();
		m.mousehover(Women,driver);
		Thread.sleep(5000);
		summdress.click();

	}
	public  void clickonwomenevedress() throws InterruptedException {

		Helper m = new Helper();
		m.mousehover(Women,driver);
		Thread.sleep(5000);
		evedress.click();

	}

}
