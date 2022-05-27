package com.vtiger.contacts.tiger;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.SDET34L1.genericUtility.BaseClass;
import com.SDET34L1.genericUtility.ExceSheetlUtility;
import com.vtiger.PomRepository.ContactPage;
import com.vtiger.PomRepository.CreateNewContactPage;
import com.vtiger.PomRepository.CreateNewOrganizationNamePage;
import com.vtiger.PomRepository.OrganizationPage;

public class CreteContactWithOrganizationTest extends BaseClass
{
	String contactNameWithOrganization;
	ContactPage contactPage;
	CreateNewContactPage createNewContactPage;
	OrganizationPage organizationpage;
	CreateNewOrganizationNamePage createNewOrganizationNamePage;
	
	@Test(groups="sanity")
	public void createContactTest() throws EncryptedDocumentException, IOException, InterruptedException
	{
		contactNameWithOrganization=ExceSheetlUtility.getDataFromExcel("Organization", 5, 1)+randomNumber;
		contactNameWithOrganization=ExceSheetlUtility.getDataFromExcel("Organization", 5, 2)+randomNumber;
		organizationpage=new OrganizationPage(driver);
		createNewOrganizationNamePage=new CreateNewOrganizationNamePage(driver);
		contactPage=new ContactPage(driver);
		createNewContactPage=new CreateNewContactPage(driver);
		homePage.clickOrganization(driver);
		organizationpage.clickCreateNewOrganization();
		createNewOrganizationNamePage.enterOrganizationName(contactNameWithOrganization);
		homePage.clickContactPage(driver);
		contactPage.clickNewContactLookUpImg();
		createNewContactPage.enterLastName(contactNameWithOrganization);
		createNewContactPage.clicksavebtn(driver);
	}
}
