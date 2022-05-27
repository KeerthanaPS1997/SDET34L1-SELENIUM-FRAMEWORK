package com.SDET34L1.genericUtility;

/*
 * import org.openqa.selenium.WebDriver; import
 * org.openqa.selenium.chrome.ChromeDriver; import
 * org.openqa.selenium.firefox.FirefoxDriver; import org.testng.ITestContext;
 * import org.testng.ITestListener; import org.testng.ITestResult; import
 * org.testng.annotations.Listeners;
 * 
 * import com.vtiger.PomRepository.HomePage; import
 * com.vtiger.PomRepository.LoginPage;
 * 
 * import io.github.bonigarcia.wdm.WebDriverManager;
 */
/*
 * //ItestListner:-It is used to moniter the test script execution and perform
 * the appropriate action, inside this we have some methods ie, onTestStart,
 * onTestSuccess etc. public class ListnerImplementation implements
 * ITestListener { public WebDriver driver; public LoginPage loginPage; public
 * HomePage homePage; //public CommonInformationElementPage commonPage; public
 * PropertyFileUtility propertyfileutility; public ExceSheetlUtility
 * excelUtility; public JavaSpecificCommonMethodsUtility javaUtility; public
 * SeleniumWebDriverUtility seleniumWebDriverUtility; public int randomNumber;
 * public static String username; public static String password; public String
 * browser; public String url; public long longTimeOut;
 * 
 * @Override public void onStart(ITestContext context) {
 * System.out.println("onStart"+Thread.currentThread().getId());
 * 
 * propertyfileutility=new PropertyFileUtility(); excelUtility=new
 * ExceSheetlUtility(); javaUtility=new JavaSpecificCommonMethodsUtility();
 * 
 * excelUtility.openExcel(IconstantPathOfFilesUtility.EXCELFILE_PATH);
 * propertyfileutility.openPropertyFile(IconstantPathOfFilesUtility.
 * PROPERTYFILEPATH);
 * url=propertyfileutility.FetchTheDataFromPropertyFile("url"); String
 * timout=propertyfileutility.FetchTheDataFromPropertyFile("timeout");
 * username=propertyfileutility.FetchTheDataFromPropertyFile("username");
 * password=propertyfileutility.FetchTheDataFromPropertyFile("password");
 * browser=propertyfileutility.FetchTheDataFromPropertyFile("browser");
 * longTimeOut=javaUtility.stringToLong(timout);
 * randomNumber=javaUtility.getRandomNumber(1000);
 * 
 * 
 * 
 * switch (browser) { case "chrome": WebDriverManager.chromedriver().setup();
 * driver=new ChromeDriver(); break; case "firefox":
 * WebDriverManager.firefoxdriver().setup(); driver=new FirefoxDriver(); break;
 * default: javaUtility.printStatement("pleasr specify proper browser key");
 * WebDriverManager.firefoxdriver().setup(); driver=new FirefoxDriver(); break;
 * }
 * 
 * seleniumWebDriverUtility=new SeleniumWebDriverUtility();
 * 
 * //navigate to the application seleniumWebDriverUtility.navigateToApp(url,
 * driver);
 * 
 * //browser settings(maximize, implicit wait, action class initialization,
 * explicit wait instance initailazation)
 * seleniumWebDriverUtility.maximizeBrowser(driver);
 * seleniumWebDriverUtility.waitTillPageLoad(longTimeOut, driver);
 * seleniumWebDriverUtility.initializeActions(driver);
 * seleniumWebDriverUtility.explicitlyWait(longTimeOut, driver);
 * 
 * //create the instance for common object repository class loginPage=new
 * LoginPage(driver); homePage=new HomePage(driver); // commonPage=new
 * CommonInformationElementPage(driver);
 * 
 * // GettersAndSettersForListeners.getInstance().setCommonpage(commonpage);
 * GettersAndSettersForListeners.getInstance().setDriver(driver);
 * GettersAndSettersForListeners.getInstance().setExceSheetlUtility(excelUtility
 * ); GettersAndSettersForListeners.getInstance().setPropertyFileUtiltity(
 * propertyfileutility);
 * GettersAndSettersForListeners.getInstance().setHomePage(homePage);
 * GettersAndSettersForListeners.getInstance().
 * setJavaSpecificCommonMethodsUtility(javaUtility);
 * GettersAndSettersForListeners.getInstance().setLoginPage(loginPage);
 * GettersAndSettersForListeners.getInstance().setRandomNumber(randomNumber);
 * GettersAndSettersForListeners.getInstance().setSeleniumWebDriverUtility(
 * seleniumWebDriverUtility); }
 * 
 * 
 *//**
	 * it will invoke immediately when ever the suite tag starts execution(start of
	 * suite)
	 */
/*
 * @Override public void onTestStart(ITestResult result) {
 * System.out.println("onTestSuite"+Thread.currentThread().getId());
 * 
 * //open database if it is required loginPage.loginAction(username, password);
 * }
 * 
 * 
 *//**
	 * it will invoke when @test annotation invokes, and based on the status of
	 * execution it will invoke(when test case is pass )
	 */
/*
 * @Override public void onTestSuccess(ITestResult result) {
 * System.out.println("onTestSuccess"+Thread.currentThread().getId()); }
 * 
 * 
 *//**
	 * it will invoke when @test annotation invokes, and based on the status of
	 * execution it will invoke(when test case is fail )
	 */
/*
 * @Override public void onTestFailure(ITestResult result) {
 * System.out.println("onTestFailure"); }
 * 
 * @Override public void onTestSkipped(ITestResult result) {
 * System.out.println("onTestSkipped"); }
 * 
 * @Override public void onTestFailedButWithinSuccessPercentage(ITestResult
 * result) { System.out.println("onTestFailedButWithinSuccessPercentage"); }
 * 
 * 
 *//**
	 * end of suite
	 *//*
		 * @Override public void onFinish(ITestContext context) {
		 * System.out.println("onFinish"+Thread.currentThread().getId());
		 * 
		 * //seleniumWebDriverUtility.waitUntilElementVisibility(commonpage.
		 * getHeaderTetxt()); //homePage.signout(driver);
		 * 
		 * seleniumWebDriverUtility.quitBrowser(driver);
		 * 
		 * excelUtility.closeExcel(); } }
		 */