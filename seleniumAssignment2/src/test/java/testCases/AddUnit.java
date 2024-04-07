package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import CommonUtility.PropertyFileReader;
import NewPOM.POMBrand;
import NewPOM.POMHome;
import NewPOM.POMUnit;
import WaitUtility.WaitUtility;
import WebDriverUtility.BrowserUtility;
import screenShotUtility.ScreenShot;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class AddUnit extends BrowserUtility {
	public static WebDriver driver;
	POMUnit unitObj;
	// ValidLogin login;
	POMHome homePage;
	SoftAssert objassert;
	POMBrand brandObj;
	ScreenShot screenShotobj;
	WaitUtility wait;
	PropertyFileReader property;

	@Test(priority = 1, enabled = true)
	public void addUnit() throws IOException, InterruptedException {
		this.driver = baseDriver();
		wait= new WaitUtility(driver);
		homePage = new POMHome(driver);
		screenShotobj = new ScreenShot(driver);
		homePage.productMenuClick();
		unitObj = new POMUnit(driver);
		unitObj.unitMenuClick();
		wait.waitUntil(2000);
		unitObj.addBtn.click();
		unitObj.addUnitName("UnitNew");
		wait.waitUntil(2000);		;
		unitObj.addUnitShortName("unit");
		wait.waitUntil(2000);
		unitObj.selectDecimal();
		wait.waitUntil(2000);
		unitObj.addSaveBtinClick();

		String searchValue = "Unit added successfully";
		String data = unitObj.getaddToastmsg();
		screenShotobj.Screenshot();
		wait.waitUntil(2000);
		objassert = new SoftAssert();
		objassert.assertEquals(searchValue, data);
		objassert.assertAll();
	}

	@Test(priority = 2, enabled = true)
	public void searchUnit() throws InterruptedException {
		property = new PropertyFileReader();
		unitObj = new POMUnit(driver);
		unitObj.unitSearchClick();
		wait.waitUntil(2000);
		// String value = "Dozen";
		String value = property.getValue("unitSearchValue");
		unitObj.unitSearch(value);
		wait.waitUntil(2000);
		String data = unitObj.getTablevalue();
		objassert = new SoftAssert();
		objassert.assertEquals(value, data);
		objassert.assertAll();

	}

	@Test(priority = 3, enabled = true)
	public void addBrand() throws IOException, InterruptedException {
		brandObj = new POMBrand(driver);
		brandObj.brandMenuClick();
		brandObj.brandAddbtnClick();
		String brandName = "BrandNew";
		String brandShortDec = "brd";
		brandObj.brandAddBrandName(brandName);
		brandObj.brandAddShortDesc(brandShortDec);
		brandObj.brandSaveBtnClick();
		String searchValue = "Brand added successfully";
		String data = brandObj.getbrandaddToastmsg();
		screenShotobj.Screenshot();
		wait.waitUntil(2000);
		objassert = new SoftAssert();
		objassert.assertEquals(searchValue, data);
		objassert.assertAll();

	}

	@Test(priority = 4, enabled = true)
	public void searchBrand() throws InterruptedException {
		brandObj = new POMBrand(driver);
		brandObj.brandSearchInputClick();
		String searchValue = "BrandNew";
		brandObj.brandSearchInputAdd(searchValue);
		wait.waitUntil(2000);
		String data = brandObj.getBrandTablevalue();
		wait.waitUntil(2000);
		objassert = new SoftAssert();
		objassert.assertEquals(searchValue, data);
		objassert.assertAll();

	}

	@Test(priority = 5, enabled = true)
	public void deleteBrand() throws InterruptedException {
		brandObj = new POMBrand(driver);
		brandObj.brandDeleteBtnClick();
		wait.waitUntil(2000);
		brandObj.brandDeleteAlertBtnClick();

		String searchValue = "Brand deleted successfully";
		wait.waitUntil(2000);
		String data = brandObj.getbranddeleteToastmsg();
		wait.waitUntil(2000);
		objassert = new SoftAssert();
		objassert.assertEquals(searchValue, data);
		objassert.assertAll();

	}

	@Test(priority = 6, enabled = false)
	public void addBrandwoValue() throws InterruptedException {
		brandObj = new POMBrand(driver);
		brandObj.brandMenuClick();
		brandObj.brandAddbtnClick();
		wait.waitUntil(2000);
		brandObj.brandSaveBtnWOClick();

	}

	@BeforeTest
	public void BeforeTest() {

	}

}
