package com.testyourskill.PRACTICE;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginAsAdminRemoveQuiz {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//step:1 read the file using fileinputstream
		WebDriver driver=null;
		FileInputStream fis=new FileInputStream(".\\Dataproperty\\Commondata.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String URL=prop.getProperty("url");
		String UN=prop.getProperty("adminuserid");
		String PWD=prop.getProperty("password");
		String Browser=prop.getProperty("browser");
		if(Browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}else if(Browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else {
		  System.out.println("incorrect browser");
		  
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
		driver.findElement(By.xpath("//a[@data-target='#login']")).click();
		driver.findElement(By.name("uname")).sendKeys(UN);
		driver.findElement(By.xpath("(//input[@type=\"password\"])[4]")).sendKeys(PWD);
		driver.findElement(By.name("login")).click();
		driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
		driver.findElement(By.xpath("//a[.='Remove Quiz']")).click();
		driver.findElement(By.xpath("//td[.='Selenium Quiz']/..//span[@class='title1']")).click();
					

}
}
