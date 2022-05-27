package com.vtiger.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocumnetPage 
{
	@FindBy(xpath="//img[@title='Create Document...']")
	private WebElement documentBTN;
	
	public DocumnetPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickdocumentImg()
	{
		documentBTN.click();
	}
}
