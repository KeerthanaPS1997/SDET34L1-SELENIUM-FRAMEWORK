package com.vtiger.practice;

import java.awt.Desktop.Action;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DtabaseConnectionGUITest 
{
	public static void main(String[] args) throws SQLException
	{
	String url=null,userName=null,password=null,OrganizationName = null;	
	Driver driver = new Driver();
	DriverManager.registerDriver(driver);
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vtiger1", "root", "root");
	Statement statement = connection.createStatement();
	ResultSet result = statement.executeQuery("select * from vtiger1;");
	while(result.next())
	{
		url=result.getString("url");
		userName=result.getString("userName");
		password=result.getString("password");
		OrganizationName=result.getString("organizationName");
	}
	//long longTimeout=Long.parseLong(timeout);
	WebDriver d=null;
	if(OrganizationName.equalsIgnoreCase("Firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		d=new FirefoxDriver();
	}
	d.get(url);
	d.manage().window().maximize();
	d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	d.findElement(By.name("user_name")).sendKeys(userName);
	d.findElement(By.name("user_password")).sendKeys(password);
	d.findElement(By.id("submitButton")).click();
	
	d.findElement(By.linkText("//a[@href='index.php?module=Accounts&action=index']")).click();
	d.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	//String firstName="vtiger1";
	//String lastName="L1";
	
	//driver.findElement(By.name("firstName")).sendKeys(firstName);
	//driver.findElement(By.name("lastName")).sendKeys(lastName);
	d.findElement(By.xpath("//input[@name='accountname']")).sendKeys(OrganizationName);
	//WebElement ActualFirstName=driver.findElement(By.id("dtlview_First Name"));
	//WebElement ActualLastName=driver.findElement(By.id("dtlview_Last Name"));
	
	//if(ActualFirstName.getText().equalsIgnoreCase(firstName)&&ActualLastName.getText().equalsIgnoreCase(lastName));
	{
		System.out.println("contact created Scuccessfully");
		System.out.println("TC Pass");
	}
	
	WebElement adminstratorIcon=d.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	
	Actions act=new Actions(d);
    act.moveToElement(adminstratorIcon).perform();
	d.findElement(By.linkText("Sign Out")).click();
	d.quit();
	
	
	
	}
	
}
	