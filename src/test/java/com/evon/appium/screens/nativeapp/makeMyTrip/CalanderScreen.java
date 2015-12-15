package com.evon.appium.screens.nativeapp.makeMyTrip;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

import com.evon.appium.base.Constants;
import com.evon.appium.base.ScreenBase;

public class CalanderScreen extends ScreenBase{
	
	@AndroidFindBy(className=Constants.CALANDER_ELEMENTS)
	public List<WebElement> DepartureCalander;
	
	@AndroidFindBy(id=Constants.CALANDER_OK_BTN)
	WebElement CalanderOKBtn;

	public CalanderScreen(AndroidDriver driver) throws IOException, InterruptedException {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public SearchFlightScreen selectDate(String date) throws InterruptedException, IOException{
		
		/*Thread.sleep(2000);
		swipeScreen(680, 1800, 680, 820, 1000);
		System.out.println(DepartureCalander.get(date).getText());*/
		float f = Float.parseFloat(date);
		int date1 = (int)Math.round(f);
		System.out.println(date1);
		DepartureCalander.get(date1).click();
		CalanderOKBtn.click();
		Thread.sleep(1000);
		return new SearchFlightScreen(driver);
	}

}
