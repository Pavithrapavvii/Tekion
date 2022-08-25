package com.testyourskill.PRACTICE;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClickAllCheckBox 
{

	public static void main(String[] args)
	{
		WebDriver driver=null;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://rmgtestingserver:8888/index.php?action=index&module=Home");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
		List<WebElement> lst = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]"));
		String expmsg="Qspider";
		
		boolean flag=false;
		for(WebElement wb:lst)
	
		{
			String Actmsg=wb.getText();
			System.out.println(Actmsg);
			wb.click();
			if(Actmsg.equals(expmsg)){
				System.out.println(expmsg+  "     TC is pass");
				flag=true;
			
			}
			
		}
		if(!flag)
		{
			System.out.println("TC IS FAIL");
		}
	}

}


