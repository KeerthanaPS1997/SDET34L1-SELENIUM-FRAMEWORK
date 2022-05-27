package com.vtiger.practice;

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

import com.SDET34L1.genericUtility.JavaSpecificCommonMethodsUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignWithProductTest 
{
	public static void main(String[] args) throws IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/Commondata.properties");
		Properties property = new Properties();
		property.load(fis);
		String url = property.getProperty("url");
		String username = property.getProperty("username");
		String password = property.getProperty("password");
		String timeout = property.getProperty("timeout");
		String browser = property.getProperty("browser");
		
		Random ran = new Random();
		int randomNumber = ran.nextInt(1000);
		
		long longTimeOut = Long.parseLong(timeout);
		
		FileInputStream fis1 = new FileInputStream("./src/test/resources/testData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		
		//product
		Sheet sh = wb.getSheet("Organization");
		Row row = sh.getRow(7);
		Cell cell = row.getCell(1);
		String organization = cell.getStringCellValue()+randomNumber;
		wb.close();
		
		//campaign name
		Sheet sh1 = wb.getSheet("Organization");
		Row row1 = sh1.getRow(7);
		Cell cell1 = row1.getCell(2);
		String ContactLastName = cell1.getStringCellValue()+randomNumber;
		wb.close();
		
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
		
		driver.findElement(By.xpath("//a[.='Products']")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(organization);
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		WebElement ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
		driver.findElement(By.xpath("//a[.='Campaigns']")).click();
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		String CampaignName = "mobile";
		driver.findElement(By.name("campaignname")).sendKeys(CampaignName);
		driver.findElement(By.xpath("(//img[@title=\"Select\"])[1]")).click();
		
		Set<String> id = driver.getWindowHandles();
		ArrayList<String> child = new ArrayList<String>(id);
		String get = child.get(1);
		driver.switchTo().window(get);
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println("     "+title+"  ");
		WebElement send = driver.findElement(By.xpath("//input[@id='search_txt']"));
		send.sendKeys(organization);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.id("1")).click();
		String get1 = child.get(0);
		driver.switchTo().window(get1);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
			
		WebElement administration = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act1 = new Actions(driver);
		act1.moveToElement(administration).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
	}
		
	}



