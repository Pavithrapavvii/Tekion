package com.testyourskill.PRACTICE;


import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StudentTakingQuizAndGivingFeedback {



	

	// Method to read all the data from Excel Sheet
	public static String getData(String sheetname,int row, int col) throws Throwable
	{
		FileInputStream  FISX= new	FileInputStream(".\\Dataproperty\\TYS_TestCases.xlsx");
		Workbook book = WorkbookFactory.create(FISX);
		String d = book.getSheet(sheetname).getRow(row).getCell(col).toString();
		return d;
	}

	public static void main(String[] args) throws Throwable {

		WebDriver driver=null;

		Random ran = new Random();
		int random = ran.nextInt(500);

		//Step 1:Read all the necessary common data
		FileInputStream FISP = new FileInputStream(".\\Dataproperty\\Commondata.properties");
		Properties prop = new Properties();
		prop.load(FISP);
		String URL = prop.getProperty("url2");
		String ADMINLOGIN = prop.getProperty("adminuserid");
		String ADMINPASSWORD = prop.getProperty("username");
		String BROWSER = prop.getProperty("browser");
		//String STUDENTLOGIN = prop.getProperty("studentlogin");
		//String STUDENTPASSWORD = prop.getProperty("spassword");

		//Step 2:Read all the data from excel sheet
		String QuizTitle = getData("Sheet1", 7, 2);
		String StudentName = getData("Sheet1", 9, 2);
		String CollegeName= getData("Sheet1", 9, 3);
		String Email= getData("Sheet1", 9, 4)+random;
		String Mobilenum= getData("Sheet1", 9, 5);
		String Password= getData("Sheet1", 9, 6);
		String ConfirmPassword = getData("Sheet1", 9, 7);
		String FeedbackDescription = getData("Sheet1", 9, 8);



		//Step 3:Launch the browser
		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("incorrect browser");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(URL);

		//Step 4: Signing in as Student
		driver.findElement(By.id("name")).sendKeys(StudentName);
		WebElement A1 = driver.findElement(By.id("gender"));
		Select Ans1 = new Select(A1);
		Ans1.selectByIndex(1);
		driver.findElement(By.id("college")).sendKeys(CollegeName);
		driver.findElement(By.xpath("(//input[@id='email'])[2]")).sendKeys(Email);
		driver.findElement(By.id("mob")).sendKeys(Mobilenum);
		driver.findElement(By.xpath("(//input[@id='password'])[2]")).sendKeys(Password);
		driver.findElement(By.id("cpassword")).sendKeys(Password);
		driver.findElement(By.xpath("(//input[@type='submit'])[1]")).click();

		//Step 5:Student taking Quiz
		String ExpectedQuiztitle = QuizTitle;
		boolean flag=false;
		String actualresult=driver.getCurrentUrl();
		System.out.println(actualresult);
		//SoftAssert s = new SoftAssert();
		Assert.assertEquals(actualresult, ExpectedQuiztitle);

		

		//Step 11: Verifying the created Quiz Present in Student Home page
		
	
		/*for (WebElement wb : StudentPageTitle) {
			String ActualTitle=wb.getText();
			
		if (ActualTitle.equalsIgnoreCase(ExpectedQuiztitle)) 
			{
				System.out.println("Created Quiz present in Student Home Page");
				flag=true;
				
			}

	
		}

		if(!flag)
		{
			System.out.println(ExpectedQuiztitle+" is not available==FAIL");
		}
		Thread.sleep(2000);
		
		
	
//Assert.assertEquals(ActualTitle, ExpectedQuiztitle);
		// Step 12: Student attending Quiz
		if (flag=true) {
			driver.findElement(By.xpath("//td[text()='Gk3']/following-sibling::td[4]/b/a/span/b[text()='Start']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//input[@type='radio'])[4]")).click();
			driver.findElement(By.xpath("//button[@type='submit']/span[@class='glyphicon glyphicon-lock']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//input[@type='radio'])[3]")).click();
			driver.findElement(By.xpath("//button[@type='submit']/span[@class='glyphicon glyphicon-lock']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[@class='glyphicon glyphicon-list-alt']")).click();
		}
*/
		//Step 13: Validating the attended test in Student History page
		List<WebElement> StudentHistory = driver.findElements(By.xpath("//table/tbody/tr/td"));
		Thread.sleep(2000);
		for (WebElement wb2 : StudentHistory)
		{
			String ActualHistory=wb2.getText();
			if (ActualHistory.equalsIgnoreCase(ExpectedQuiztitle)) 
			{
				System.out.println("Attended Quiz present in Student History Page");
				flag=true;
				break;
			}
		}

		if(!flag)
		{
			System.out.println(ExpectedQuiztitle+" is not available in History Page==FAIL");
		}
		Thread.sleep(2000);

		//Step 14: Student Logging out
		driver.findElement(By.xpath("//a[@class='log']/span[@class='glyphicon glyphicon-log-out']")).click();

		//Step 15: Student giving Feedback
		driver.findElement(By.xpath("//a[text()='Feedback']")).click();

		String MainWindow = driver.getWindowHandle();
		Set<String> AllWindows = driver.getWindowHandles();
		for (String lv : AllWindows) 
		{
			driver.switchTo().window(lv);	
		}


		driver.findElement(By.xpath("//input[@placeholder='Enter your name']")).sendKeys(StudentName);
		driver.findElement(By.xpath("//input[@placeholder='Enter subject']")).sendKeys(ExpectedQuiztitle);
		driver.findElement(By.xpath("(//input[@placeholder='Enter your email-id'])[2]")).sendKeys(Email);
		driver.findElement(By.xpath("//textarea[@placeholder='Write feedback here...']")).sendKeys(FeedbackDescription);
		driver.findElement(By.name("submit")).click();

		driver.close();
		driver.switchTo().window(MainWindow);

		//Step : Login as Admin
		driver.findElement(By.xpath("//a[text()='Admin Login']")).click();
		driver.findElement(By.name("uname")).sendKeys(ADMINLOGIN);
		driver.findElement(By.xpath("//form[@method='post']/descendant::input[@name='password']")).sendKeys(ADMINPASSWORD);
		driver.findElement(By.name("login")).click();

		//Step : validating students feedback
		driver.findElement(By.xpath("//a[text()='Feedback']")).click();
		boolean flag1=false;
		List<WebElement> StudentFeedback = driver.findElements(By.xpath("//table/tbody/tr/td[3]"));
		Thread.sleep(2000);
		for (WebElement wb3: StudentFeedback) {
			String ActualFeedback=wb3.getText();
			if (ActualFeedback.equalsIgnoreCase(Email)) 
			{
				System.out.println("Given feedback present in Admin feedback Page");
				flag1=true;
				break;
			}
		}

		if(!flag1)
		{
			System.out.println(Email+" is not available in Feedback Page==FAIL");
		}

		//Step: loging out as Admin

		driver.findElement(By.xpath("//span[text()='Test Your Skill']/parent::div/following-sibling::span/a[@class='log']/span[@class='glyphicon glyphicon-log-out']")).click();


	}
}


