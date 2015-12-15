package com.evon.appium.screens.nativeapp.makeMyTrip;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

import com.evon.appium.base.Constants;
import com.evon.appium.base.ScreenBase;

public class FlightListingScreen extends ScreenBase{
	
	@AndroidFindBy(id=Constants.DEPARTURE_CITY_SRP)
	WebElement DepartureCitySRP;

	@AndroidFindBy(id=Constants.ARRIVAL_CITY_SRP)
	WebElement ArrivalCitySRP;
	
	
	@AndroidFindBy(id=Constants.FILTER_BTN)
	WebElement FilterBtn;

	@AndroidFindBy(id=Constants.STOPS_HEADER)
	WebElement stopsHeader;
	
	@AndroidFindBy(id=Constants.ONE_STOP)
	WebElement oneStop;
	
	@AndroidFindBy(id=Constants.ZERO_STOP)
	WebElement zeroStop;
	
	@AndroidFindBy(id=Constants.TWO_STOP)
	WebElement twoStop;
	
	@AndroidFindBy(id=Constants.BEFORE_SIX)
	WebElement beforeSix;
	
	@AndroidFindBy(id=Constants.SIX_TO_TWELVE)
	WebElement sixToTwelve;
	
	@AndroidFindBy(id=Constants.TWELVE_TO_SIX)
	WebElement twelveToSix;
	
	@AndroidFindBy(id=Constants.AFTER_SIX)
	WebElement afterSix;
	
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
	
	@AndroidFindBy(id=Constants.FLIGHT_LIST_AFTER_FILTER)
	public List<WebElement> flightListAfterFilter;
	
	public FlightListingScreen(AndroidDriver driver) throws IOException, InterruptedException {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public String DepartureCity = DepartureCitySRP.getText();
	public String ArrivalCity = ArrivalCitySRP.getText();
	
	public void clickFiltersbtn(){
		
		FilterBtn.click();
		System.out.println("Clicked on Filter button");
	}
	
	public void stopFilter(String stops){
		
		stopsHeader.click();
		float s = Float.parseFloat(stops);
		int s1 = (int)Math.round(s);
		
		//int stopCount = Integer.parseInt(s);
		
		switch(s1){
		
		case 0: zeroStop.click();
			break;
		
		case 1: oneStop.click();
			break;
			
		case 2: twoStop.click();
			break;
			
		}
		
	}
	
	public void selectTime(String departureTime) throws InterruptedException{
		
		timeFilterHeader.click();
		Thread.sleep(3000);
		
		switch(departureTime){
		
		case "Before 6": beforeSix.click();
			break;
			
		case "6 to 12": sixToTwelve.click();
			break;
			
		case "12 to 6": twelveToSix.click();
			break;
			
		case "After 6": afterSix.click();
			break;
		}
		Thread.sleep(2000);
	}
	
	public void selectAirlines(String airline){
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
		
	}
	
	public FlightListingScreen filterApplyButton() throws InterruptedException, IOException{
		
		applyFilterBtn.click();
		Thread.sleep(2000);
		return this;
	}
	
	public FlightDetailScreen selectFlight() throws IOException, InterruptedException{
		
		/*int i=0;
		while(i<=flightListAfterFilter.size()){
			
			
		}*/
		flightListAfterFilter.get(0).click();
		Thread.sleep(10000);
		return new FlightDetailScreen(driver);
	}
}
