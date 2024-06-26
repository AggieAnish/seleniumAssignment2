
package WebDriverUtility;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.common.io.Files;

import WaitUtility.WaitUtility;


public class BrowserUtility {
	public static WebDriver driver;
	
	public void launchBrowser(String Browser, String url) {

		switch (Browser) {
		case "Chrome":
			driver = new ChromeDriver();
			break;
		case "Firefox":
			driver = new FirefoxDriver();
			break;
		default:
			break;
		}
		driver.manage().window().maximize();
		driver.get(url);
		WaitUtility wait=new WaitUtility(driver);
		wait.implicitWait();

	}

	public void closeBrowser() {
		driver.close();
	}

	
	public WebDriver baseDriver() {
		return this.driver;
	}

	public void waitUntil(int time) throws InterruptedException {
		Thread.sleep(time);		
		
	}
/*	public void Screenshot() throws IOException
	
	{
		
		Calendar cal=Calendar.getInstance();
		java.util.Date time=  cal.getTime();
		String timestamp=time.toString().replace(":", "").replace("", "").trim();
		
		
		System.out.println(time);
		System.out.println(timestamp);
		
		
		TakesScreenshot scrShot =((TakesScreenshot)driver);

	       //Call getScreenshotAs method to create image file

	               File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

	           //Move image file to new destination

	               File DestFile=new File("D:\\Selenium\\obsqura2\\src\\main\\resources\\Screenshot\\test"+timestamp+".jpg");

	               //Copy file at destination

	               Files.copy(SrcFile, DestFile);
	}*/
}