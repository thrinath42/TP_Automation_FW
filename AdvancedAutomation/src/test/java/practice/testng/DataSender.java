package practice.testng;


import org.testng.annotations.DataProvider;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class DataSender {
	
	@DataProvider
	public Object[][] getProductData() throws Exception {
		ExcelUtility eu = new ExcelUtility();
		int rowCount = eu.getRowCount("amazonProduct");
		Object[][] ar = new Object[rowCount][2];
		
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < 2; j++) {
				ar[i][j] = eu.getDataFromExcel("amazonProduct", i+1, j);
			}
		}
		
		return ar;
	}
}
