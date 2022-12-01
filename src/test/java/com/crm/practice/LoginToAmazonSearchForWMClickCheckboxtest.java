package com.crm.practice;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginToAmazonSearchForWMClickCheckboxtest {
	@Test
	public void amazon()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");	
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("washing machine");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		driver.findElement(By.xpath("//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1']/descendant::span[contains(text(),'Amazon Basics')]")).click();
		handleWindow(driver);
	}

	public void handleWindow(WebDriver driver)
	{
		String mainWindow = driver.getWindowHandle();
		Set<String> allwindow = driver.getWindowHandles();
		for(String lv:allwindow)
		{
			driver.switchTo().window(lv);
		}

		List<WebElement> value = driver.findElements(By.xpath("//td[@class='a-span4']"));
		//System.out.println(value);    It will print adress
		
		for(WebElement valueElement:value)
		{
			//String details = ;
			String details = valueElement.getText();
			if(details.contains("6.5 Kilograms"))
			{
				System.out.println("Items are pressent");
			}
		
		}
		driver.findElement(By.xpath("//input[g@id='mbb-offeringID-1']")).click();
		
		
	} 

}
