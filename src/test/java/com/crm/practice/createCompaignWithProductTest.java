package com.crm.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.testyourskill.genericutility.ExcelUtility;
import com.testyourskill.genericutility.FileUtility;
import com.testyourskill.genericutility.JavaUtility;
import com.testyourskill.genericutility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class createCompaignWithProductTest {
	public static void main(String[] args) throws Throwable {
		//create object for webdriver utility
		 WebDriver driver=null;
		WebDriverUtility wlib=new WebDriverUtility();
			FileUtility flib=new FileUtility();
			ExcelUtility elib=new ExcelUtility();
			JavaUtility jlib=new JavaUtility();
			
			//read common data properties file
			String URL=flib.getPropertyKeyValue("url");
			String BROWSER=flib.getPropertyKeyValue("browser");
			String USERNAME=flib.getPropertyKeyValue("username");
			String PASSWORD=flib.getPropertyKeyValue("password");
			
			
			//GET RANDOM NUMBER
			int intRanNum=jlib.getRanDomNumber();
			
			
			//READ TEST DATA FROM EXCEL
			String compaignName=elib.getExcelData("mj",4,2)+intRanNum;
			String productName=elib.getExcelData("mj", 4, 3)+intRanNum;
			
			
			//launch the browser
			WebDriverManager.chromedriver().setup(); 
			 driver = new ChromeDriver();
			 wlib.waitForElementInDOM(driver);
			
	        //STEP1:LOGIN TO APPN
			wlib.waitForElementInDOM(driver);
			driver.get(URL);
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			
			//step:2 navigate to product page
			driver.findElement(By.linkText("Products")).click();
			
			//step:3 navigate to product page
			driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
			
			//step:4 create a new product
			driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(productName);
			driver.findElement(By.xpath("(//input[@type='submit'])[1]")).click();

			//step5:Navigate to compaign page
			WebElement more= driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
			wlib.mouseOverOnElement(driver, more);
			//step6:navigate to create compaign page
			driver.findElement(By.xpath("//a[@name='Campaigns']")).click();
			
			driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
			
			driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
			
			wlib.swithToWindow(driver, "Products&action");
			
			driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(productName);
			driver.findElement(By.xpath("//input[@type='button']")).click();
			driver.findElement(By.xpath("//a[@href='javascript:window.close();']")).click();
			
			wlib.swithToWindow(driver, "http://rmgtestingserver:8888/index.php?module=Campaigns&action=EditView&return_action=DetailView&parenttab=Marketing");
			driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(compaignName);
			driver.findElement(By.xpath("//input[@name='button' and @class='crmButton small save']")).click();
			
			//verify the compaign name
			String actval = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(actval.contains("Campaign Information"))
			{
				System.out.println("TC IS PASS");
			}
			else
			{
				System.out.println("TC IS FAIL");
			}
			driver.close();
					
	}

}
