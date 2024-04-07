package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import NewPOM.POMBrand;
import NewPOM.POMHome;
import NewPOM.POMProductAdd;
import NewPOM.POMProductList;
import WaitUtility.WaitUtility;
import WebDriverUtility.BrowserUtility;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

public class AddProduct extends BrowserUtility{
	 public  static WebDriver driver;	
	SoftAssert objassert ; 
  public POMProductAdd prodObj;
  POMProductList prodList;
  WaitUtility wait;

	

	
  @Test (priority = 1)
  public void addProduct() throws InterruptedException {
	  //prodObj = new POMProductAdd(driver);
	 this.driver= baseDriver();
	 wait= new WaitUtility(driver);
	 prodObj = new POMProductAdd(driver);
	  Thread.sleep(2000);
	  prodObj.productMenuClick();
	 // System.out.println(driver);
	  prodObj.addproductName("ProductNew");
	  wait.waitUntil(2000);	  
	  prodObj.selectBrand();
	  wait.waitUntil(2000);	  
	  prodObj.selectUnit();
	  wait.waitUntil(2000);	  
	  prodObj.selectBarcodeType();
	  wait.waitUntil(2000);	 
	  prodObj.addselectAlertQty("10");
	  wait.waitUntil(2000);
	  prodObj.addpurchaseIncTax("5");
	  wait.waitUntil(2000);
	  prodObj.addexpiry("10");
	  prodObj.productSaveBtnClick();
	  
	  String toastValue = "Product added successfully";	 
	  String data =  prodObj.getSaveToastValue();	
	 // System.out.println(data);
		objassert = new SoftAssert();
		objassert.assertEquals(toastValue, data);
		objassert.assertAll();
 
  }
  @Test (priority = 2)
  public void searchProduct() throws InterruptedException {
	  prodList = new POMProductList(driver);
	   prodList.productSearchClick();
	   wait.waitUntil(2000);
		String searchValue = "ProductNew";
		prodList.productSearch(searchValue);
		wait.waitUntil(2000);;
		String data = prodList.getTablevalue();		
		objassert = new SoftAssert();
		objassert.assertEquals(searchValue, data);
		objassert.assertAll();

	}
  @Test (priority = 3)
	 public void deleteproduct() throws InterruptedException {
	  prodList = new POMProductList(driver);
	  prodList.actionBtnClick();
	  wait.waitUntil(2000);
	  JavascriptExecutor js=(JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0,4500)");
	  prodList.prodDeleteBtnClick();
	  wait.waitUntil(2000);
	  prodList.prodDeleteConfirmBtnClick();
	  String searchValue = "Product deleted successfully";	 
	  String data =  prodList.getDeleteToastValue();	
	//  System.out.println(data);
		objassert = new SoftAssert();
		objassert.assertEquals(searchValue, data);
		objassert.assertAll();
	  
  } 
  
  
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
	 
	 
  }

}
