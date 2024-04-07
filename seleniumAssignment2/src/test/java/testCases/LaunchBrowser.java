package testCases;

import org.testng.annotations.Test;

import ExcelUtility.ReadExcelcode;
import NewPOM.POMLogin;
import WebDriverUtility.BrowserUtility;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class LaunchBrowser {
  public  WebDriver driver; 
  POMLogin login;
  @Test
  public void login() throws IOException {
	  ReadExcelcode objUsername = new ReadExcelcode();
		 String expectedValue = objUsername.readStringData(1, 0);
		 System.out.println(expectedValue);
		 login= new POMLogin(driver);
		 login.usernameSendKey(expectedValue);
	  
  }
  @BeforeTest
  @Parameters({"Browser","Url"})
  public void beforeTest(String Browser,String Url) {
	  BrowserUtility objutil = new BrowserUtility(); 
		objutil.launchBrowser(Browser, Url); 
		driver =objutil.baseDriver();
  }

  @AfterTest
  public void afterTest() {
	// driver.close(); 
  }

}
