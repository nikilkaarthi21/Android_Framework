package com.USICS.testcases;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.USICS.base.BaseTest;
import com.USICS.util.DataUtil;
import com.USICS.util.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class videos extends BaseTest{
	public ExtentReports extent=ExtentManager.getInstance();
	  public ExtentTest test;
	  private SoftAssert softAssert=new SoftAssert();
	  String testCaseName="TestB";
	  
	@Test(dataProvider="getData")
	public void TestC(Hashtable<String,String>data) throws FileNotFoundException, MalformedURLException, InterruptedException
	{
		 String Actualresult="passed";
		test=extent.startTest("TestC","Starting TestC");
		if(!DataUtil.isTestRunnable(xls,"TestC") || data.get("Runmode").equals("N"))
			throw new SkipException("Skipping TestC");
		System.out.println("TESTC");
		test.log(LogStatus.INFO, "In TESTC");
		test.log(LogStatus.INFO,"Screeshotbelow"+test.addScreenCapture("C:\\report\\SS.png"));
		lauchApp();
	//	dr.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		//type("casestatus_id","LIN1790226753");
		click("region_xpath");
		/*List<String>actualmenu=getmenuitems();
		for(int i=0;i<actualmenu.size();i++ )
		{
		System.out.println(actualmenu.get(i));
		}*/
		
		 scrollandclick("videos_xpath");
		// click(data.get("Index"));
		 
		/*  List<String>expmenu=getmenuitemstestB();
			for(int i=0;i<expmenu.size()-1;i++ )
			{
			System.out.println(expmenu.get(i));
			}*/
	
		getvideoitems();
		 Thread.sleep(5000);
		//click("MERVAL_xpath");
		//click("Steven Mnuchin");
		// takeScreenshot();
		//	quitApp();
		
/*	List<String>expmenu=getmenuitemstestB();
	for(int i=0;i<expmenu.size();i++ )
	{
		System.out.println(expmenu.get(i));
		}
		
		scrollandclicktestB(data.get("NEWS_CLICK"));
	*/	
	
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




