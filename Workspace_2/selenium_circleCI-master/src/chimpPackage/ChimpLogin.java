package chimpPackage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ChimpLogin extends ChimpBaseForSequentialExecution{
	
	String strFilepath,strSheetname,strTabname,strClickloginbutton,
	stUsername,strPassword,strLogin,stClosebabywindow,strClickdropdown,
	strTempVariable,strlognUsername,strloginPassword;
	
	@BeforeClass(groups={"Smoke","Regression"})
	public void initialiseDriver() throws IOException{
		setWebDriver(getDriver());
		System.out.println(driver.getCurrentUrl());
		getPropertyValues();
	}
	
	public void getPropertyValues() throws IOException
	{
		Properties prop = new Properties();
		String propFileName = "ChimpLogin.properties";
		input = getClass().getClassLoader().getResourceAsStream(propFileName);
		if (input != null) {
			prop.load(input);
			strlognUsername=prop.getProperty("strlognUsernameconf");
			strloginPassword=prop.getProperty("strloginPasswordconf");
			strFilepath=prop.getProperty("strFilepathconf");
			strSheetname=prop.getProperty("strSheetnameconf");
			strTabname=prop.getProperty("strTabnameconf");
			strClickloginbutton=prop.getProperty("strClickloginbuttonconf");
			stUsername=prop.getProperty("stUsernameconf");
			strPassword=prop.getProperty("strPasswordconf");
			strLogin=prop.getProperty("strLoginconf");
			stClosebabywindow=prop.getProperty("stClosebabywindowconf");
			strClickdropdown=prop.getProperty("strClickdropdownconf");
			strTempVariable=prop.getProperty("strTempVariableconf");
			System.out.println(strFilepath + strSheetname + strTabname);
		}
		else 
		{
			throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
		}
		
	}

	@Test(groups={"Smoke","Regression"})
	public void tc01LogintoChimp(){
		try
		{
			byElement=By.xpath(strClickloginbutton);	
			objWaitforanelement.waitForElement(driver, byElement);
			driver.findElement(By.xpath(strClickloginbutton)).click();
			System.out.println("Credentials :  "+ strlognUsername + strloginPassword );
			byElement=By.xpath(stUsername);		
			objWaitforanelement.waitForElement(driver, byElement);	
			driver.findElement(By.xpath(stUsername)).sendKeys(strlognUsername);
			byElement=By.xpath(strPassword);		
			objWaitforanelement.waitForElement(driver, byElement);	
			driver.findElement(By.xpath(strPassword)).sendKeys(strloginPassword);
			byElement=By.xpath(strLogin);		
			objWaitforanelement.waitForElement(driver, byElement);	
			driver.findElement(By.xpath(strLogin)).click();
			try{
				
				byElement=By.xpath(stClosebabywindow);
				objWaitforanelement.waitForElement(driver, byElement);
				driver.findElement(byElement).click();
	//			WebElement svgObject = driver.findElement(By.xpath(stClosebabywindow));
	//			Actions builder = new Actions(driver);
	//			builder.click(svgObject).build().perform();
			}
			catch(NoSuchElementException nse){
				nse.getMessage();
			}
			
			byElement=By.xpath(strClickdropdown);
			objWaitforanelement.waitForElement(driver, byElement);
			System.out.println("Login Completed Successfully");	
			Reporter.log("Login Completed Successfully - PASS");
		}
		catch(Exception e){
			Reporter.log(e.toString());
		}
	}

}
