package com.evon.appium.base;

import java.io.IOException;

import org.apache.commons.io.FilenameUtils;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;












import com.evon.appium.screens.nativeapp.SelendroidHomeScreen;
import com.evon.appium.screens.nativeapp.WebViewInteractionScreen;
import com.evon.appium.screens.nativeapp.makeMyTrip.BookFlight;
import com.evon.appium.screens.nativeapp.makeMyTrip.CalanderScreen;
import com.evon.appium.screens.nativeapp.makeMyTrip.CityListingScreen;
import com.evon.appium.screens.nativeapp.makeMyTrip.FlightDetailScreen;
import com.evon.appium.screens.nativeapp.makeMyTrip.FlightListingScreen;
import com.evon.appium.screens.nativeapp.makeMyTrip.HomeScreen;
import com.evon.appium.screens.nativeapp.makeMyTrip.SearchFlight;
import com.evon.appium.screens.nativeapp.makeMyTrip.SearchFlightScreen;
import com.evon.appium.screens.nativeapp.makeMyTrip.TravellerDetailScreen;
import com.evon.appium.testcases.makeMyTrip.ApplyFilterTest;
import com.evon.appium.utils.Appiumserver;
import com.evon.appium.utils.CommonUtils;
import com.evon.appium.utils.Xls_Reader;

import io.appium.java_client.android.AndroidDriver;

public class TestBase {

	public static AndroidDriver driver;
	public SelendroidHomeScreen homeScreen;
	public WebViewInteractionScreen webViewIntr;
	public SearchFlight searchFlightObject;
	public BookFlight bookFlightObject;
	public HomeScreen homeScreenObject;
	public CalanderScreen calanderScreenObject;
	public CityListingScreen cityListingScreenObject;
	public FlightListingScreen flightListingScreenObject;
	public SearchFlightScreen searchFlightScreenObject;
	public TravellerDetailScreen travellerDetailScreenObject;
	public FlightDetailScreen flightDetailScreenObject;
	public static String path = System.getProperty("user.dir");
	public static Xls_Reader excel = new Xls_Reader(path.replace("\\target","")+"\\src\\test\\resources\\testdata\\makeMyTripTestdata.xlsx");
	public ApplyFilterTest applyFilterTestObject;
	@BeforeSuite
	public void setUp() throws IOException, InterruptedException{
		
		
		//Appiumserver.stop();
		Appiumserver.start();
		CommonUtils.loadConfigProp("makeMyTrip.properties");
		CommonUtils.setCapabilities();
		driver = CommonUtils.getDriver();
		
	}
	
	@AfterSuite
	public void shutDown() throws IOException, InterruptedException{
		
		driver.quit();
		Appiumserver.stop();
	}
}
