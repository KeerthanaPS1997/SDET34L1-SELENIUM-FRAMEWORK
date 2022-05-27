package com.vtiger.practice;

import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class TestNgBasicConfigAnnotationPracticeTest 
{
	@BeforeSuite(groups="baseclass")
	public void beforesuite1Test()
	{
		Reporter.log("beforesuite1"+Thread.currentThread().getId(), true);
	}
	
	@AfterSuite(groups="baseclass")
	public void aftersuite1Test()
	{
		Reporter.log("aftersuite"+Thread.currentThread().getId(), true);
	}
	
	@BeforeClass(groups="baseclass")
	public void beforeclass1Test()
	{
		Reporter.log("beforeClass1"+Thread.currentThread().getId(), true);
	}
	
	
}
