package practice.testng;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class SampleTestForScreenShot {
	
	@Test
	public void amazonTest() throws IOException {
		WebDriver driver=new EdgeDriver();
		driver.get("https://www.amazon.in/");
		
		//step1=create an object to EventFiring Webdriver
//		EventFiringWebDriver edriver=new EventFiringWebDriver(driver);    		This will work with only sel 4.12.0
		
		//step2=use getscreenshotas method to get file type of screenshot
//		File srcFile = edriver.getScreenshotAs(OutputType.FILE);
		
		//step3=store screen on local driver
//		FileUtils.copyFile(srcFile, new File("./Screenshots/test.png"));
	}

}
