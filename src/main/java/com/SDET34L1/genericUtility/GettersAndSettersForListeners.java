package com.SDET34L1.genericUtility;

import org.openqa.selenium.WebDriver;

import com.vtiger.PomRepository.HomePage;
import com.vtiger.PomRepository.LoginPage;

public class GettersAndSettersForListeners 
{
  private static GettersAndSettersForListeners instance;
  
  public WebDriver driver;
  public LoginPage loginPage;
  public HomePage homePage;
  //public CommonInformationElementPage commonPage;
  public PropertyFileUtility propertyfileutility;
  public ExceSheetlUtility excelUtility;
  public JavaSpecificCommonMethodsUtility javaUtility;
  public SeleniumWebDriverUtility seleniumWebDriverUtility;
  public int randomNumber;
  public static String username;
  public static String password;
  public String browser;
  public String url;
  public long longTimeOut;
  
  
  private GettersAndSettersForListeners() {}
  public static GettersAndSettersForListeners getInstance()
  {
	  if(instance==null)
	  {
		  instance=new GettersAndSettersForListeners();
	  }
	  return instance;
  }
  
  public LoginPage getLoginPage()
  {
	  return loginPage;
  }
  
  public HomePage getHomePage()
  {
	  return homePage;
  }
  
	/*
	 * public CommonInformationElementPage getCommonpage() { return commonPage; }
	 */
  
  public PropertyFileUtility getPropertyFileUtility()
  {
	  return propertyfileutility;
  }
  
  public ExceSheetlUtility getExceSheetlUtility()
  {
	  return excelUtility;
  }
  
  public JavaSpecificCommonMethodsUtility getJavaSpecificCommonMethodsUtility()
  {
	  return javaUtility;
  }
  
  public SeleniumWebDriverUtility getSeleniumWebDriverUtility()
  {
	  return seleniumWebDriverUtility;
  }
  
  public int getRandomNumber()
  {
	  return randomNumber;
  }
  
  public static String getUsername()
  {
	  return username;
  }
  
  public static String getPassword()
  {
	  return password;
  }
  
  public String getBrowser()
  {
	  return browser;
  }
  
  public String getUrl()
  {
	  return url;
  }
  
  public long getLongTimeOut()
  {
	  return longTimeOut;
  }
  
  public WebDriver getDriver()
  {
	  return driver;
  }
  
  public void setDriver(WebDriver driver)
  {
	  this.driver=driver;
  }
  
  public void setLoginPage(LoginPage loginPage)
  {
	  this.loginPage=loginPage;
  }
  
  public void setHomePage(HomePage homePage)
  {
	  this.homePage=homePage;
  }
  
  //public void setCommonpage(CommonInformationElementPage commonpage)
 // {
 //   this.commonPage=commonpage;
  //}
  
  public void setPropertyFileUtiltity(PropertyFileUtility fileUtiltiy)
  {
	  this.propertyfileutility=propertyfileutility;
  }
  
  public void setExceSheetlUtility(ExceSheetlUtility excelUtility)
  {
	  this.excelUtility=excelUtility;
  }
  
  public void setJavaSpecificCommonMethodsUtility(JavaSpecificCommonMethodsUtility javaUtility)
  {
	  this.javaUtility=javaUtility;
  }
  
  public void setSeleniumWebDriverUtility(SeleniumWebDriverUtility seleniumWebDriverUtility)
  {
	  this.seleniumWebDriverUtility=seleniumWebDriverUtility;
  }
  
  public void setRandomNumber(int randomNumber)
  {
	  this.randomNumber=randomNumber;
  }
  
  public static void setUsername(String username)
  {
	  GettersAndSettersForListeners.username=username;
  }
  
  public static void setPassword(String password)
  {
	  GettersAndSettersForListeners.password=password;
  }
  
  public void setBrowser(String browser)
  {
	  this.browser=browser;
  }
  
  public void setUrl(String url)
  {
	  this.url=url;
  }
  
  public void setLongTimeOut(long longTimeOut)
  {
	  this.longTimeOut=longTimeOut;
  }
}
