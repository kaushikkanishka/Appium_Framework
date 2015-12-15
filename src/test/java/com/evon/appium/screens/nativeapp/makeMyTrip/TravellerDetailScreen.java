package com.evon.appium.screens.nativeapp.makeMyTrip;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.evon.appium.base.Constants;
import com.evon.appium.base.ScreenBase;

public class TravellerDetailScreen extends ScreenBase{
	
	@AndroidFindBy(id=Constants.ADULT_DETAILS)
	public List<WebElement> adultDetail;

	@AndroidFindBy(id=Constants.ADD_ADULT)
	public WebElement addAdult;
	
	@AndroidFindBy(id=Constants.FIRST_NAME)
	public WebElement firstName;
	
	@AndroidFindBy(id=Constants.LAST_NAME)
	public WebElement lastName;
	
	@AndroidFindBy(id=Constants.GENDER)
	public List<WebElement> gender;
	
	@AndroidFindBy(id=Constants.ADD_TRAVELLER_BTN)
	public WebElement addTravellerBtn;
	
	@AndroidFindBy(id=Constants.EMAIL_FIELD)
	public WebElement emailField;
	
	@AndroidFindBy(id=Constants.PHONE_NUMBER_FIELD)
	public WebElement phoneNumberField;
	
	@AndroidFindBy(className=Constants.BOOK_FLIGHT_BTN)
	public List<WebElement> bookFlightBtn;
	
	@AndroidFindBy(id=Constants.BOOK_FLIGHT_ID)
	public WebElement bookFlightID;
	
	public int TravellersCount = adultDetail.size();	
	public static int AdultCount = 0;
	
	SearchFlightScreen searchFlightScreenObject = new SearchFlightScreen(driver);
	
	public TravellerDetailScreen(AndroidDriver driver) throws IOException,
			InterruptedException {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public TravellerDetailScreen selectAdults(String adult1, String adult2, String FirstName, String LastName, String Gender, String AdultCountExcel) throws IOException, InterruptedException{
		
		float f = Float.parseFloat(AdultCountExcel);
		int adultCount = (int)Math.round(f);
		
		System.out.println("selectAdults:" +adultDetail.size());
		int i=0;
		while(i<adultCount){
			
			System.out.println("Before if: "+adultDetail.get(i).getText());
			if(adultDetail.get(i).getText().equalsIgnoreCase(adult1)||adultDetail.get(i).getText().equalsIgnoreCase(adult2)){
				System.out.println("Inside if "+adultDetail.get(i).getText());
				adultDetail.get(i).click();
				AdultCount++;
			}/*else{
				
				addAdult.click();
				doAddNewAdult(FirstName, LastName, Gender);
				//AdultCount++;
			}*/
			i++;
		}
		return new TravellerDetailScreen(driver);
	}
	
	public TravellerDetailScreen doAddNewAdult(String FirstName, String LastName, String Gender) throws IOException, InterruptedException{
		
		firstName.sendKeys(FirstName);
		lastName.sendKeys(LastName);
		if(Gender=="Female"){
			gender.get(1).click();
		}
		addTravellerBtn.click();
		return new TravellerDetailScreen(driver);
	}
	
	public TravellerDetailScreen selectChildren(String child1, String child2, String childFirstName, String childLastName, String childGender, String childCountExcel) throws IOException, InterruptedException{
		
		System.out.println("TravellersCount: "+TravellersCount);
		System.out.println("AdultCount: "+AdultCount);
		int childIndex = TravellersCount - AdultCount;
		float f = Float.parseFloat(childCountExcel);
		int childCount = (int)Math.round(f);
		int a = TravellersCount - 1;
		System.out.println("select Children:" +adultDetail.size());
		int i=childIndex;
		System.out.println("Child Index: "+childIndex);
		System.out.println("Child count: "+childCount);
		while(i<a){
			
			System.out.println(adultDetail.get(i).getText());
			if(adultDetail.get(i).getText().equalsIgnoreCase(child1)){
				
				adultDetail.get(i).click();
				
				//AdultCount++;
			}/*else{
				
				addAdult.click();
				doAddNewAdult(childFirstName, childLastName, childGender);
				//AdultCount++;
			}*/
			i++;
		}
		return new TravellerDetailScreen(driver);
	}
	
	public TravellerDetailScreen enterEmail(String Email) throws IOException, InterruptedException{
		
		emailField.clear();
		emailField.sendKeys(Email);
		driver.navigate().back();
		return new TravellerDetailScreen(driver);
	}
	
	public TravellerDetailScreen enterPhoneNumber(String PhoneNumber) throws IOException, InterruptedException{
		
		phoneNumberField.clear();
		float f = Float.parseFloat(PhoneNumber);
		double mobileNum = (double)Math.round(f);
		String mobileNum1 = Double.toString(mobileNum);
		phoneNumberField.sendKeys(mobileNum1);
		driver.navigate().back();
		return new TravellerDetailScreen(driver);
	}
	
	public PaymentModeScreen doBookFlight() throws IOException, InterruptedException{
		
		/*int i=0;
		while(i<bookFlightBtn.size()){
			
			bookFlightBtn.get(i).getText();
			if(bookFlightBtn.get(i).getText().equalsIgnoreCase("BOOK FLIGHT")){
				bookFlightBtn.get(i).click();
				break;
			}
		}*/
		bookFlightID.click();
		System.out.println("Clicked on button");
		return new PaymentModeScreen(driver);
	}
}
