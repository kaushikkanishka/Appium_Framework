package com.evon.appium.screens.nativeapp.makeMyTrip;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

import com.evon.appium.base.Constants;
import com.evon.appium.base.ScreenBase;

public class CityListingScreen extends ScreenBase{

	@AndroidFindBy(id=Constants.DEP_CITY_NAME)
	public List<WebElement> DepartureCityName;
	
	public CityListingScreen(AndroidDriver driver) throws IOException, InterruptedException {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public SearchFlightScreen selectCity(String City) throws IOException, InterruptedException{
		
		for(int i=0; i<DepartureCityName.size();i++){
			
			if(DepartureCityName.get(i).getText().startsWith(City)){
				
				DepartureCityName.get(i).click();
				break;
			}
		}
		return new SearchFlightScreen(driver);
	}
	
	

}
