package com.maveri.reference;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// location& access to read or write
		
		FileInputStream fileIn= new FileInputStream("Utilities/data.properties");
		
		Properties prop= new Properties();//memory allocation happened for empty properties file
		
		prop.load(fileIn);
		String url=prop.getProperty("url");
		System.out.println(url);
		
		String username=prop.getProperty("username");
		System.out.println(username);
		
		
	}

}
