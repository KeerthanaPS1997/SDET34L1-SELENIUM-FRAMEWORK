package com.SDET34L1.genericUtility;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * 
 * @author Admin
 *
 */
public class SeleniumWebDriverUtility 
{

/**
 * This method is used to navigate the application 
 * @param url
 * @param driver1
 */
  
	//global variable
  static WebDriverWait wait;
  static Select select;
  static Actions act;
  static JavascriptExecutor js;
  static JavaSpecificCommonMethodsUtility jutil=new JavaSpecificCommonMethodsUtility();
  
  
public static void navigateToApp(String url, WebDriver driver1)
{
	driver1.get(url);
}
/**
 * This method is used to maximize the browser and implicitly wait 
 * @param longtimeout
 * @param driver1
 */
public static void browserSetting(long longtimeout, WebDriver driver)
{
	maximizeBrowser(driver);
	waitTillPageLoad(longtimeout, driver);
}

/**
 * This method use to wait for title
 * @param driver1
 * @param title
 */
public static void waitForTitle(WebDriver driver1, String title)
{
	waitForTitle(driver1, title);
}

/**
 * This method is used to maximize the browser 
 * @param driver1
 */
public static void maximizeBrowser(WebDriver driver)
{
	driver.manage().window().maximize();
}
/**
 * 
 * @param longtimout
 * @param driver1
 */
public static void waitTillPageLoad(long longtimeout, WebDriver driver)
{
	driver.manage().timeouts().implicitlyWait(longtimeout, TimeUnit.SECONDS);
}

/**
 * 
 * @param driver
 */
public static void initializeActions(WebDriver driver)
{
	act=new Actions(driver);
}

/**
 * 
 * @param ele
 * @param driver
 */
public  static void mouseHoverOnTheElement(WebElement ele, WebDriver driver)
{
	act=new Actions(driver);
	act.moveToElement(ele).click().perform();
}

public static void doubleClick(WebElement element)
{
	act.moveToElement(element).click().perform();
}

/**
 * 
 * @param driver1
 */
public static void quitBrowser(WebDriver driver1)
{
	driver1.quit();
}

public static void explicitlyWait()
{
	
}
/**
 * 
 * @param ele
 */
public static void waitUntillElementClickable(WebDriver driver, WebElement element)
{
	WebDriverWait wait=new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.elementToBeClickable(element));
}
 
public void waitUntilElementVisibility(WebDriver driver, WebElement element)
{
	WebDriverWait wait=new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.elementToBeSelected(element));
}
/**
 * 
 * @param driver
 * @param partialText
 */
public static void switchToWindowBasedOnTitle(WebDriver driver, String partialText)
{
	Set<String> sessionIDs = driver.getWindowHandles();
	for(String id:sessionIDs)
	{
		driver.switchTo().window(id);
		if(driver.getTitle().contains(partialText))
		{
			break;
		}
	}
}

/**
 * This method is used to intialize the select class
 * @param element
 */
public static void initilizeSelect(WebElement element)
{
	select=new Select(element);
}

/**
 * This method is used to handle dropdowns by visibleText
 * @param element
 * @param visibletext
 */
public static void dropDownHandlebyVisibleText(WebElement element, String visibletext)
{
	select.selectByVisibleText(visibletext);
}

/**
 * 
 * @param element
 * @param index
 */
public static void dropDownHandlebyIndex(WebElement element, int index)
{
	select.selectByIndex(index);
}

/**
 * 
 * @param value
 * @param element
 */
public static void dropDownHandlebyValue(String value, WebElement element)
{
	select.selectByValue(value);
}

/**
 * 
 * @param driver
 * @param index
 */
public static void switchToFrame(WebDriver driver, int index)
{
	driver.switchTo().frame(index);
}

public static void switchToFrame(WebDriver driver, String nameorID)
{
	driver.switchTo().frame(nameorID);
}

public static void switchToBackHome(WebDriver driver)
{
	driver.switchTo().defaultContent();
}
/**
 * 
 * @param timeout
 * @param driver1
 */
public static void explicitlyWait(long timeout, WebDriver driver1)
{
	WebDriverWait wait = new WebDriverWait(driver1, timeout);
}

/**
 * This method is used to switch the control from one window to another based on title
 * @param driver
 * @param partialText
 s*/
public static void switchToWindow(WebDriver driver2, String partialText)
{
	Set<String> windowsid = driver2.getWindowHandles();
	for(String id:windowsid)
	{
		driver2.switchTo().window(id);
		if(driver2.getTitle().contains(partialText))
		{
			break;
		}
	}
}

public static void initializeJs(WebDriver driver)
{
	js=(JavascriptExecutor) driver;
}

public static void enterdataThroughjs(WebElement element, String data)
{
	js.executeScript("arguments[0].value=arguments[1]",element,data);
}

public static void navigateAplicationThroughjs(String url)
{
  js.executeScript("window.location=arguments[0]", url);
}

public static void scrollToSpecfiedHieght(String height)
{
	js.executeScript("window.scrollBy(0,"+height+")");
}

public static void scrolToBottom()
{
	js.executeScript("window.scrllBy(0,document.body.scrollHeight)");
}

public static void scrollTillElement(WebElement element)
{
	js.executeScript("argumrnts[0].scrollintoView()", element);
}

public static void takeScreenShot(String fileName, WebDriver driver) throws IOException 
{
	TakesScreenshot ts = (TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File dst = new File("./screenshot/"+fileName+"_"+jutil.dateTimeInFormat()+".png");
	System.out.println(dst.getAbsolutePath());
	FileUtils.copyFile(src, dst);
}

public static void alertAccept(WebDriver driver)
{
	driver.switchTo().alert().accept();
}

public static void alertDismiss(WebDriver driver)
{
	driver.switchTo().alert().dismiss();
}

public static void alertsendData(WebDriver driver, String data)
{
	driver.switchTo().alert().sendKeys(data);
}

public static String getalertText(WebDriver driver)
{
	return driver.switchTo().alert().getText();
}

public static void rightClick()
{
	act.contextClick().perform();
}

public static void rightClick(WebElement element)
{
	act.contextClick(element).perform();
}
/**
 * this method use to switch child browser
 * @param driver
 * @param title
 */
public static void switchToChild(WebDriver driver,String title) {
	Set<String> set = driver.getWindowHandles();
	Iterator<String> it = set.iterator();
	while(it.hasNext()) {
		String w_id = it.next();
		driver.switchTo().window(w_id);
		String current_title = driver.getTitle();
		if(current_title.contains(title)) {
			break;
		}
	}
}

}

