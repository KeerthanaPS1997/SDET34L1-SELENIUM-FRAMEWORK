package com.testng.practice;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNgPractice1Test
{
	@Test(dataProvider="loginData")
	public void practiceTest(String username, String password)
	{
		Reporter.log(username+"   ---->   "+password, true);
	}
	
	@DataProvider
	public Object[][] loginData()
	{
		Object[][] data=new Object[3][2];
		data[0][0]="username";
		data[0][1]="password";
		
		data[1][0]="username1";
		data[1][1]="password1";
		
		data[2][0]="username2";
		data[2][1]="password2";
	
	return data;
}
	
}
