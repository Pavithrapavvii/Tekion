package com.testyourskill.PRACTICE;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;



import io.github.bonigarcia.wdm.WebDriverManager;

public class AdminCreatingQuizAndStdentAttendingthatQuiz {

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
		//Step 1:Read all the necessary common data
		FileInputStream FISP = new FileInputStream(".\\Dataproperty\\Commondata.properties");
		Properties prop = new Properties();
		prop.load(FISP);
		String URL = prop.getProperty("url2");
		String ADMINLOGIN = prop.getProperty("adminuserid");
		String ADMINPASSWORD = prop.getProperty("password");
		String BROWSER = prop.getProperty("browser");
		String STUDENTLOGIN = prop.getProperty("studentlogin");
		String STUDENTPASSWORD = prop.getProperty("Spassword");

		//Step 2:Read all the data from excel sheet
		String QuizTitle = getData("Sheet1", 7, 2);
		String NoOfQuestions = getData("Sheet1", 7, 3);
		String MarksForRightAns = getData("Sheet1", 7, 4);
		String MarksforWrongAnswer = getData("Sheet1", 7, 5);
		String TimeLimit = getData("Sheet1", 7, 6);
		String TagName = getData("Sheet1", 7, 7);
		String Description = getData("Sheet1", 7, 8);
		String QuestionNumber1 = getData("Sheet1", 7, 9);
		String OptionAofQuestion1 = getData("Sheet1", 7, 10);
		String OptionBofQuestion1 = getData("Sheet1", 7, 11);
		String OptionCofquestion1 = getData("Sheet1", 7, 12);
		String OptionDofQuestion1 = getData("Sheet1", 7, 13);
		String QuestionNumber2 = getData("Sheet1", 7, 14);
		String OptionAofQuestion2 = getData("Sheet1", 7, 15);
		String OptionBofQuestion2 = getData("Sheet1", 7, 16);
		String OptionCofquestion2 = getData("Sheet1", 7, 17);
		String OptionDofQuestion2 = getData("Sheet1", 7, 18);

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

		//Step 4:Navigate to Admin Login page
		driver.findElement(By.xpath("//a[text()='Admin Login']")).click();

		//Step 5:Fill Admin credentials and click on Login button
		driver.findElement(By.name("uname")).sendKeys(ADMINLOGIN);
		driver.findElement(By.xpath("//form[@method='post']/descendant::input[@name='password']")).sendKeys(ADMINPASSWORD);
		driver.findElement(By.name("login")).click();

		//Step 6:Navigate to Add Quiz button
		driver.findElement(By.xpath("//a[text()='Quiz']")).click();
		driver.findElement(By.xpath("//a[text()='Add Quiz']")).click();

		//Step 7:Fill all the fields of Enter Quiz details page
		driver.findElement(By.xpath("//input[@placeholder='Enter Quiz title']")).sendKeys(QuizTitle);
		driver.findElement(By.xpath("//input[@placeholder='Enter total number of questions']")).sendKeys(NoOfQuestions);
		driver.findElement(By.xpath("//input[@placeholder='Enter marks on right answer']")).sendKeys(MarksForRightAns);
		driver.findElement(By.xpath("//input[@placeholder='Enter minus marks on wrong answer without sign']")).sendKeys(MarksforWrongAnswer);
		driver.findElement(By.xpath("//input[@placeholder='Enter time limit for test in minute']")).sendKeys(TimeLimit);
		driver.findElement(By.xpath("//input[@placeholder='Enter #tag which is used for searching']")).sendKeys(TagName);
		driver.findElement(By.xpath("//textarea[@placeholder='Write description here...']")).sendKeys(Description);
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		//Step 8:Fill all the fields of Question Details Page 
		driver.findElement(By.xpath("//textarea[@placeholder='Write question number 1 here...']")).sendKeys(QuestionNumber1);
		driver.findElement(By.xpath("//input[@id=11 and @placeholder='Enter option a']")).sendKeys(OptionAofQuestion1);
		driver.findElement(By.xpath("//input[@id=12 and @placeholder='Enter option b']")).sendKeys(OptionBofQuestion1);
		driver.findElement(By.xpath("//input[@id=13 and @placeholder='Enter option c']")).sendKeys(OptionCofquestion1);
		driver.findElement(By.xpath("//input[@id=14 and @placeholder='Enter option d']")).sendKeys(OptionDofQuestion1);
		Thread.sleep(3000);
		WebElement A1 = driver.findElement(By.xpath("//select[@id='ans1' and @placeholder='Choose correct answer ']"));
		Select Ans1 = new Select(A1);
		Ans1.selectByIndex(4);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//textarea[@placeholder='Write question number 2 here...']")).sendKeys(QuestionNumber2);
		driver.findElement(By.xpath("//input[@id=21 and @placeholder='Enter option a']")).sendKeys(OptionAofQuestion2);
		driver.findElement(By.xpath("//input[@id=22 and @placeholder='Enter option b']")).sendKeys(OptionBofQuestion2);
		driver.findElement(By.xpath("//input[@id=23 and @placeholder='Enter option c']")).sendKeys(OptionCofquestion2);
		driver.findElement(By.xpath("//input[@id=24 and @placeholder='Enter option d']")).sendKeys(OptionDofQuestion2);

		WebElement A2 = driver.findElement(By.xpath("//select[@id='ans2' and @placeholder='Choose correct answer ']"));
		Select Ans2 = new Select(A2);
		Ans2.selectByVisibleText("option c");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();

		//Step 9:Logging out as Admin
		driver.findElement(By.xpath("//span[text()='Test Your Skill']/parent::div/following-sibling::span/a[@class='log']/span[@class='glyphicon glyphicon-log-out']")).click();

		//Step 10: Signing in as Student
		driver.findElement(By.xpath("//span/b[text()='Signin']")).click();
		driver.findElement(By.xpath("//div[@class='modal-dialog']/descendant::input[@id='email']")).sendKeys(STUDENTLOGIN);
		driver.findElement(By.xpath("//div[@class='modal-dialog']/descendant::input[@id='password']")).sendKeys(STUDENTPASSWORD);
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		Thread.sleep(2000);
		String ExpectedQuiztitle = QuizTitle;
		boolean flag=false;
		List<WebElement> StudentPageTitle = driver.findElements(By.xpath("//table/tbody/tr/td"));
		
		//Step 11: Verifying the created Quiz Present in Student Home page
		for (WebElement wb : StudentPageTitle) {
			String ActualTitle=wb.getText();
			if (ActualTitle.equalsIgnoreCase(ExpectedQuiztitle)) 
			{
				System.out.println("Created Quiz present in Student Home Page");
				flag=true;
				break;
			}
		}

		if(!flag)
		{
			System.out.println(ExpectedQuiztitle+" is not available==FAIL");
		}
		Thread.sleep(2000);

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
		
		//Step 13: Validating the attended test in Student History page
		List<WebElement> StudentHistory = driver.findElements(By.xpath("//table/tbody/tr/td"));
		Thread.sleep(2000);
		for (WebElement wb2 : StudentHistory) {
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
	}
}

