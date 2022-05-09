package Utilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


public class ScreenShot 
{
	public static void takeshot(WebDriver driver,String name) throws IOException
	{
		
		String sandesh=ScreenShot.datesave();
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destination=new File("C:\\Users\\hp\\eclipse-workspace\\KiteZerodha\\ScreenShot"+name+ "" + sandesh + "" + " .jpg");
		FileHandler.copy(source, destination);
	}

	public static String datesave()
	{
		DateTimeFormatter time=DateTimeFormatter.ofPattern("yyyy-MM-dd  hh-mm-ss");
		LocalDateTime now=LocalDateTime.now();//It shows time and date  in this way 2022-04-10T23:44:53.906711900
		String d=time.format(now);//It shows date and time in this way  (2022-04-10)(11-48-01)
		return d;
	}

}
