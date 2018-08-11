/*package webTours;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TestRunner {
	private WebDriver driver;
	LoginPage loginPage;

	@BeforeClass
	public void beforeTest() {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://newtours.demoaut.com/mercurywelcome.php");
		// Initialize Login Page
		loginPage = PageFactory.initElements(driver, LoginPage.class);

	}

	@Test
	public void LoginTest() throws InterruptedException {

		// Enter user name
		loginPage.EnterUserName("arf");
		// Enter Password
		loginPage.EnterPassword("arf");
		// Click Login Button
		loginPage.ClickLoginButton();
	}

	@Test
	public void LogoutTest() {
		// Click Logout button
		loginPage.ClickLogoutButton();
	}

	@AfterClass
	public void afterTest() {
		// Close the browser
		driver.close();
		driver.quit();
	}

}*/