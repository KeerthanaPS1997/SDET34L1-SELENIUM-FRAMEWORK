package com.SDET34L1.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseCommonMethodsUtility 
{
   static Connection connection;
   static Statement statement;
   
   
   /**
    * This method is used to open the database connection and initialize the connection, statement
    * @param dBUrl
    * @param dbbUserName
    * @param dbPassword
    * @throws SQLException
    */
   public static void openDBConnection(String dBUrl, String dbbUserName, String dbPassword) throws SQLException
   {
	   Driver d=new Driver();
	   DriverManager.registerDriver(d);
	   connection=DriverManager.getConnection(dBUrl, dbbUserName, dbPassword);
	   statement=connection.createStatement();
   }
   
   
   /**
    * 
    * @param query
    * @param columnName
    * @return
 * @throws SQLException 
    */
   public static ArrayList<String> getDataFromDataBase(String query, String columnName) throws SQLException
   {
	   ArrayList<String> list=new ArrayList<>();
	   ResultSet result=statement.executeQuery(query);
	   while(result.next())
	   {
		   list.add(result.getString(columnName));
	   }
	   return list;
	   }
   
   /**
    * 
    * @param query
    * @param columnName
    * @param expectedData
    * @return
    * @throws SQLException
    */
   public static boolean validateDataInDatabase(String query, String columnName, String expectedData) throws SQLException
   {
	   ArrayList<String> list = getDataFromDataBase(query, columnName);
	   boolean flag=false;
	   for(String actualData:list)
	   {
		   if(actualData.equalsIgnoreCase(expectedData))
		   {
			   flag=true;
			   break;
		   }
	   }
	   return flag;
   }
   
   
   /**
    * 
    * @param query
    * @throws SQLException
    */
   public static void setDataInDataBase(String query) throws SQLException
   {
	   int result=statement.executeUpdate(query);
	   if(result>=1)
	   {
		   System.out.println("Data enetered/modified successfully");
	   }
   }
   
   
   /**
    * 
    */
   public static void closeDBConnection()
   {
	   try
	   {
		   connection.close();
	   }
	   catch(SQLException e)
	   {
		   e.printStackTrace();
		   System.out.println(e.getMessage());
		   System.out.println("while closing the Database connection we got exception");
	   }
   }
}


