package webTours;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TestRunner {
	private WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://newtours.demoaut.com/mercurywelcome.php");

	}

	@Test
	public void LoginTest() throws InterruptedException {
		// Initialize Login Page
	
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		// Enter user name
		loginPage.EnterUserName("arf");
		// Enter Password
		loginPage.EnterPassword("arf");
		// Click Login Button
		loginPage.ClickLoginButton();
	}

	@Test
	public void LogoutTest() {
		// Initialize Login Page
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		// Click Logout button
		loginPage.ClickLogoutButton();
	}

	@AfterClass
	public void afterClass() {
		// Close the browser
		driver.close();
		driver.quit();
	}

}