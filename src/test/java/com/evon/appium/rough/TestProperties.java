package com.evon.appium.rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
	
	public static Properties prop= new Properties();
	final static String USER_DIR = System.getProperty("user.dir");
	
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileInputStream fis = new FileInputStream(USER_DIR+"//src//test//resources//properties//selendroidtestapp.properties");
		prop.load(fis);
		
		System.out.println(fis);
		System.out.println(prop.getProperty("explicit.wait"));

	}

}
