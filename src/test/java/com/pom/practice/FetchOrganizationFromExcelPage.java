package com.pom.practice;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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
import com.vtiger.PomRepository.ContactPage;
import com.vtiger.PomRepository.CreateNewContactPage;
import com.vtiger.PomRepository.CreateNewOrganizationNamePage;
import com.vtiger.PomRepository.HomePage;
import com.vtiger.PomRepository.LoginPage;
import com.vtiger.PomRepository.OrganizationPage;
import com.vtiger.PomRepository.SearchOrganizationNamePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchOrganizationFromExcelPage 
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
		String OrganizationName=ExceSheetlUtility.getDataFromExcel("Organization", 5, 1)+"_"+randomNumber;
		System.out.println(OrganizationName);
		
		
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

		SeleniumWebDriverUtility.browserSetting(longTimeOut, driver);
		
		LoginPage loginpage=new LoginPage(driver);
		HomePage homepage=new HomePage(driver);
		OrganizationPage organizationpage=new OrganizationPage(driver);
		CreateNewOrganizationNamePage createNewOrganizationNamePage=new CreateNewOrganizationNamePage(driver);
		
		SeleniumWebDriverUtility.navigateToApp(url, driver);
		SeleniumWebDriverUtility.maximizeBrowser(driver);
		
		loginpage.loginAction(username, password);
		homepage.clickOrganization(driver);
		organizationpage.clickCreateNewOrganization();
		createNewOrganizationNamePage.enterOrganizationName(OrganizationName);
		createNewOrganizationNamePage.clickIndustryDropDown("Apparel");
		createNewOrganizationNamePage.clicksavebtn();
		homepage.signout(driver);
		SeleniumWebDriverUtility.quitBrowser(driver);
	}
}

//Script running
