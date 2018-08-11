package sankar_frame2.testCases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import sankar_frame2.pageObjects.BaseClass;
import sankar_frame2.pageObjects.ProductListing_Page;
import sankar_frame2.utility.Constant;
import sankar_frame2.utility.ExcelUtils;
import sankar_frame2.utility.Log;
import sankar_frame2.utility.Utils;
import sankar_frame2.appModules.CheckOut_Action;
import sankar_frame2.appModules.Confirmation_Action;
import sankar_frame2.appModules.PaymentDetails_Action;
import sankar_frame2.appModules.ProductSelect_Action;
import sankar_frame2.appModules.SignIn_Action;
import sankar_frame2.appModules.Verification_Action;

public class Framework_002 {
	public WebDriver driver;
	private String sTestCaseName;
	private int iTestCaseRow;
	
  @BeforeMethod
  public void beforeMethod() throws Exception {
	  	DOMConfigurator.configure("log4j.xml");
	  	sTestCaseName = this.toString();
	  	sTestCaseName = Utils.getTestCaseName(this.toString());
		Log.startTestCase(sTestCaseName);
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Sheet1");
		iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		driver = Utils.OpenBrowser(iTestCaseRow);
		new BaseClass(driver);  
        }
  
  @Test
  public void f() throws Exception {
	  try{
		SignIn_Action.Execute(iTestCaseRow);
		Thread.sleep(1000);
		ProductSelect_Action.productType(iTestCaseRow);
		Thread.sleep(2000);
		ProductSelect_Action.productNumber(iTestCaseRow);
		Thread.sleep(2000);
		//ProductListing_Page.PopUpAddToCart.btn_GoToCart();
		CheckOut_Action.Execute();
		PaymentDetails_Action.execute(iTestCaseRow);
		Confirmation_Action.Execute();
		Verification_Action.Execute();
		ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.Col_Result);
	  }catch (Exception e){
		  ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.Col_Result);
		  Utils.takeScreenshot(driver, sTestCaseName);
		  Log.error(e.getMessage());
		  throw (e);
	  }
		
  }
		
		
  @AfterMethod
  public void afterMethod() {
	    Log.endTestCase(sTestCaseName);
	    driver.close();
  		}
}
