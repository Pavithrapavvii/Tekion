package Practice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GridPractic
{
@Test
public void gridPractice() throws MalformedURLException
{

	URL url = new URL("http://localhost:4444/wd/hub");
	DesiredCapabilities cap = new DesiredCapabilities();
	cap.setBrowserName("firefox");
	cap.setPlatform(Platform.WINDOWS);
	RemoteWebDriver driver = new RemoteWebDriver(url, cap);
	driver.get("http://www.gmail.com");
	
}
}
