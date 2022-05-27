package com.vtiger.organization.Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.SDET34L1.genericUtility.BaseClass;
import com.SDET34L1.genericUtility.ExceSheetlUtility;
import com.vtiger.PomRepository.CreateNewOrganizationNamePage;
import com.vtiger.PomRepository.OrganizationPage;

public class CreateOrganizationTest extends BaseClass
{
	String organizationname;
	OrganizationPage organizationpage;
	CreateNewOrganizationNamePage createNewOrganizationNamePage;
	
	
	@Test(groups="sanity")
	
	public void createOrganizationtest() throws EncryptedDocumentException, IOException, InterruptedException
	{
		organizationname=ExceSheetlUtility.getDataFromExcel("Organization", 5, 1)+randomNumber;
		organizationpage=new OrganizationPage(driver);
		createNewOrganizationNamePage=new CreateNewOrganizationNamePage(driver);
		homePage.clickOrganization(driver);
		organizationpage.clickCreateNewOrganization();
		createNewOrganizationNamePage.enterOrganizationName(organizationname);
		createNewOrganizationNamePage.clicksavebtn();
		
	}
}
