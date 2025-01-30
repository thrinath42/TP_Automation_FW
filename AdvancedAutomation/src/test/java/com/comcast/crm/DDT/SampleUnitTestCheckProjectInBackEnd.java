package com.comcast.crm.DDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class SampleUnitTestCheckProjectInBackEnd {
	
		@Test
		public void projectCheckTest() throws SQLException {
			String expectedProjectName="abhi";
			boolean flag=false;
			//Step1 : load/register the DB driver
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			
			//Step2 : connect to Database
			Connection conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root", "root");
			System.out.println("====Done====");
			
			//Step3 : create sql statement
			Statement stat = conn.createStatement();
			
			//Step4 : execute select query & get result
			ResultSet resultset= stat.executeQuery("select * from project");
			while (resultset.next()) {
				String ProjectName= resultset.getString(4);
				if (expectedProjectName.equals(ProjectName)) {
					flag=true;
					System.out.println(expectedProjectName+" is available==pass");
					}
			}
			if(flag==false) {
				System.out.println(expectedProjectName+" is not available==fail");
				Assert.fail();	//you need fail the test case watch video for this 
			}
			//step5 : close the connection
			conn.close();
			System.out.println("====close the connection====");
		}

}
