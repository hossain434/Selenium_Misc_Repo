package extendreports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Extentreports {

	@Test
	public void verifySeleniumBlog() {

		String extentReportFile = System.getProperty("user.dir")
				+ "\\extentReportFile.html";
		String extentReportImage = System.getProperty("user.dir")
				+ "\\extentReportImage.png";

		// Create object of extent report and specify the report file path.
		ExtentReports extent = new ExtentReports(extentReportFile, false);

		// Start the test using the ExtentTest class object.
		ExtentTest extentTest = extent.startTest("My First Test",
				"Verify WebSite Title");

		// Launch the FireFox browser.
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe"); 
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		extentTest.log(LogStatus.INFO, "Browser Launched");

		// Open application.
		driver.get("http://www.techbeamers.com");

		extentTest.log(LogStatus.INFO, "Navigated to www.techbeamers.com");

		// get title.
		String title = driver.getTitle();

		extentTest.log(LogStatus.INFO, "Get the WebSite title");

		// Verify title.
		//Assert.assertTrue(title.contains("Selenium Webdriver"));

		extentTest.log(LogStatus.PASS, "Title verified");

		// In case you want to attach screenshot then use below method
		// We used a random image but you've to take screenshot at run-time
		// and specify the error image path.
		extentTest.log(
				LogStatus.INFO,
				"Error Snapshot : "
						+ extentTest.addScreenCapture(extentReportImage));

		// Close application.
		driver.quit();

		extentTest.log(LogStatus.INFO, "Browser closed");

		// close report.
		extent.endTest(extentTest);

		// writing everything to document.
		extent.flush();
	}
}