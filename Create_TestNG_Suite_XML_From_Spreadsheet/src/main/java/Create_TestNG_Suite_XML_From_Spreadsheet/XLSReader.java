package Create_TestNG_Suite_XML_From_Spreadsheet;

import java.io.File;

import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XLSReader {

    private final Fillo fillo;
    private String filePath="C:\\Users\\ahoss1\\Desktop\\Workspace_new\\Create_TestNG_Suite_XML_From_Spreadsheet\\TestCases.xls";

    private Connection connection;
@Test
    public XLSReader(String filePath) {
        fillo = new Fillo();
       // this.filePath = filePath;
       // XLSReader suite = new XLSReader("TestCases.xls");
        //suite.getTests("select * from TestCase where module='Order'");
    }
@Test
    public void getTests(String query) {
        try {
            connection = fillo.getConnection(this.filePath);

            Recordset recordset = connection.executeQuery(query);
            this.createSuite(recordset);
        } catch (FilloException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }
@Test
    private void createSuite(Recordset recordset) {
        XmlMapper xmlMapper = new XmlMapper();
        Suite suite = new Suite("Create_TestNG_Suite_XML_From_Spreadsheet");
        try {
            while (recordset.next()) {

                String testName = recordset.getField("TestCaseDescription");
                String className = recordset.getField("ClassName");
                String param = "Data";
                String paramValue = recordset.getField("Data");

                suite.addTest(testName, param, paramValue, className);
            }
            xmlMapper.writeValue(new File("C:/Users/ahoss1/Desktop/testng-suite.xml"), suite);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            recordset.close();
        }
    }

/*public class XLSReader {
    //public static   Connection connection;
    @Test
  public void pawan() throws FilloException{
     
Fillo fillo=new Fillo();
Connection connection=fillo.getConnection("C:\\Users\\ahoss1\\Desktop\\Workspace_new\\Create_TestNG_Suite_XML_From_Spreadsheet\\TestCases.xls");
String strQuery="select * from Sheet1";
Recordset recordset=connection.executeQuery(strQuery);

while(recordset.next()){
    System.out.println(recordset.getField("Module"));
}

recordset.close();
connection.close();
      
  }*/

}