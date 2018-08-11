package datadriven;
import org.openqa.selenium.*;
import datadriven.Log;
public class LogIn_Page {
static WebElement element = null;
public static WebElement txtbx_UserName(WebDriver driver){
    element = driver.findElement(By.id("log"));
	Log.info("Username text box found");
    return element;
    }
public static WebElement txtbx_Password(WebDriver driver){
	driver.findElement(By.id("pwd")).click();
    element = driver.findElement(By.id("pwd"));
	Log.info("Password text box found");
    return element;
    }
/*public static WebElement btn_LogIn(WebDriver driver){
    element = driver.findElement(By.id("login"));
	Log.info("Submit button found");
    return element;
    }*/
}


