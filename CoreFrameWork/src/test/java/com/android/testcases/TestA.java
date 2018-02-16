package com.android.testcases;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;
import java.util.List;

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

import com.android.base.BaseTest;
import com.android.util.DataUtil;
import com.android.util.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class TestA extends BaseTest{
	
 
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
		click("member_id");
		type("email_id", "nikil.kaarthi@gmail.com");
		click("continue_id");
		type("pwd_id","7@oracle");
		click("submit_id");
		touch("icon_id");
		List<String>actualmenu=getmenuitems();
		String temp[]= data.get("Expectedmenu").split("\\|");
		
		for(int i=0;i<actualmenu.size();i++ )
		{
		System.out.println(actualmenu.get(i)+temp[i]);
		softAssert.assertEquals(actualmenu.get(i),temp.length);
		}
	/*	try
		{
		//softAssert.assertAll();
		test.log(LogStatus.PASS,"test passed");
		}catch(Exception ex){
		test.log(LogStatus.FAIL,ex.getMessage());
		*/
		scrollandclick("scroll");
		
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
