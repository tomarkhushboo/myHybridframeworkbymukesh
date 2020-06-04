package factory;

import java.util.concurrent.TimeUnit;

/*this class has details to launch browser and properties*/

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	static WebDriver driver;
	public static WebDriver getdriver(String browserName) {

		// ConfigDataprovider config = new ConfigDataprovider();
		if(browserName.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", DataProviderFactory.getconfig().getChromePath());
			driver = new ChromeDriver();

		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			System.setProperty("webdriver.gecko.driver",DataProviderFactory.getconfig().getGeckoPath());
		}

		else if(browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			System.setProperty("webdriver.edge.driver", DataProviderFactory.getconfig().getEdgePath());
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		return driver;
	}
	
	public static void closebrowser(WebDriver ldriver) {
		ldriver.quit();
	}
	
	
}
