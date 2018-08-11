package ImproveTestPerformanceJava8;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AppTest{
	private WebDriver driver;
	@Test
	  public void goTo(){
    	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
        driver.get("http://www.zlti.com");
    }
	
		@Test
	public void link() {

		Map<Boolean, List<String>> map = driver.findElements(By.tagName("a")) // find all elements which has href
																						// attribute
				.stream().map(ele -> ele.getAttribute("href")) // get the value of href
				.map(String::trim) // trim the text
				.distinct() // there could be duplicate links , so find unique
				.collect(Collectors.partitioningBy(link -> LinkUtil.getResponseCode(link) == 200)); // partition based
																									// on response code

		map.get(true); // will contain all the good urls
		map.get(false); // will contain all the bad urls

		map.get(false).stream().forEach(System.out::println);
	}
}
