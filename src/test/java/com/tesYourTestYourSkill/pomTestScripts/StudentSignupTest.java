package com.tesYourTestYourSkill.pomTestScripts;

import org.testng.annotations.Test;

import com.testyourskill.PomReposototyLib.AdminLogin;
import com.testyourskill.PomReposototyLib.Homepage;
import com.testyourskill.PomReposototyLib.Login;
import com.testyourskill.PomReposototyLib.StudentAttendQuiz;
import com.testyourskill.PomReposototyLib.StudentSignout;
import com.testyourskill.genericutility.BaseClass;
import com.testyourskill.genericutility.JavaUtility;

public class StudentSignupTest extends BaseClass 
{
	@Test(priority=1)
	public void signup() throws Throwable {
		int randonint=javalib.getRanDomNumber();

		String StudentName =exlib.getExcelData("Sheet1", 9, 2);
		String CollegeName= exlib.getExcelData("Sheet1", 9, 3);
		String Email= exlib.getExcelData("Sheet1", 9, 4)+randonint;
		String Mobilenum= exlib.getExcelData("Sheet1", 9, 5);
		String Password= exlib.getExcelData("Sheet1", 9, 6);
		String ConfirmPassword =exlib.getExcelData("Sheet1", 9, 7);
		String gender=exlib.getExcelData("Sheet1", 10, 1);

		Login loginpage=new Login(driver);
		loginpage.LoginToApplication(StudentName, gender, CollegeName, Email, Mobilenum, Password, ConfirmPassword);

		String Expectedurl = "http://rmgtestingserver/domain/Online_Examination_System/account.php?q=result&eid=62f2057dcd279.";
		String actualurl = driver.getCurrentUrl();	
		if (actualurl.equalsIgnoreCase(Expectedurl))
		{System.out.println("Student login successfull");
		} 
		else
		{System.out.println("Student login Failed");

		}

	}
	@Test(priority=2)
	public void stdtakeTest() {

		Homepage HP = new Homepage(driver);
		HP.startQuiz();
	}

	@Test(priority=3)
	public void AttendQuiz()
	{

		StudentAttendQuiz atd=new StudentAttendQuiz(driver);
		atd.studentQuiz();
	}

	@Test(priority=4)
	public void Studentouut() throws InterruptedException
	 {
		StudentSignout LG = new StudentSignout(driver);
		LG.Slogout();
		Thread.sleep(3000);
	 }
	@Test(priority=5)
	public void LoginAdmin() throws Throwable
	{
		
		
		
		 String ADMINLOGIN = filelib.getPropertyKeyValue("adminuserid");
			String ADMINPASSWORD = filelib.getPropertyKeyValue("username");
			
			AdminLogin adn=new AdminLogin(driver);
		adn.login(ADMINLOGIN, ADMINPASSWORD);
		
		
	}
	
}

