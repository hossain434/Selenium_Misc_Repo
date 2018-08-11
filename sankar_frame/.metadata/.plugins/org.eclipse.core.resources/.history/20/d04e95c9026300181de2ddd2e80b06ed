	//https://selenium-coding.blogspot.com/2016/05/reading-and-writting-data-from-xlsx.html
	package sankar_frame1;
	import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
	public class ApachePOIReadandWriteBack {
	//XSSFSheet sh;
	//int i=0; 
    WebDriver driver = null;
   //File scenarioFile = new File(("user.dir")+"\\","TestScenarios.xlsx");
   File scenarioFile = new File("C:\\Users\\ahoss1\\sankar_frame\\sankar_frame\\src\\sankar_frame1\\TestScenarios.xlsx");
   @Test(dataProvider = "dp")
   public void f(String testCaseID,String userName, String password, String result) {
   driver.findElement(By.xpath(".//*[@name = 'userName']")).sendKeys(userName);
   driver.findElement(By.xpath(".//*[@name = 'password']")).sendKeys(password);
   driver.findElement(By.xpath(".//*[@name='login']")).click();
   try {
	Thread.sleep(4000);
} catch (InterruptedException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
   try {
      FileInputStream fis = new FileInputStream(scenarioFile);
      XSSFWorkbook workbook = (XSSFWorkbook) WorkbookFactory.create(fis);
      XSSFSheet sheet = workbook.getSheetAt(0);
      //int rowNum = 0;
	  int rowNum = Integer.parseInt(testCaseID);
      Row row = sheet.getRow(rowNum);
     // XSSFRow row = sh.createRow(i);
      if (driver.getTitle().equals("Find a Flight: Mercury Tours:")) {
      row.createCell(3).setCellValue("PASS");
   } else {
      row.createCell(3).setCellValue("FAIL");
      //i++;
   }
   fis.close();
   FileOutputStream fos = new FileOutputStream(scenarioFile);
   workbook.write(fos);
   fos.close();
   } catch (FileNotFoundException e) {
      e.printStackTrace();
   } catch (EncryptedDocumentException e) {
      e.printStackTrace();
   } catch (InvalidFormatException e) {
      e.printStackTrace();
   } catch (IOException e) {
      e.printStackTrace(); }
   }

   @BeforeMethod
   public void beforeMethod() {  
/*   System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe"); 
   driver = new FirefoxDriver(); */
	System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe"); 
	driver = new ChromeDriver();
   driver.manage().window().maximize();
   driver.get("http://newtours.demoaut.com");
   }

   @AfterMethod
   public void afterMethod() {
   driver.quit();
   }

   @DataProvider
   public Object[][] dp() {
   Object[][] o = null;
   try {
   FileInputStream fis = new FileInputStream(scenarioFile);
   XSSFWorkbook workbook = (XSSFWorkbook) WorkbookFactory.create(fis);
   XSSFSheet sheet = workbook.getSheetAt(0);
   o = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
   Iterator<Row> rowIterator = sheet.iterator();
   while (rowIterator.hasNext()) {
      Row row = rowIterator.next();
      if (row.getRowNum() == 0) {
      continue;
      }
   Iterator<Cell> cellIterator = row.cellIterator();
   while (cellIterator.hasNext()) {
      Cell cell = cellIterator.next();
      o[(row.getRowNum() - 1)][cell.getColumnIndex()] = cell.getStringCellValue();
      }
   }
   fis.close();
   } catch (FileNotFoundException e) {
      e.printStackTrace();
   } catch (EncryptedDocumentException e) {
      e.printStackTrace();
   } catch (InvalidFormatException e) {
      e.printStackTrace();
   } catch (IOException e) {
      e.printStackTrace();
   }
   return o;
   }
}


