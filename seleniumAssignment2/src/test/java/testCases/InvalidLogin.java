package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import ExcelUtility.ReadExcelcode;
import NewPOM.POMHome;
import NewPOM.POMLogin;
import WebDriverUtility.BrowserUtility;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class InvalidLogin {
	public  WebDriver driver; 
	  POMLogin login;	
	  POMHome homePage;
		SoftAssert objassert ;
  @Test(dataProvider = "data-provider")
  public void invalidLogin(String username, String pwd) throws IOException, InterruptedException {	 
	    login = new POMLogin(driver);
		login.usernameSendKey(username);
		login.pwdSendKey(pwd);
		login.clickLoginBtn();
		String expectedMsg=login.getinvalidMsg();			
		System.out.println("expectedMsg   " + expectedMsg);
		String errorMsg= "These credentials do not match our records.";
		objassert = new SoftAssert();
		objassert.assertEquals(errorMsg, expectedMsg);
		objassert.assertAll();			
		Thread.sleep(2000);
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
  }
  
  @DataProvider (name = "data-provider") 
  public Object[][] dpMethod(){ 
	 return new Object[][] {{"admin11","123456"}}; 
  } 

}
