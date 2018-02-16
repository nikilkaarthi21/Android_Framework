package com.android.testcases;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.Hashtable;
import java.util.List;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.android.base.BaseTest;
import com.android.util.DataUtil;
import com.android.util.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestB extends BaseTest{
	  public ExtentReports extent=ExtentManager.getInstance();
	  public ExtentTest test;
	String testCaseName="TestB";
	@Test(dataProvider="getData")
	public void TestB(Hashtable<String,String>data) throws FileNotFoundException, MalformedURLException, InterruptedException
	{
		test=extent.startTest("TestB","Starting TestB");
		if(!DataUtil.isTestRunnable(xls,"TestB") || data.get("Runmode").equals("N"))
			throw new SkipException("Skipping TetsB");
		System.out.println("TESTB");
		test.log(LogStatus.INFO, "In TESTB");
		test.log(LogStatus.INFO,"Screeshotbelow"+test.addScreenCapture("C:\\report\\SS.png"));
	         lauchApp();
	        click("member_id");
			type("email_id", "nikil.kaarthi@gmail.com");
			click("continue_id");
			type("pwd_id","7@oracle");
			click("submit_id");
			touch("icon_id");
			List<String>actualmenu=getmenuitemstestB();
			scrollandclicktestB("yourorder_xpath");
			click(data.get("Buyitagain"));	
			click(data.get("Addtocart"));
			click(data.get("Proceed"));
			//scroll();
			
		    //swipe("outerframe_id");
			//tap(data.get("shipping"));
		   // click(data.get("shipping_xpath"));

			//scrollandclicktestB("address_xpath");
			quitApp();	
		
	}
	
	@DataProvider
	public Object[][] getData(){
		
		return DataUtil.getData(xls,testCaseName);
		
	}
	@AfterMethod
	public void afterMethod()
	{
		extent.endTest(test);
		extent.flush();
	}

}
