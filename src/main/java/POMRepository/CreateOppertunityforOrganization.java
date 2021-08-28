package POMRepository;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateOppertunityforOrganization {

	WebDriver driver;
	public CreateOppertunityforOrganization(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="potentialname")
	private WebElement potentialnameButton;
	@FindBy(xpath="//select[@id='related_to_type']")
	private WebElement RelateDropDown;
	public WebDriver getDriver() {
		return driver;
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

	public WebElement getOrganizationLink() {
		return OrganizationLink;
	}

	public WebElement getClearBtn() {
		return ClearBtn;
	}

	public WebElement getSavebtn() {
		return Savebtn;
	}
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement ClickImg;
	@FindBy(linkText="TYS")
	private WebElement OrganizationLink;

	public void CeateOpportunity(String Oppertunity)
	{
		potentialnameButton.sendKeys(Oppertunity);
	}
	
	public void RelateBtn()
	{
		Select s=new Select(RelateDropDown);
		s.selectByValue("Accounts");
		ClickImg.click();
		/*String ParentWindid = driver.getWindowHandle();
		List<String> AllWindowIdList = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(AllWindowIdList.get(1));
		OrganizationLink.click();
		driver.switchTo().window(ParentWindid);*/
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

