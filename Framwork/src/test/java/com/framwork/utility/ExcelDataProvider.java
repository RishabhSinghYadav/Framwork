package com.framwork.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {//for taking excel data we have to add apache POI dependency.
	
	 XSSFWorkbook wb;
	public ExcelDataProvider() {//when we call object this constructor will load the file automatically.
		
		File src = new File("./TestData/Data.xlsx");
		
		try {
			FileInputStream fis= new FileInputStream(src);
			
			wb=new XSSFWorkbook(fis);
			
		} catch (Exception e) {
			
			System.out.println("unable to read excel file "+e.getMessage());
					 
		}
		}
	//Below mathod overloading happening same name different parameters
	
	public String getStringData(int sheetName, int row,int colomn) {//it will work on index of excelsheet
		return wb.getSheetAt(sheetName).getRow(row).getCell(colomn).getStringCellValue();
	}
	
	public String getStringData(String sheetName, int row,int colomn) {//for string value
		return wb.getSheet(sheetName).getRow(row).getCell(colomn).getStringCellValue();
	}
	
	public Double getNumaricdata(String sheetName, int row,int colomn) {//for numaric value
		return wb.getSheet(sheetName).getRow(row).getCell(colomn).getNumericCellValue();
		
		
	}
	}


