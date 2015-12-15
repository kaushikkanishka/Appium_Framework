package com.evon.appium.screens.nativeapp.makeMyTrip;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

import com.evon.appium.base.Constants;
import com.evon.appium.base.ScreenBase;

public class SearchFlightScreen extends ScreenBase{
	
	@AndroidFindBy(id=Constants.DEP_CITY)
	WebElement DepartureCityButton;

	@AndroidFindBy(id=Constants.DEP_CITY_NAME)
	public List<WebElement> DepartureCityName;
	
	@AndroidFindBy(id=Constants.TO_CITY)
	WebElement ToCityButton;
	
	@AndroidFindBy(className=Constants.DEP_DATE_MONTH)
	public List<WebElement> DepartureDateMonth;
	
	@AndroidFindBy(id=Constants.DEPARTURE_DATE)
	WebElement DepartureDate;
	
	@AndroidFindBy(id=Constants.TRAVELLERS_COUNT)
	WebElement TravellersCount;
	
	@AndroidFindBy(id=Constants.ADULT_COUNT)
	WebElement AdultCount;
	
	@AndroidFindBy(id=Constants.ADULT_ADD)
	WebElement adultAdd;
	
	@AndroidFindBy(id=Constants.ADULT_REMOVE)
	WebElement adultRemove;
	
	@AndroidFindBy(id=Constants.CHILD_COUNT)
	WebElement ChildCount;
	
	@AndroidFindBy(id=Constants.CHILD_ADD)
	WebElement childAdd;
	
	@AndroidFindBy(id=Constants.CHILD_REMOVE)
	WebElement childRemove;
	
	@AndroidFindBy(id=Constants.INFANT_COUNT)
	WebElement InfantCount;
	
	@AndroidFindBy(id=Constants.INFANT_ADD)
	WebElement InfantAdd;
	
	@AndroidFindBy(id=Constants.INFANT_REMOVE)
	WebElement InfantRemove;
	
	@AndroidFindBy(id=Constants.PASSENGER_COUNT_OK_BTN)
	WebElement psngrCountOkBtn;

	@AndroidFindBy(id=Constants.CLASS_SELECTION)
	WebElement classSelection;
	
	@AndroidFindBy(id=Constants.BUSINESS_CLASS)
	WebElement businessClass;
	
	@AndroidFindBy(id=Constants.ECONOMY_CLASS)
	WebElement economyClass;
	
	@AndroidFindBy(id=Constants.PREMIUM_ECONOMY_CLASS)
	WebElement premiumEconomyClass;
	
	@AndroidFindBy(id=Constants.SEARCH_BTN)
	WebElement searchBtn;

	public SearchFlightScreen(AndroidDriver driver) throws IOException, InterruptedException {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public CityListingScreen selectFromCity() throws IOException, InterruptedException{
		
		DepartureCityButton.click();
		return new CityListingScreen(driver);
		
		}
	
	public CityListingScreen selectToCity() throws IOException, InterruptedException{
		
		ToCityButton.click();
		return new CityListingScreen(driver);
		
		}
	
	public CalanderScreen selectDepartureDate() throws IOException, InterruptedException{
		
		DepartureDate.click();
		/*int i=0;
		while(i<DepartureDateMonth.size()){
			System.out.println(DepartureDateMonth.get(i).getText());
			i++;
		}
		
		while(DepartureDateMonth.get(6).getText()!="March 2016"){
			
			swipeScreen(startX, startY, endX, endY, duration);
			DepartureDateMonth = 
		}
		*/
		return new CalanderScreen(driver);
	}
	
	//Selecting number of passengers
	
	public SearchFlightScreen selectPassengersCount(String adult, String children, String infants) throws InterruptedException{
		
		TravellersCount.click();
		//childAdd.click();
		float f = Float.parseFloat(adult);
		float f1 = Float.parseFloat(children);
		float f2 = Float.parseFloat(infants);
		
		int adultCount = (int)Math.round(f);
		int childCount = (int)Math.round(f1);
		int infantCount = (int)Math.round(f2);
		
		int adultCountExcel = Integer.parseInt(AdultCount.getText());
		int childCountExcel = Integer.parseInt(ChildCount.getText());
		int infantCountExcel = Integer.parseInt(InfantCount.getText());
		
		//Adult 
		if(adultCountExcel<adultCount){
			System.out.println("adultCountExcel < adultCount");
			System.out.println("adultCountExcel: "+adultCountExcel);
			System.out.println("adultCount: "+adultCount);
			while(adultCountExcel<adultCount){
				adultAdd.click();
				adultCountExcel++;
			}
			
		}else if(adultCountExcel>adultCount){
			System.out.println("adultCountExcel > adultCount");
				while(adultCountExcel>adultCount){
				
					adultRemove.click();
					adultCount++;
			}
		}
		
		//Child 
		
			
		if(childCountExcel<childCount){
			
			while(childCountExcel<childCount){
				childAdd.click();
				childCountExcel++;
			}
			
		}else if(childCountExcel>childCount){
			
				while(childCountExcel>childCount){
				
					childRemove.click();
					childCount++;
			}
		}
		
		//Infant 
		if(infantCountExcel<infantCount){
			
			while(infantCountExcel<infantCount){
				InfantAdd.click();
				infantCountExcel++;
			}
			
		}else if(infantCountExcel>infantCount){
			
				while(infantCountExcel>infantCount){
				
					InfantRemove.click();
					infantCount++;
			}
		}
		Thread.sleep(3000);
		psngrCountOkBtn.click();
		return this;
	}
	
	public SearchFlightScreen selectClass(String travelClass){
		
		classSelection.click();
		switch (travelClass) {
		case "Economy":
			economyClass.click();
			break;
		case "Premium Economy":
			economyClass.click();
			break;
		case "Business":
			businessClass.click();
			break;			
		default:
			break;
		}
		
		return this;
	}
	
	public FlightListingScreen search() throws InterruptedException, IOException{
		
		searchBtn.click();
		Thread.sleep(20000);
		return new FlightListingScreen(driver);
	}
}
