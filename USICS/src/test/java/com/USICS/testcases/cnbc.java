package com.USICS.testcases;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.USICS.base.BaseTest;
import com.USICS.util.DataUtil;
import com.USICS.util.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class cnbc extends BaseTest{
	
 
	  public ExtentReports extent=ExtentManager.getInstance();
	  public ExtentTest test;
	  private SoftAssert softAssert=new SoftAssert();
	  String testCaseName="TestA";
	  
	@Test(dataProvider="getData")
	public void TestA(Hashtable<String,String>data) throws FileNotFoundException, MalformedURLException, InterruptedException
	{
		 String Actualresult="passed";
		test=extent.startTest("TestA","Starting TestA");
		if(!DataUtil.isTestRunnable(xls,"TestA") || data.get("Runmode").equals("N"))
			throw new SkipException("Skipping TetsA");
		System.out.println("TESTA");
		test.log(LogStatus.INFO, "In TESTA");
		test.log(LogStatus.INFO,"Screeshotbelow"+test.addScreenCapture("C:\\report\\SS.png"));
		lauchApp();
	//	dr.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		//type("casestatus_id","LIN1790226753");
		click("region_xpath");
		click("arrow_id");
		click("arrow_id");
		click("done_id");
		/*List<String>actualmenu=getmenuitems();
		for(int i=0;i<actualmenu.size();i++ )
		{
		System.out.println(actualmenu.get(i));
		}*/
		
		 scrollandclick(data.get("News"));
		 
		// Thread.sleep(5000);
		//List<String>expmenu=getmenuitemstestB();
		//List<String>expmenu=getmenuitemstestB();
		//for(int i=0;i<expmenu.size()-1;i++ )
		//{
	//	System.out.println(expmenu.get(i));
	//	}
		
		//scrollandclicktestB("lay_id");
		//scrollandclicktestB("layout_xpath");
		Thread.sleep(5000);
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
