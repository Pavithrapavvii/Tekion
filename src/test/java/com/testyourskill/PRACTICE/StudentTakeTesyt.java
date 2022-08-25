package com.testyourskill.PRACTICE;



import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StudentTakeTesyt {

public static void main(String[] args) throws Throwable
{
	WebDriver driver=null;
		//step1:- read all the necessary common data
	FileInputStream fis = new FileInputStream(".//Dataproperty//Commondata.properties");
	Properties prop = new Properties();
	prop.load(fis);
	String URL = prop.getProperty("url");
	String browser=prop.getProperty("browser");
	String SLogin = prop.getProperty("studentlogin");
	String S_PASSWORD = prop.getProperty("Spassword");
	

		//step2:- read the test data from excel sheet
	FileInputStream fis1 = new FileInputStream(".//Dataproperty//DataDriven.xlsx");
	Workbook workbook = WorkbookFactory.create(fis1);
	Sheet sh = workbook.getSheet("mj");
    Row row=sh.getRow(1);
    Cell cel = row.getCell(2);
    cel.getStringCellValue();
	
	
		//step3:- launch the browser
	if (browser.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	else if(browser.equalsIgnoreCase("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}
	else
	{
		System.out.println("INCORRECT BROWSER");
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get(URL);
	
	//step4.0:- student signup
	
	
	
		//step4:- login to application
		driver.findElement(By.xpath("//a[@class='pull-right btn sub1']")).click();
		driver.findElement(By.id("email")).sendKeys( SLogin);
		driver.findElement(By.id("password")).sendKeys(S_PASSWORD);
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		driver.findElement(By.xpath("(//a[@class='pull-right btn sub1'])[1]")).click();
		//driver.findElement(By.xpath("//td[text()='Selenium Quiz']/..//span[@class='title1']")).click();
		driver.findElement(By.xpath("(//input[@type='radio'])[1]")).click();
		driver.findElement(By.xpath("//form[@class='form-horizontal']/..//button[@type='submit']")).click();
		
		

		//step5:- Navigate to homepage
		//step6:- click on taketest button
		
	
}
}

		