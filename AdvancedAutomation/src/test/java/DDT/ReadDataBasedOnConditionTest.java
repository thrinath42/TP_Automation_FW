package DDT;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataBasedOnConditionTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("C:\\Users\\Thrinath\\Documents\\Tek Pyramid\\ExternalResourceFiles\\testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);						
		Sheet sh = wb.getSheet("org");
		
		String expectedTestID="tc_03";
		String data1="";
		String data2="";
		String data3="";
		int rowCount=sh.getLastRowNum();
		boolean flag =false;			 //to inform users that expected testcase is available
		
		for(int i=0;i<=rowCount;i++) {
			String data="";				//every time refreshing data variable otherwise for every empty cell previous cell value will be printed
			try {
				data=sh.getRow(i).getCell(0).toString();	
				if (data.equals(expectedTestID)) {
					flag=true;
					data1=sh.getRow(i).getCell(1).toString();
					data2=sh.getRow(i).getCell(2).toString();
					data3=sh.getRow(i).getCell(3).toString();	
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
		}
		if (flag==true) {
			System.out.println(data1);
			System.out.println(data2);
			System.out.println(data3);
		}else {
			System.out.println(expectedTestID+" "+"data not available");
		}
		wb.close();
	}

}
