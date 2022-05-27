package com.vtiger.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

public class FetchDataFromExcel 
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException
	{
		Random ran = new Random();
		int randomNumber = ran.nextInt(1000);
		
	  FileInputStream fis = new FileInputStream("'/src/test/resources/testData.xlsx");
	  Workbook wb = WorkbookFactory.create(fis);
	  Sheet sh = wb.getSheet("");
	  Row row = sh.getRow(2);
	  Cell cell = row.getCell(1);
	   String organizationName = cell.getStringCellValue()+randomNumber;
	  
	  wb.close();
	}
}
