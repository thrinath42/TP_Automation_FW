package DDT;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
			FileInputStream fis=new FileInputStream("C:\\Users\\Thrinath\\Documents\\Tek Pyramid\\ExternalResourceFiles\\testscriptdata.xlsx");
			Workbook wb = WorkbookFactory.create(fis);						
			Sheet sh = wb.getSheet("Sheet1");
			
			int rowCount=sh.getLastRowNum();
			for(int i=1;i<=rowCount;i++) {
				
			Row row = sh.getRow(i);//fetches each row
			
			String brand = row.getCell(0).toString();
			String Model=row.getCell(1).toString();
			
			System.out.println(brand+"\t"+Model);
			}
			wb.close();
	}

}
