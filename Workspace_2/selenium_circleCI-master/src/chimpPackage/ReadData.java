package chimpPackage;

import java.io.BufferedReader;
import java.io.File;


import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.FileInputStream;
import java.io.FileReader;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadData {
	//To read data from excel sheet
	public String[][] readFromexcel(String filePath, String fileName, String tabName) throws IOException
	{
		File file = new File(filePath + "/" + fileName);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook ReadExcel = null;
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		if (fileExtensionName.equals(".xlsx")) {
			ReadExcel = new XSSFWorkbook(inputStream);
		} 
		//	System.out.println(sheetName);
		//System.out.println(file.getAbsolutePath() +" Sheet Name is-" + sheetName+"-");
		Sheet excelSheet = ReadExcel.getSheet(tabName);
		int rowCount = excelSheet.getLastRowNum() - excelSheet.getFirstRowNum();
		String[][] arrayExcelData = null;
		// Create a loop over all the rows of excel file to read it
		arrayExcelData = new String[rowCount][];
		for (int i = 1; i < rowCount + 1; i++) {
			int index = i - 1;
			Row row = excelSheet.getRow(i);
			arrayExcelData[index] = new String[row.getLastCellNum()];
			for (int j = 0; j < row.getLastCellNum(); j++) {

				//System.out.print(index + "|| " + j);
				try {
					row.getCell(j).setCellType(CellType.STRING);
					if(row.getCell(j) != null){
						arrayExcelData[index][j] = row.getCell(j).getStringCellValue();
					}
						
				//	System.out.print(">> " + arrayExcelData[index][j] + "|| ");
				}
				catch(NullPointerException NPE){
					arrayExcelData[index][j] = "";
				}
				catch (Exception e) {
					System.out.println(e.toString());
				}
			}
		}
		ReadExcel.close();
		inputStream.close();
		
		return arrayExcelData;
	}

	public String[][] readFromcsv(String filePath, String fileName) throws IOException
	{
	    List <List<String>> arrayValues=new ArrayList<List<String>>();
        File file = new File(filePath + "/" + fileName);
        BufferedReader bufRdr  = new BufferedReader(new FileReader(file.toString()));
        String line = null;
        //read each line of text file
        while((line = bufRdr.readLine()) != null)
        {
            StringTokenizer st = new StringTokenizer(line,",");
            List<String> rowValues = new ArrayList<String>();
            while (st.hasMoreTokens())
            {
            	//get next token and store it in the array
            	rowValues.add(st.nextToken());
            }
            arrayValues.add(rowValues);
        }
        //close the file
        bufRdr.close();
        //Removing the header from the arraylist
        arrayValues.remove(0);
      //Converting to a two dimensional string array
        String[][] array = new String[arrayValues.size()][];
        int intCounter = 0;
        for (List<String> nestedList : arrayValues) {
            array[intCounter++] = nestedList.toArray(new String[nestedList.size()]);
        }
        
        for(int k=0;k<array.length;k++){
        	for (int m=0;m<array[k].length;m++){
        		System.out.print(array[k][m]);
        	}
        	System.out.println();
        }
        return array;
		}
		
}
