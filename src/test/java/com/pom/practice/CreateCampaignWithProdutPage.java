package com.pom.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

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

public class CreateCampaignWithProdutPage 
{
	public static void main(String[] args) throws IOException, InterruptedException
	{
		JavaSpecificCommonMethodsUtility jutil=new JavaSpecificCommonMethodsUtility();
		
		PropertyFileUtility.openPropertyFile(IconstantPathOfFilesUtility.PROPERTYFILEPATH);
		String url = PropertyFileUtility.FetchTheDataFromPropertyFile("url");
		String username = PropertyFileUtility.FetchTheDataFromPropertyFile("username");
		String password = PropertyFileUtility.FetchTheDataFromPropertyFile("password");
		String timeout = PropertyFileUtility.FetchTheDataFromPropertyFile("timeout");
		String browser = PropertyFileUtility.FetchTheDataFromPropertyFile("browser");
		
		ExceSheetlUtility.openExcel(IconstantPathOfFilesUtility.EXCELFILE_PATH);
		int randomNumber=jutil.getRandomNumber(1000);
		String ProductName=ExceSheetlUtility.getDataFromExcel("Organization", 8, 1)+"_"+randomNumber;
		System.out.println(ProductName);
		String CampaignName=ExceSheetlUtility.getDataFromExcel("Organization", 8, 2)+"_"+randomNumber;
		System.out.println(CampaignName);
		
		
		long longTimeOut = Long.parseLong(timeout);
	
		
		WebDriver driver=null;
		switch (browser)
		{
		case "chrome":
		   WebDriverManager.chromedriver().setup();
		   driver=new ChromeDriver();
		   break;
		case "firefox":
		   WebDriverManager.firefoxdriver().setup();
		   driver=new FirefoxDriver();
		   break;
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(longTimeOut, TimeUnit.SECONDS);
		
		LoginPage loginpage=new LoginPage(driver);
		HomePage homepage=new HomePage(driver);
		ProductPage productpage=new ProductPage(driver);
		CreateNewProductPage createnewproduct=new CreateNewProductPage(driver);
		CmpaignPage campaignPage=new CmpaignPage(driver);
		CreateNewCampaignPage createNewCampaignPage=new CreateNewCampaignPage(driver);
		SearchProductNamePage searchProductNamePage=new SearchProductNamePage(driver);
		
		loginpage.loginAction(username, password);
		homepage.clickProduct(driver);
		productpage.clickcreateProductLookUpImg();
		createnewproduct.enterProductnameAndEnter(ProductName);
		homepage.clickCampaign(driver);
		campaignPage.clickcreateCampaignLookUpImg();
		createNewCampaignPage.enterCampaignNameAndEnter(CampaignName);
		
		
		createNewCampaignPage.clicksearchproductLookUpImg(driver);
		searchProductNamePage.switchToChild(driver,"Products&action" );
		searchProductNamePage.selectProduct(ProductName,driver);
		searchProductNamePage.switchToChild(driver,"Campaigns&action" );
		//searchProductNamePage.selectProduct(ProductName, driver);
		createNewCampaignPage.clickSaveBTN();
		Thread.sleep(2000);
		homepage.signout(driver);
		SeleniumWebDriverUtility.quitBrowser(driver);
	}
}

//Script running 
		
	
		