package com.testyourskill.Admin;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginAsAdminAddQuizAndRemoveQuizViewinHomePage {
	public static void main(String[] args) throws IOException {
		WebDriver driver=null;
		Random ran=new Random();
		double random=ran.nextDouble();
		
		//step1:read the data using fileinput stream
		
		FileInputStream fis=new FileInputStream(".//Dataproperty//Commondata.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String URL=prop.getProperty("url");
		String UN=prop.getProperty("adminuserid");
		String PWD=prop.getProperty("password");

		
		//STEP2:Read the data from excel
		FileInputStream filexcel=new FileInputStream(".//Dataproperty//DataDriven.xlsx");
		Workbook WB=WorkbookFactory.create(filexcel);
		String USERNAME=WB.getSheet("mj").getRow(3).getCell(2).getStringCellValue();
		String CNAME=WB.getSheet("mj").getRow(4).getCell(2).getStringCellValue();
		String EMAIL=WB.getSheet("mj").getRow(5).getCell(2).getStringCellValue();
		String MOBNO=WB.getSheet("mj").getRow(6).getCell(2).getStringCellValue();
		String PW=WB.getSheet("mj").getRow(7).getCell(2).getStringCellValue();
		String CPW=WB.getSheet("mj").getRow(8).getCell(2).getStringCellValue();
		
		
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
		driver.findElement(By.xpath("//a[@data-target='#login']")).click();
		driver.findElement(By.name("uname")).sendKeys(UN);
		driver.findElement(By.xpath("(//input[@type=\"password\"])[4]")).sendKeys(PWD);
		driver.findElement(By.name("login")).click();
		driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
		driver.findElement(By.xpath("//a[.='Remove Quiz']")).click();
		//driver.findElement(By.xpath("//td[text()='Ad']/ancestor::tr/descendant::b[text()='Remove']")).click();
		driver.findElement(By.xpath("//a[@href='logout.php?q=account.php'and @class='log']")).click();
		driver.findElement(By.xpath("//a[@data-target='#login']")).click();
		driver.findElement(By.name("uname")).sendKeys(UN);
		driver.findElement(By.xpath("(//input[@type=\"password\"])[4]")).sendKeys(PWD);
		driver.findElement(By.name("login")).click();
         String expmsg="Selenium";
		List<WebElement> lst = driver.findElements(By.xpath("//table/tbody/tr[*]/td[2]"));
		boolean flag=false;
		for(WebElement wb:lst)
	
		{
			String Actmsg=wb.getText();
			System.out.println(Actmsg);
			if(Actmsg.equals(expmsg)){
				System.out.println(expmsg+  "     TC is pass");
				flag=true;
			
			}	
		}
		if(!flag)
		{
			System.out.println("TC IS FAIL");
		}driver.findElement(By.xpath("(//span[@class='glyphicon glyphicon-log-out'])[1]")).click();
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(USERNAME);
	    WebElement gender = driver.findElement(By.xpath("//select[@name='gender']"));
	       Select sel=new Select(gender);
	       sel.selectByIndex(1);
	       driver.findElement(By.id("college")).sendKeys(CNAME);
	       driver.findElement(By.xpath("(//input[@id='email'])[2]")).sendKeys(EMAIL+random+"@gmail.com");
	       driver.findElement(By.id("mob")).sendKeys(MOBNO);
	       driver.findElement(By.xpath("(//input[@id='password'])[2]")).sendKeys(PW);
	       driver.findElement(By.id("cpassword")).sendKeys(CPW);
	       driver.findElement(By.xpath("//input[@class='sub']")).click();
	       driver.findElement(By.xpath("//table/tbody/tr[3]/td[last()]/descendant::b[text()='Start']")).click();
	       driver.findElement(By.xpath("//div[@class='panel']//child::form/button/preceding-sibling::input[1]")).click();
	       driver.findElement(By.xpath("//div[@class='panel']//child::form/button")).click();
	       driver.findElement(By.xpath("//div[@class='panel']//child::form/button/preceding-sibling::input[1]")).click();	
	       driver.findElement(By.xpath("//div[@class='panel']//child::form/button")).click();
	}
}
