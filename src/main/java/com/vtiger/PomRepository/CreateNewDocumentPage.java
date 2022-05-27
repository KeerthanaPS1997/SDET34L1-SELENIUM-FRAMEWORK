package com.vtiger.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewDocumentPage 
{
	@FindBy(xpath="//input[@name='notes_title']")
	private WebElement titileNameTXT;
	
	public CreateNewDocumentPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterTitleName(String titleName)
	{
		titileNameTXT.sendKeys(titleName);
	}
}
