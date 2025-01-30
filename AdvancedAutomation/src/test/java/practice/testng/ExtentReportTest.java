package practice.testng;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportTest {
	
	@Test
	public void createContactTest() {
		//spark report config
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.STANDARD);
		
		//add Environment information and create Test
		ExtentReports report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("operating system", "Windows 11");
		report.setSystemInfo("Browser", "chrome B405");
		ExtentTest test = report.createTest("create COntact TEst");
		
		test.log(Status.INFO, "Login to app");
		test.log(Status.INFO, "Navigate to contact page");
		test.log(Status.INFO, "Create COntact");
		if ("HDFC".equals("HDFC")) 
			test.log(Status.INFO, "Contact is created");
		else
		test.log(Status.INFO, "Contact not created");
		
		report.flush();
	}

}
