package com.comcast.crm.DDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.mysql.jdbc.Driver;

public class CreateProjectAndVerifyDataInDBWithGUI {

	public static void main(String[] args) throws InterruptedException, SQLException {
				String ProjectName="Ins_002";
				Boolean flag=false;
				WebDriver driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("http://49.249.28.218:8091/");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
								
				driver.findElement(By.id("username")).sendKeys("rmgyantra");
				driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
				driver.findElement(By.xpath("//button[text()='Sign in']")).click();
				
				driver.findElement(By.linkText("Projects")).click();
				driver.findElement(By.xpath("//span[text()='Create Project']")).click();
				
				driver.findElement(By.name("projectName")).sendKeys(ProjectName);
				driver.findElement(By.name("createdBy")).sendKeys("Rohit");
				WebElement select = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
				Select sel=new Select(select);
				Thread.sleep(2000);
				sel.selectByIndex(1);
				driver.findElement(By.xpath("//input[@type='submit']")).click();
				
				DataBaseUtility dLib=new DataBaseUtility();
				dLib.getDbConnection();
				ResultSet resultset = dLib.executeSelectQuery("select * from project");
				
//				//Step1 : load/register the DB driver
//				Driver driverRef = new Driver();
//				DriverManager.registerDriver(driverRef);
//				
//				//Step2 : connect to Database
//				Connection conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root", "root");
//				System.out.println("====Done====");
//				
//				//Step3 : create sql statement
//				Statement stat = conn.createStatement();
				
				//Step4 : execute select query & get result
//				ResultSet resultset= stat.executeQuery("select * from project");
				while (resultset.next()) {
					String ActualProjectName= resultset.getString(4);
					if (ProjectName.equals(ActualProjectName)) {
						flag=true;
						System.out.println(ProjectName+" is available==pass");
						}
				}
				if(flag==false) {
					System.out.println(ProjectName+" is not available==fail");
					Assert.fail();	//you need fail the test case watch video for this 
				}
				//step5 : close the connection
				dLib.closeDbConnection();
				System.out.println("====close the connection====");
	}

}
