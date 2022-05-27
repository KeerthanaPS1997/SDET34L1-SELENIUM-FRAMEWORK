package com.pom.practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.SDET34L1.genericUtility.IconstantPathOfFilesUtility;
import com.SDET34L1.genericUtility.PropertyFileUtility;
import com.SDET34L1.genericUtility.SeleniumWebDriverUtility;
import com.vtiger.PomRepository.CampaignInformationPage;
import com.vtiger.PomRepository.CmpaignPage;
import com.vtiger.PomRepository.CreateNewCampaignPage;
import com.vtiger.PomRepository.HomePage;
import com.vtiger.PomRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignMyPractice 
{
	public static void main(String[] args) throws IOException, InterruptedException
	{
		PropertyFileUtility.openPropertyFile(IconstantPathOfFilesUtility.PROPERTYFILEPATH);
		String url = PropertyFileUtility.FetchTheDataFromPropertyFile("url");
		String username = PropertyFileUtility.FetchTheDataFromPropertyFile("username");
		String password = PropertyFileUtility.FetchTheDataFromPropertyFile("password");
		String timeout = PropertyFileUtility.FetchTheDataFromPropertyFile("timeout");
		String browser = PropertyFileUtility.FetchTheDataFromPropertyFile("browser");
		
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
		LoginPage lp=new LoginPage(driver);
		HomePage hp=new HomePage(driver);
		CmpaignPage campaignPage=new CmpaignPage(driver);
		CreateNewCampaignPage createNewCampaignPage=new CreateNewCampaignPage(driver);
		CampaignInformationPage campaignInformationPage=new CampaignInformationPage(driver);
		
		SeleniumWebDriverUtility.navigateToApp(url, driver);
		SeleniumWebDriverUtility.maximizeBrowser(driver);
		SeleniumWebDriverUtility.waitTillPageLoad(longTimeOut, driver);
		
		lp.loginAction(username, password);
		hp.clickCampaign(driver);
		campaignPage.clickcreateCampaignLookUpImg();
		createNewCampaignPage.enterCampaignNameAndEnter("Keerthana");
		
		hp.signout(driver);
		SeleniumWebDriverUtility.quitBrowser(driver);

}
}

//Script running 
