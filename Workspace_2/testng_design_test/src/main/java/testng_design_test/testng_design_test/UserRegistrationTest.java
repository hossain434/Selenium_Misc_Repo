package testng_design_test.testng_design_test;

import java.sql.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import testng_design_test.testng_design_test.*;

public class UserRegistrationTest<EnterUserInfoAndSubmit, ProductSearchPage, OrderSummaryPage, OrderConfirmationPage, UserDetailsPage> {
	private WebDriver driver;
	private Data data;
	DriverManager driverManager;

	private UserDetailsPage userDetailsPage;
	 private EnterUserInfoAndSubmit enterUserInfoAndSubmit; 
	 private ProductSearchPage productSearchPage; 
	 private OrderSummaryPage orderSummaryPage; 
	 private OrderConfirmationPage orderConfirmationPage;
	 

	@BeforeTest
	@Parameters({ "browser", "user-registration-data-file" })
	public void setUpDriver(String browser, String userDataFile) throws Throwable {
		driver = (WebDriver) DriverManager.getDriver(browser);
		//driverManager = DriverManagerFactory.getManager(DriverType.IE);
		data = Data.get(userDataFile);
	}
	@Test
	public void launch() {
	  //  userDetailsPage = UserDetailsPage.init(driver)
       //         .launch();
	    //validate if the page is loaded
	//    Assert.assertTrue(userDetailsPage.isAt());  
	} 

	@Test(dependsOnMethods = "enterUserInfoAndSubmit")
	public void searchProductAndSubmit() {
		// search for a product with specific criteria & select
	}

	@Test(dependsOnMethods = "searchProductAndSubmit")
	public void enterPaymentInfoAndSubmit() {
		// enter payment info & submit
	}

	@Test(dependsOnMethods = "enterPaymentInfoAndSubmit")
	public void validateOrderConfirmation() {
		// verify the order confirmation
	}

	@AfterTest
	public void tearDownDriver() {
		// quit driver
	}
}