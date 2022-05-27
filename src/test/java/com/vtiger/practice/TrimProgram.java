package com.vtiger.practice;

public class TrimProgram 
{
	//In order to remove the spaces we use trim class
	public static void main(String[] args)
	{
		String s1="Keerthana";
		String s2=" Keerthana ";
		
		if(s1.equals(s2.trim()))
		{
			System.out.println("both strings are same");
		}
		else
		{
			System.out.println("both strings are not same");
		}
	}
}
