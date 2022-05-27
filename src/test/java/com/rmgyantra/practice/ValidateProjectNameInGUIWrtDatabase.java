package com.rmgyantra.practice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.SDET34L1.genericUtility.DatabaseCommonMethodsUtility;
import com.SDET34L1.genericUtility.ExceSheetlUtility;
import com.SDET34L1.genericUtility.IconstantPathOfFilesUtility;
import com.SDET34L1.genericUtility.JavaSpecificCommonMethodsUtility;
import com.SDET34L1.genericUtility.PropertyFileUtility;
import com.SDET34L1.genericUtility.SeleniumWebDriverUtility;
import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ValidateProjectNameInGUIWrtDatabase 
{
	public static void main(String[] args) throws SQLException, IOException
	{
		JavaSpecificCommonMethodsUtility jutil = new JavaSpecificCommonMethodsUtility();
		PropertyFileUtility.openPropertyFile(IconstantPathOfFilesUtility.RMGYANTRA_PROPERTYFILE_PATH);
		ExceSheetlUtility.openExcel(IconstantPathOfFilesUtility.RMGYANTRA_PROPERTYFILE_PATH);
		int randomNumber=jutil.getRandomNumber(1000);
		String projectName=ExceSheetlUtility.getDataFromExcel("projects", 1, 1)+"_"+randomNumber;
		System.out.println(projectName);
		DatabaseCommonMethodsUtility.openDBConnection(IconstantPathOfFilesUtility.DATABASEURL+PropertyFileUtility.FetchTheDataFromPropertyFile("dbName"),PropertyFileUtility.FetchTheDataFromPropertyFile("dbUserName"), PropertyFileUtility.FetchTheDataFromPropertyFile("dbPassword"));
		DatabaseCommonMethodsUtility.setDataInDataBase("insert into project values('TY_PROJ_"+randomNumber+"', 'Sanjay', '28/04/2022', '"+projectName+"', 'on Going', 12);");
		DatabaseCommonMethodsUtility.closeDBConnection();
		
		
			WebDriverManager.firefoxdriver().setup();
			WebDriver driver=new FirefoxDriver();
			SeleniumWebDriverUtility.browserSetting(10, driver);
			SeleniumWebDriverUtility.navigateToApp("http://localhost:8084", driver);
			driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("rmgyantra");
			driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("rmgy@9999");
			driver.findElement(By.xpath("//button[.='Sign in']")).click();
			driver.findElement(By.xpath("//a[.='Projects']")).click();
			
			List<WebElement> listOfProjects = driver.findElements(By.xpath("//table//tbody/tr/td[2]"));
			for(WebElement project:listOfProjects)
			{
				if(project.getText().equalsIgnoreCase(projectName))
				{
					System.out.println("project name isvisible in GUI");
					System.out.println("TC Pass");
					break;
				}
			}
			
			SeleniumWebDriverUtility.quitBrowser(driver);
		
}
		
	}



