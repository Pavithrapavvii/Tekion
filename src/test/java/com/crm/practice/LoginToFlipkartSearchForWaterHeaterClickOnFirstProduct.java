package com.crm.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginToFlipkartSearchForWaterHeaterClickOnFirstProduct
{
	//WebDriver driver=null;
	@Test
	public void Login()
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");	
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("waterheater");
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'BAJAJ 25 L Storage Water Geyser ')]")).click();
		driver.close();	
	}

}
