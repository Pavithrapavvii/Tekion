package com.testyourskill.PomReposototyLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentAttendQuiz {
	@FindBy(xpath="//div[@class='panel']/child::form/child::input[@value='62ff3c38b17f0']")
	private WebElement ChooseOption1 ;
	
	@FindBy(xpath="(//button[@type='submit'])[2]")
			private WebElement clickbtn;
			
	
	@FindBy(xpath="(//input[@type='radio'])[3]")
	private WebElement ChooseOption2;
	
	@FindBy(xpath="//button[@type='submit']/span[@class='glyphicon glyphicon-lock']")
	private WebElement clickbtn2;
	
	@FindBy(xpath="//span[@class='glyphicon glyphicon-list-alt']")
	private WebElement Finalclick;

	
	
	public StudentAttendQuiz(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	public WebElement getChooseOption1() {
		return ChooseOption1;
	}

	public WebElement getClickbtn() {
		return clickbtn;
	}

	public WebElement getChooseOption2() {
		return ChooseOption2;
	}

	public WebElement getChooseOption3() {
		return clickbtn2;
	}

	public WebElement getFinalclick() {
		return Finalclick;
	}
	
	public void studentQuiz()
	{
		ChooseOption1.click();	
		clickbtn.click();
		ChooseOption2.click();
		clickbtn2.click();
		Finalclick.click();
	}
	
	
	
	
	
	

}
