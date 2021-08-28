package VtigerGenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import POMRepository.HomePage;
import POMRepository.LoginPage;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver sdriver;
	public HomePage homepageObj;
	public WebDriverUtility wlib=new WebDriverUtility();
	public ExcelUtility elib=new ExcelUtility();
	public FileUtility flib=new FileUtility();
	public JavaUtility jlib=new JavaUtility();
	@BeforeSuite(groups= {"RegressionTesting","smokeTest"})
	
	public void configBS()
	{
		
	}

		//@Parameters("BROWSER")
	@BeforeClass(groups= {"RegressionTesting","smokeTest"})
	public void configBC() throws Throwable
	{
		//Get the values from The FileUtility
		String BROWSER=flib.getValuePropertykeyValue("Browser");
		String Url=flib.getValuePropertykeyValue("URL");
		if(BROWSER.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("Firefox") )
		{
			driver=new FirefoxDriver();
			
		}
		else if(BROWSER.equals("IE"))
		{
		driver=new InternetExplorerDriver();
		}
		sdriver=driver;
		driver.get(Url);
		driver.manage().window().maximize();
		wlib.waitUntillPageload(driver);

	}
	
	@BeforeMethod(groups= {"RegressionTesting","smokeTest"})
	public void configBM() throws Throwable
	{
		
		String username=flib.getValuePropertykeyValue("Username");
		String password=flib.getValuePropertykeyValue("Password");

		LoginPage lp=new LoginPage(driver);
		lp.LogintoApp(username, password);
	}
	
	@AfterMethod(groups= {"RegressionTesting","smokeTest"})
	public void configAM()
	{
		homepageObj.LogOutLink();
	}
	
	@AfterClass(groups= {"RegressionTesting","smokeTest"})
	public void configAC()
	{
		driver.quit();
	}
	@AfterSuite(groups= {"RegressionTesting","smokeTest"})
	public void configAS()
	{
	}
	}
	
	
	
	
	

