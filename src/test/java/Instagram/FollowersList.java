//package Instagram;
//
//	import java.util.ArrayList;
//	import java.util.List;
//	import java.util.concurrent.TimeUnit;
//
//	import javax.xml.xpath.XPath;
//
//	import org.apache.poi.ss.usermodel.Row;
//	import org.apache.poi.ss.usermodel.Workbook;
//	import org.openqa.selenium.By;
//	import org.openqa.selenium.JavascriptExecutor;
//	import org.openqa.selenium.WebDriver;
//	import org.openqa.selenium.WebElement;
//	import org.openqa.selenium.support.ui.ExpectedConditions;
//	import org.openqa.selenium.support.ui.WebDriverWait;
//	import org.testng.annotations.Test;
//
//import com.Instagram.login.Baseclass;
//import com.Instagram.login.LoginPage;
//import com.Instagram.login.ProfilePage;
//
//
//	public class FollowersList extends Baseclass{
//
//		@Test
//		public void getFollowersList() throws Throwable {
//
//			driver.get("https://www.instagram.com/");
//
//			//String username = eLib.getExcelData("Instagram", 1, 0);
//		//String password = eLib.getExcelData("Instagram", 1, 1);
//
//			LoginPage lp = new LoginPage();
//			lp.getuserName().sendKeys("manjums9379@gmail.com");
//			lp.getPassword().sendKeys("manju9379034760");
//			lp.getClickButton().click();
//			lp.getNotNowButton().click();
//			lp.getNotNowButton().click();
//
////			HomePage hp = new HomePage(driver);
////			hp.clickNotNow(driver);
////			hp.clickNotNow(driver);
////			hp.getSearchBtn().click();
////			hp.enterValueSearch("mysorefood");
////			Thread.sleep(3000);
////			hp.clickOnIdFromSearch(driver, "mysoreblogger");
//
//			ProfilePage pp = new ProfilePage(driver);
//			pp.clickFollowersBtn(driver);
//			WebElement popUp = pp.getFollowersPopUp();
//			Thread.sleep(3000);
//
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//
//			ArrayList<Integer> wb = new ArrayList<Integer>();
//
//			wb.add(1);
//
//			Workbook wrkBk;
//			
//			int j = 1;
//			int k = 1;
//			
//			while(true) {
//				js.executeScript("arguments[0].scrollTop = arguments[0].scrollTop + arguments[0].scrollHeight;", popUp);
//				
//				System.out.println(j++);
//
//				List<WebElement> userName = pp.getTotalNames();
//				
//				int size = userName.size();
//				wb.add(size);
//
//				int lastButOne = wb.get(wb.size()-2);
//				int last = wb.get(wb.size()-1);
//				if(lastButOne == last) {
//					for (int i = 0; i < userName.size(); i++) {
//						Row ro = eLib.createRow(wrkBk, "InstagramFollowersNameLengthy", i+1);	
//						String usrNm = userName.get(i).getText();
//						try {
//							String fulNm = pp.getFullName(driver, usrNm);
//							System.out.println("printing row number " + k++ +" ==> "+usrNm+" : "+fulNm);
//							eLib.createCellAndSetCellValue(ro, 0, usrNm);
//							eLib.createCellAndSetCellValue(ro, 1, fulNm);
//						}
//						catch(Exception e) {
//							eLib.createCellAndSetCellValue(ro, 0, usrNm);
//							System.out.println("catch "+usrNm);
//						}				
//					}
//					break;
//				}
//				Thread.sleep(7000);
//			}
//			eLib.writeDataToExcel(wrkBk);
//		}
//	}
//
//
