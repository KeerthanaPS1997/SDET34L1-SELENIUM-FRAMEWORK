package com.vtiger.practice;

import java.awt.Window;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.SDET34L1.genericUtility.SeleniumWebDriverUtility;
import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExcecuter 
{
	public static void main(String[] args) throws IOException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		SeleniumWebDriverUtility.initializeJs(driver);
		driver.manage().window().maximize();
		SeleniumWebDriverUtility.navigateAplicationThroughjs("http://localhost:8888");
		
		SeleniumWebDriverUtility.enterdataThroughjs(driver.findElement(By.name("user_name")), "admin");
		SeleniumWebDriverUtility.enterdataThroughjs(driver.findElement(By.name("user_password")), "admin");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		SeleniumWebDriverUtility.scrollTillElement(driver.findElement(By.xpath("//b[contains(.,'UpcomingbActivities')]")));
		
		String fileName=new JavaScriptExcecuter().getClass().getName();
		SeleniumWebDriverUtility.takeScreenShot(fileName, driver);
		
		
		
	}
}
