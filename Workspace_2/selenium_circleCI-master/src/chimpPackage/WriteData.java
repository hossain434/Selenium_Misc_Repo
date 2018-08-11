package chimpPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteData {
	//To write to excel file as single row
	public void writeToexcel(String filePath, String fileName, String sheetName, String[] dataToWrite) throws IOException
	{
		//System.out.println("File Path " + filePath + "\\" + fileName);
		File file = new File(filePath + "/" + fileName); 
		FileInputStream inputStream = new FileInputStream(file);
		Workbook BDExcelWorkbook = null;
		String fileExtensionName = fileName.substring(fileName.indexOf(".")); 
		if (fileExtensionName.equals(".xlsx")) 
		{	
			BDExcelWorkbook = new XSSFWorkbook(inputStream); 

		}
		Sheet sheet = BDExcelWorkbook.getSheet(sheetName);		
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum(); 
		//System.out.println(rowCount);
		Row row = sheet.getRow(0);
		//System.out.println("Row Last Cell num " + row.getLastCellNum());
		Row newRow = sheet.createRow(rowCount + 1); 
     	for (int j = 0; j < row.getLastCellNum(); j++)
		{ 
			Cell cell = newRow.createCell(j);// Fill data in row
			//System.out.println("Results " + dataToWrite[j]);
			cell.setCellValue(dataToWrite[j]);
			//System.out.println("Results " + dataToWrite[j]);

		}
		inputStream.close(); 
		FileOutputStream outputStream = new FileOutputStream(file);
		BDExcelWorkbook.write(outputStream);
		outputStream.close();
		BDExcelWorkbook.close();

	}
	//To write data to excel as bulk records
	public void writeToexcelasobject(String filePathwithFileName, String sheetName,Object[][] objExcelValues) throws FileNotFoundException, IOException
    {
				
		//System.out.println(" Reached Here to Write");   
		//filePathwithFileName= "C:/Test.xlsx";//name of excel file
     	//sheetName = "Sheet1";//name of sheet
		
		FileInputStream inputStream = new FileInputStream(filePathwithFileName);
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);
		wb.getSheet(sheetName);
		//wb.createSheet(sheetName);
		XSSFSheet sheet = wb.getSheet(sheetName);
		int lastrow=sheet.getLastRowNum();
		//System.out.println(" ** Lastrow position " + lastrow + " arraySize " + objExcelValues.length);
		lastrow++;
		int noOfrowsneeded=objExcelValues.length+lastrow;
		int rowcount=0;
		//System.out.println(" ** Total rows to create " + noOfrowsneeded);
		//iterating r number of rows
		for (int r=lastrow;r < noOfrowsneeded; r++ )
		{
			XSSFRow row = sheet.createRow(r);

			//iterating c number of columns
			String strInsertCellValue="";
			for (int c=0;c < objExcelValues[0].length; c++ )
			{
				XSSFCell cell = row.createCell(c);
				cell.setCellType(CellType.STRING);
				if(objExcelValues[rowcount][c]!=null)
					strInsertCellValue= objExcelValues[rowcount][c].toString();
				else
					strInsertCellValue="";	
				cell.setCellValue(strInsertCellValue);
				//cell.setCellValue("Cell "+r+" "+c);
				//System.out.print(" -- " + row.getCell(c) + " || " );
			}
			rowcount++;
		//	System.out.println("\n");
		}
		inputStream.close();
		//write this workbook to an Outputstream.
		FileOutputStream fileOut = new FileOutputStream(filePathwithFileName);
		wb.write(fileOut);
		fileOut.flush();
		fileOut.close();
		fileOut.close();
		wb.close();
	}
}
