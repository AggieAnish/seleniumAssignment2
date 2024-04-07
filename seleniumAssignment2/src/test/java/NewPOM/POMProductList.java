package NewPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import WaitUtility.WaitUtility;
import WebDriverUtility.DriverActions;

public class POMProductList {
	
	WebDriver driver;
	 WaitUtility wait;
	 DriverActions action;
	 public POMProductList(WebDriver driver) {
		 this.driver= driver;
		 PageFactory.initElements(driver, this);
		 wait =new WaitUtility(driver);
		 action = new DriverActions(driver);	

}
	 
	 @FindBy(xpath="//input[@class='form-control input-sm']")
	 public WebElement listSearch;
	 
	 @FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']")
	 public WebElement tableActionBtn;
	 
	 @FindBy(xpath = "//table[@id='product_table']//tbody//tr[1]//td[3]")
		public WebElement cellData;
	 
	 @FindBy(xpath = "//table[@id='product_table']//tbody//tr[1]//td[12]")
		public WebElement actionBtn;
	 
	 @FindBy(xpath = "//table[@id='product_table']//tbody//tr[1]//td[12]//ul[@class='dropdown-menu dropdown-menu-right']//a[@class='delete-product']")
		public WebElement prodDeleteBtn;
	
	 @FindBy(xpath = "//button[@class='swal-button swal-button--confirm swal-button--danger']")
		public WebElement prodDeleteConfirmBtn;
	 
	 @FindBy(xpath = "//div[@class='toast-message']")
		public WebElement prodDeletetoast;
	 
	

	 public void productSearchClick() {
			action.click(listSearch);
		}
	 public void productSearch(String value) {
			action.sendkeys(listSearch, value);

		}
	 public String getTablevalue( ) {
			//WebElement cellData = driver.findElement(By.xpath("//table[@id='product_table']//tbody//tr[1]//td[3]"));
			String data = cellData.getText();	
			return data;

		}	 
	 public void actionBtnClick() {		 
			action.click(actionBtn);
		}
	 
	 public void prodDeleteBtnClick() {		 
			action.click(prodDeleteBtn);
		}
	 public void prodDeleteConfirmBtnClick() {		 
			action.click(prodDeleteConfirmBtn);
		}
	 
	 public String getDeleteToastValue() {			
			String data = prodDeletetoast.getText();
			return data;

		}
	 
	 }

