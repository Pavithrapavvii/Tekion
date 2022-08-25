package com.testyourskill.genericutility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	
	//Object Creation for the Libraries
	
	public ExcelUtility exlib=new ExcelUtility();
	public FileUtility filelib=new FileUtility();
	public JavaUtility javalib=new JavaUtility();
	public WebDriverUtility weblib=new WebDriverUtility();
	
	//Connect to the DataBase
	@BeforeSuite (groups = {"smoke","regresion"})
	public void configBS() {
		System.out.println("........connect to database........");
		
		
	}
	//Launch The Browser
	@BeforeClass (groups = {"smoke","regresion"})
	public void confgBC() throws Throwable{
		System.out.println("................Launch The Browser.........");
		String BROWSER=filelib.getPropertyKeyValue("browser");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();	
	    driver.manage().window().maximize();
		weblib.waitForElementInDOM(driver);
		String UN=filelib.getPropertyKeyValue("username");
		String PW=filelib.getPropertyKeyValue("password");
	    
		String URL=filelib.getPropertyKeyValue("url2");
		driver.get(URL);
	}
	
	
	@BeforeMethod (groups = {"smoke","regresion"})
	public void configBM()  {
		
		
	}
	@AfterMethod (groups = {"smoke","regresion"})
	public void confgAM() {
		
		//Homepage home=new Homepage(driver);
		
		
	}
	
	@AfterClass (groups = {"smoke","regresion"})
	public void configAC()
	{
		System.out.println(".....close the browser......");
		//driver.close();
		
	}
	public void capturescreenshot(String scriptName)
	{
		TakesScreenshot ts= (TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dst=new File("./screenshot/"+javalib.getSystemDate()+"/"+scriptName);
		try {
			FileUtils.copyFile(src, dst);
		}catch (IOException e)
		{
		
	}
		System.out.println("screenshot saved successfullly");
	
	}
	
	@AfterSuite (groups = {"smoke","regresion"})
	public void configAS(){
		System.out.println("....close the Database....");
		
	}
	

}
