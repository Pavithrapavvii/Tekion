package com.testyourskill.genericutility;

import java.sql.Connection;
import java.sql.DriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassPractice {
	public ExcelUtility exe=new ExcelUtility();
	public JavaUtility jlib=new JavaUtility();
	
	@BeforeSuite

	public void config()
	{
		/*Driver driver=new Driver();
	//	DriverManager.registerDriver(driver);
		Connection con = DriverManager.getConnection("","","");
		String query="select * from emp";
		con.createStatement().executeQuery(query);
		con.createStatement().executeUpdate(query);	 */
	}
	@BeforeClass
	public void LaunchBrowser()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("google.com");
		
	}
	@BeforeMethod
	public void Login()
	{
		
	}
 
}
