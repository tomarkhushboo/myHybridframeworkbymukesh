package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Helper {



	public void mousehover(WebElement ele,WebDriver driver){
		Actions action = new Actions(driver);
		action.moveToElement(ele).build().perform();


	}

	//scroll down
	public void scrolltillelement(WebDriver driver,WebElement y) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,"+y+")"); 
	}

	//screenshot

	public static String getScreenshot(WebDriver driver, String screenshotName) {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/screenshot/"+screenshotName+"_"+System.currentTimeMillis()+".png";
		File des = new File(path);
		
		try {
			FileUtils.copyFile(src, des);
		} catch (Exception e) {
			System.out.println("failed to capture screenshot" +e.getMessage());
		}
		return path;


	}


}
