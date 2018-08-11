package testCases;
import java.io.IOException;
import java.util.Properties;
import operation.ReadObject;
import operation.UIOperation;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import excelExportAndFileIO.ReadExcelFile;
public class HybridExecuteTest {
    WebDriver webdriver = null;
@Test(dataProvider="hybridData")
    public void testLogin(String testcaseName,String keyword,String objectName,String objectType,String value) throws Exception {
        // TODO Auto-generated method stub
      
    if(testcaseName!=null&&testcaseName.length()!=0){
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		webdriver = new ChromeDriver();
    }
ReadObject object = new ReadObject();
Properties allObjects = object.getObjectRepository();
UIOperation operation = new UIOperation(webdriver);
    //Call perform function to perform operation on UI
            operation.perform(allObjects, keyword, objectName,
                objectType, value);
    
    }
@DataProvider(name="hybridData")
    public Object[][] getDataFromDataprovider() throws IOException{
    Object[][] object = null;
    ReadExcelFile file = new ReadExcelFile();
//Read keyword sheet
Sheet Sheet = file.readExcel(System.getProperty("user.dir")+"\\","TestCase.xlsx" , "KeywordFramework");
//Find number of rows in excel file
    int rowCount = Sheet.getLastRowNum()-Sheet.getFirstRowNum();
    object = new Object[rowCount][5];
    for (int i = 0; i < rowCount; i++) {
        //Loop over all the rows
        Row row = Sheet.getRow(i+1);
        //Create a loop to print cell values in a row
        for (int j = 0; j < row.getLastCellNum(); j++) {
            //Print excel data in console
            object[i][j] = row.getCell(j).toString();
        }
    }
    System.out.println("");
     return object;    
    }
}