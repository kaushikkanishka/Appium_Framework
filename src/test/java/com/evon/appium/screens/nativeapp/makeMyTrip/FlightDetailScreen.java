package com.evon.appium.screens.nativeapp.makeMyTrip;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.evon.appium.base.Constants;
import com.evon.appium.base.ScreenBase;

public class FlightDetailScreen extends ScreenBase{
	
	@AndroidFindBy(id=Constants.FLIGHT_DETAIL_CONTINUE_BTN)
	WebElement flightDetailContinueBtn;
	
	public FlightDetailScreen(AndroidDriver driver) throws IOException,
			InterruptedException {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public TravellerDetailScreen clickContinueBtn() throws IOException, InterruptedException{
		
		flightDetailContinueBtn.click();
		System.out.println("Clicked on Continue button");
		Thread.sleep(15000);
		return new TravellerDetailScreen(driver);
	}
	
	
}
