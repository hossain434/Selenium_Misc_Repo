package test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class test1{

public static void main(String agrs[]){
	WebDriver driver;
	System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
	driver = new FirefoxDriver();
	driver.get("http://store.demoqa.com");
	driver.findElement(By.linkText("Product Category")).click();
}
}
