package NewPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import WaitUtility.WaitUtility;
import WebDriverUtility.DriverActions;

public class POMProductAdd {
	
	public static WebDriver driver;
	 WaitUtility wait;
	 DriverActions action;
	 public POMProductAdd(WebDriver driver) {
		 this.driver= driver;
		 PageFactory.initElements(driver, this);
		 wait =new WaitUtility(driver);
		 action = new DriverActions(driver);	

}
	 
	 @FindBy(xpath="//a[text()='Add Product']")
	 public WebElement productMenu;
	
	@FindBy(xpath="//input[@id='name']")
	 public WebElement productName;
	 
	 @FindBy(xpath="//select[@name='brand_id']")
	 public WebElement selectBrand;	 
	 
	 
	  @FindBy(xpath="//select[@name='unit_id']")
	 public WebElement selectUnit;
	 
	   @FindBy(xpath="//select[@name='barcode_type']")
	 public WebElement selectBarcodeType;
	 
	   @FindBy(xpath="//input[@id='alert_quantity']")
	 public WebElement selectAlertQty;
	 
	   @FindBy(xpath="//span[@id='select2-tax_type-container']")
	 public WebElement sellingPriceTaxType;
	 	 
	   @FindBy(xpath="//span[@id='select2-type-container']")
	 public WebElement productType;
	 	 
	    @FindBy(xpath="//input[@id='single_dpp']")
	 public WebElement purchaseExcTax;
	 
	   @FindBy(xpath="//input[@id='single_dpp_inc_tax']")
	 public WebElement purchaseIncTax;
	 
	   @FindBy(xpath="//input[@id='single_dsp']")
	 public WebElement sellingExcTax;
	 
	 @FindBy(xpath="//button[@class='btn btn-primary submit_product_form']")
	 public WebElement productSaveBtn;
	 
	 
	 @FindBy(xpath="//div[@class='form-control file-caption  kv-fileinput-caption']")
	 public WebElement productImage;
	 
	 @FindBy(xpath="//input[@id='upload_image']")
	 public WebElement productImageBrowse;
	 
	 
	 @FindBy(xpath="//input[@id='expiry_period']")
	 public WebElement expiry;
	
	 @FindBy(xpath="//div[@class='toast-message']")
	 public WebElement saveToastMsg;
	
	 
	 public void productMenuClick() {		
			action.click(productMenu);			
		}
	 
	 public void addproductName(String value) {
			action.sendkeys(productName, value);
		}
	 public void selectBrand() {
			action.DropdownselectByvalue(selectBrand, "3");

		}
	 public void selectUnit() {
			action.DropdownselectByvalue(selectUnit, "1");

		}
	 public void selectBarcodeType() {
			action.DropdownselectByvalue(selectBarcodeType, "C39");

		}
	 public void addselectAlertQty(String value) {
			action.sendkeys(selectAlertQty, value);
		}
	 
	 public void addpurchaseExcTax(String value) {
			action.sendkeys(purchaseExcTax, value);
		}
	 
	 public void addpurchaseIncTax(String value) {
			action.sendkeys(purchaseIncTax, value);
		}
	 public void addexpiry(String value) {
			action.sendkeys(expiry, value);
		}
	 
	 public void productSaveBtnClick() {			
				action.click(productSaveBtn);			
			}
	 
	 public String getSaveToastValue() {			
			String data = saveToastMsg.getText();
			return data;

		}
}
