package Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POM.AddFund;
import POM.Loginpage;
import Pojo.Browser;
import Utilities.Excel;
import Utilities.ScreenShot;

public class ZerodhaFundTest
 { 
	
	WebDriver driver;
 
		@BeforeMethod
		public void launchBrowserAndLogin() throws EncryptedDocumentException, IOException
		{
			driver=Browser.openBrowser("https://kite.zerodha.com/");
			
			Loginpage loginpage=new Loginpage(driver);
			    String Userid= Excel.getdata(0, 1, "Sheet2");
				String Pass= Excel.getdata(1, 1, "Sheet2");
				String Pin=Excel.getdata(2, 1, "Sheet2");
			
			  loginpage.enterUsername(Userid);
			
			  loginpage.enterPassword(Pass);
			
	         loginpage.clickOnSubmit();
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			loginpage.enterPin(Pin);
			loginpage.clickoncontineu();
			ScreenShot.takeshot(driver, Pin);
			
		}
		@Test
		public void addFundinDMATaccount()
		{
			AddFund addfund=new AddFund(driver);
			addfund.clickOnFund();
			addfund.clickOnAddFund();
			Set<String> Adress=driver.getWindowHandles();
			Iterator<String> i=Adress.iterator();
			String a=i.next();
			String b=i.next();
			driver.switchTo().window(b);
			Assert.assertTrue(false);
			
			driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
			addfund.enterAmount();
		}

}
