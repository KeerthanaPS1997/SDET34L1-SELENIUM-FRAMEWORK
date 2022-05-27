package com.vtyger.module.tc;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.SDET34L1.genericUtility.ExceSheetlUtility;
import com.SDET34L1.genericUtility.IconstantPathOfFilesUtility;
import com.SDET34L1.genericUtility.JavaSpecificCommonMethodsUtility;
import com.SDET34L1.genericUtility.PropertyFileUtility;
import com.SDET34L1.genericUtility.SeleniumWebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationWithMembersOf 
{
	public static void main(String[] args) throws IOException
	{
		JavaSpecificCommonMethodsUtility jutil=new JavaSpecificCommonMethodsUtility();
		PropertyFileUtility.openPropertyFile(IconstantPathOfFilesUtility.PROPERTYFILEPATH);
		ExceSheetlUtility.openExcel(IconstantPathOfFilesUtility.EXCELFILE_PATH);
		int randomNumber=jutil.getRandomNumber(1000);
		String OrganizationName=ExceSheetlUtility.getDataFromExcel("organization", 13, 1)+"_"+randomNumber;
		System.out.println(OrganizationName);
		
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		SeleniumWebDriverUtility.browserSetting(11, driver);
		SeleniumWebDriverUtility.navigateToApp("http://localhost:8888", driver);
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(OrganizationName);
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		
		String browser=driver.getWindowHandle();
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		Set<String> windows = driver.getWindowHandles();
		String wind1=null;
		
		for(String win:windows)
		{
			wind1=win;
		}
		driver.switchTo().window(wind1);
		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys("cam**abc_391");
		driver.findElement(By.xpath("//input[@type='button']")).click();
		driver.findElement(By.xpath("//a[@id='1']")).click();
		driver.switchTo().window(browser);
driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		WebElement ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		SeleniumWebDriverUtility.mouseHoverOnTheElement(ele, driver);
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
		ExceSheetlUtility.closeExcel();
		
	}
}
