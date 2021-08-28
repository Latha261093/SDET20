package POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import VtigerGenericUtility.FileUtility;

public class LoginPage  {
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="user_name")
	private WebElement user_nameEdt;
	@FindBy(name="user_password")
	private WebElement user_passwordEdt;
	@FindBy(id="submitButton")
	private WebElement submitButtonEdt;

	public WebElement getUser_nameEdt() {
		return user_nameEdt;
	}
	
	public void setUser_nameEdt(WebElement user_nameEdt) {
		this.user_nameEdt = user_nameEdt;
	}
	
	public WebElement getUser_passwordEdt() {
		return user_passwordEdt;
	}
	
	public void setUser_passwordEdt(WebElement user_passwordEdt) {
		this.user_passwordEdt = user_passwordEdt;
	}
	
	public WebElement getSubmitButtonEdt() {
		return submitButtonEdt;
	}
	
	public void setSubmitButtonEdt(WebElement submitButtonEdt) {
		this.submitButtonEdt = submitButtonEdt;
	}
	
	
	
	public void LogintoApp(String Username,String Password) throws Throwable
	{		
		user_nameEdt.sendKeys(Username);
		user_passwordEdt.sendKeys(Password);
		submitButtonEdt.click();
	
	}
		
		
	

}
