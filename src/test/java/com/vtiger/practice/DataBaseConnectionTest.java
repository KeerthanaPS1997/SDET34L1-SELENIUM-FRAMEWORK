package com.vtiger.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;


public class DataBaseConnectionTest 
{
	public static void main(String[] args) throws SQLException
	{
		Connection connection=null;
		try
		{
		//step1: create object for implementation class
		Driver driver = new Driver();
		//step2: Register the driver with JDBC
		DriverManager.registerDriver(driver);
		//step3: Establish the database connection
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/SDET34L1", "root", "root");
		//step4: Create Statement
		Statement statement = connection.createStatement();
		//step5: Execute query
		ResultSet result = statement.executeQuery("select * from SDET34L1;");
		//step6: validate(based on test case)
		while(result.next())
		{
			System.out.println(result.getString("name"));
		}
		}
		finally
		{
		//step8: close the connection
		connection.close();
		}
		
	}
}
