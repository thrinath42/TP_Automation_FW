package practice.testng;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.listenerUtility.ListenerImplementationClass;
@Listeners(ListenerImplementationClass.class)
public class InvoiceTest extends BaseClass{
	
	@Test(retryAnalyzer = com.comcast.crm.listenerUtility.RetryListenerImp.class)
	public void createInvoiceTEst() {
		System.out.println("execute createInvoiceTEst");
		String actTitle=driver.getCurrentUrl();
		Assert.assertEquals(actTitle, "Login");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
		System.out.println("step-5");
	}
	
	@Test
	public void createInvoiceWithContact() {
		System.out.println("execute createInvoiceWithContact");
		System.out.println("execute createInvoiceTEst");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
		System.out.println("step-5");
	}

}
