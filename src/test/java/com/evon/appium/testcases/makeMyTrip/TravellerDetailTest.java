package com.evon.appium.testcases.makeMyTrip;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.evon.appium.base.TestBase;
import com.evon.appium.rough.SwipeContacts;
import com.evon.appium.screens.nativeapp.makeMyTrip.FlightDetailScreen;
import com.evon.appium.screens.nativeapp.makeMyTrip.FlightListingScreen;
import com.evon.appium.screens.nativeapp.makeMyTrip.PaymentModeScreen;
import com.evon.appium.screens.nativeapp.makeMyTrip.TravellerDetailScreen;
import com.evon.appium.utils.CommonUtils;

public class TravellerDetailTest extends TestBase {

	@BeforeTest
	public void init() throws IOException, InterruptedException{
		applyFilterTestObject = new ApplyFilterTest();
	}
	
	public void isSkip(){
		
		if(!CommonUtils.isExecutable("TravellerDetailTest",TestBase.excel)){
			
			throw new SkipException("Skipping the test case as the Run mode is not Y");
		}
		
		
	}
	
	@Test(dataProvider="getData")
	public void testTravellerDetail(Hashtable<String,String> data) throws Exception{
		
		FlightDetailScreen flightDetailScreenObject = new FlightDetailScreen(driver);
		TravellerDetailScreen travellerDetailScreenObject = new TravellerDetailScreen(driver);
		FlightListingScreen flightListingScreenObject = new FlightListingScreen(driver);
		flightDetailScreenObject = flightListingScreenObject.selectFlight();
		travellerDetailScreenObject = flightDetailScreenObject.clickContinueBtn();
		travellerDetailScreenObject.selectAdults(data.get("Adult 1"), data.get("Adult 2"), data.get("New Adult First Name"), data.get("New Adult Last Name"), data.get("New Adult Gender"), data.get("AdultCountExcel"));
		travellerDetailScreenObject.selectChildren(data.get("Child 1"), data.get("Child 2"), data.get("New Child First Name"), data.get("New Child Last Name"), data.get("New Child Gender"), data.get("ChildCountExcel"));
		travellerDetailScreenObject.swipeScreen(640, 1925, 640, 590, 1000);
		travellerDetailScreenObject.enterEmail(data.get("Email"));
		travellerDetailScreenObject.enterPhoneNumber(data.get("Phone Number"));
		PaymentModeScreen paymentModeScreenObject = new PaymentModeScreen(driver);
		paymentModeScreenObject = travellerDetailScreenObject.doBookFlight();
	}
	
	@DataProvider
	public Object[][] getData(){
		
		return CommonUtils.getData("TravellerDetailTest", TestBase.excel);
		
	}
}
