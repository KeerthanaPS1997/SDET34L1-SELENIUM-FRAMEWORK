package com.rmgyantra.practice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.SDET34L1.genericUtility.DatabaseCommonMethodsUtility;
import com.SDET34L1.genericUtility.IconstantPathOfFilesUtility;
import com.SDET34L1.genericUtility.JavaSpecificCommonMethodsUtility;
import com.SDET34L1.genericUtility.PropertyFileUtility;
import com.SDET34L1.genericUtility.SeleniumWebDriverUtility;
import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ValidateProjectNameInDatabaseWrtGUI 
{
	public static void main(String[] args) throws SQLException, InterruptedException, IOException
	{
		JavaSpecificCommonMethodsUtility jutil = new JavaSpecificCommonMethodsUtility();
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8084");
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		driver.findElement(By.linkText("Projects")).click();
		driver.findElement(By.xpath("//span[.='Create Project']")).click();
		String projectName="PEN-"+jutil.getRandomNumber(1000);
		driver.findElement(By.name("projectName")).sendKeys(projectName);
		driver.findElement(By.name("createdBy")).sendKeys("HP");
		WebElement projectstatusDropDown=driver.findElement(By.xpath("//label[.='Project Status ']/following sibling::select"));
		Select s = new Select(projectstatusDropDown);
		s.selectByVisibleText("Created");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		
		PropertyFileUtility.openPropertyFile(IconstantPathOfFilesUtility.RMGYANTRA_PROPERTYFILE_PATH);
		DatabaseCommonMethodsUtility.openDBConnection(IconstantPathOfFilesUtility.DATABASEURL+PropertyFileUtility.FetchTheDataFromPropertyFile("dbName"), PropertyFileUtility.FetchTheDataFromPropertyFile("dbUserName"), PropertyFileUtility.FetchTheDataFromPropertyFile("dbPassword"));
		boolean status=DatabaseCommonMethodsUtility.validateDataInDatabase("select project_name from project;", "project_name", projectName);
		if(status==true)
		{
			System.out.println("TC pass");
		}
		else
		{
			System.out.println("TC fail");
		}
		DatabaseCommonMethodsUtility.closeDBConnection();
		SeleniumWebDriverUtility.quitBrowser(driver);
		}
	}

