package Find_Broken_links;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AppTest{

	@Test
	  public void goTo(){
    	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
        driver.get("https://wrappixel.com/demos/admin-templates/admin-pro/main/ui-notification.html");
    }
}

