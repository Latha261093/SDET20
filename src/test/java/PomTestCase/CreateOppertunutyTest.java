package PomTestCase;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import POMRepository.CreateNewOppurtunityPage;
import POMRepository.CreateOppertunityforOrganization;
import POMRepository.HomePage;
import POMRepository.LoginPage;
import POMRepository.OppurtunityPage;
import VtigerGenericUtility.BaseClass;
import VtigerGenericUtility.ExcelUtility;
import VtigerGenericUtility.FileUtility;
import VtigerGenericUtility.JavaUtility;
import VtigerGenericUtility.WebDriverUtility;
@Listeners(VtigerGenericUtility.Listner.class)
public class CreateOppertunutyTest extends BaseClass {
		
		@Test(groups = {"smokeTest"})
		public void createOppurtunity() throws Throwable {
			
			String oppurtunityName = elib.getDataFromExcel("Sheet1", 4, 2);
		
			homepageObj = new HomePage(driver);
			homepageObj.getOpportunitiesLink().click();
			
			OppurtunityPage oppurnityPageObj = new OppurtunityPage(driver);
			oppurnityPageObj.getCreateLink().click();
			
			CreateNewOppurtunityPage createNewOppurtunityPageObj = new CreateNewOppurtunityPage(driver);
			createNewOppurtunityPageObj.CeateOpportunity(oppurtunityName);
			createNewOppurtunityPageObj.RelateBtn();
			String ParentWindid = driver.getWindowHandle();
			wlib.switchToWindow(driver, "Contacts");
			createNewOppurtunityPageObj.getContactList().click();
			driver.switchTo().window(ParentWindid);
			createNewOppurtunityPageObj.Clear();
			createNewOppurtunityPageObj.Save();
			
			
			String expectedAlertMsg = driver.switchTo().alert().getText();
			String actualAlertMsg = "Related To cannot be none";
			boolean expect=actualAlertMsg.contains(expectedAlertMsg);
			Assert.assertTrue(expect);
			/*if(actualAlertMsg.contains(expectedAlertMsg))
			{
				System.out.println("Verification is done ====>Test is pass");
			}
			else
			{
				System.out.println("Verification is not done ====>Test is Fail");			
			}*/
			
			wlib.acceptAlert(driver);
			
		}
		@Test(groups = {"RegressionTesting","smokeTest"})
		public void CreateOpportunityWithOrg()throws Throwable
		{
			JavaUtility javautility=new JavaUtility();
			int randomInt=javautility.getRandomNum();
			String oppurtunityName =elib.getDataFromExcel("Sheet1", 4, 2)+randomInt;
			
			
			
			homepageObj = new HomePage(driver);
			homepageObj.getOpportunitiesLink().click();
			
			
			OppurtunityPage oppurnityPageObj = new OppurtunityPage(driver);
			oppurnityPageObj.getCreateLink().click();
			
			//Creating a CreateOppertunityforOrganization Object
			CreateNewOppurtunityPage createNewOppurtunityPageObj = new CreateNewOppurtunityPage(driver);
			createNewOppurtunityPageObj.CeateOpportunity(oppurtunityName);
			
			//Creating a CreateOppertunityforOrganization Object with the Organizations
			CreateOppertunityforOrganization CreateOrg= new CreateOppertunityforOrganization(driver);

			CreateOrg.RelateBtn();
			String ParentWindid = driver.getWindowHandle();
			wlib.switchToWindow(driver, "Accounts");
			CreateOrg.getOrganizationLink().click();
			driver.switchTo().window(ParentWindid);
			CreateOrg.Clear();
			CreateOrg.Save();
			//Verifying the Alert PopUp
			String ExpectedAlertMsg = driver.switchTo().alert().getText();
			String ActualAlert = "Related To cannot be none";
			boolean ExpectAlert = ExpectedAlertMsg.contains(ActualAlert);
			Assert.assertTrue(ExpectAlert);
			/*if(ExpectedAlertMsg.contains(ActualAlert))
			{
				System.out.println("Verification is done ====>Test is pass");
			}
			
			else
			{
				System.out.println("Verification is not done ====>Test is Fail");
			}*/
			wlib.acceptAlert(driver);
		}
			
		@Test(groups = {"RegressionTesting"})
			public void CreteOpportunityWithContactAndOrganizations() throws Throwable
			{
				String oppurtunityName =elib.getDataFromExcel("Sheet1", 4, 2);
				
				homepageObj = new HomePage(driver);
				homepageObj.getOpportunitiesLink().click();
				
				
				OppurtunityPage oppurnityPageObj = new OppurtunityPage(driver);
				oppurnityPageObj.getCreateLink().click();
				
				//Creating a CreateOppertunityforOrganization Object
				CreateNewOppurtunityPage createNewOppurtunityPageObj = new CreateNewOppurtunityPage(driver);
				createNewOppurtunityPageObj.CeateOpportunity(oppurtunityName);
				
				//Creating a CreateOppertunityforOrganization Object with the Organizations
				CreateOppertunityforOrganization CreateOrg= new CreateOppertunityforOrganization(driver);
				
			/*	CreateOrganizationTest_06 CreateOrganizationTest_06=new CreateOrganizationTest_06(driver);
				String ParentWindid = driver.getWindowHandle();
				CreateOrganizationTest_06.RelateBtn();
				
				wlib.switchToWindow(driver, "Accounts");
				CreateOrganizationTest_06.getOrganizationLink().click();
				driver.switchTo().window(ParentWindid);
				
				CreateOrganizationTest_06.AssignedTo();
				String ExpectedOutPut="Opportunity Information";
				String ActualOutPut=CreateOrganizationTest_06.getActualop().getText();
				boolean ExpectedOutput=ActualOutPut.contains(ExpectedOutPut);
				Assert.assertTrue(ExpectedOutput);
			/*	if(ActualOutPut.contains(ExpectedOutPut))
				{
							System.out.println("Oppertunity sucessfully created========>Test is pass");
						}
						else
						{
							
								System.out.println("Oppertunity is not created========>Test is Fail");
							
						}	*/
			   }
			

}
