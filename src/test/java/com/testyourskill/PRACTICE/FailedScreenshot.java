package com.testyourskill.PRACTICE;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.testyourskill.genericutility.BaseClass;

public class FailedScreenshot extends BaseClass{
	@Test (retryAnalyzer =com.testyourskill.PRACTICE.RetryClass.class )
	public void flipkart() {
		driver.get("https://www.flipkart.com");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		Assert.assertTrue(false);
	}
 @Test
 public void amazon() {
	 driver.get("https://www.amazon.com");
 }
}
