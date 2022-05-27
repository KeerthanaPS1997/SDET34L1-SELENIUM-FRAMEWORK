package com.testng.practice;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNgAssertTest 
{
	@Test
	public void practiceTest1()
	{
		Reporter.log("Practice1");
		Reporter.log("practic12");
		Reporter.log("Practice13");
		Reporter.log("practic14");
	}
	
	@Test
	public void practiceTest2()
	{
		Reporter.log("Practice2", false);
	}
	
	@Test
	public void practiceTest3()
	{
		Reporter.log("Practice3", true);
	}
}
