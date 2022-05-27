package com.vtiger.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInformationPage 
{
	@FindBy(id="dtlview_Campaign Name")
	private WebElement campaignNameConfirmation;
	
	public CampaignInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void verifyCampaignName()
	{
		campaignNameConfirmation.getText();
	}
	
}
