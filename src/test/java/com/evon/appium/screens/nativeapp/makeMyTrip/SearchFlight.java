package com.evon.appium.screens.nativeapp.makeMyTrip;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;

import com.evon.appium.base.Constants;
import com.evon.appium.base.ScreenBase;
import com.evon.appium.utils.CommonUtils;

public class SearchFlight extends ScreenBase {
	
	@AndroidFindBy(className=Constants.SERVICE_MENU)
	WebElement ServiceImageButton;
	
	@AndroidFindBy(id=Constants.MENU_LIST)
	public List<WebElement> services;
	
	@AndroidFindBy(id=Constants.DEP_CITY)
	WebElement DepartureCityButton;

	@AndroidFindBy(id=Constants.DEP_CITY_NAME)
	public List<WebElement> DepartureCityName;
	
	@AndroidFindBy(id=Constants.TO_CITY)
	WebElement ToCityButton;
	
	@AndroidFindBy(id=Constants.DEPARTURE_DATE)
	WebElement DepartureDate;
	
	@AndroidFindBy(className=Constants.CALANDER_ELEMENTS)
	public List<WebElement> DepartureCalander;
	
	@AndroidFindBy(id=Constants.CALANDER_OK_BTN)
	WebElement CalanderOKBtn;
	
	@AndroidFindBy(id=Constants.TRAVELLERS_COUNT)
	WebElement TravellersCount;
	
	@AndroidFindBy(id=Constants.ADULT_COUNT)
	WebElement AdultCount;
	
	@AndroidFindBy(id=Constants.ADULT_ADD)
	WebElement adultAdd;
	
	@AndroidFindBy(id=Constants.ADULT_REMOVE)
	WebElement adultRemove;
	
	@AndroidFindBy(id=Constants.CHILD_ADD)
	WebElement childAdd;
	
	@AndroidFindBy(id=Constants.CHILD_REMOVE)
	WebElement childRemove;
	
	@AndroidFindBy(id=Constants.PASSENGER_COUNT_OK_BTN)
	WebElement psngrCountOkBtn;

	@AndroidFindBy(id=Constants.CLASS_SELECTION)
	WebElement classSelection;
	
	@AndroidFindBy(id=Constants.BUSINESS_CLASS)
	WebElement businessClass;
	
	@AndroidFindBy(id=Constants.ECONOMY_CLASS)
	WebElement economyClass;
	
	@AndroidFindBy(id=Constants.SEARCH_BTN)
	WebElement searchBtn;
	
	
	public SearchFlight(AndroidDriver driver) throws IOException, InterruptedException {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void getServices() throws IOException{
		
		waitForElement(18,Constants.SERVICE_MENU);
		ServiceImageButton.click();
		
		for(WebElement item: services){
			
			System.out.println(item.getText());
		}
		
	}
	
	public void serviceSelection(String service){
		
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
	}
	
	public void selectFromCity(String FromCity){
		
		DepartureCityButton.click();
		
		for(int i=0; i<DepartureCityName.size();i++){
			
			System.out.println(DepartureCityName.get(i).getText());
			
			if(DepartureCityName.get(i).getText().startsWith(FromCity)){
				
				DepartureCityName.get(i).click();
				break;
			}
		}
	}
	
	public void selectToCity(String ToCity){
		
		ToCityButton.click();
		
		for(int i=0; i<DepartureCityName.size();i++){
			
			System.out.println(DepartureCityName.get(i).getText());
			
			if(DepartureCityName.get(i).getText().startsWith(ToCity)){
				
				DepartureCityName.get(i).click();
				break;
			}
		}
	}
	
	public void selectDepartureDate(String date) throws InterruptedException{
		
		DepartureDate.click();
		/*Thread.sleep(2000);
		swipeScreen(680, 1800, 680, 820, 1000);
		System.out.println(DepartureCalander.get(date).getText());*/
		float f = Float.parseFloat(date);
		
		//int date1 = Integer.parseInt(date);
		int date1 = (int)Math.round(f);
		System.out.println(date1);
		DepartureCalander.get(date1).click();
		CalanderOKBtn.click();
		Thread.sleep(1000);
	}
	
	//Selecting number of passengers
	
	public void selectPassengersCount(String adult, String children, String infants){
		
		TravellersCount.click();
		//childAdd.click();
		float f = Float.parseFloat(adult);
		float f1 = Float.parseFloat(children);
		float f2 = Float.parseFloat(infants);
		
		int adultCount = (int)Math.round(f);
		int childCount = (int)Math.round(f1);
		int infantCount = (int)Math.round(f2);
		
		childRemove.click();
		childRemove.click();
		childRemove.click();
		
		psngrCountOkBtn.click();
		
		
		/*int adultCount = Integer.parseInt(AdultCount.getText());
		if(adultCount<adult){
			
			while(adultCount==adult){
				adultAdd.click();
			}
			
		}else if(adultCount>adult){
			
				while(adultCount>2){
				
					adultRemove.click();
			}
		}
		{
			
			driver.findElementById("com.makemytrip:id/adultAdd").click(); //Adding adults
		}*/
		
	}
	
	public void selectClass(){
		
		classSelection.click();
		//businessClass.click();
		economyClass.click();
	}
	
	public void search() throws InterruptedException{
		
		searchBtn.click();
		Thread.sleep(20000);
	}
	
	
	/*
			driver.findElementById("com.makemytrip:id/paxcount").click();
			//int adultCount = Integer.parseInt(driver.findElementById("com.makemytrip:id/adultCount").getText());
			while(Integer.parseInt(driver.findElementById("com.makemytrip:id/adultCount").getText())>2){
				
				driver.findElementById("com.makemytrip:id/adultRemove").click();
				
			}
			driver.findElementById("com.makemytrip:id/adultAdd").click(); //Adding adults
			
			while(Integer.parseInt(driver.findElementById("com.makemytrip:id/childrenCount").getText())>0){
				
				driver.findElementById("com.makemytrip:id/childrenRemove").click();
				
			}
			driver.findElementById("com.makemytrip:id/childrenAdd").click(); //Adding Child
			driver.findElementById("com.makemytrip:id/okPax").click();
			
			// Selecting Class
			
			driver.findElementById("com.makemytrip:id/classLayout").click();
			driver.findElementById("com.makemytrip:id/businessClass").click();
			
			//Clicking the search button
			
			driver.findElementById("com.makemytrip:id/searchFlights").click();*/
}
