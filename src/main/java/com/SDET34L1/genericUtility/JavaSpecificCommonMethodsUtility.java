package com.SDET34L1.genericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.WebElement;
/**
 * 
 * @author Admin
 *
 */

public class JavaSpecificCommonMethodsUtility 
{
	/**
	 * 
	 * @param value
	 * @return
	 */
 public long stringToLong(String value)
 {
	 return Long.parseLong(value);
 }
 /**
  * 
  * @param limit
  * @return
  */
 public int getRandomNumber(int limit)
 {
	 Random ran=new Random();
	 return ran.nextInt(limit);
 }
 
 public static void printStatement(String message)
 {
	 System.out.println(message);
 }
 
 public static void assertionThroughIfCondition(String actualResult, String expectedResult, String testCaseName)
 {
	 if(actualResult.equalsIgnoreCase(expectedResult))
	 {
		 System.out.println(testCaseName+"Created successfully");
		 System.out.println("TC pass");
	 }
 }
 
 
 public static void customWait(WebElement element, long polingTime, int duration) throws InterruptedException
 {
	 int count=0;
	 while(count<=duration)
	 {
		 try
		 {
		 element.click();
		 break;
		 }
		 catch(Exception e)
		 {
		 Thread.sleep(polingTime);
		 count++;
	     }
	  }	
  }
 
 public String dateTimeInFormat()
 {
	 return new SimpleDateFormat("yyyy_MM_dd_HH_mm_sss").format(new Date());
 }
}

