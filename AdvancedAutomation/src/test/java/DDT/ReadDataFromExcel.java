package DDT;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
			//Step 1: get the excel path location and java object of physcial excel file
					FileInputStream fis=new FileInputStream("C:\\Users\\Thrinath\\Documents\\Tek Pyramid\\ExternalResourceFiles\\testscriptdata.xlsx");
			
			//Step 2: open workbook in read mode
					Workbook wb = WorkbookFactory.create(fis);
			//Step 3: get the control of the "org" sheet
					Sheet sh = wb.getSheet("org");
			//Step 4: get the control of the "1st" Row
					Row row = sh.getRow(1);
			//Step 5: get the control of the 2nd cell and read the string data
//					Cell cell = row.getCell(2);
//					String data=cell.getStringCellValue();
			//method chaining
					String data = row.getCell(3).getStringCellValue();
					System.out.println(data);
					 String data1 = row.getCell(3).toString(); //even though string data present in excel it will be converted to string
					System.out.println(data1);
			//Step 6: close the workbook
					wb.close();
	}

}
