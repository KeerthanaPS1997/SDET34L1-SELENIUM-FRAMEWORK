package com.vtiger.practice;

import java.io.FileInputStream;
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
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.SDET34L1.genericUtility.ExceSheetlUtility;
import com.SDET34L1.genericUtility.IconstantPathOfFilesUtility;
import com.SDET34L1.genericUtility.PropertyFileUtility;
import com.SDET34L1.genericUtility.SeleniumWebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchOrganizationNameFromExcel 
{
	public static void main(String[] args) throws IOException
	{
		
		PropertyFileUtility.openPropertyFile(IconstantPathOfFilesUtility.PROPERTYFILEPATH);
		String url = PropertyFileUtility.FetchTheDataFromPropertyFile("url");
		String username = PropertyFileUtility.FetchTheDataFromPropertyFile("username");
		String password = PropertyFileUtility.FetchTheDataFromPropertyFile("password");
		String timeout = PropertyFileUtility.FetchTheDataFromPropertyFile("timeout");
		String browser= PropertyFileUtility.FetchTheDataFromPropertyFile("browser");
		
		
		Random ran = new Random();
		int randomNumber = ran.nextInt(1000);
		
		long longTimeOut = Long.parseLong(timeout);
		
		ExceSheetlUtility.openExcel(IconstantPathOfFilesUtility.EXCELFILE_PATH);
		ExceSheetlUtility.getDataFromExcel("organization",  2, 3);
		
		/*FileInputStream fis1 = new FileInputStream("./src/test/resources/testData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		
		Sheet sh = wb.getSheet("organization");
		Row row = sh.getRow(2);
		Cell cell = row.getCell(1);
		String organization = cell.getStringCellValue()+randomNumber;
		wb.close();*/
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
		

		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
	    driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("organization");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		WebElement ActualOrganization = driver.findElement(By.id("dtlview_Organization Name"));
		
		if(ActualOrganization.getText().equalsIgnoreCase("organization"))
		{
			System.out.println("Organization created Successfully");
			System.out.println("TC PASS");
		}
		
		WebElement administration = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG;']"));
		Actions act = new Actions(driver);
		act.moveToElement(administration).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
		}
		
	}
