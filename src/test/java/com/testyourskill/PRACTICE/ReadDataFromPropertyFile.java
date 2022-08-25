package com.testyourskill.PRACTICE;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {
	public static void main(String[] args) throws IOException {
		//step1: use fileinputstream to load the property file
		FileInputStream fis=new FileInputStream(".\\Dataproperty\\Commondata.properties");
		 
		//step2: create the object of property and load the file
		Properties prop=new Properties();
		prop.load(fis);
		 
		//step3: provide key to read the value
		String url=prop.getProperty("url");
		System.out.println(url);
		
		String pass=prop.getProperty("password");
		System.out.println(pass);
		
		
	}
 
}
