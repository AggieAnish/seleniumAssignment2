package screenShotUtility;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class ScreenShot {
	public static WebDriver driver;

	public ScreenShot(WebDriver driver) {
		ScreenShot.driver = driver;
	}

	public void Screenshot() throws IOException

	{
		Calendar cal = Calendar.getInstance();
		java.util.Date time = cal.getTime();
		String timestamp = time.toString().replace(":","").replace("", "").trim();		

		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File("C:\\Users\\HP\\git\\seleniumAssignment\\seleniumAssignment\\src\\main\\resources\\Screenshot\\Test" + timestamp + ".jpg");
		Files.copy(SrcFile, DestFile);
	}

}
