package sankar_frame;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class executetestcasesfromexcelhybrid{
	WebDriver webdriver = null;
    @Test(dataProvider="hybridData")
	public void testLogin(String TestCase,String Keyword,String objectName,String objectType,String value) throws Exception { 	
    	if(TestCase!=null&&TestCase.length()!=0){
			System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe"); 
			webdriver=new ChromeDriver();
    	}
        readobjectproperties object = new readobjectproperties();
        Properties allObjects =  object.getObjectRepository();
        appsscript script = new appsscript(webdriver);
      	//Call perform function to perform operation on UI
    			script.perform(allObjects, Keyword, objectName,
    				objectType, value);    	    
	}   
    @DataProvider(name="hybridData")
	public Object[][] getDataFromDataprovider() throws IOException{
    	Object[][] object = null; 
    	readexcel file = new readexcel();     
         //Read keyword sheet
         Sheet myexcelsheet = file.readExcel(System.getProperty("user.dir")+"\\src\\sankar_frame","TestCase.xlsx" , "KeywordFramework");
       //Find number of rows in excel file
     	int rowCount = myexcelsheet.getLastRowNum()-myexcelsheet.getFirstRowNum();
     	object = new Object[rowCount][5];
     	for (int i = 0; i < rowCount; i++) {
    		//Loop over all the rows
    		Row row = myexcelsheet.getRow(i+1);
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
