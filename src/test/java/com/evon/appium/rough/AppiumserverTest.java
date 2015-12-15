package com.evon.appium.rough;

import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;


public class AppiumserverTest {
	
	
	//Appium Launch on Windows
	private static Process process;

	//Calling the node.exe and appium.js
	private static String STARTSERVER = "C:\\Program Files (x86)\\Appium\\node.exe C:\\Program Files (x86)\\Appium\\node_modules\\appium\\bin\\appium.js";
	//Starting the Appium Server
	
	public static void startAppiumServer() throws IOException, InterruptedException {

	Runtime runtime = Runtime.getRuntime();

	process = runtime.exec(STARTSERVER);

	Thread.sleep(7000);

	if (process != null) {
		
	System.out.println("Appium server started");

	}

	}

	
	//Stopping the Appium Server
	
	public static void stopAppiumServer() throws IOException {

	if (process != null) {

	process.destroy();

	}

	System.out.println("Appium server stopped");

	}

	public static void main(String[] args) throws Exception{

	stopAppiumServer();

	startAppiumServer();

	DesiredCapabilities capabilities=new DesiredCapabilities();

	capabilities.setCapability("automationName", "Appium");

	capabilities.setCapability("platformName", "Android");

	capabilities.setCapability("platformVersion","4.4.4");

	capabilities.setCapability("deviceName","Galaxy Note3");

	capabilities.setCapability("appPackage","io.selendroid.testapp");

	capabilities.setCapability("appActivity","io.selendroid.testapp.HomeScreenActivity");

	System.out.println("//////////");
	AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
	System.out.println(driver);

	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

	driver.findElement(By.id("io.selendroid.testapp:id/my_text_field")).sendKeys("Hello Appium");

	Thread.sleep(3000);

	driver.quit();

	stopAppiumServer();

	}
}
