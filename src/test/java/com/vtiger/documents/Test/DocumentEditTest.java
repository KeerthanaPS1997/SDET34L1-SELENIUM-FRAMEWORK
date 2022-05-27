package com.vtiger.documents.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
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

import io.github.bonigarcia.wdm.WebDriverManager;

public class DocumentEditTest 
{
	public static void main(String[] args) throws IOException, InterruptedException
	{
		JavaSpecificCommonMethodsUtility jutil=new JavaSpecificCommonMethodsUtility();
		PropertyFileUtility.openPropertyFile(IconstantPathOfFilesUtility.PROPERTYFILEPATH);
		String url=PropertyFileUtility.FetchTheDataFromPropertyFile("url");
		String username = PropertyFileUtility.FetchTheDataFromPropertyFile("username");
		String password = PropertyFileUtility.FetchTheDataFromPropertyFile("password");
		String browser = PropertyFileUtility.FetchTheDataFromPropertyFile("browser");
		String timeout = PropertyFileUtility.FetchTheDataFromPropertyFile("timeout");
		
		ExceSheetlUtility.openExcel(IconstantPathOfFilesUtility.EXCELFILE_PATH);
		
		long longTimeOut=jutil.stringToLong(timeout);
		int randomNumber=jutil.getRandomNumber(1000);
		String titleName=ExceSheetlUtility.getDataFromExcel("Organization", 14, 1);
		System.out.println(titleName);

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
		
	    driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
	    driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
	    driver.findElement(By.xpath("//input[@id='submitButton']")).click();
	    
	    driver.findElement(By.xpath("//a[.='Documents']")).click();
	    driver.findElement(By.xpath("//img[@title='Create Document...']")).click();
	    driver.findElement(By.xpath("//input[@name='notes_title']")).sendKeys(titleName);
	    
	    driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Rich text editor, notecontent, press ALT 0 for help.']")));
	    WebElement element=driver.findElement(By.xpath("//body[@class='cke_show_borders']"));
	    Thread.sleep(1000);
	    element.sendKeys("vtiger project two thousand nineteen", Keys.CONTROL+"a");
	    driver.switchTo().defaultContent();
	    driver.findElement(By.xpath("//a[@id='cke_5']")).click();
	    driver.findElement(By.xpath("//a[@id='cke_6']")).click();
	    //driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\Arkesh\\Desktop\\vtiger documnet");
	    driver.findElement(By.xpath("//b[.='File Information']/../../following-siblings::tr[4]//input[@title='Save [Alt+S]']")).click();
	    WebElement docname=driver.findElement(By.xpath("//span[@classs='dvHeader Text']"));
	    
	    WebElement admistratorIcon=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	    Actions act=new Actions(driver);
	    act.moveToElement(admistratorIcon).perform();
	    driver.findElement(By.linkText("Sign Out")).click();
	    driver.quit();
		}
}
