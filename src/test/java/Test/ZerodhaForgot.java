package Test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POM.ForgotIDorPASS;
import Pojo.Browser;

public class ZerodhaForgot 
{
	WebDriver driver;
	
	@BeforeMethod()
	public void open()
	{
		 driver=Browser.openBrowser("https://kite.zerodha.com/");
	}
	
	@Test()
	public void Forgotten() throws InterruptedException
	{
		ForgotIDorPASS ref=new ForgotIDorPASS(driver);
		
		
		ref.ForgotIDpassword();
    	
		ref.heading();

		}
	@Test()
	public void Text()
	{
		ForgotIDorPASS ref=new ForgotIDorPASS(driver);
		String a=ref.heading();
		String b="Forgot user ID or password?";
		Assert.assertEquals(a, b);
	}
	@AfterClass()
	public void clicklogo()
	{
		ForgotIDorPASS ref=new ForgotIDorPASS(driver);
		ref.Checklogo();
	}

}
