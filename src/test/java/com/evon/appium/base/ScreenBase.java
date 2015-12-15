package com.evon.appium.base;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.evon.appium.utils.Appiumserver;
import com.evon.appium.utils.CommonUtils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ScreenBase {

	public static AndroidDriver driver;
	
	public ScreenBase(AndroidDriver driver) throws IOException, InterruptedException{
		
		this.driver = driver;
		//System.out.println("Driver in base: "+ driver);
		loadElements();
		
	}
	
	public void loadElements(){
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void waitForElement(long duration, String locator){
		
		WebDriverWait wait = new WebDriverWait(driver, duration);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className(locator)));
	}
	
	public void swipeScreen(int startX, int startY, int endX, int endY, int duration){
		
		driver.swipe(startX, startY, endX, endY, duration);
	}
}
