package com.vtiger.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SDET34L1.genericUtility.SeleniumWebDriverUtility;

public class CreateNewContactPage 
{
	@FindBy(name="lastname")
	private WebElement lastNameTXT;
	
	@FindBy(xpath="//img[@title='Select']")
	private WebElement selectOrganizationImg;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBTN;
	
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterLastName(String lastname)
	{
		lastNameTXT.sendKeys(lastname);
	}
	
	public void clickselectorganizationImg()
	{
		selectOrganizationImg.click();
		//SeleniumWebDriverUtility.switchToFrame(driver, 1);
	}
	
	public void clicksavebtn(WebDriver driver)
	{
		saveBTN.click();
	}
}
