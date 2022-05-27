package com.SDET34L1.genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.vtiger.PomRepository.HomePage;
import com.vtiger.PomRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class contains implementation of all basic configuration annotations
 * @author Arkesh
 *It is a baseclass
 *
 */
public class BaseClass 
{
	public int randomNumber;
	public String password;
	public String username;
	public long longTimeOut;
	public WebDriver driver;
	public LoginPage loginPage;
	public HomePage homePage;
	public JavaSpecificCommonMethodsUtility jutil;
	
	/**
	 * In this annotation we open database, open the property file, open the excel
	 * @throws IOException
	 */
	@BeforeSuite(groups="baseclass")
	public void beforesuite1Test() throws IOException
	{
		//open database if it is required
		PropertyFileUtility.openPropertyFile(IconstantPathOfFilesUtility.PROPERTYFILEPATH);
		ExceSheetlUtility.openExcel(IconstantPathOfFilesUtility.EXCELFILE_PATH);
	}
	
	/**
	 * In this annotation we fetch the data from the properyt file, create the instance
	 * @throws IOException
	 */
   
	
	@BeforeClass(groups="baseclass")
	public void beforeClass1Test() throws IOException
	{
		jutil=new JavaSpecificCommonMethodsUtility();
		String url=PropertyFileUtility.FetchTheDataFromPropertyFile("url");
		String timeout=PropertyFileUtility.FetchTheDataFromPropertyFile("timeout");
		username=PropertyFileUtility.FetchTheDataFromPropertyFile("username");
		password=PropertyFileUtility.FetchTheDataFromPropertyFile("password");
		String browser=PropertyFileUtility.FetchTheDataFromPropertyFile("browser");
		longTimeOut=jutil.stringToLong(timeout);
		randomNumber=jutil.getRandomNumber(1000);
		
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
		SeleniumWebDriverUtility.initializeActions(driver);
		SeleniumWebDriverUtility.explicitlyWait(longTimeOut, driver);
		loginPage=new LoginPage(driver);
		homePage=new HomePage(driver);
		
		SeleniumWebDriverUtility.navigateToApp(url, driver);
	}

	
	/**
	 * In this annotation login action is performed 
	 */
@BeforeMethod(groups="baseclass")
public void beforeMethod1Test()
{
	loginPage.loginAction(username, password);
}

/**
 * In this annotation signout action is performed 
 * @throws InterruptedException
 */
@AfterMethod(groups="baseclass")
public void afterMethod1Test() throws InterruptedException
{
	homePage.signout(driver);
}


/**
 * In this annotation we will perform the close browser
 */
@AfterClass(groups="baseclass")
public void afterClass1Test()
{
	SeleniumWebDriverUtility.quitBrowser(driver);
}


/**
 * In this annotation we will close the excel
 */
@AfterSuite(groups="baseclass")
public void aftersuite1Test()
{
	ExceSheetlUtility.closeExcel();
}
}
