package readwrite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class excelReadWrite extends ExcelUtils{
	static int RowNum;
	static WebDriver driver;
	@BeforeTest
	public void Setup()
	 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		 driver = new ChromeDriver();
			String baseURL = "http://demo.guru99.com/test/newtours/";
			driver.get(baseURL);	
	}
	@Test
	public static void main(String[] args) throws Exception {
			

		// String baseURL="http://127.0.0.1:1080/WebTours/index.htm";
		// String baseURL="file:///C:/Users/ahoss1/Desktop/f.html";
		// taking excel path and sheet name
		
			 
			{
				@Test(dataProvider="Authentication")
				public void logindata(String uname,String pass) {
		
		
					driver.findElement(By.cssSelector("input[name='userName']")).sendKeys(uname);
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys(pass);
		driver.findElement(By.cssSelector("input[name='submit']")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("table>tbody>tr>.mouseOut a:nth-child(1)")).click();
			}
			
			
				@DataProvider

				  public Object[][] Authentication() throws Exception{

					ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Sheet1");

					
					String uname = ExcelUtils.getCellData(RowNum, Constant.Col_Username);
					String pass = ExcelUtils.getCellData(RowNum, Constant.Col_Password);


					    Object[][] testObjArray = ExcelUtils.getTableArray("D://ToolsQA//OnlineStore//src//testData//TestData.xlsx","Sheet1",iTestCaseRow);

					    	return (testObjArray);

						}

			  }
	}
		}
	


