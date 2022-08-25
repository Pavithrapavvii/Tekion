package com.tesYourTestYourSkill.pomTestScripts;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.testyourskill.PomReposototyLib.AdminLogin;
import com.testyourskill.PomReposototyLib.Homepage;
import com.testyourskill.PomReposototyLib.StudentAttendQuiz;
import com.testyourskill.PomReposototyLib.StudentSignout;
import com.testyourskill.genericutility.ExcelUtility;
import com.testyourskill.genericutility.FileUtility;
import com.testyourskill.genericutility.JavaUtility;
import com.testyourskill.genericutility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	

	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
		
		WebDriverUtility wlib=new WebDriverUtility();
		FileUtility flib=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
		JavaUtility jlib=new JavaUtility();
		
		int intRanNum=jlib.getRanDomNumber();
		
		

		

		String URL = flib.getPropertyKeyValue("url2");
		String ADMINLOGIN = flib.getPropertyKeyValue("adminuserid");
		String ADMINPASSWORD = flib.getPropertyKeyValue("password");
		String BROWSER = flib.getPropertyKeyValue("browser");
		String STUDENTLOGIN = flib.getPropertyKeyValue("studentlogin");
		String STUDENTPASSWORD = flib.getPropertyKeyValue("spassword");

		//Step 2:Read all the data from excel sheet
		//String QuizTitle = getData("Sheet1", 7, 2);
		String StudentName =elib.getExcelData("Sheet1", 9, 2);
		String CollegeName= elib.getExcelData("Sheet1", 9, 3);
		String Email= elib.getExcelData("Sheet1", 9, 4)+intRanNum;
		String Mobilenum= elib.getExcelData("Sheet1", 9, 5);
		String Password= elib.getExcelData("Sheet1", 9, 6);
		String ConfirmPassword =elib.getExcelData("Sheet1", 9, 7);
		String gender=elib.getExcelData("Sheet1", 10, 1);
//		String FeedbackDescription = elib.getExcelData("Sheet1", 9, 8);



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
		
		com.testyourskill.PomReposototyLib.Login LP = new com.testyourskill.PomReposototyLib.Login(driver);
		LP.LoginToApplication(StudentName, gender, CollegeName, Email, Mobilenum, Password, ConfirmPassword);
		
		Homepage HP = new Homepage(driver);
		HP.startQuiz();
		
	StudentAttendQuiz SAQ = new StudentAttendQuiz(driver);
	SAQ.studentQuiz();
	
						StudentSignout SSO = new StudentSignout(driver);
						SSO.Slogout();
						
						AdminLogin AL = new AdminLogin(driver);
						AL.login(ADMINLOGIN, ADMINPASSWORD);
}
}
