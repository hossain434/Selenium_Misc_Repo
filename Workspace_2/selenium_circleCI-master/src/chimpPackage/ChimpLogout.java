package chimpPackage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ChimpLogout extends ChimpBaseForSequentialExecution{
	
	String strClickdropdown,strClicklogout;
	@BeforeClass(groups={"Smoke","Regression"})
	public void initialiseDriver() throws IOException{
		setWebDriver(getDriver());
		System.out.println(driver.getCurrentUrl());
		getPropertyValues();
	}
	public void getPropertyValues() throws IOException
	{
		Properties prop = new Properties();
		String propFileName = "ChimpLogout.properties";
		input = getClass().getClassLoader().getResourceAsStream(propFileName);
		if (input != null) {
			prop.load(input);
			strClickdropdown=prop.getProperty("strClickdropdownconf");
			strClicklogout=prop.getProperty("strClicklogoutconf");
			//for logout use the following xpath - //a[text()='Logout']  or //*[@id="header"]/header/div/div[2]/div[2]/div/div/div/div[3]/ul/li[4]/a
		}
		else 
		{
			throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
		}
		
	}
	@Test(groups={"Smoke","Regression"})
	public void tc01LogoutFromchimp() throws InterruptedException{
		try{
		byElement=By.xpath(strClickdropdown);		
		objWaitforanelement.waitForElement(driver, byElement);
		driver.findElement(By.xpath(strClickdropdown)).click();
		byElement=By.xpath(strClicklogout);		
		objWaitforanelement.waitForElement(driver, byElement);
		driver.findElement(By.xpath(strClicklogout)).click();
		System.out.println("Logout Completed Successfully");
		Reporter.log("Logout Completed Successfully - PASS");
		}
		catch(Exception e){
			Reporter.log(e.toString());
			
		}
	}
}
