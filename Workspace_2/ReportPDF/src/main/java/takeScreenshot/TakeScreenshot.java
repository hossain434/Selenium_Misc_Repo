package takeScreenshot;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TakeScreenshot {

	@Test
	public void testTakeScreenShot() throws Exception{
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe"); 
		WebDriver driver = new ChromeDriver();
		//goto url
		driver.get("http://demo.guru99.com/V4/");
		//Call take screenshot function
		TakeScreenshot.takeSnapShot(driver, "C:\\Users\\ahoss1\\Desktop\\test.png");
		
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
