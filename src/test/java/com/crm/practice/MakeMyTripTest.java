package com.crm.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTripTest {
	@Test
	public void test() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		WebElement frame = driver.findElement(By.xpath("//iframe[@id='webklipper-publisher-widget-container-notification-frame']"));
		// WebDriverWait wait=new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.elementToBeClickable(frame));
		driver.switchTo().frame(frame);
	
		//String frame = driver.getWindowHandle();
		//System.out.println(frame);
driver.findElement(By.xpath("//a[@id='webklipper-publisher-widget-container-notification-close-div']")).click();
		Thread.sleep(2000);
		 WebElement ele2 = driver.findElement(By.xpath("//a[@class='primaryBtn font24 latoBold widgetSearchBtn 'and contains(.,'Search')]"));
		 Actions act=new Actions(driver);
		 act.doubleClick(ele2);
		driver.findElement(By.xpath("//span[@class='bgProperties icon20 overlayCrossIcon']")).click();
        /* for(int num=0;num<=40;num++)
         {
        	if(num<=30)
        	{
        		driver.findElement(By.xpath("//div[@class='filtersOuter' and contains(.,'Popular')]/descendant::div[@class='makeFlex flexOne gap-x-10' and contains(.,'"+num+"')]/descendant::span[@class='customCheckbox']")).click();    		
        	}
         }*/     
	
	}
}
