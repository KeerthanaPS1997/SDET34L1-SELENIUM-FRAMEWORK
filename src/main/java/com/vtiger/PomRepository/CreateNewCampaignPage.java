package com.vtiger.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SDET34L1.genericUtility.SeleniumWebDriverUtility;

public class CreateNewCampaignPage 
{
	@FindBy(name="campaignname")
	private WebElement campaignnameTXT;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBTN;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement searchProductLookupImg;
	
	public CreateNewCampaignPage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	}
	
	//business library
	public void enterCampaignNameAndEnter(String campaignname)
	{
	campaignnameTXT.sendKeys(campaignname);
	}
	
	public void clickSaveBTN()
	{
		saveBTN.click();
	}
	
	/*
	 * public void enterCampaignNameAndSwitchToSearchProduct(String campaignName,
	 * WebDriver driver) { campaignnameTXT.sendKeys(campaignName); }
	 */
	
	public void clicksearchproductLookUpImg(WebDriver driver)
	{
		searchProductLookupImg.click();
	}
}
