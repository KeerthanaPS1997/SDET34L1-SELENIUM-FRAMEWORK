package com.vtiger.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SDET34L1.genericUtility.JavaSpecificCommonMethodsUtility;
import com.SDET34L1.genericUtility.SeleniumWebDriverUtility;

public class ContactPage 
{
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement contactImgLookUpImg;
	
	public ContactPage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	}
	
	public void clickNewContactLookUpImg() throws InterruptedException
	{
		Thread.sleep(2000);
		contactImgLookUpImg.click();
	}
}
