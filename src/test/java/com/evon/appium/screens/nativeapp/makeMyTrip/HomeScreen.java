package com.evon.appium.screens.nativeapp.makeMyTrip;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

import com.evon.appium.base.Constants;
import com.evon.appium.base.ScreenBase;

public class HomeScreen extends ScreenBase  {

	@AndroidFindBy(className=Constants.SERVICE_MENU)
	WebElement ServiceImageButton;
	
	@AndroidFindBy(id=Constants.MENU_LIST)
	public List<WebElement> services;
	
	public HomeScreen(AndroidDriver driver) throws IOException, InterruptedException {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public HomeScreen getServices() throws IOException{
		
		waitForElement(18,Constants.SERVICE_MENU);
		ServiceImageButton.click();
		
		for(WebElement item: services){
			
			System.out.println(item.getText());
		}
		return this;
		
	}
	
	public SearchFlightScreen serviceSelection(String service) throws IOException, InterruptedException{
		
		for(WebElement item: services){
			
			if(item.getText().equalsIgnoreCase(service)){
				String element = item.getText();
				item.click();
				System.out.println("Clicked on "+ element);
				break;
			}
			else{
				System.out.println("Invalid selection");
			}
		}
		return new SearchFlightScreen(driver);
	}
}
