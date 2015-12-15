package com.evon.appium.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.evon.appium.base.TestBase;
import com.evon.appium.screens.nativeapp.SelendroidHomeScreen;
import com.evon.appium.screens.nativeapp.WebViewInteractionScreen;

public class SelendroidHomePageValidationTest extends TestBase{

	@Test
	public void validateHomeScreenTest() throws IOException, InterruptedException{
		
	homeScreen = new SelendroidHomeScreen(driver);
	homeScreen.typeData("Hello");
	homeScreen.verifyVisibleText();
	homeScreen.webViewInteraction();
	
	}
}
