package practice.testng;

import org.testng.annotations.DataProvider;

import com.comcast.crm.generic.webdriverutility.JavaUtility;

public class ProductData {
	JavaUtility jLib=new JavaUtility();
	@DataProvider
	public Object[][] fetchData(){
	Object[][] obj= {{"snapdeal"+jLib.getRandomNumber(),89745623l,},
					 {"myntra"+jLib.getRandomNumber(),444558444l},
					 {"ajio"+jLib.getRandomNumber(),785552233l}};
	return obj;
}
@DataProvider
public Object[][] fetchDataComm(){

Object[][] obj= {{"snapdeal"+jLib.getRandomNumber(),89745623l,"18"},
				 {"myntra"+jLib.getRandomNumber(),444558444l,"18"},
				 {"ajio"+jLib.getRandomNumber(),785552233l,"14"}};
return obj;
}}

