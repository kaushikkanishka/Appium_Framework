package com.evon.appium.utils;

import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;


public class Appiumserver {
	
	
	//Appium Launch on Windows
	private static Process process;

	//Calling the node.exe and appium.js
	private static String STARTSERVER = "C:\\Program Files (x86)\\Appium\\node.exe C:\\Program Files (x86)\\Appium\\node_modules\\appium\\bin\\appium.js";
	//Starting the Appium Server
	
	public static void start() throws IOException, InterruptedException {

		if (process!=null){
			
			Runtime runtime = Runtime.getRuntime();

			process = runtime.exec(STARTSERVER);
			
			System.out.println("Starting server...");
		}
	

	Thread.sleep(7000);

	if (process != null) {

		
	System.out.println("Appium server started");

	}else{
		
		System.out.println("Failed to start server");
	}

	}

	
	//Stopping the Appium Server
	
	public static void stop() throws IOException {

	if (process != null) {

	process.destroy();

	}

	System.out.println("Appium server stopped");

	}

}
