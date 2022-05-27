package com.vtiger.PomRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CmpaignPage 
{
	@FindBy(xpath="//img[@title='Create Campaign...']")
	private WebElement createCampainLookUpImg;
	
	public CmpaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickcreateCampaignLookUpImg()
	{
		createCampainLookUpImg.click();
	}
}
