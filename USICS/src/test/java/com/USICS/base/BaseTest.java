package com.USICS.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.util.Strings;

import com.USICS.util.Xls_Reader;
import com.USICS.util.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BaseTest {
	public Xls_Reader xls = new Xls_Reader("C:\\Users\\nikil kaarthi\\Downloads\\CoreFrameWork\\Data.xlsx");
	public Properties pr;
	public AndroidDriver adr;
	public WebDriver dr;
	public ExtentReports extent=com.USICS.util.ExtentManager.getInstance();
	  public ExtentTest test;
	
	public void lauchApp() throws FileNotFoundException, MalformedURLException, InterruptedException
	{
		if(pr==null)
		{
			 pr=new Properties();
			//String path=System.getProperty("user.dir")+"\\src\\test\\resources\\project.properties";
			try{
			 FileInputStream fs=new FileInputStream("C:\\Users\\nikil kaarthi\\Downloads\\USICS\\src\\test\\java\\com\\USICS\\resources\\pro.properties");
			//FileInputStream fs= new FileInputStream(path);
				pr.load(fs);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(pr.getProperty("application"));
			
		  File app = new File(pr.getProperty("apkfilepath"));
			DesiredCapabilities capabilities = new DesiredCapabilities();
			//DesiredCapabilities capabilities = DesiredCapabilities.android();
			capabilities.setCapability("deviceName", pr.getProperty("device"));
			capabilities.setCapability("platformVersion",pr.getProperty("platform"));
			capabilities.setCapability("platformName", pr.getProperty("platformN"));
			//capabilities.setCapability(CapabilityType.BROWSER_NAME,"Chrome");
			//capabilities.setCapability("autoWebview",true);
		   capabilities.setCapability("app", app.getAbsolutePath());
			//capabilities.setCapability("appPackage", "com.cnbc.client");
			//capabilities.setCapability("appActivity","com.cnbc.client.Home.HomeActivity");
			
				dr = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);	
				
				//dr.get("https://egov.uscis.gov/");
				//System.out.println(dr.getPageSource());
				Thread.sleep(5000);
				//JavascriptExecutor js=(JavascriptExecutor)dr;
				//String UA=(String)dr.executeScript("return navigator.userAgent");
				//System.out.println(UA);
				//Thread.sleep(5000);
	     	}
		
	}

	public void click(String locator) throws InterruptedException
	{
		getAndroidElement(locator).click();
		Thread.sleep(7000);
	}
	
	public void Webclick(String locator) throws InterruptedException
	{
		getWebElement(locator).click();
		Thread.sleep(7000);
	}
	public void tap(String locator) throws InterruptedException
	{
		WebElement e3=( WebElement) dr.findElement(By.xpath(pr.getProperty(locator)));;
		   TouchAction tap1=new TouchAction((MobileDriver)dr);
		   tap1.tap(e3).perform();
    }
	
  public void touch(String locator)
  {
	  getAndroidElement(locator).tap(1,1000);
  }
 
  public void swipe(String Locator) throws InterruptedException
	{
	    System.out.println("IN SWIPE");
		   AndroidDriver<AndroidElement> aDriver =(AndroidDriver<AndroidElement>)dr;
	       AndroidElement  menulist=aDriver.findElement(By.id(pr.getProperty(Locator)));
	        Thread.sleep(5000);
			int startx=menulist.getLocation().x;
			int endy=menulist.getLocation().y;	
		   aDriver.swipe(startx,500, 500, endy,1000);
		   Thread.sleep(5000);
			   
	}
  
  public void scroll() throws InterruptedException
 	{
 	 System.out.println("IN SCROLL");
 		   AndroidDriver<AndroidElement> aDriver =(AndroidDriver<AndroidElement>)dr;
 		 aDriver.findElementByAndroidUIAutomator("Uiscrollable(UiSelector().resourceId(\"com.cnbc.client:id/news_item_layout\")");
 		 aDriver.getPageSource();
 		// aDriver.findElementByAndroidUIAutomator("Uiscrollable(UiSelector().index(0)");
 	     //  AndroidElement  menulist=aDriver.findElement(By.xpath(pr.getProperty(Locator)));
 	       
 		 // aDriver.scrollTo("Locator");
 		  Thread.sleep(5000);
 			   
 	}
   
	public void type(String locator,String data) throws InterruptedException
	{
		getAndroidElement(locator).sendKeys(data);
		Thread.sleep(5000);
	}
	
	
	public boolean isElementPresent(String locator)
	{
		return false;
	
	}
	
	public boolean VerifyText(String locator)
	{
	return false;	
	}
	public void quitApp()
	{
		if(dr!=null)
		{
			dr.quit();
		}
	}

	public AndroidElement getAndroidElement(String Locator)
	{
		AndroidElement e=null;
		AndroidDriver<AndroidElement> adriver =(AndroidDriver<AndroidElement>)dr;
		
		 try
		 {
		System.out.println("LOCATOR IS"+Locator);	
		
		if(Locator.endsWith("_id"))
		{
			System.out.println("IN IF LOOP");
			Thread.sleep(2000);
			e=adriver.findElement(By.id((pr.getProperty(Locator))));
		}
		else if(Locator.endsWith("_xpath"))
		{
			System.out.println("IN IF LOOP");
			Thread.sleep(5000);
			e=adriver.findElement(By.xpath((pr.getProperty(Locator))));
			System.out.println(e);

		}
			else
			{
				System.out.println("element not found");
			}
	
		}catch(Exception ex)
		{

		}
		return e;
	
		
	}
	
	
	public WebElement getWebElement(String Locator)
	{
		WebElement e=null;
		WebElement adriver =(WebElement)dr;
		
		 try
		 {
		System.out.println("LOCATOR IS"+Locator);	
		
		if(Locator.endsWith("_id"))
		{
			System.out.println("IN IF LOOP");
			Thread.sleep(2000);
			e=adriver.findElement(By.id((pr.getProperty(Locator))));
		}
		else if(Locator.endsWith("_xpath"))
		{
			System.out.println("IN IF LOOP");
			Thread.sleep(5000);
			e=adriver.findElement(By.xpath((pr.getProperty(Locator))));
			System.out.println(e);

		}
			else
			{
				System.out.println("element not found");
			}
	
		}catch(Exception ex)
		{

		}
		return e;
	
		
	}
	
	public List<String> getmenuitems()
	{
	List<String> items=new ArrayList<String>();
	List<WebElement> menulist=dr.findElements(By.id(pr.getProperty("drawer_id")));
	int waitcount=1;
	for(WebElement menu:menulist)
	{
		System.out.println(menu.getText());
		items.add(menu.getText());
	}
	while(true)
	{
	String FirstElement=menulist.get(menulist.size()-1).getText();
	//System.out.println("FIRST ELEMENT iS"+menulist.get(menulist.size()-1).getText());
	AndroidDriver<AndroidElement> aDriver =(AndroidDriver<AndroidElement>)dr;
	int starty=menulist.get(0).getLocation().y;
	int endy=menulist.get(menulist.size()-1).getLocation().y;	
    aDriver.swipe(300, starty, 300, endy,1000);;
  //  menulist=dr.findElements(By.id("com.amazon.mShop.android.shopping:id/drawer_item_title"));
	String Lastelement=menulist.get(menulist.size()-1).getText();
	//System.out.println("LAST ELEMENT iS"+menulist.get(menulist.size()-1).getText());	
	/*	if(Lastelement.equals(FirstElement))
		{
			if(waitcount==4)
			{
				break;
			
			}
			waitcount++;
		}
		else
		{
			System.out.println(Lastelement);
			waitcount=1;
			
		}
		
	}*/
	return items;
	}
	}
	
	
	public List<String> getmenuitemstestB()
	{
	List<String> items=new ArrayList<String>();
	List<WebElement> menulist=dr.findElements(By.id(pr.getProperty("symbol_id")));
	int waitcount=1;
	for(WebElement menu:menulist)
	{
		//System.out.println(menu.getText());
		items.add(menu.getText());
	}
	while(true)
	{
	String FirstElement=menulist.get(0).getText();
	//System.out.println("FIRST ELEMENT iS"+menulist.get(menulist.size()-1).getText());
	AndroidDriver<AndroidElement> aDriver =(AndroidDriver<AndroidElement>)dr;
	int startx=menulist.get(0).getLocation().getX();
	int starty=menulist.get(menulist.size()-1).getLocation().getY();	
   aDriver.swipe(startx, 300,300,starty,1000);
   
    menulist=dr.findElements(By.id("com.cnbc.client:id/txtSymbolID"));
	String Lastelement=menulist.get(menulist.size()-1).getText();
	System.out.println("LAST ELEMENT iS"+menulist.get(menulist.size()-1).getText());	
	//if(Lastelement.equals(FirstElement))
	//	{
			/*if(waitcount==4)
			{
				break;
			
			}
			waitcount++;
		}*/
		//else
	//	{
		//	System.out.println(Lastelement);
			//waitcount=1;
			
		//}
		//menulist.get(menulist.size()-1).click();
	}
		
	}
	//return items;
//	}
//	}
	
	
	public void scrollandclick(String Locator)
	{
		
	WebElement menulist=dr.findElement(By.xpath(pr.getProperty(Locator)));
	menulist.click();
	}
		/*for(WebElement menu:menulist)
		{
			if(menu.getText().equals(pr.getProperty(Locator)))
			{
				menu.click();
			}
			else
			{
				while(true)
				{
			//	String FirstElement=menulist.get(0).getText();
				AndroidDriver<AndroidElement> aDriver =(AndroidDriver<AndroidElement>)dr;
			    //List<WebElement> menulist=dr.findElements(By.xpath(pr.getProperty(Locator)));
				int starty=menulist.get(0).getLocation().y;
				int endy=menulist.get(menulist.size()-1).getLocation().y;	
			    aDriver.swipe(500, starty, 500, endy,1000);
			      menulist=dr.findElement(By.id(pr.getProperty(Locator)));
			   // String Lastelement=menulist.get(menulist.size()-1).getText();
				System.out.println("LAST ELEMENT iS"+menulist.get(menulist.size()-1).getText());	
			  //  if(Lastelement.equals(menulist))
			  {
			    	 menulist.get(menulist.size()).click();
			    	  return;
					 // aDriver.manage().timeouts().implicitlyWait(5000,TimeUnit.SECONDS); 
					
			  }
				
				}
			}
			
		}*/

	public void scrollandclicktestB() throws InterruptedException
	{
		List<String> items=new ArrayList<String>();
		List<WebElement> menulist=dr.findElements(By.id(pr.getProperty("symbol_id")));
		int waitcount=1;
		for(WebElement menu:menulist)
		{
			//System.out.println(menu.getText());
			items.add(menu.getText());
		}
		while(true)
		{
			//Thread.sleep(5000);
			
		//String FirstElement=menulist.get(0).getText();
		String Lastelement=menulist.get(menulist.size()-1).getText();
		//System.out.println("FIRST ELEMENT iS"+menulist.get(menulist.size()-1).getText());
	    AndroidDriver<AndroidElement> aDriver =(AndroidDriver<AndroidElement>)dr;
		int startx=menulist.get(0).getLocation().getX();
		int starty=menulist.get(menulist.size()-1).getLocation().getY();	
	    aDriver.swipe(startx, 300,300,starty,1000);
	  // menulist=dr.findElements(By.id(pr.getProperty("symbol_id")));
		Thread.sleep(3000);
		
	
		//System.out.println("LAST ELEMENT iS"+menulist.get(menulist.size()-1).getText());	
	if(Lastelement.equals(pr.getProperty("MERVAL_xpath")))
			{
			if(waitcount==4)
				{
					break;
				
				}
				waitcount++;
				Thread.sleep(3000);
				menulist.get(menulist.size()-1).click();
				Thread.sleep(3000);
			
			}
			
			else
			{
			System.out.println(Lastelement);
			Thread.sleep(3000);
				click("MERVAL_xpath");
				
			}
	return;
		}
		}
		
	
	public void getvideoitems() throws InterruptedException
	{
	List<String> items=new ArrayList<String>();
	List<WebElement> menulist=dr.findElements(By.id(pr.getProperty("play_id")));
	int waitcount=1;
	for(WebElement menu:menulist)
	{
		System.out.println(menu.getText());
		items.add(menu.getText());
	}
	while(true)
	{
		String Lastelement=menulist.get(menulist.size()-1).getText();
	//String FirstElement=menulist.get(0).getText();
	//System.out.println("FIRST ELEMENT iS"+menulist.get(menulist.size()-1).getText());
	AndroidDriver<AndroidElement> aDriver =(AndroidDriver<AndroidElement>)dr;
	int startx=menulist.get(0).getLocation().getX();
	int starty=menulist.get(menulist.size()-1).getLocation().getY();	
     aDriver.swipe(startx,300,starty,300,1000);
   
   // menulist=dr.findElements(By.id("com.cnbc.client:id/txtSymbolID"));
	
	System.out.println("LAST ELEMENT iS"+menulist.get(menulist.size()-1).getText());	
	if(Lastelement.equals(pr.getProperty("item_xpath")))
		{
		menulist.get(menulist.size()-1).click();
		Thread.sleep(3000);
	
	}
	
	else
	{
	System.out.println(Lastelement);
	Thread.sleep(3000);
		click("item_xpath");
		
	}
	
return;
	}
}


			
	public void takeScreenshot(){
		Date d = new Date();
		
		String screenshotFile=d.toString().replace(":", "_").replace(" ","_")+".png";

		File scrFile = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("C://Reports//screenshots//"+screenshotFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(LogStatus.INFO,"Snapshot below: ("+screenshotFile+")"+
				 test.addScreenCapture(System.getProperty("C://Reports//screenshots//"+screenshotFile)));
	}
}


	
