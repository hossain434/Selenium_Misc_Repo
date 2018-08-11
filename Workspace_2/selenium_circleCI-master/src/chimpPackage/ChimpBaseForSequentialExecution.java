package chimpPackage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;


import chimpBasePackage.ChimpBaseClass;

//Use this class for all your local test devlopment
public class ChimpBaseForSequentialExecution extends ChimpBaseClass {
	//public String strBrowsertype,strFirefoxDriver,strBaseUrl,strChromeDriver;
	public static WebDriver driver;
		
	@Parameters({"browserType","buildType","executionUrl"})
		@BeforeSuite(groups={"Main"})
		// Passing Browser parameter from TestNG xml
		public void BeforeTest(String browser,String strBuildType,String strExecutionUrl) throws IOException, InterruptedException {
			getPropertyValues();
			System.out.println(browser +"  "+ strBuildType + " " + strExecutionUrl );
			System.out.println(strChromeDriver  + " " +  strFirefoxDriver);
			capability= getDesiredcapablities(browser);
			URL ="https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
			URL browserStackUrl = new URL(URL);
		     System.out.println(browser);  
		     System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");
				// If the browser is fire fox, then do this
				if (browser.equalsIgnoreCase("firefox")) {
					getFirefox(strBuildType,browserStackUrl,capability);
				}
				// If browser is chrome, then do this
				else if (browser.equalsIgnoreCase("chrome")) {
					getChrome(strBuildType,browserStackUrl,capability);
					
				}
				driver.manage().window().maximize();
				getExecutionBuild(strExecutionUrl);
		}
		
		public WebDriver getDriver() {
	        return driver;
	    }
	 
	    public void setWebDriver(WebDriver driver) {
	    	ChimpBaseForSequentialExecution.driver = driver;
	    }
		
		@AfterSuite(groups={"Main"})
		public void closeBrowser(){
			driver.quit();
		}
		
		
		//To get and initialize variables
		public void getPropertyValues() throws IOException
		{
			Properties prop = new Properties();
			String propFileName = "ChimpBaseClass.properties";
			InputStream input = getClass().getClassLoader().getResourceAsStream(propFileName);
			System.out.println(input.read());
			if (input != null) {
				prop.load(input);
				strFirefoxDriver = prop.getProperty("strFirefoxDriverconf");
				strBaseUrlDev=prop.getProperty("strBaseUrlDevconf");
				strBaseUrlStage=prop.getProperty("strBaseUrlStageconf");
				strChromeDriver=prop.getProperty("strChromeDriverconf");
				String temp=prop.getProperty("strBSPlatformconf");;
				strBSPlatform=temp;
				strBSBrowserVersion=prop.getProperty("strBSBrowserVersionconf");
				strBSSeleniumversion=prop.getProperty("strBSSeleniumversionconf");
				USERNAME=prop.getProperty("USERNAMECONF");
				AUTOMATE_KEY=prop.getProperty("AUTOMATE_KEYCONF");
			}
			else 
			{
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
			System.out.println(strChromeDriver  + " " +  strFirefoxDriver);
		}
		
		//To set the desired capability for browser
		public DesiredCapabilities getDesiredcapablities(String browser){
			DesiredCapabilities Capabilities = new DesiredCapabilities();
			Capabilities.setCapability("platform",strBSPlatform);
			Capabilities.setBrowserName(browser);
			Capabilities.setVersion(strBSBrowserVersion);
			Capabilities.setCapability("browserstack.debug", "true");
			Capabilities.setCapability("browserstack.selenium_version",strBSSeleniumversion);
			return Capabilities;
		}
		
		//To get the firefoxDriver
		public void getFirefox(String strBuildType, URL browserStackUrl,DesiredCapabilities capability ){
			
			if(strBuildType.equalsIgnoreCase("LocalBuild")){
				System.setProperty("webdriver.gecko.driver", strFirefoxDriver);
				driver =new FirefoxDriver();
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			}
			else{
				driver = new RemoteWebDriver (browserStackUrl, capability);
			}
			
		}
		
		//To get the ChromeDriver
		public void getChrome(String strBuildType, URL browserStackUrl,DesiredCapabilities capability ){
			
			if(strBuildType.equalsIgnoreCase("LocalBuild")){
				System.setProperty("webdriver.chrome.driver", strChromeDriver);
				driver =new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			}
			else{
				System.out.println(browserStackUrl.toString());
				driver = new RemoteWebDriver (browserStackUrl, capability);
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			}
		}
				
		//To get Execution URL
		public void getExecutionBuild(String strExecutionUrl)
		{
			if(strExecutionUrl.equalsIgnoreCase("Dev")){
				driver.get(strBaseUrlDev);
			}
			else{
				driver.get(strBaseUrlStage);
			}
		}

}
