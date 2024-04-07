package testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


import ExcelUtility.ReadExcelcode;
import NewPOM.POMHome;
import NewPOM.POMLogin;
import WaitUtility.WaitUtility;
import WebDriverUtility.BrowserUtility;
import extentReports.ExtentTestManager;

public class ValidLogin extends ExtentTestManager{

	public static WebDriver driver;
	POMLogin login;
	ReadExcelcode objLogin;
	POMHome homePage;
	SoftAssert objassert ;
	ExtentTest test1;	
	WaitUtility wait;
	

	  @Test(dataProvider = "data-provider", priority=1, enabled=true, groups={"login"})
	  public void invalidLogin(String username, String pwd) throws IOException, InterruptedException {	 
			login = new POMLogin(driver);
			wait= new WaitUtility(driver);
			login.usernameSendKey(username);
			login.pwdSendKey(pwd);
			login.clickLoginBtn();
			String expectedMsg=login.getinvalidMsg();			
			String errorMsg= "These credentials do not match our records.";
			objassert = new SoftAssert();
			objassert.assertEquals(errorMsg, expectedMsg);
			objassert.assertAll();	
			test1.log(Status.PASS, "Invalid login attempt");
			wait.waitUntil(2000);
			driver.navigate().refresh();
			
	  }
	
	@Test(priority =2, groups = { "login" }, enabled=true)
	public void login() throws IOException {
		
		objLogin = new ReadExcelcode();		
		String expectedValue = objLogin.readStringData(1, 0);
		String expectedpwd = objLogin.readIntegerData(1, 1);		
		login = new POMLogin(driver);
		login.usernameSendKey(expectedValue);
		login.pwdSendKey(expectedpwd);
		login.clickLoginBtn();
		String url = driver.getCurrentUrl();
		String expectedUrl = "https://qalegend.com/billing/public/home";		
		objassert = new SoftAssert();
		objassert.assertEquals(url, expectedUrl);
		objassert.assertAll();
		test1.log(Status.PASS, "valid login attempt");
		homePage=new POMHome(driver);		
		homePage.endTourBtnClick();
		

	}

	@BeforeTest(alwaysRun = true)
	@Parameters({ "Browser", "Url" })
	public void beforeTest(String Browser, String Url) {
		BrowserUtility objutil = new BrowserUtility();
		objutil.launchBrowser(Browser, Url);
		driver = objutil.baseDriver();
		test1=extent.createTest("Login testcase", "test to validate login");
		
		
	}

	@AfterTest (alwaysRun = true)
	public void afterTest() {
		// driver.close();
	}
	 @DataProvider (name = "data-provider") 
	  public Object[][] dpMethod(){ 
		 return new Object[][] {{"admin11","123456"}}; 
	  } 

}
