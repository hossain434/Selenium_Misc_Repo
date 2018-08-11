package PDFEmail;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class BaseClass {

	static WebDriver driver;
	public static WebDriver getDriver(){
		if(driver==null){
			System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe"); 
			driver = new ChromeDriver();
		}
		return driver;
	}
	
	/**
	 * This function will take screenshot
	 * @param webdriver
	 * @param fileWithPath
	 * @throws Exception
	 */
	public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
		//Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		//Call getScreenshotAs method to create image file
				File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			//Move image file to new destination 
				File DestFile=new File(fileWithPath);
				//Copy file at destination
				FileUtils.copyFile(SrcFile, DestFile);
			
	}

}
