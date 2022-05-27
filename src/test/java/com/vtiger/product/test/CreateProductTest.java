package com.vtiger.product.test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.SDET34L1.genericUtility.BaseClass;
import com.SDET34L1.genericUtility.ExceSheetlUtility;
import com.SDET34L1.genericUtility.SeleniumWebDriverUtility;
import com.vtiger.PomRepository.CreateNewProductPage;
import com.vtiger.PomRepository.ProductPage;

public class CreateProductTest extends BaseClass
{
	String productname;
	ProductPage productpage;
	CreateNewProductPage createNewProductPage;
	
	
	@Test(groups="sanity")
	public void createProdcutName() throws EncryptedDocumentException, IOException
	{
		productname=ExceSheetlUtility.getDataFromExcel("Organization", 8, 1)+randomNumber;
		productpage=new ProductPage(driver);
		createNewProductPage=new CreateNewProductPage(driver);
		homePage.clickProduct(driver);
		productpage.clickcreateProductLookUpImg();
		createNewProductPage.enterProductnameAndEnter(productname);
		createNewProductPage .clicksave();
	}
}
