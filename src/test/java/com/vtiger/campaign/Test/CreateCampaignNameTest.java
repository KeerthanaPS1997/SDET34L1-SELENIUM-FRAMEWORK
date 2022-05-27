package com.vtiger.campaign.Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.SDET34L1.genericUtility.BaseClass;
import com.SDET34L1.genericUtility.ExceSheetlUtility;
import com.SDET34L1.genericUtility.IconstantPathOfFilesUtility;
import com.SDET34L1.genericUtility.PropertyFileUtility;
import com.SDET34L1.genericUtility.SeleniumWebDriverUtility;
import com.vtiger.PomRepository.CmpaignPage;
import com.vtiger.PomRepository.CreateNewCampaignPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignNameTest extends BaseClass
{
		String campaignName;
		CmpaignPage campaignPage;
		CreateNewCampaignPage createNewCampaignPage;
		
		@Test(groups="sanity")
		public void CreateCampaignNameTest() throws EncryptedDocumentException, IOException
		{
			campaignName=ExceSheetlUtility.getDataFromExcel("Organization", 8, 2)+randomNumber;
			campaignPage=new CmpaignPage(driver);
			createNewCampaignPage=new CreateNewCampaignPage(driver);
			homePage.clickCampaign(driver);
			campaignPage.clickcreateCampaignLookUpImg();
			createNewCampaignPage.enterCampaignNameAndEnter(campaignName);
			createNewCampaignPage.clickSaveBTN();
		}
}