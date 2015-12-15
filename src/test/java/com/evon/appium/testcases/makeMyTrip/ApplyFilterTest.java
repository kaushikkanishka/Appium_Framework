package com.evon.appium.testcases.makeMyTrip;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.evon.appium.base.TestBase;
import com.evon.appium.screens.nativeapp.makeMyTrip.BookFlight;
import com.evon.appium.screens.nativeapp.makeMyTrip.FlightListingScreen;
import com.evon.appium.utils.CommonUtils;

public class ApplyFilterTest extends TestBase {

	@BeforeTest
	public void init() throws IOException, InterruptedException{
		applyFilterTestObject = new ApplyFilterTest();
	}
	
	public void isSkip(){
		
		if(!CommonUtils.isExecutable("ApplyFilterTest",TestBase.excel)){
			
			throw new SkipException("Skipping the test case as the Run mode is not Y");
		}
		
		
	}
	
	@Test(dataProvider="getData")
	public void testFilters(Hashtable<String,String> data) throws Exception{
		
		FlightListingScreen flightListingScreenObject = new FlightListingScreen(driver);
		flightListingScreenObject.clickFiltersbtn();
		flightListingScreenObject.stopFilter(data.get("Stops"));
		flightListingScreenObject.selectTime(data.get("DepartureTime"));
		flightListingScreenObject.selectAirlines(data.get("Airlines"));
		flightListingScreenObject = flightListingScreenObject.filterApplyButton();
	}
	
	@DataProvider
	public Object[][] getData(){
		
		return CommonUtils.getData("ApplyFilterTest", TestBase.excel);
		
	}
}
