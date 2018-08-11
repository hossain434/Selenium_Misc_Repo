package Find_Broken_links;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestPage{
WebDriver driver;

	@BeforeTest
	public void go() {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.yahoo.com");
	}

	@Test
	public void link() {

		Map<Boolean, List<String>> map = driver.findElements(By.xpath("//*[@href]")) // find all elements which has href
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
