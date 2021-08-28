package POMRepository;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import VtigerGenericUtility.JavaUtility;
import VtigerGenericUtility.WebDriverUtility;

public class CreateNewOppurtunityPage {

	WebDriver driver;
	public CreateNewOppurtunityPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
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
//		String ParentWindid = driver.getWindowHandle();
//		List<String> AllWindowIdList = new ArrayList<String>(driver.getWindowHandles());
//		driver.switchTo().window(AllWindowIdList.get(1));
//		ContactList.click();
//		driver.switchTo().window(ParentWindid);
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


	public WebElement getClearBtn() {
		return ClearBtn;
	}


	public WebElement getSavebtn() {
		return Savebtn;
	}

	@FindBy(xpath="//input[@id = 'related_to']/following-sibling::input[@title = 'Clear']")
	private WebElement ClearBtn;
	
	public void Clear()
	{
		ClearBtn.click();
	}
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement Savebtn;
	
	public void Save() {
		
	Savebtn.click();
	
	}
	
	
	
	
		}

