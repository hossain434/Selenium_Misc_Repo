//https://selenium-coding.blogspot.in/2016/05/generalized-apache-poi-script-for.html
package datadriven1;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ApachePOIMethods {

   public static Object[][] readFromXLSX(File scenarioFile) {
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

public static void writeTestResultToXLSX(File scenarioFile, String testCaseID, int cellNo, resultEnum rEnum) {
   FileInputStream fis;
   try {
   fis = new FileInputStream(scenarioFile);

   XSSFWorkbook workbook = (XSSFWorkbook) WorkbookFactory.create(fis);
   XSSFSheet sheet = workbook.getSheetAt(0);
   int rowNum = Integer.parseInt(testCaseID);
   Row row = sheet.getRow(rowNum);
   row.createCell(cellNo).setCellValue(rEnum.toString());
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
      e.printStackTrace();
      }
   }

public enum resultEnum {
   PASS, FAIL;
   }
}
