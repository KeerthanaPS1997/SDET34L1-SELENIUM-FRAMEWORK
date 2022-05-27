package com.vtiger.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SDET34L1.genericUtility.JavaSpecificCommonMethodsUtility;
import com.SDET34L1.genericUtility.SeleniumWebDriverUtility;

public class HomePage 
{
	@FindBy(linkText="More")
	private WebElement moreDropDown;
	
	@FindBy(linkText="Campaigns")
	private WebElement campaignsTab;
	
	@FindBy(xpath="//a[.='Products']")
	private WebElement productBTN;
	
	@FindBy(xpath="//a[@href='index.php?module=Accounts&action=index']")
	private WebElement organizationTAB;
	
	@FindBy(xpath="//a[.='Contacts']")
	private WebElement contactTAB;
	
	@FindBy(xpath="//a[.='Documents']")
	private WebElement documentTAB;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorIcon;
	
	@FindBy(xpath="//a[.='Sign Out']")
	private WebElement signOutLink;
	
	
	//initialize the driver address to all the elements through constructors and make it as public 
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//business library
	public void clickCampaign(WebDriver driver) 
	{
		SeleniumWebDriverUtility.mouseHoverOnTheElement(moreDropDown, driver);
		campaignsTab.click();
	}
	
	public void clickProduct(WebDriver driver)
	{
		productBTN.click();
	}
	
	public void clickOrganization(WebDriver driver)
	{
		organizationTAB.click();
	}
	
	public void clickContactPage(WebDriver driver) throws InterruptedException
	{
		JavaSpecificCommonMethodsUtility.customWait(contactTAB, 20, 1000);
		contactTAB.click();
	}
	
	public void clickdocumentpage(WebDriver driver)
	{
		documentTAB.click();
	}
	
	public void signout(WebDriver driver) throws InterruptedException
	{
		JavaSpecificCommonMethodsUtility.customWait(contactTAB, 20, 1000);
		SeleniumWebDriverUtility.mouseHoverOnTheElement(administratorIcon, driver);
		signOutLink.click();
	}
}
