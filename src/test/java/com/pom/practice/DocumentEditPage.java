package com.pom.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.SDET34L1.genericUtility.ExceSheetlUtility;
import com.SDET34L1.genericUtility.IconstantPathOfFilesUtility;
import com.SDET34L1.genericUtility.JavaSpecificCommonMethodsUtility;
import com.SDET34L1.genericUtility.PropertyFileUtility;
import com.SDET34L1.genericUtility.SeleniumWebDriverUtility;
import com.vtiger.PomRepository.CreateNewDocumentPage;
import com.vtiger.PomRepository.DocumnetPage;
import com.vtiger.PomRepository.HomePage;
import com.vtiger.PomRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DocumentEditPage 
{
	public static void main(String[] args) throws IOException
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
		String titleName=ExceSheetlUtility.getDataFromExcel("Organization", 14, 1)+"_"+randomNumber;
		System.out.println(titleName);
		
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
		DocumnetPage documnetPage=new DocumnetPage(driver);
		CreateNewDocumentPage createNewDocumentPage=new CreateNewDocumentPage(driver);
		
		loginpage.loginAction(username, password);
		homepage.clickdocumentpage(driver);
		documnetPage.clickdocumentImg();
		createNewDocumentPage.enterTitleName(titleName);
	}
	}
		