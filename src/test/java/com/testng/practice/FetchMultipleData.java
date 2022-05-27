package com.testng.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchMultipleData 
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException
	{
		FileInputStream fisExcel=new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fisExcel);
		Sheet sh = wb.getSheet("logindata");
		
		Object[][] arr=new Object[sh.getLastRowNum()+1][sh.getRow(0).getLastCellNum()];
		for(int i=0; i<sh.getLastRowNum(); i++)
		{
			for(int j=0; j<sh.getRow(i).getLastCellNum(); j++)
			{
				arr[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
				System.out.println(arr[i][j]);
			}
			
		}
		
	}
}
