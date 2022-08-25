package com.testyourskill.PomReposototyLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
	@FindBy(xpath="//td[text()='Gk3']/following-sibling::td[4]/b/a/span/b[text()='Start']")
	private WebElement startbtn;
	
	public Homepage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getStartbtn()
	{
		return startbtn;
	}
	public void startQuiz()
	{
		startbtn.click();
	}
	

}
