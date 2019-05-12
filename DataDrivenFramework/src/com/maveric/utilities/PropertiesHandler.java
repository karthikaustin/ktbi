package com.maveric.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHandler {

	public static Properties getPropertiesDetails(String fileDetails) throws IOException {
    
		FileInputStream fileIn= new FileInputStream(fileDetails);
		
		Properties prop= new Properties();//memory allocation happened for empty properties file
		prop.load(fileIn);
		
		return prop;
	}
	
	public static String getValueFromKey(String fileDetails, String key) throws IOException
	{
     FileInputStream fileIn= new FileInputStream(fileDetails);
		
		Properties prop= new Properties();//memory allocation happened for empty properties file
		prop.load(fileIn);
		
		String Value = prop.getProperty(key);
		return key;
	}
}