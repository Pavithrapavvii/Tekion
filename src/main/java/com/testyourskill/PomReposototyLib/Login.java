package com.testyourskill.PomReposototyLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Login {
	//Rule1: Create a seperate java class for every page in a application
	
	//Rule2:Identify all the elements using @FindBY,FindAll,@findBys
	
	@FindBy(id="name")
	private WebElement EnterYourNamea;
	
	@FindBy(id="gender")
	private WebElement SelectGendera;
	
	@FindBy(id="college")
	private WebElement EnterYourCollegeName;
	
	@FindBy(xpath ="(//input[@id='email'])[2]")
	private WebElement EnterYourMaila;
	
	@FindBy(id ="mob")
	private WebElement EnterYourMobileNumber;
	
	@FindBy(xpath ="(//input[@id='password'])[2]")
	private WebElement EnterYourPassworda;
	
	@FindBy(id ="cpassword")
	private WebElement ConfirmPassworda;
	
	@FindBy(xpath ="(//input[@type='submit'])[1]")
	private WebElement ClickSubmita;
	
	//Rule3: Execute all the elements and initialise the elements
	public Login(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	
	//Rule4:Declare the all the methods as private and provide the getters method ,,business method for (utilization)
	
	public WebElement getEnterYourNamea() {
		return EnterYourNamea;
	}

	public WebElement getSelectGendera() {
	return SelectGendera;
	}

	public WebElement getEnterYourCollegeName() {
		return EnterYourCollegeName;
	}

	public WebElement getEnterYourMaila() {
		return EnterYourMaila;
	}

	public WebElement getEnterYourMobileNumber() {
		return EnterYourMobileNumber;
	}

	public WebElement getEnterYourPassworda() {
		return EnterYourPassworda;
	}

	public WebElement getConfirmPassworda() 
	{
		return ConfirmPassworda;
	}

	public WebElement getClickSubmita()
	{
		return ClickSubmita;
	}
	
	
	//Step1:Login To Application
	public void LoginToApplication(String StudentName,String gender,String collegeName,String Email,String Mobilenum,String Password,String ConfirmPassword)
	{
		EnterYourNamea.sendKeys(StudentName);
		SelectGendera.sendKeys(gender);
		EnterYourCollegeName.sendKeys(collegeName);
		EnterYourMaila.sendKeys(Email);
		EnterYourMobileNumber.sendKeys(Mobilenum);
		EnterYourPassworda.sendKeys(Password);
		ConfirmPassworda.sendKeys(ConfirmPassword);
		ClickSubmita.click();
	}
		
		
		
		
		
	
}
	
	
	
	
 


