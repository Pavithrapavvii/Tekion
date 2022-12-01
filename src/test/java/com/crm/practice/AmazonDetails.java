package com.crm.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Listeners;

import io.github.bonigarcia.wdm.WebDriverManager;

//@Listeners(com.testyourskill.genericutility.Listener.class)
public class AmazonDetails {

	public static void main(String[] args) throws Throwable {

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.get("https://www.amazon.in/");

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("mobiles");

		driver.findElement(By.xpath("//input[@type ='submit']")).click();

		driver.findElement(By.xpath("//div[@cel_widget_id='MAIN-SEARCH_RESULTS-2']/descendant::span[@class='a-size-medium a-color-base a-text-normal']")).click();

		String productName = driver.findElement(By.xpath("//div[@cel_widget_id='MAIN-SEARCH_RESULTS-2']/descendant::span[@class='a-size-medium a-color-base a-text-normal']")).getText();

		String productPrice = driver.findElement(By.xpath("//div[@cel_widget_id='MAIN-SEARCH_RESULTS-2']/descendant::span[@class='a-price-whole']")).getText();

		Set<String> title = driver.getWindowHandles();

		for (String wd : title) {

			if(wd.equals(title)) {

			}

			else {

				driver.switchTo().window(wd);

			}

		}

		File file = new File("./Data/testData.xlsx");

		FileInputStream fis = new FileInputStream(file);

		Workbook wb = WorkbookFactory.create(fis);

		Sheet sheet = wb.getSheet("Demo");

		Row row = sheet.createRow(0);

		row.createCell(0).setCellValue(productName);

		row.createCell(1).setCellValue(productPrice);

		HashMap<String, String> map = new HashMap<String, String>();

		for(int i = 1; i <= 5; i++) {

			String temp1 = driver.findElement(By.xpath("//table[@class='a-normal a-spacing-micro' or @class='a-normal a-spacing-none a-spacing-top-base']/tbody/tr["+i+"]/td[1]/span")).getText();

			String temp2 = driver.findElement(By.xpath("//table[@class='a-normal a-spacing-micro' or @class='a-normal a-spacing-none a-spacing-top-base']/tbody/tr["+i+"]/td[2]/span")).getText();

			Row row1 = sheet.createRow(i);

			row1.createCell(0, CellType.STRING).setCellValue(temp1);

			row1.createCell(1, CellType.STRING).setCellValue(temp2);

			map.put(temp1, temp2); 

		}

		FileOutputStream fos = new FileOutputStream(file);
		wb.write(fos);
		wb.close();

		System.out.println("ProductName" + " : " + productName);

		System.out.println("ProductPrice" + " : " + productPrice);

		for ( Entry<String, String> st: map.entrySet()) {

			System.out.println(st.getKey()+" : "+st.getValue());


		}

	}

}
