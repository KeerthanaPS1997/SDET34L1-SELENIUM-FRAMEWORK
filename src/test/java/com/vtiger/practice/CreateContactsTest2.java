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

import com.SDET34L1.genericUtility.SeleniumWebDriverUtility;
import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactsTest2 
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
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(longTimeOut, TimeUnit.SECONDS);
		
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		String firstName = "abcd";
		String lastName = "l1";
		
		driver.findElement(By.name("firstname")).sendKeys(firstName);
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		WebElement ActualFirstName=driver.findElement(By.id("dtlview_First Name"));
		WebElement ActualLastName=driver.findElement(By.id("dtlview_Last Name"));
		
		if(ActualFirstName.getText().equalsIgnoreCase(firstName)&&ActualLastName.getText().equalsIgnoreCase(lastName))
		System.out.println("contact created Scuccessfully");
		System.out.println("TC Pass");
		
		WebElement ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	    SeleniumWebDriverUtility.mouseHoverOnTheElement(ele, driver);
	    
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		driver.quit();
	}
	
	
	
	
	
}
	
		