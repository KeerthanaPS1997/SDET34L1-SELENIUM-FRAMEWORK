package com.SDET34L1.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class contains only property file specific common methods
 * @author Admin
 *
 */

public class PropertyFileUtility 
{
  static Properties property=null;
  /**
 * @throws IOException 
   * 
   */
  public static void openPropertyFile(String filePath) throws IOException
  {
	  FileInputStream fis=new FileInputStream(filePath);
	  property=new Properties();
	  property.load(fis);
  }
  
  public static String FetchTheDataFromPropertyFile(String key) throws IOException
  {
	  String value=property.getProperty(key);
	  return value;
  }
  }


