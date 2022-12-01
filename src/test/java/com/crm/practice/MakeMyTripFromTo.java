package com.crm.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTripFromTo {
	@Test
	public void loginAndSearchForTrip() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		WebElement frame = driver.findElement(By.xpath("//iframe[@id='webklipper-publisher-widget-container-notification-frame']"));
		//WebDriverWait wait=new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.elementToBeClickable(frame));
		driver.switchTo().frame(frame);
	
		//String frame = driver.getWindowHandle();
		//System.out.println(frame);
		
     driver.findElement(By.xpath("//a[@id='webklipper-publisher-widget-container-notification-close-div']")).click();
     driver.findElement(By.xpath("//input[@id='fromCity']")).click();
     WebElement elem = driver.findElement(By.xpath("//p[text()='Mumbai, India']"));
     
   //  WebDriverWait wait=new WebDriverWait(driver, 10);
     
    // wait.until(ExpectedConditions.visibilityOf(elem));
     
     List<WebElement> list = driver.findElements(By.xpath("//ul[@class='react-autosuggest__suggestions-list']/descendant::li"));
    JavascriptExecutor js=(JavascriptExecutor)driver;
    WebElement ele = list.get(list.size()-3);
    int y = elem.getLocation().getY();
    Actions act=new Actions(driver);
    act.moveToElement(elem);
    js.executeScript("window.scrollBy(0,"+y+")");
    Thread.sleep(2000);
     ele.click();
     //driver.findElement(By.xpath("//p[contains(text(),'Mumbai, India')]")).click();
     driver.findElement(By.xpath("//p[contains(text(),'Bangkok, Thailand')]")).click();
     driver.findElement(By.xpath("//div[@class='DayPicker-Body']/..//ancestor::div[text()='October 2022']/../../descendant::p[text()='30']")).click();
      
//driver.close();
	}
}
	