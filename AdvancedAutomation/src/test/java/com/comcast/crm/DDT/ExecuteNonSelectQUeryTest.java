package com.comcast.crm.DDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.mysql.jdbc.Driver;

public class ExecuteNonSelectQUeryTest {

	public static void main(String[] args) throws SQLException {
//		//Step1 : load/register the DB driver
//		Driver driverRef = new Driver();
//		DriverManager.registerDriver(driverRef);
//		
//		//Step2 : connect to Database
//		Connection conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root", "root");
//		System.out.println("====Done====");
//		
//		//Step3 : create sql statement
//		Statement stat = conn.createStatement();
//		
//		//Step4 : execute select query & get result
//		int Result = stat.executeUpdate("insert into project values('TY_Proj_2026','Thrinath','04/27/2024','fbi1','On Going','100');");
		DataBaseUtility dLib=new DataBaseUtility();
		dLib.getDbConnection();
		int Result = dLib.executeNonSelectQuery("insert into project values('TY_Proj_2027','Thrinath','04/27/2024','fbi2','On Going','100');");
		
		System.out.println(Result);
		
		//step5 : close the connection
		dLib.closeDbConnection();
		System.out.println("====close the connection====");

	}

}
