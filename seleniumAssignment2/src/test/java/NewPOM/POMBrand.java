package NewPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import WaitUtility.WaitUtility;
import WebDriverUtility.DriverActions;

public class POMBrand {
	public static WebDriver driver;
	WaitUtility wait;
	DriverActions action;

	public POMBrand(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WaitUtility(driver);
		action = new DriverActions(driver);

	}

	@FindBy(xpath = "//form[@id='brand_add_form']")
	public WebElement brandAddForm;

	@FindBy(xpath = "//span[text()='Brands']")
	public WebElement brandMenu;

	@FindBy(xpath = "//button[@class='btn btn-block btn-primary btn-modal']")
	public WebElement brandAddBtn;

	@FindBy(xpath = "//input[@id='name']")
	public WebElement brandName;

	@FindBy(xpath = "//input[@id='description']")
	public WebElement brandShortDecription;

	@FindBy(xpath = "//button[@class='btn btn-primary']")
	public WebElement brandSaveBtn;

	@FindBy(xpath = "//input[@class='form-control input-sm']")
	public WebElement brandSearchInput;

	@FindBy(xpath = "//table[@id='brands_table']//tbody//tr[1]//td[1]")
	public WebElement brandSearchResult;

	@FindBy(xpath = "//button[@class='btn btn-xs btn-danger delete_brand_button']")
	public WebElement brandDeleteBtn;

	@FindBy(xpath = "//button[@class='swal-button swal-button--confirm swal-button--danger']")
	public WebElement brandDeleteAlertBtn;
	
	@FindBy(xpath = "//div[@class='toast-message']")
	public WebElement brandAddtoastmsg;

	@FindBy(xpath = "//div[@class='toast-message']")
	public WebElement brandDeletetoastmsg;
	
	public void brandMenuClick() {
		action.click(brandMenu);
	}

	public void brandAddBrandName(String value) {
		action.sendkeys(brandName, value);
	}

	public void brandAddbtnClick() {
		action.click(brandAddBtn);
	}

	public void brandAddShortDesc(String value) {
		action.sendkeys(brandShortDecription, value);
	}

	public void brandSaveBtnClick() {
		action.click(brandSaveBtn);
	}

	public void brandSearchInputClick() {
		action.click(brandSearchInput);
	}

	public void brandSearchInputAdd(String value) {
		action.sendkeys(brandSearchInput, value);
	}

	public String getBrandTablevalue() {		
		String data = brandSearchResult.getText();
		return data;

	}

	public void brandDeleteBtnClick() {
		action.click(brandDeleteBtn);		
	}
	
	public void brandDeleteAlertBtnClick() {
		action.click(brandDeleteAlertBtn);
	}
	
	public void brandSaveBtnWOClick() throws InterruptedException {
		action.click(brandSaveBtn);
		System.out.println("brandSaveBtnWOClick");
		Thread.sleep(2000);
		String alertText = driver.switchTo().alert().getText();
		System.out.println(alertText);
		action.Alertaccept();
		
		
	}
	
	public String getbrandaddToastmsg( ) {
		String data = brandAddtoastmsg.getText();	
		return data;

	}
	
	public String getbranddeleteToastmsg( ) {
		String data = brandDeletetoastmsg.getText();	
		return data;

	}
}

