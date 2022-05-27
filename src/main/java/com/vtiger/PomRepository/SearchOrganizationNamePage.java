package com.vtiger.PomRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SDET34L1.genericUtility.SeleniumWebDriverUtility;

public class SearchOrganizationNamePage 
{
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement searchTXTField;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchnowBTN;
	
	public SearchOrganizationNamePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void switchToChild(WebDriver driver,String title) {
		SeleniumWebDriverUtility.switchToChild(driver, title);
	}
	
	public void SelectOrganization(String Organizationname , WebDriver driver)
	{
		
		searchTXTField.sendKeys(Organizationname);
		searchnowBTN.click();
		driver.findElement(By.xpath("//a[@id='1']")).click();
		
	}
	
	public void switchToparent(WebDriver driver,String title) {
		SeleniumWebDriverUtility.switchToChild(driver, title);
	}
}
