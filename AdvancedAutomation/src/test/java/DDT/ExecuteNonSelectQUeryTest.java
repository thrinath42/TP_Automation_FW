package DDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ExecuteNonSelectQUeryTest {

	public static void main(String[] args) throws SQLException {
		//Step1 : load/register the DB driver
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		//Step2 : connect to Database
		Connection conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root", "root");
		System.out.println("====Done====");
		
		//Step3 : create sql statement
		Statement stat = conn.createStatement();
		
		//Step4 : execute select query & get result
		int Result = stat.executeUpdate("insert into project values('TY_Proj_2028','Thrinath2','04/27/2024','fbi3','On Going','1100'),('TY_Proj_2127','Mark','04/27/2024','fbi5','On Going','170');");
		System.out.println(Result);
		
		//step5 : close the connection
		conn.close();
		System.out.println("====close the connection====");

	}

}
