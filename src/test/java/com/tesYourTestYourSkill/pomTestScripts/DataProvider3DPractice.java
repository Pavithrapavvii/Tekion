package com.tesYourTestYourSkill.pomTestScripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider3DPractice {
	@Test(dataProvider ="BookticketTest")
	public void Print(String src,String dst,String amount)
	{
		System.out.println("Book ticket from "+src+"To "+amount);
	}
	@DataProvider
	public Object[][] BookticketTest()
	{
		Object[][] objarr=new Object[2][3];
		objarr[0][0]="bangalore";
		objarr[0][1]="bangalore";
		objarr[0][2]="30";
		objarr[1][0]="bangalore";
		objarr[1][1]="bangalore";
		objarr[1][2]="60";
		
		return objarr;
		
	}
	
	
	

}
