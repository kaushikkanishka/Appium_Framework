package com.evon.appium.rough;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SwipeContacts {

	public static RemoteWebDriver driver;

	public static void main(String[] args) throws MalformedURLException {
		

	DesiredCapabilities capabilites = new DesiredCapabilities();
	capabilites.setCapability("device", "Android");
	capabilites.setCapability("deviceName", "10.0.0.6:5555");
	capabilites.setCapability("platformVersion", "4.4.2");
	capabilites.setCapability("platformName", "Android");
	capabilites.setCapability("appPackage", "com.android.contacts");
	capabilites.setCapability("appActivity", "com.android.contacts.activities");

	driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilites);
	driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);


	int i=0;

	boolean firstTime=true;



	while (true)
	{
		
		//WebElement frameLayout = driver.findElement(By.id("com.android.contacts:id/list_container"));
		List<WebElement> contacts = driver.findElements(By.className("android.widget.TextView"));
		
		System.out.println(contacts.get(i).getText());
	}
	    /*if (contacts.get(i).getText().equalsIgnoreCase("Ads"))
	    {
	    	swipe(generateY(contacts.get(i).getLocation()));
	        break;
	    }
	   
	    if(i==5)
	    {
	   	if (firstTime)
	   	{ i=0;
	      horizontalswipe();
	   	}
	    }
	    i++;
	    
	}*/

	}



	public static void swipe(double y)
	{  
	JavascriptExecutor js = (JavascriptExecutor) driver;
	HashMap<String, Double> swipeObject = new HashMap<String, Double>();
	swipeObject.put("startX", 164.00);
	swipeObject.put("startY", y);
	swipeObject.put("endX", 500.00);
	swipeObject.put("endY", y);
	swipeObject.put("duration", 1.0);
	js.executeScript("mobile: swipe", swipeObject);
	System.out.println("Up to Down");
	 }

	public static void horizontalswipe()
	{  
	JavascriptExecutor js = (JavascriptExecutor) driver;
	HashMap<String, Double> swipeObject = new HashMap<String, Double>();
	swipeObject.put("startX", 116.00);
	swipeObject.put("startY", 1268.00);
	swipeObject.put("endX", 164.00);
	swipeObject.put("endY", 1118.00);
	swipeObject.put("duration", 2.0);
	js.executeScript("mobile: swipe", swipeObject);
	System.out.println("Left to Right");
	 }

	public double generateX(Point point)
	{
		int x=point.getX();
		return x;

	}
	public static double generateY(Point point)
	{
		int y=point.getY();
		return y;

	}


}
