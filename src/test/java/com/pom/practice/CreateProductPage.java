package com.pom.practice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.SDET34L1.genericUtility.ExceSheetlUtility;
import com.SDET34L1.genericUtility.IconstantPathOfFilesUtility;
import com.SDET34L1.genericUtility.JavaSpecificCommonMethodsUtility;
import com.SDET34L1.genericUtility.PropertyFileUtility;
import com.SDET34L1.genericUtility.SeleniumWebDriverUtility;
import com.vtiger.PomRepository.CreateNewProductPage;
import com.vtiger.PomRepository.HomePage;
import com.vtiger.PomRepository.LoginPage;
import com.vtiger.PomRepository.ProductPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProductPage 
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
		ProductPage productpage=new ProductPage(driver);
		CreateNewProductPage createNewProductPage=new CreateNewProductPage(driver);
		
		
		
		
		SeleniumWebDriverUtility.navigateToApp(url, driver);
		SeleniumWebDriverUtility.maximizeBrowser(driver);
		
		loginpage.loginAction(username, password);
		homepage.clickProduct(driver);
		productpage.clickcreateProductLookUpImg();
		createNewProductPage.enterProductnameAndEnter(ProductName);
		createNewProductPage.clicksave();
		homepage.signout(driver);
		SeleniumWebDriverUtility.quitBrowser(driver);
		
		
	}
}
