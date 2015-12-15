package com.evon.appium.screens.nativeapp;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.evon.appium.base.ScreenBase;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SelendroidHomeScreen extends ScreenBase{

	//public static AndroidDriver driver;
	
	public SelendroidHomeScreen(AndroidDriver driver) throws IOException, InterruptedException{
		
		super(driver);
	}
	
	@AndroidFindBy(id = "io.selendroid.testapp:id/my_text_field")
	public WebElement textField;
	@AndroidFindBy(id = "io.selendroid.testapp:id/visibleButtonTest")
	public WebElement displayButton;
	@AndroidFindBy(id = "io.selendroid.testapp:id/visibleTextView")
	public WebElement displayText;
	@AndroidFindBy(id = "io.selendroid.testapp:id/buttonStartWebview")
	public WebElement WebViewButton;
	
	//public String textField= "io.selendroid.testapp:id/my_text_field";
	

	
	public SelendroidHomeScreen typeData(String data){
		
		System.out.println("value: " + driver);
		textField.sendKeys(data);
		//driver.findElementById(textField).sendKeys(data);
		return this;
	}
	
	public void verifyVisibleText(){
		
		displayButton.click();
		Assert.assertEquals(displayText.getText(), "Text is sometimes displayed");
	}
	
	public WebViewInteractionScreen webViewInteraction() throws IOException, InterruptedException{
		
		WebViewButton.click();
		System.out.println("Driver in webView: "+ driver);
		return new WebViewInteractionScreen(driver);
		
		
	}
}

