package com.crm.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginToIccCricketMouseOverToRankingClickOnPlayersRankingInWoomenCatogory {
	@Test
	public void login()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.icc-cricket.com/awards/overview");
		driver.findElement(By.xpath("//nav[@class='main-navigation__desktop-list js-desktop-nav']/descendant::button[@class='linked-list__dropdown-label js-dropdown-btn' and contains(text(),'Rankings')]")).click();
	    driver.findElement(By.xpath("(//li[@class='linked-list__item  has-children ']/descendant::ul[@class='linked-list__dropdown']/descendant::li[@class='linked-list__item   ']/child::a[normalize-space(text())='Player Rankings'])[1]")).click();
	}

}
