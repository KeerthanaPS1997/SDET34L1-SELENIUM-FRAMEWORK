package com.vtiger.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SDET34L1.genericUtility.SeleniumWebDriverUtility;

public class CreateNewOrganizationNamePage 
{
	@FindBy(name="accountname")
	private WebElement organizationNameTXT;
	
	@FindBy(name="industry")
	private WebElement industryDD;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBTN;
	
	public CreateNewOrganizationNamePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterOrganizationName(String organizationName)
	{
		organizationNameTXT.sendKeys(organizationName);
	}
	
	public void clickIndustryDropDown(String text)
	{
		SeleniumWebDriverUtility.initilizeSelect(industryDD);
		SeleniumWebDriverUtility.dropDownHandlebyValue(text,industryDD);
		
	}
	
	public void clicksavebtn() throws InterruptedException
	{
		saveBTN.click();
		Thread.sleep(2000);
	}
}
