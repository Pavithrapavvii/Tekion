package Practice;


import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyUrlLaunchtest {
	@Test
	public void url()
	{
		WebDriverManager.chromedriver().setup();
		//WebDriver driver =new ChromeDriver();
		//driver.manage().window().maximize();
		//driver.get("https://www.flipkart.com/");
		//String act = driver.getCurrentUrl();
		String exp="https://www.flipkart.com/";
		//if(act.equals(exp))
		{
			System.out.println("URL verified");
		}
		//else {
			System.out.println("Not verified");
		}
	//}
	@Test
	public void OpenNewWindowytest()
	{
		WebDriverManager.chromedriver().setup();
		//WebDriver driver =new ChromeDriver();
		//driver.manage().window().maximize();
		//driver.manage().window()
	}
	

}
