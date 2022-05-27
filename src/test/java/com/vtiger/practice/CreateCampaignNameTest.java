package com.vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.SDET34L1.genericUtility.IconstantPathOfFilesUtility;
import com.SDET34L1.genericUtility.JavaSpecificCommonMethodsUtility;
import com.SDET34L1.genericUtility.PropertyFileUtility;
import com.SDET34L1.genericUtility.SeleniumWebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignNameTest 
{
	public static void main(String[] args) throws IOException
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
		SeleniumWebDriverUtility.navigateToApp(url, driver);
		SeleniumWebDriverUtility.maximizeBrowser(driver);
		SeleniumWebDriverUtility.waitTillPageLoad(longTimeOut, driver);
		
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		
		WebElement ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
		SeleniumWebDriverUtility.mouseHoverOnTheElement(ele, driver);
		
		
		driver.findElement(By.name("Campaigns")).click();
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		String CampaignName = "abcdef";
		driver.findElement(By.name("campaignname")).sendKeys(CampaignName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
}
}
