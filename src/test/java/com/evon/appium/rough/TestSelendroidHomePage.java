package com.evon.appium.rough;

import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;

import com.evon.appium.base.ScreenBase;
import com.evon.appium.screens.nativeapp.SelendroidHomeScreen;
import com.evon.appium.screens.nativeapp.WebViewInteractionScreen;
import com.evon.appium.utils.CommonUtils;

public class TestSelendroidHomePage extends ScreenBase{

	public TestSelendroidHomePage(AndroidDriver driver) throws IOException, InterruptedException {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//public static AndroidDriver driver;
	public static void main(String[] args) throws IOException, InterruptedException {
		
		CommonUtils.loadConfigProp("selendroidtestapp.properties");
		CommonUtils.setCapabilities();
		driver = CommonUtils.getDriver();
		System.out.println("Driver in TestSelendroid: "+ driver);
		SelendroidHomeScreen homeScreen = new SelendroidHomeScreen(driver);
		homeScreen.typeData("Hello");
		homeScreen.verifyVisibleText();
		WebViewInteractionScreen webViewIntr = homeScreen.webViewInteraction();
		webViewIntr.validateWebView();
		
	}

}
