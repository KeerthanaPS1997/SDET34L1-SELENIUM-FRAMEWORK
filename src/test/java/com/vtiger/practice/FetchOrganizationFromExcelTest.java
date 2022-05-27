package com.vtiger.practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.SDET34L1.genericUtility.BaseClass;
import com.SDET34L1.genericUtility.ExceSheetlUtility;
import com.vtiger.PomRepository.CreateNewOrganizationNamePage;
import com.vtiger.PomRepository.OrganizationPage;

public class FetchOrganizationFromExcelTest extends BaseClass
{
	String organiztionname;
	OrganizationPage organizationPage;
	CreateNewOrganizationNamePage createNewOrganizationNamePage;
	
	
	
	@Test
	public void fetchOrganization() throws EncryptedDocumentException, IOException, InterruptedException
	{
		organiztionname=ExceSheetlUtility.getDataFromExcel("Organization", 5, 1)+randomNumber;
		organizationPage=new OrganizationPage(driver);
		createNewOrganizationNamePage=new CreateNewOrganizationNamePage(driver);
		homePage.clickOrganization(driver);
		organizationPage.clickCreateNewOrganization();
		createNewOrganizationNamePage.enterOrganizationName(organiztionname);
		createNewOrganizationNamePage.clicksavebtn();
		homePage.signout(driver);
		
	}
}
