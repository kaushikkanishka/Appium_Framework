package com.evon.appium.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.evon.appium.base.TestBase;
import com.evon.appium.screens.nativeapp.WebViewInteractionScreen;

public class WebViewInteractionTest extends TestBase {

	@Test
	public void webViewTest() throws IOException, InterruptedException{
		
		webViewIntr = new WebViewInteractionScreen(driver);
		webViewIntr.validateWebView();
	}
}
