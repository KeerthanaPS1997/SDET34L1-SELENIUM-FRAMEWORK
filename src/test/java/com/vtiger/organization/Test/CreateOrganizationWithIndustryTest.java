package com.vtiger.organization.Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.SDET34L1.genericUtility.BaseClass;
import com.SDET34L1.genericUtility.ExceSheetlUtility;
import com.SDET34L1.genericUtility.SeleniumWebDriverUtility;
import com.vtiger.PomRepository.CreateNewOrganizationNamePage;
import com.vtiger.PomRepository.OrganizationPage;

public class CreateOrganizationWithIndustryTest extends BaseClass
{
	String organizationname;
	OrganizationPage organizationpage;
	CreateNewOrganizationNamePage createNewOrganizationNamePage;
	
	@Test(groups="sanity")
	public void createOrganizationWithIndustry() throws EncryptedDocumentException, IOException, InterruptedException
	{
		organizationname=ExceSheetlUtility.getDataFromExcel("Organization", 10, 1)+randomNumber;
		organizationpage=new OrganizationPage(driver);
		createNewOrganizationNamePage=new CreateNewOrganizationNamePage(driver);
		homePage.clickOrganization(driver);
		organizationpage.clickCreateNewOrganization();
		createNewOrganizationNamePage.enterOrganizationName(organizationname);
		createNewOrganizationNamePage.clickIndustryDropDown("Apparel");
		createNewOrganizationNamePage.clicksavebtn();
		
	}
}
