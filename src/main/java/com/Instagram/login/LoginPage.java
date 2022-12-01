package com.Instagram.login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginPage {
	


	 @FindBy(xpath = "//input[@name='username']") 
	 private WebElement userName;
	 
	 @FindBy(xpath ="//input[@name='password']")
	 private WebElement password;
	 
	 @FindBy(xpath = "//button[@class='_acan _acap _acas']")
	 private WebElement clickButton;
	 
	 @FindBy(xpath = "//button[text()='Not Now']")
	 private WebElement NotNowButton;
	 
	 public void LoginPage(WebDriver driver)
	 {
		 PageFactory.initElements(driver,this);
	 }

	public WebElement getuserName()
	{
		return userName;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getClickButton() {
		return clickButton;
	}

	public WebElement getNotNowButton() {
		return NotNowButton;
	}
	 
	 
	 
	 
 }

