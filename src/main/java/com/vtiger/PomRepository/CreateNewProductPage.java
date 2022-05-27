package com.vtiger.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProductPage 
{
	@FindBy(name="productname")
	private WebElement productnameTXT;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBTN;
	
	
	public CreateNewProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterProductnameAndEnter(String productname)
	{
		productnameTXT.sendKeys(productname);
	}
	
	public void clicksave()
	{
		saveBTN.click();
	}
}
