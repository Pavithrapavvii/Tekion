package com.testyourskill.PomReposototyLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLogin {

	@FindBy(xpath="//a[text()='Admin Login']")
	private WebElement Adminclick;
	
	@FindBy(name="uname")
	private WebElement UNAME;
	
	@FindBy(xpath="//form[@method='post']/descendant::input[@name='password']")
	private WebElement PASS;
	
	@FindBy(name="login")
	private WebElement CLICK;
	
	
	public WebElement getAdminclick() {
		return Adminclick;
	}

	public WebElement getUNAME() {
		return UNAME;
	}

	public WebElement getPASS() {
		return PASS;
	}

	public WebElement getClick() {
		return CLICK;
	}
	public AdminLogin(WebDriver driver)
	{
		
		PageFactory.initElements(driver,this);
	}
	
	public void login(String adminuserid,String password ) throws InterruptedException 
	{
		Adminclick.click();
		UNAME.sendKeys(adminuserid);
		Thread.sleep(3000);
		PASS.sendKeys(password);
		Thread.sleep(3000);
		CLICK.click();
		
		
	}
	}

	
	

	

