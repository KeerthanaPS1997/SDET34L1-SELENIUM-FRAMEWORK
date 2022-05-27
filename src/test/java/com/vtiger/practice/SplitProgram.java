package com.vtiger.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SplitProgram 
{
	static WebDriver driver;
	public static void main(String[] args)
	{
		String username="name###user_name";
		String password="name###user_password";
		String login="id###submitButton";
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		findElement(username).sendKeys("admin");
		findElement(password).sendKeys("admin");
		findElement(login).click();
		
	}
	public static WebElement findElement(String s)
	{
		String[] str=s.split("###");
		WebElement element=null;
		switch(str[0])
		{
		case "name":
			element=driver.findElement(By.name(str[1]));
			break;
		case "id":
			element=driver.findElement(By.id(str[1]));
			break;
		case "xpath":
			element=driver.findElement(By.xpath(str[1]));
			break;
		case "linkText":
			element=driver.findElement(By.linkText(str[1]));
			break;
		default:
			System.out.println("please specify the locator in proper formate");
			element=null;
			break;
		}
		return element;
	}
}
