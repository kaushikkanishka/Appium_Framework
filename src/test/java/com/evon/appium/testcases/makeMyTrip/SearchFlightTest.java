package com.evon.appium.testcases.makeMyTrip;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ErrorCollectors.ErrorCollector;

import com.evon.appium.base.TestBase;
import com.evon.appium.screens.nativeapp.makeMyTrip.HomeScreen;
import com.evon.appium.screens.nativeapp.makeMyTrip.SearchFlight;
import com.evon.appium.utils.CommonUtils;

public class SearchFlightTest extends TestBase{

	@BeforeTest
	public void init() throws IOException, InterruptedException{
		searchFlightObject = new SearchFlight(driver);
	}
	
	public void isSkip(){
		
		if(!CommonUtils.isExecutable("SearchFlightTest",TestBase.excel)){
			
			throw new SkipException("Skipping the test case as the Run mode is not Y");
		}
		
		
	}
	
	@Test(dataProvider="getData")
	public void doSearchFlightTest(Hashtable<String,String> data) throws Exception{
			
		HomeScreen homeScreenObject = new HomeScreen(driver);
		homeScreenObject.getServices();
		searchFlightScreenObject = homeScreenObject.serviceSelection(data.get("Service"));
		cityListingScreenObject = searchFlightScreenObject.selectFromCity();
		searchFlightScreenObject = cityListingScreenObject.selectCity(data.get("Departure_City"));
		cityListingScreenObject = searchFlightScreenObject.selectToCity();
		searchFlightScreenObject = cityListingScreenObject.selectCity(data.get("To_City"));
		calanderScreenObject = searchFlightScreenObject.selectDepartureDate();
		searchFlightScreenObject = calanderScreenObject.selectDate(data.get("Departure_Date"));
		searchFlightScreenObject.selectPassengersCount(data.get("Adult"), data.get("Children"), data.get("Infant"));
		searchFlightScreenObject.selectClass(data.get("TravelClass"));
		flightListingScreenObject = searchFlightScreenObject.search();
		Thread.sleep(5000);
		
		System.out.println(flightListingScreenObject.DepartureCity);
		ErrorCollector.verifyEquals(flightListingScreenObject.DepartureCity, data.get("Departure_City"));
		//ErrorCollector.verifyEquals(flightListingScreenObject.DepartureCity, "Mumbai");
		System.out.println(flightListingScreenObject.ArrivalCity);
		ErrorCollector.verifyEquals(flightListingScreenObject.ArrivalCity, data.get("To_City"));
	}
	
	@DataProvider
	public Object[][] getData(){
		
		return CommonUtils.getData("SearchFlightTest", TestBase.excel);
		
	}
	
	
}
