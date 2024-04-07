package WaitUtility;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	WebDriver driver;
	public  WaitUtility(WebDriver driver) {
		this.driver = driver;
	}
public void	implicitWait(){
		
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
public void explicitWait(By value,int sec) {
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(sec));
	wait.until(ExpectedConditions.elementToBeClickable(value));
}
@SuppressWarnings({ "rawtypes", "unchecked" })
public void fluentWait(int timeout, int polling) {
	//Declare and initialise a fluent wait 
	System.out.println("time out " +timeout );
	FluentWait wait = new FluentWait(driver) 
	.withTimeout(Duration.ofSeconds(timeout)) //Specify the timout of the wait 
	.pollingEvery(Duration.ofSeconds(polling)) //Sepcify polling time 
	.ignoring(NoSuchElementException.class); //Specify what exceptions to ignore 
	wait.until(ExpectedConditions.alertIsPresent());//This is how we specify the condition to wait on. 
	
	
}

public void waitUntil(int time) throws InterruptedException {
	Thread.sleep(time);
}
}
