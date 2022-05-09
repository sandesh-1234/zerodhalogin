package Pojo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser 
{
	public  static  WebDriver  openBrowser(String url)
	{
		ChromeOptions Options=new ChromeOptions();
		Options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\eclipse-workspace\\KiteZerodha\\src\\main\\resources\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(Options);
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}
	public void search()
	{
		System.out.println("add this result ");
	}

}
