package POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import VtigerGenericUtility.WebDriverUtility;

public class CreatePageOpportunityWithDate {

	WebDriver driver;
	public void CreateoppertunityWithDate(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//td[text()='Assigned To 			']")
	private WebElement AssignedToDropDown;
	@FindBy(xpath="//input[@name='assigntype' and @value='T']")
	private WebElement UserCheckBox;
	@FindBy(xpath="//select[@name='assigned_group_id']")
	private WebElement AssignElement;
	public WebElement getAssignElement() {
		return AssignElement;
	}
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getAssignedToDropDown() {
		return AssignedToDropDown;
	}
	public WebElement getUserCheckBox() {
		return UserCheckBox;
	}
	
	String Day="9";
	String YearMonth="February 2022";
	@FindBy(xpath="//img[@id='jscal_trigger_closingdate']")
	private WebElement DateImgButton;
	
	@FindBy(xpath="//td[text()='August, 2021']/ancestor::div[@class='calendar']/table/tbody/tr//td[text()='27']")
	private WebElement datebutton;
	public String getDay() {
		return Day;
	}
	public String getYearMonth() {
		return YearMonth;
	}
	public WebElement getDateImgButton() {
		return DateImgButton;
	}
	public WebElement getDatebutton() {
		return datebutton;
	}
	public WebElement getClearBtn1() {
		return ClearBtn1;
	}
	public WebElement getPotentialnameButton() {
		return potentialnameButton;
	}
	public WebElement getRelateDropDown() {
		return RelateDropDown;
	}
	public WebElement getClickImg() {
		return ClickImg;
	}
	public WebElement getContactList() {
		return ContactList;
	}
	public WebElement getSavebtn() {
		return Savebtn;
	}
	//String dateXpath="//td[text()='August, 2021']/ancestor::div[@class='calendar']/table/tbody/tr//td[text()='27']";
	@FindBy(xpath="//input[@id = 'related_to']/following-sibling::input[@title = 'Clear']")
	private WebElement ClearBtn1;
	@FindBy(name="potentialname")
	private WebElement potentialnameButton;
	@FindBy(xpath="//select[@id='related_to_type']")
	private WebElement RelateDropDown;
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement ClickImg;
	@FindBy(linkText="latha A")
	private WebElement ContactList;
	

	public void CeateOpportunity(String Oppertunity)
	{
		potentialnameButton.sendKeys(Oppertunity);
	}
	
	public void RelateBtn()
	{
		WebDriverUtility wlib=new WebDriverUtility();
		wlib.select(RelateDropDown, "Contacts");
		ClickImg.click();
	}
	public void AssignBtn()
	{
		WebDriverUtility wlib=new WebDriverUtility();
		wlib.select(AssignElement,"Team Selling");
		
	}
	
	
	
	public void Clear()
	{
		ClearBtn1.click();
	}
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement Savebtn;
	
	public void Save() {
		
	Savebtn.click();
}
}
