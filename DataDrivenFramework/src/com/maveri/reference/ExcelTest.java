package com.maveri.reference;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Location- Read or Write
		//Open-excelworkbook
		//sheet-
		//row
		//cell
		
		//OpenExcelUtilis.getsheetData(XSSFSheet row, XSSFSheet cell);
		
		/*XSSFRow row="sheet".getRow(0);*/
		
		//XSSFCell cell=row.getCell(0);
		
		//String Value= cell.getStringCellValue();
		
		DataFormatter df= new DataFormatter();
		//String Value= df.formatCellValue(cell);
		
		//System.out.println(Value);
		
		
		

	}

}
