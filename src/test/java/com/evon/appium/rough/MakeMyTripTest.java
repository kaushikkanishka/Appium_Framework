package com.evon.appium.rough;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.evon.appium.utils.CommonUtils;

import io.appium.java_client.android.AndroidDriver;

public class MakeMyTripTest {
	
	public static AndroidDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		CommonUtils.loadConfigProp("makeMyTrip.properties");
		CommonUtils.setCapabilities();
		driver = CommonUtils.getDriver();
		//id="com.makemytrip:id/shareAndEarn"
		WebDriverWait wait = new WebDriverWait(driver, 18);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("android.widget.ImageButton"))).click();
		
		List<WebElement> services = driver.findElementsById("com.makemytrip:id/drawer_text_vw");
		
		
		for(WebElement item: services){
			
			System.out.println(item.getText());
		}
		System.out.println("List Printed");		
		services.get(0).click();
		
		//Selecting FROM city
		driver.findElementById("com.makemytrip:id/depCity").click();
		WebElement listView = driver.findElementById("com.makemytrip:id/city_picker_recycler_view");
		List<WebElement> cities = driver.findElementsById("com.makemytrip:id/cityName");
		for(int i=0; i<cities.size();i++){
			
			System.out.println(cities.get(i).getText());
			
			if(cities.get(i).getText().startsWith("Pune")){
				
				cities.get(i).click();
				break;
			}
		}
		
		//Selecting TO city
		driver.findElementById("com.makemytrip:id/arrCity").click();
		listView = driver.findElementById("com.makemytrip:id/city_picker_recycler_view");
		cities = driver.findElementsById("com.makemytrip:id/cityName");
		for(int i=0; i<cities.size();i++){
			
			System.out.println(cities.get(i).getText());
			
			if(cities.get(i).getText().startsWith("Bang")){
				
				cities.get(i).click();
				break;
			}
		}
		
		//Selecting departure date
		driver.findElementById("com.makemytrip:id/depDateLayout").click();
		//driver.navigate().back();
		Thread.sleep(2000);
		//driver.swipe(680, 1800, 680, 900, 1000);
		//System.out.println("Swipping done");
		/*int i = 1;
		List<WebElement> month = driver.findElementsByClassName("android.widget.TextView");
		while(!month.get(6).getText().equalsIgnoreCase("January 2016")){
			
			driver.swipe(680, 1800, 680, 818, 1000);
			Thread.sleep(1000);
			month = driver.findElementsByClassName("android.widget.TextView");
			System.out.println("Swapped "+i+" time");
			i++;
		}*/
		
		
		List<WebElement> cal = driver.findElementsByClassName("android.widget.CheckedTextView");
		
		cal.get(30).click();
		driver.findElementById("com.makemytrip:id/calOK").click();
		
		
		
		//Selecting number of passengers
		
		driver.findElementById("com.makemytrip:id/paxcount").click();
		//int adultCount = Integer.parseInt(driver.findElementById("com.makemytrip:id/adultCount").getText());
		while(Integer.parseInt(driver.findElementById("com.makemytrip:id/adultCount").getText())>2){
			
			driver.findElementById("com.makemytrip:id/adultRemove").click();
			
		}
		driver.findElementById("com.makemytrip:id/adultAdd").click(); //Adding adults
		
		while(Integer.parseInt(driver.findElementById("com.makemytrip:id/childrenCount").getText())>0){
			
			driver.findElementById("com.makemytrip:id/childrenRemove").click();
			
		}
		driver.findElementById("com.makemytrip:id/childrenAdd").click(); //Adding Child
		driver.findElementById("com.makemytrip:id/okPax").click();
		
		// Selecting Class
		
		driver.findElementById("com.makemytrip:id/classLayout").click();
		driver.findElementById("com.makemytrip:id/businessClass").click();
		
		//Clicking the search button
		
		driver.findElementById("com.makemytrip:id/searchFlights").click();
	}
	}

	

