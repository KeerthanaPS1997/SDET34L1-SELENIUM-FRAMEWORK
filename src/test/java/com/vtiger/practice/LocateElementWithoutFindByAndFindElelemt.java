package com.vtiger.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocateElementWithoutFindByAndFindElelemt 
{
	static WebElement user_name;
	static WebElement user_password;
	static WebElement submitButton;
	
	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http//localhost:8888");
		driver.manage().window().maximize();
		PageFactory.initElements(driver, LocateElementWithoutFindByAndFindElelemt.class);
		user_name.sendKeys("admin");
		user_password.sendKeys("admin");
		submitButton.click();
	}
}
