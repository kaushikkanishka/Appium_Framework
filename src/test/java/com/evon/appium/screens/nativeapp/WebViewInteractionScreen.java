package com.evon.appium.screens.nativeapp;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;

import com.evon.appium.base.ScreenBase;

public class WebViewInteractionScreen extends ScreenBase {

	public WebViewInteractionScreen(AndroidDriver driver) throws IOException, InterruptedException {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@AndroidFindBys({
		@AndroidFindBy(id = "io.selendroid.testapp:id/tableHeader"),
		@AndroidFindBy(className = "android.widget.TextView")
	})
	public WebElement webTextView;
	
	public WebViewInteractionScreen validateWebView(){
		
		Assert.assertEquals(webTextView.getText(), "Web View Interaction");
		System.out.println(driver.getPageSource());
		return this;
	}
}
