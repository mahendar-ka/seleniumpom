package com.mystore.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties properties;
	String path="C:\\Users\\mahen\\OneDrive\\Desktop\\FrameWork\\MyStoreV1\\configaration\\config.properties";
	
	public ReadConfig() {
		try {
		properties = new Properties();
		FileInputStream fis = new FileInputStream(path);
		properties.load(fis);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
public String  getbaseUrl() {
	
	String value = properties.getProperty("baseUrl");
	if(value!= null)
		return value;
	else
		throw new RuntimeException("value not specified");
}
	
public String  getBrowser() {
	
	String value = properties.getProperty("browser");
	if(value!= null)
		return value;
	else
		throw new RuntimeException("value not specified");
}
}
