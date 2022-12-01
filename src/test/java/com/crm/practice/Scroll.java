package com.crm.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
 
public class Scroll {
      public static void main(String[] args) throws InterruptedException {
    	  
    	  ChromeOptions option=new ChromeOptions();
          option.addArguments("--disable-notifications");
    	  
         WebDriverManager.chromedriver().setup();
          WebDriver driver = new ChromeDriver(option);
          driver.manage().window().maximize();
          
          driver.get("https://www.clinique.in/");         //testing webpage
         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
         driver.findElement(By.xpath("//button[@class='onetrust-close-btn-handler onetrust-close-btn-ui banner-close-button ot-close-icon']")).click();
          driver.findElement(By.xpath("//h2[contains(text(),'Sign')]/preceding-sibling::div")).click();
          driver.findElement(By.xpath("//div[@class=\"hero-full-width__content margin-left-0 hero-full-width__content--right-default margin-top-15 text-align--left \"]/descendant::span")).click();
         //driver.switchTo().alert().accept();                         //login button
         
           
      }
}
