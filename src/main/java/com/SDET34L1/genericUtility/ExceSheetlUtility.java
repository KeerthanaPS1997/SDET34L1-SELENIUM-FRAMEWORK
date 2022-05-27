package com.SDET34L1.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This class issued to maintain all excel specific common methods
 * @author Admin
 *
 */
public class ExceSheetlUtility 
{
	static Workbook wb;
	
	/**
	 * 
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @return
	 */
	public static String getDataFromExcel(String sheetName, int rowNumber, int cellNumber) throws EncryptedDocumentException, IOException
	{
		String data=wb.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber).getStringCellValue();
		return data;
	}
	public static void openExcel(String filePath) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream(filePath);
		wb=WorkbookFactory.create(file);
	}
	public static void writeIntoExcel(String filePath) throws IOException
	{
		FileOutputStream file2 = new FileOutputStream(filePath);
		wb.write(file2);
	}
	/**
	 * 
	 * @param filePath
	 */
	public static void closeExcel() 
	{
		try 
		{
			wb.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			System.out.println("while closing excel some exception occured...please check the excel utility");
		}
	}
	public static void setCellvalue(String sheetName,int rowNumber, int cellNumber, String text)
	{
		wb.getSheet(sheetName).getRow(rowNumber).createCell(cellNumber).setCellValue(text);
	}
}
