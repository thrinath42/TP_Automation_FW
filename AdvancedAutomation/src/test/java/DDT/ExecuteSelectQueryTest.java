package DDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;



public class ExecuteSelectQueryTest {

	public static void main(String[] args) throws SQLException {
		Connection conn=null;
		
		try {
			//Step1 : load/register the DB driver
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			
			//Step2 : connect to Database
			conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root", "root");
			System.out.println("====Done====");
			
			//Step3 : create sql statement
			Statement stat = conn.createStatement();
			
			//Step4 : execute select query & get result
			ResultSet resultset= stat.executeQuery("select * from employee");
			while (resultset.next()) {
				System.out.println(resultset.getString(1)+"\t"+resultset.getString(2)+"\t"+resultset.getString(3)+"\t"+resultset.getString(4));
			}
		
		}catch (Exception e) {
			System.out.println("handle exception");
		}
		finally {
			//step5 : close the connection
			conn.close();
			System.out.println("====close the connection====");
		}
	}

}
