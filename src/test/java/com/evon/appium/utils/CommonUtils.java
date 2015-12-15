package com.evon.appium.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;





import com.evon.appium.utils.CommonUtils;

public class CommonUtils {

	private static Properties prop = new Properties();
	public static int EXPLICIT_WAIT_TIME;
	public static int IMPLICIT_WAIT_TIME;
	public static int DEFAULT_WAIT_TIME;
	public static String APPLICATION_NAME;
	public static String BASE_PKG;
	public static String APP_ACTIVITY;
	public static String APP_PASSWORD;
	private static String APPIUM_PORT;
	public static String AUTOMATION_INSTRUMENTATION;
	public static String BROWSER_NAME;
	public static String PLATFORM_NAME;
	public static String NEW_COMMAND_TIMEOUT;
	public static String PLATFORM_VERSION;
	public static String DEVICE_READY_TIMEOUT;
	public static String DEVICE_NAME;
	private static DesiredCapabilities capabilities = new DesiredCapabilities();
	private static URL serverUrl;
	private static AndroidDriver driver;
	final static String USER_DIR = System.getProperty("user.dir");
	public static String mailscreenshotpath;
	 
	
	public static void loadConfigProp(String propertyFileName) throws IOException{
		FileInputStream fis = new FileInputStream(USER_DIR.replace("\\target","")+"\\src\\test\\resources\\properties\\"+propertyFileName);
		prop.load(fis);

		EXPLICIT_WAIT_TIME = Integer.parseInt(prop.getProperty("explicit.wait"));
		System.out.println("EXPLICIT_WAIT_TIME: " + EXPLICIT_WAIT_TIME);
		IMPLICIT_WAIT_TIME = Integer.parseInt(prop.getProperty("implicit.wait"));
		System.out.println("IMPLICIT_WAIT_TIME: "+ IMPLICIT_WAIT_TIME);
		DEFAULT_WAIT_TIME = Integer.parseInt(prop.getProperty("default.wait"));
		System.out.println("DEFAULT_WAIT_TIME: "+ DEFAULT_WAIT_TIME);
		//APPLICATION_NAME = prop.getProperty("application.path");
		System.out.println("APPLICATION_NAME: "+ APPLICATION_NAME);
		BASE_PKG = prop.getProperty("base.pkg");
		System.out.println("BASE_PKG: "+ BASE_PKG);
		APP_ACTIVITY = prop.getProperty("application.activity");
		System.out.println("APP_ACTIVITY: "+ APP_ACTIVITY);
		APPIUM_PORT = prop.getProperty("appium.server.port");
		System.out.println("APPIUM_PORT: "+ APPIUM_PORT);
		AUTOMATION_INSTRUMENTATION=prop.getProperty("automation.instumentation");
		System.out.println("AUTOMATION_INSTRUMENTATION: " + AUTOMATION_INSTRUMENTATION);
		DEVICE_NAME=prop.getProperty("device.name");
		System.out.println("DEVICE_NAME: "+ DEVICE_NAME);
		//BROWSER_NAME=prop.getProperty("browser.name");
		System.out.println("BROWSER_NAME: "+ BROWSER_NAME);
		PLATFORM_NAME=prop.getProperty("platform.name");
		System.out.println("PLATFORM_NAME: "+ PLATFORM_NAME);
		PLATFORM_VERSION=prop.getProperty("platform.version");
		System.out.println("PLATFORM_VERSION: " + PLATFORM_VERSION);
		NEW_COMMAND_TIMEOUT=prop.getProperty("new.command.timeout");
		System.out.println("NEW_COMMAND_TIMEOUT: " + NEW_COMMAND_TIMEOUT);
		DEVICE_READY_TIMEOUT=prop.getProperty("device.ready.timeout");
		System.out.println("DEVICE_READY_TIMEOUT: " + DEVICE_READY_TIMEOUT);

	}
	
	public static void setCapabilities() {
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,
				CommonUtils.BROWSER_NAME);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,
				CommonUtils.PLATFORM_VERSION);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,
				CommonUtils.PLATFORM_NAME);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,
				CommonUtils.DEVICE_NAME);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,
				CommonUtils.AUTOMATION_INSTRUMENTATION);
		capabilities.setCapability(MobileCapabilityType.APP, 
				CommonUtils.APPLICATION_NAME);
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,
				CommonUtils.NEW_COMMAND_TIMEOUT);
		capabilities.setCapability(MobileCapabilityType.DEVICE_READY_TIMEOUT,
				CommonUtils.DEVICE_READY_TIMEOUT);
		capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY,
				CommonUtils.APP_ACTIVITY);
		capabilities.setCapability(MobileCapabilityType.APP_PACKAGE,
				CommonUtils.BASE_PKG);
	}
	
	public static AndroidDriver getDriver() throws MalformedURLException {
		serverUrl = new URL("http://127.0.0.1:" + APPIUM_PORT + "/wd/hub");	
		System.out.println(serverUrl);
		driver = new AndroidDriver(serverUrl, capabilities);
		System.out.println("Driver: " + driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}
	
public static boolean isExecutable(String tcid, Xls_Reader excel){
		
		for(int rowNum=2; rowNum<= excel.getRowCount("test_suite"); rowNum++){
			if(excel.getCellData("test_suite", "TCID", rowNum).equals(tcid)){
				if(excel.getCellData("test_suite", "Runmode", rowNum).equalsIgnoreCase("Y")){
					
					return true;
				}
				else{
					return false;
				}
			}
		}
		return false;
	}

// TestNG Parameterization

public static Object[][] getData(String testName, Xls_Reader excel){
	
			
		// This will test where the test will start from
		
		int testCaseStartIndex=0;
		for(int rNum=1; rNum<=excel.getRowCount("test data"); rNum++){
			if(testName.equals(excel.getCellData("test data", 0, rNum))){
				testCaseStartIndex = rNum;
				break;
			}
		}
		System.out.println("testName:"+testName+"||  Test starts at index - " + testCaseStartIndex);
		
		//Logic for finding total no of columns in each testcase.
		
		int colStartIndex = testCaseStartIndex + 1;
		int cols=0;
		while(!excel.getCellData("test data", cols, colStartIndex).equals("")){
			
			cols++;
		}
		System.out.println("Total no of Cols - " + cols);
		
		//Logic for finding total no of rows in each testcase
		
		int dataStartIndex = testCaseStartIndex + 2;
		int rows=0;
		//while(!excel.getCellData("test_data", 0, (dataStartIndex+rows)).equals("")){
		while(!excel.getCellData("test data", 0, (dataStartIndex+rows)).equals("")){
			rows++;
		}
		System.out.println("Total no of data rows - " + rows);
		
		// Print data from testcase
		Hashtable<String, String> table = null;
		Object[][] data = new Object[rows][1];
		for(int rNum=dataStartIndex; rNum<(dataStartIndex + rows); rNum++){
		table = new Hashtable<String,String>();
			for(int cNum = 0; cNum < cols ; cNum++){
				
				table.put(excel.getCellData("test data", cNum, colStartIndex), excel.getCellData("test data", cNum, rNum));
				//System.out.println(excel.getCellData("test_data", cNum, rNum));
				}
			//System.out.println(table.get("username"));
			data[rNum-dataStartIndex][0]=table;
			System.out.println();// Debug here
		}
		return data;
}

// Capture Screenshots

	public static void captureScreenshot() {
	
	 Calendar cal = new GregorianCalendar();
	  int month = cal.get(Calendar.MONTH);
	  int year = cal.get(Calendar.YEAR); 
	  int sec =cal.get(Calendar.SECOND);
	  int min =cal.get(Calendar.MINUTE);
	  int date = cal.get(Calendar.DATE);
	  int day =cal.get(Calendar.HOUR_OF_DAY);
	
	

	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    try {
    	mailscreenshotpath = System.getProperty("user.dir")+"\\screenshots\\"+year+"_"+date+"_"+(month+1)+"_"+day+"_"+min+"_" +sec+".jpeg";
		FileUtils.copyFile(scrFile, new File(mailscreenshotpath));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	   
}

}

