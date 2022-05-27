package com.testng.practice;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNgPractice2Test extends TestNgBasicConfigAnnotationPracticeTest
{
	@Test(groups="sanity")
	public void practice1Test()
	{
		Reporter.log("TestNgPractice1Test--> Test1", true);
	}
	
	@Test(groups="regression")
	public void practice2Test()
	{
		Reporter.log("TestNgPractice2Test--> Test2", true);
	}
	
	@Test(groups="regression")
	public void practice3Test()
	{
		Reporter.log("TestNgPractice3Test--> Test3", true);
	}
	
	@Test(groups="sanity")
	public void practice4Test()
	{
		Reporter.log("TestNgPractice2Test---> Test4", true);
	}
}
