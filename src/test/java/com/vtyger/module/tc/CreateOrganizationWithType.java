package com.vtyger.module.tc;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.SDET34L1.genericUtility.ExceSheetlUtility;
import com.SDET34L1.genericUtility.IconstantPathOfFilesUtility;
import com.SDET34L1.genericUtility.JavaSpecificCommonMethodsUtility;
import com.SDET34L1.genericUtility.PropertyFileUtility;
import com.SDET34L1.genericUtility.SeleniumWebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationWithType 
{
	public static void main(String[] args) throws IOException
	{
		JavaSpecificCommonMethodsUtility jutil=new JavaSpecificCommonMethodsUtility();
		PropertyFileUtility.openPropertyFile(IconstantPathOfFilesUtility.PROPERTYFILEPATH);
		ExceSheetlUtility.openExcel(IconstantPathOfFilesUtility.EXCELFILE_PATH);
		int randomNumber=jutil.getRandomNumber(1000);
		String OrganizationName=ExceSheetlUtility.getDataFromExcel("organization", 10, 1)+"_"+randomNumber;
		System.out.println(OrganizationName);
		
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		SeleniumWebDriverUtility.browserSetting(11, driver);
		SeleniumWebDriverUtility.navigateToApp("http://localhost:8888", driver);
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(OrganizationName);
		WebElement element=driver.findElement(By.xpath("//select[@name='accounttype']"));
		Select s=new Select(element);
		s.selectByVisibleText("Analyst");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		WebElement ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		SeleniumWebDriverUtility.mouseHoverOnTheElement(ele, driver);
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
		ExceSheetlUtility.closeExcel();
	}
}