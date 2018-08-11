//http://toolsqa.com/selenium-webdriver/data-driven-testing-excel-poi/
package datadriven;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import datadriven.*;
import datadriven.Constant;
// Import Package utility.*
import datadriven.ExcelUtils;
import datadriven.SignIn_Action;
public class Apache_POI_TC {
private static WebDriver driver = null;
public static void main(String[] args) throws Exception {
//This is to open the Excel file. Excel path, file name and the sheet name are parameters to this method
ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Sheet1");
/*System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe"); 
driver = new FirefoxDriver();*/
System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe"); 
driver = new ChromeDriver();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.get(Constant.URL);
SignIn_Action.Execute(driver);
System.out.println("Login Successfully, now it is the time to Log Off buddy.");
//Home_Page.lnk_LogOut(driver).click(); 
driver.quit();
//This is to send the PASS value to the Excel sheet in the result column.
ExcelUtils.setCellData("Pass", 1, 3);
}
}
