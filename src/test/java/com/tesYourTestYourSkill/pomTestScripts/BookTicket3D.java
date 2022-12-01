package com.tesYourTestYourSkill.pomTestScripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BookTicket3D {
	@Test(dataProvider = "BookTickettest")
	public void bookticketsrcdst(String src,String dst,String to)
	{
		System.out.println("book ticket from  " +src+ "to  "+dst);
	}
	@DataProvider
	public Object[][] BookTickettest()
	{
		Object[][] objarr=new Object[3][3];
		objarr[0][0]="banga";
		objarr[0][1]="mysore";
		objarr[0][2]="20";
		objarr[1][0]="banga";
		objarr[1][1]="manga";
		objarr[1][2]="30";
		objarr[2][0]="banga";
		objarr[2][1]="mandya";
		objarr[2][2]="30";
		return objarr;
	}
	

}
