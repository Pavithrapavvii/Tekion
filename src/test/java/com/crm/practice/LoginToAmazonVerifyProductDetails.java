package com.crm.practice;


	import java.util.ArrayList;
	import java.util.Set;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class LoginToAmazonVerifyProductDetails {
		
		public static void main(String[] args) throws Throwable {
			
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			
			driver.get("https://www.amazon.in/");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			String[] expValues1 = {"Amazon Basics", "52.5D x 57.1W x 92.9H Centimeters", "6.5 Kilograms", "Top Load", "Grey"};
			
			driver.findElement(By.xpath("//input[@type='text']")).sendKeys("washing machine amazon basic");
			
			driver.findElement(By.xpath("//input[@type ='submit']")).click();
			                           
			driver.findElement(By.xpath("//div[@cel_widget_id='MAIN-SEARCH_RESULTS-2']/descendant::div[@class='aok-relative']")).click();
			 
			Set<String> title = driver.getWindowHandles();
			
			for (String wd : title) {
				
				if(wd.equals(title)) 
				{
					
				}
				
				else {
					
					driver.switchTo().window(wd);
					
				}
				
			}
			
			String[] key = {"Brand", "Product Dimensions", "Capacity", "Access Location", "Colour"};
			
			ArrayList<String> actValue = new ArrayList<String>();
			
			for(int i =0; i < key.length; i++) 
			{
			
				String temp = driver.findElement(By.xpath("//span[text()='"+key[i]+"']/parent::td/following-sibling::td/span")).getText();
				
			 actValue.add(temp);
			 
			 temp ="";
			 
			}
			
			for(int i = 0; i < key.length; i++) {
				
				for(int j = 0; j < key.length; j++) {
					
					 if(expValues1[i].equals(actValue.get(j))) {
						 
						 System.out.println(key[i] + " ==> " + actValue.get(j));
						 		 
					 }
					
				}
				
			}
			
		}

	}




