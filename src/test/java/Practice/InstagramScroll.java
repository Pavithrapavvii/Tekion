package Practice;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.Instagram.login.Baseclass;
import com.Instagram.login.ProfilePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InstagramScroll extends Baseclass {
	@Test
	public void ista() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.instagram.com/");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("8105081139");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("manju9379034760");
		driver.findElement(By.xpath("//button[@class='_acan _acap _acas']")).click();
		driver.findElement(By.xpath("//button[text()='Not Now']")).click();
		driver.findElement(By.xpath("//a[text()='manjunathamskpr']")).click();
		driver.findElement(By.xpath("//span[@class='_ac2a' and text()='367']")).click();
		ProfilePage pp = new ProfilePage(driver);
		WebElement popUp = pp.getFollowersPopUp();
		Thread.sleep(3000);
		JavascriptExecutor jss=(JavascriptExecutor)driver;
		ArrayList<Integer> wb=new ArrayList<Integer>();
		wb.add(1);
		
		int j=1;
		int k=1;
		
		while(true)
		{
			jss.executeScript("arguments[0].scrollTop=arguments[0].srollTop+arguments[0].scrollHeight;",popUp);
			
		}
		
	}

}
