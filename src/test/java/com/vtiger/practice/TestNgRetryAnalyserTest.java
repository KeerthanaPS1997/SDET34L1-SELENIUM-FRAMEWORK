package com.vtiger.practice;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNgRetryAnalyserTest 
{
	@Test(retryAnalyzer=com.SDET34L1.genericUtility.RetryAnalyserListenerImplementation.class)
	public static void practiceTest()
	{
		Reporter.log("hii", true);
		Assert.assertEquals("abc", "123");
	}
	
	@Test(dependsOnMethods="practiceTest")
	public static void practiceTest2()
	{
		Reporter.log("hello hello", true);
	}
	
	@Test(invocationCount=2)
	public static void practiceTest3()
	{
		Reporter.log("hii hii", true);
		Assert.assertEquals("A", "C");
	}
	
	@Test(enabled=false)
	public static void practiceTest4()
	{
		Reporter.log("bye bye", true);
	}
}
