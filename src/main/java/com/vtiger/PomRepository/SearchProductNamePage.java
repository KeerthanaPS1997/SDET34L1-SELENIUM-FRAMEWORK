package com.vtiger.PomRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SDET34L1.genericUtility.SeleniumWebDriverUtility;

public class SearchProductNamePage 
{
	@FindBy(xpath="//input[@id='search_txt']")
	private WebElement searchTXT;
	
	@FindBy(name="search")
	private WebElement searchBTN;
	
	//@FindBy(xpath="//a[@id='2']")
	//private WebElement titleclick;
	
	public SearchProductNamePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void switchToChild(WebDriver driver,String title) {
		SeleniumWebDriverUtility.switchToChild(driver, title);
	}
	
	public void switchToparent(WebDriver driver,String title) {
		SeleniumWebDriverUtility.switchToChild(driver, title);
	}
	
	public void selectProduct(String productName, WebDriver driver)
	{
		SeleniumWebDriverUtility.switchToWindowBasedOnTitle(driver, productName);
		searchTXT.sendKeys(productName);
		searchBTN.click();
		driver.findElement(By.xpath("//a[@id='2']")).click();
		SeleniumWebDriverUtility.switchToWindowBasedOnTitle(driver, "Campaigns");
	}
}
