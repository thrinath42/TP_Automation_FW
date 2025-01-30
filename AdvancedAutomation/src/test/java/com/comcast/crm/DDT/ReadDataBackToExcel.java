package com.comcast.crm.DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class ReadDataBackToExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
//		FileInputStream fis=new FileInputStream("C:\\Users\\Thrinath\\Documents\\Tek Pyramid\\ExternalResourceFiles\\testscriptdata.xlsx");
//		Workbook wb = WorkbookFactory.create(fis);						
//		Sheet sh = wb.getSheet("org");
//		Row row = sh.getRow(1);
//		Cell cel = row.createCell(4);
//		cel.setCellType(CellType.STRING);			//mention type of data you want to pass
//		cel.setCellValue("Pass"); 					//data you want to pass
//		//to save the data written open the excel in write mode and get object of write mode
//		FileOutputStream fos=new FileOutputStream("C:\\\\Users\\\\Thrinath\\\\Documents\\\\Tek Pyramid\\\\ExternalResourceFiles\\\\testscriptdata.xlsx");
//		wb.write(fos);								//using write method saving the program
//		wb.close();
//		System.out.println("Program got executed");
		
		ExcelUtility eUtil=new ExcelUtility();
		eUtil.setDataIntoExcel("product", 6, 1, "DBUtilityTestextended");
		
		

	}

}
