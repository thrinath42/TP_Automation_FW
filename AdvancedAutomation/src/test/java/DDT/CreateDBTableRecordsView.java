package DDT;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.mysql.jdbc.Driver;

public class CreateDBTableRecordsView {
	
	public static void main(String[] args) throws SQLException, EncryptedDocumentException, IOException {
	boolean Result=false;
		// Step1 : load/register the DB driver
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);

		// Step2 : connect to Database
		Connection conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root", "root");
		System.out.println("====Done====");

		// Step3 : create sql statement
		Statement stat = conn.createStatement();
		System.out.println("statement");

		// Step4 : execute select query & get result
		//Result = stat.execute("create database johnr8");
		System.out.println(Result);
		if (true) {
			stat.execute("use johnr4");
			boolean TResult = stat.execute(" create table LTT(id int,name varchar(45),occupation varchar(35),age  int)");
			System.out.println("inside db if");
			if (true) {
				FileInputStream fis = new FileInputStream("C:\\Users\\Thrinath\\Documents\\Tek Pyramid\\ExternalResourceFiles\\testscriptdata.xlsx");
				Workbook wb = WorkbookFactory.create(fis);
				Sheet sh = wb.getSheet("Sheet2");
				System.out.println("inside tabel if");
				int rowCount = sh.getLastRowNum();
				for (int i = 1; i <= rowCount; i++) {
					Row row = sh.getRow(i);// fetches each row
					int id = (int) row.getCell(0).getNumericCellValue();
					System.out.println(id);
					String name = row.getCell(1).getStringCellValue();
					System.out.println(name);
					String occupation = row.getCell(2).getStringCellValue();
					int age = (int) row.getCell(3).getNumericCellValue();
					stat.executeUpdate("INSERT INTO LTT(id,name,occupation,age) Values('1','Linus','Head','40')");
					System.out.println("inside for");
				}
			} else {
				System.out.println("Table not created");
			}
		}

		else {
			System.out.println("DataBase Not created");
		}
		// step5 : close the connection
		conn.close();
		System.out.println("====close the connection====");

	}

}
