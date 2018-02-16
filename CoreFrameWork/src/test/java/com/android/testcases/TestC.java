package com.android.testcases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.android.base.BaseTest;
import com.android.util.DataUtil;
import com.android.util.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestC extends BaseTest {
	  public ExtentReports extent=ExtentManager.getInstance();
	  public ExtentTest test;
	String testCaseName="TestC";
	@Test(dataProvider="getData")
	public void TestC(Hashtable<String,String> data)
	{
		test=extent.startTest("TestC","Starting TestA");
		if(data.get("Runmode").equals("N"))
	throw new SkipException("Skipping TestC");
		System.out.println("TESTC");
		test.log(LogStatus.INFO, "In TestC");
		test.log(LogStatus.INFO,"Screeshotbelow"+test.addScreenCapture("C:\\report\\SS.png"));
	}

	@DataProvider
	public Object[][] getData(){
		
		return DataUtil.getData(xls,testCaseName);
		
	}
}
