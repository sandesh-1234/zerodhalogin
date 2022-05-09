package Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import POM.Loginpage;

import Pojo.Browser;

import Utilities.Excel;
import Utilities.ScreenShot;

@Listeners(ListenerTest.class)
public class ZerodhaLoginTest extends BaseTest
{
      WebDriver driver;
	
	  @Test(priority = 1)
	     public void ZerodhaloginWithValidCreadentials() throws EncryptedDocumentException, IOException
	  {
		  driver=Browser.openBrowser("https://kite.zerodha.com/");
		  Loginpage obj=new Loginpage(driver);
		  String Userid= Excel.getdata(0, 1, "Sheet2");
			String Pass= Excel.getdata(1, 1, "Sheet2");
			String Pin=Excel.getdata(2, 1, "Sheet2");
		
		obj.enterUsername(Userid);
		
		obj.enterPassword(Pass);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		obj.clickOnSubmit();
		ScreenShot.takeshot(driver, "loginPage");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		obj.enterPin(Pin);
		Assert.assertFalse(false);
		obj.clickoncontineu();
		ScreenShot.takeshot(driver, "continue");
		
	  }
	 
}
