package POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText="Opportunities")
	private WebElement OpportunitiesLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorLink;
	
	@FindBy(linkText="Sign Out")
	private WebElement SignOutLink;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getOpportunitiesLink() {
		return OpportunitiesLink;
	}

	public WebElement getAdministratorLink() {
		return AdministratorLink;
	}

	public WebElement getSignOutLink() {
		return SignOutLink;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void setOpportunitiesLink(WebElement opportunitiesLink) {
		OpportunitiesLink = opportunitiesLink;
	}

	public void setAdministratorLink(WebElement administratorLink) {
		AdministratorLink = administratorLink;
	}

	public void setSignOutLink(WebElement signOutLink) {
		SignOutLink = signOutLink;
	}
	
	public void LogOutLink()
	{
		Actions actions=new Actions(driver);
		{
			actions.moveToElement(AdministratorLink).perform();
			SignOutLink.click();
		}
				}
	}
	


