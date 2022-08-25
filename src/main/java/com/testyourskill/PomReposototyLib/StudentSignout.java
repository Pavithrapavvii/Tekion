package com.testyourskill.PomReposototyLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentSignout 
{
	@FindBy(xpath="//li[@class='pull-right']")
	private WebElement signout;



	public WebElement getSignout() {
		return signout;
	}
	
	public StudentSignout(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Slogout()
	{
		signout.click();
	}
	

}
