package POMRepository;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OppurtunityPage {

	WebDriver driver;
	public OppurtunityPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
@FindBy(css="img[title='Create Opportunity...']")
private WebElement CreateLink;

public WebElement getCreateLink() {
	return CreateLink;
}






		
		
		
		

	

}
