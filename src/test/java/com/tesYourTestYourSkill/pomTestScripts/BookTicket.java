package com.tesYourTestYourSkill.pomTestScripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BookTicket 
{
	@Test(dataProvider = "dataprivider_bookTicketTest")
	
		public void book(String src,String dst)
		{
			System.out.println("Book ticket from " +dst+ " to " +src);
		} 
	@DataProvider
	public Object[][] dataprivider_bookTicketTest()
	{	
 Object[][] objarr=new Object[5][2];
 objarr[0][0]="Bangalore";
 objarr[0][1]="mysore";
 objarr[1][0]="man";
 objarr[1][1]="manga";
 objarr[2][0]="Bangalore";
 objarr[2][1]="hubli";
 objarr[3][0]="Bangalore";
 objarr[3][1]="mandya";
 objarr[4][0]="Bangalore";
 objarr[4][1]="shimogga";
 return objarr;	 
	}
	}
	


