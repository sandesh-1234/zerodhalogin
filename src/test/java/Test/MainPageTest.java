package Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import POM.Loginpage;
import POM.MainPage;
import Pojo.Browser;
import Utilities.Excel;
import Utilities.Reports;
import Utilities.ScreenShot;

public class MainPageTest extends BaseTest
{
	ExtentReports reports;
	ExtentTest test;
	
	@BeforeClass
	public void conFugureExtentReport()
	{
		reports= Reports.addReport();
	}
	
	@BeforeMethod
	public void launchBrowserAndLogin() throws EncryptedDocumentException, IOException
	{
		driver=Browser.openBrowser("https://kite.zerodha.com/");
		test=reports.createTest("launchBrowserAndLogin");
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
	public void buyStockTest()
	{
		test= reports.createTest("buyStockTest");
		SoftAssert assertion=new SoftAssert();
		assertion.assertFalse(true);
		
		MainPage mainpage=new MainPage(driver);
		mainpage.searchStock("suzlon");
		mainpage.selectFirstStock(driver);
		mainpage.clickOnBuy();
		mainpage.clickOnLongterm();
		mainpage.sendQuantity("25");
		mainpage.clickOnMarket();
		mainpage.clickOnBuyButton();
		mainpage.clickOnSwitch();
		mainpage.clickOnsellButton();
		
	}
	@AfterMethod
	public void addTestResult(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName());
		}
		else {
			test.log(Status.SKIP, result.getName());
		}
	}
	@AfterClass
	public void fiushResults() {
		reports.flush();
	}

}
