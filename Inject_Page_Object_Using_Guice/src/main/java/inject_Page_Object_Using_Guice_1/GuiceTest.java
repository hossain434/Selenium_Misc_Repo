package inject_Page_Object_Using_Guice_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import com.google.inject.Inject;

//@Guice(modules = {
//	    DriverModule.class
//	})
	public class GuiceTest {
		WebDriver driver;

	    @Inject
	    Google google;


	    @Test(dataProvider = "google-test")
	    public void f(String txt, String color) throws InterruptedException {
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://www.google.com");

	       // google.goTo();
	        
	        //change the color of the google page
	        google.execute("document.body.style.backgroundColor='" + color + "';");

	       //do search and show results
	        google.getSearchWidget().searchFor(txt);
	        google.getResults().displayResult();

	    }

	    @DataProvider(name = "google-test")
	    public static Object[][] getData() {
	        return new Object[][] {
	            {
	                "guru",
	                "blue"
	            }, {
	                "guice",
	                "green"
	            }
	        };
	    }

	}