package com.pom.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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

public class CreateContactPage 
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
		String ContactName=ExceSheetlUtility.getDataFromExcel("Organization", 5, 2)+"_"+randomNumber;
		System.out.println(ContactName);
		
		
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
		ContactPage contacname=new ContactPage(driver);
		CreateNewContactPage createNewContactPage=new CreateNewContactPage(driver);
		
		SeleniumWebDriverUtility.navigateToApp(url, driver);
		SeleniumWebDriverUtility.maximizeBrowser(driver);
		//SeleniumWebDriverUtility.waitTillPageLoad(longTimeOut, driver);
		
		loginpage.loginAction(username, password);
		homepage.clickContactPage(driver);
		contacname.clickNewContactLookUpImg();
		createNewContactPage.enterLastName(ContactName);
		createNewContactPage.clicksavebtn(driver);
		Thread.sleep(2000);
		homepage.signout(driver);
		SeleniumWebDriverUtility.quitBrowser(driver);
	}
}

//Script running