package Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Pojo.Browser;

public class BrokenLinks 
{ static int temp=0;

	public static void main(String[] args) {
		String url ;
		WebDriver driver =Browser.openBrowser("https://open.spotify.com/");
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		Iterator<WebElement> i= links.iterator();
		
		while(i.hasNext()) {
			url =i.next().getAttribute("href");
			if(url == null|| url.isEmpty()) {
				System.out.println("url is missing");
				continue;
			}
			try {
				HttpURLConnection huc =(HttpURLConnection)(new URL(url).openConnection());
				huc.setRequestMethod("HEAD");
				huc.connect();
				int respCode =huc.getResponseCode();
				if(respCode>=400) {
		                     temp++;
					System.out.println(url+" is a broken link");
				
					}
				else {
					System.out.println(url+" is a valid link");
				}
				}catch(Exception e) {
					e.printStackTrace();
					continue;
				}
		}
	System.out.println("Total Broken Links" +temp);
	}
	

	}
