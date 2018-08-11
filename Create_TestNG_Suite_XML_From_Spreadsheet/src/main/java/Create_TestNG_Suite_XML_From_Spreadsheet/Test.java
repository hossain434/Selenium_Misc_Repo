package Create_TestNG_Suite_XML_From_Spreadsheet;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class Test {
	
	
	public static void main (String args[]){
	XLSReader suite = new XLSReader("tests.xls");
	suite.getTests("select * from Sheet1 where module='Order'");
	}
}
