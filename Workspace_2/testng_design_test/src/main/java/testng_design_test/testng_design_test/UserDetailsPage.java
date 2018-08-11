package testng_design_test.testng_design_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class UserDetailsPage {

	private WebDriver driver;

	private UserDetailsPage(WebDriver driver) {
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
	}

	public static UserDetailsPage init(WebDriver driver) {
	    return new UserDetailsPage(driver);
	}

}
