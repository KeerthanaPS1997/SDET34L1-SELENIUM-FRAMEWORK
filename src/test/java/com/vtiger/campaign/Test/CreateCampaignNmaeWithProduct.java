package com.vtiger.campaign.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.SDET34L1.genericUtility.BaseClass;
import com.SDET34L1.genericUtility.ExceSheetlUtility;
import com.SDET34L1.genericUtility.IconstantPathOfFilesUtility;
import com.SDET34L1.genericUtility.JavaSpecificCommonMethodsUtility;
import com.SDET34L1.genericUtility.PropertyFileUtility;
import com.SDET34L1.genericUtility.SeleniumWebDriverUtility;
import com.vtiger.PomRepository.CmpaignPage;
import com.vtiger.PomRepository.CreateNewCampaignPage;
import com.vtiger.PomRepository.CreateNewProductPage;
import com.vtiger.PomRepository.HomePage;
import com.vtiger.PomRepository.LoginPage;
import com.vtiger.PomRepository.ProductPage;
import com.vtiger.PomRepository.SearchProductNamePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignNmaeWithProduct extends BaseClass
{
	String campaignnameWithProduct;
	ProductPage productpage;
	CreateNewProductPage createNewProductPage;
	CmpaignPage campaignPage;
	CreateNewCampaignPage createCampaignPage;
	SearchProductNamePage searchProductNamePage;
	
	
	
	@Test(groups="sanity")
	public void createProdcutName() throws EncryptedDocumentException, IOException, InterruptedException
	{
		campaignnameWithProduct=ExceSheetlUtility.getDataFromExcel("Organization", 8, 1)+randomNumber;
		campaignnameWithProduct=ExceSheetlUtility.getDataFromExcel("Organization", 8, 2)+randomNumber;
		productpage=new ProductPage(driver);
		createNewProductPage=new CreateNewProductPage(driver);
		campaignPage=new CmpaignPage(driver);
		createCampaignPage=new CreateNewCampaignPage(driver);
		searchProductNamePage=new SearchProductNamePage(driver);
		homePage.clickProduct(driver);
		productpage.clickcreateProductLookUpImg();
		createNewProductPage.enterProductnameAndEnter(campaignnameWithProduct);
		homePage.clickCampaign(driver);
		campaignPage.clickcreateCampaignLookUpImg();
		createCampaignPage.enterCampaignNameAndEnter(campaignnameWithProduct);
		createCampaignPage.clicksearchproductLookUpImg(driver);
		searchProductNamePage.switchToChild(driver,"Products&action" );
		searchProductNamePage.selectProduct(campaignnameWithProduct,driver);
		searchProductNamePage.switchToChild(driver,"Campaigns&action" );
		//searchProductNamePage.selectProduct(ProductName, driver);
		createCampaignPage.clickSaveBTN();
		
	}
}
