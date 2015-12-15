package com.evon.appium.rough;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class MakeaCallTest {


	public static AppiumDriver driver;
	
	
	public static void main(String[] args) throws MalformedURLException {


		
		DesiredCapabilities capabilites = new DesiredCapabilities();
		
		capabilites.setCapability("device", "Android");
		capabilites.setCapability("deviceName", "MOTOROLAXT1022");
		capabilites.setCapability("platformVersion", "4.4.4");
		capabilites.setCapability("platformName", "Android");
		
		capabilites.setCapability("appPackage", "com.android.contacts");
		capabilites.setCapability("appActivity", "com.android.contacts.activities.PeopleActivity");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilites);
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);

		WebElement frameLayout = driver.findElement(By.className("android.widget.FrameLayout"));
		WebElement HorizontalScrollView =  frameLayout.findElement(By.className("android.widget.HorizontalScrollView"));
		List<WebElement> actionTab = HorizontalScrollView.findElements(By.className("android.app.ActionBar$Tab"));
		
		actionTab.get(0).click();
		
		WebElement linearLayout = driver.findElement(By.id("com.android.contacts:id/dialpad"));
		
		//9711191558
		linearLayout.findElement(By.id("com.android.contacts:id/nine")).click();
		linearLayout.findElement(By.id("com.android.contacts:id/seven")).click();
		linearLayout.findElement(By.id("com.android.contacts:id/one")).click();
		linearLayout.findElement(By.id("com.android.contacts:id/one")).click();
		linearLayout.findElement(By.id("com.android.contacts:id/one")).click();
		linearLayout.findElement(By.id("com.android.contacts:id/nine")).click();
		linearLayout.findElement(By.id("com.android.contacts:id/one")).click();
		linearLayout.findElement(By.id("com.android.contacts:id/five")).click();
		linearLayout.findElement(By.id("com.android.contacts:id/five")).click();
		linearLayout.findElement(By.id("com.android.contacts:id/eight")).click();
		
		driver.findElement(By.id("com.android.contacts:id/callbutton")).click();
		
		
		
		

	}

}
