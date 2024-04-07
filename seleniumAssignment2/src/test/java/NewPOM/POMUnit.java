package NewPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonUtility.PropertyFileReader;
import WaitUtility.WaitUtility;
import WebDriverUtility.DriverActions;

public class POMUnit {
	public static WebDriver driver;
	WaitUtility wait;
	DriverActions action;
	PropertyFileReader property;
	

	public POMUnit(WebDriver driver) {		
		this.driver = driver;
		PageFactory.initElements(driver, this);		
		wait = new WaitUtility(driver);
		action = new DriverActions(driver);		
	}

	@FindBy(xpath = "//ul//li[8]//a//span[text()='Units']")
	public WebElement unitMenu;

	@FindBy(xpath = "//button[@class='btn btn-block btn-primary btn-modal']")
	public WebElement addBtn;

	@FindBy(xpath = "//input[@id='actual_name']")
	public WebElement unitName;

	@FindBy(xpath = "//input[@id='short_name']")
	public WebElement shortName;

	@FindBy(xpath = "//select[@id='allow_decimal']")
	public WebElement decimal;

	@FindBy(xpath = "//button[@class='btn btn-primary']")
	public WebElement unitSaveBtn;

	@FindBy(xpath = "//input[@class='form-control input-sm']")
	public WebElement unitSearch;

	@FindBy(xpath = "//form//div[@class='modal-header']")
	public WebElement unitAddForm;

	@FindBy(xpath = "//table[@id='unit_table']//tbody//tr[1]//td[1]")
	public WebElement tableFirstCell;
	
	@FindBy(xpath = "//div[@class='toast-message']")
	public WebElement unitAddtoastmsg;
	
	public void unitMenuClick() {
		//wait.explicitWait(unitMenu, 1);
		property = new PropertyFileReader();
		int timeout = (int)property.getTimeout();		
		//wait.fluentWait(timeout,3);
		action.click(unitMenu);
	}

	public void unitAddBtnClick() {
		action.click(addBtn);
	}

	public void addUnitName(String value) {
		action.sendkeys(unitName, value);
	}

	public void addUnitShortName(String value) {
		action.sendkeys(shortName, value);
	}

	public void addSaveBtinClick() {
		action.click(unitSaveBtn);

	}

	public void selectDecimal() {
		action.DropdownselectByvalue(decimal, "1");

	}

	public void unitSearchClick() {
		action.click(unitSearch);
	}

	public void unitSearch(String value) {
		action.sendkeys(unitSearch, value);

	}

public String getTablevalue( ) {
	WebElement cellData = driver.findElement(By.xpath("//table[@id='unit_table']//tbody//tr[1]//td[1]"));
	String data = cellData.getText();	
	return data;

}

public String getaddToastmsg( ) {
	String data = unitAddtoastmsg.getText();	
	return data;

}
}

