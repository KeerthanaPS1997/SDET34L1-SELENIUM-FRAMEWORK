package com.vtiger.contacts.tiger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.SDET34L1.genericUtility.BaseClass;
import com.SDET34L1.genericUtility.ExceSheetlUtility;
import com.SDET34L1.genericUtility.SeleniumWebDriverUtility;
import com.vtiger.PomRepository.ContactPage;
import com.vtiger.PomRepository.CreateNewContactPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactTest extends BaseClass
{
	String contactName;
	ContactPage contactPage;
	CreateNewContactPage createNewContactPage;
	
	@Test(groups="sanity")
	public void createContactTest() throws EncryptedDocumentException, IOException, InterruptedException
	{
		contactName=ExceSheetlUtility.getDataFromExcel("Organization", 2, 2)+randomNumber;
		contactPage=new ContactPage(driver);
		createNewContactPage=new CreateNewContactPage(driver);
		homePage.clickContactPage(driver);
		contactPage.clickNewContactLookUpImg();
		createNewContactPage.enterLastName(contactName);
		createNewContactPage.clicksavebtn(driver);
	}
}
