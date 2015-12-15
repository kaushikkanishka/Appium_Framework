package com.evon.appium.screens.nativeapp.makeMyTrip;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

import com.evon.appium.base.Constants;
import com.evon.appium.base.ScreenBase;

public class BookFlight extends ScreenBase{
	
	@AndroidFindBy(id=Constants.FILTER_BTN)
	WebElement FilterBtn;

	@AndroidFindBy(id=Constants.STOPS_HEADER)
	WebElement stopsHeader;
	
	@AndroidFindBy(id=Constants.ONE_STOP)
	WebElement oneStop;
	
	@AndroidFindBy(id=Constants.TIME_FILTER_HEADER)
	WebElement timeFilterHeader;
	
	@AndroidFindBy(id=Constants.TIME_EVENING)
	WebElement eveningTime;
	
	@AndroidFindBy(id=Constants.AIRLINES_HEADER)
	WebElement airlinesHeader;
	
	@AndroidFindBy(id=Constants.AIRLINES_LIST)
	public List<WebElement> airlinesList;
	
	@AndroidFindBy(id=Constants.APPLY_FILTER_BTN)
	WebElement applyFilterBtn;
	
	
	
	public BookFlight(AndroidDriver driver) throws IOException, InterruptedException {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void applyFilters(String airline){
		
		FilterBtn.click();
		stopsHeader.click();
		oneStop.click();
		timeFilterHeader.click();
		eveningTime.click();
		airlinesHeader.click();
		int i=0;
		while(i <= airlinesList.size()){
			
			System.out.println(airlinesList.get(i).getText());
			
			if(airlinesList.get(i).getText().startsWith(airline)){
				airlinesList.get(i).click();
				break;
			}
			i++;
		}
		applyFilterBtn.click();
		
	}
}
