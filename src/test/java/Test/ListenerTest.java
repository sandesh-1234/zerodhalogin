package Test;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

import Utilities.ScreenShot;
import zmq.ZError.IOException;

public class ListenerTest extends BaseTest implements ITestListener
{
	public void onTestStart(ITestResult Result)
	{
		System.out.println("Test has Started"+Result.getName());
	}
	
	public void onTestSuccess(ITestResult Result)
	{
		System.out.println("Test is passed"+Result.getName());
	}
	
	public void onTestFailure(ITestResult Result)
	{
		try
		{
			ScreenShot.takeshot(driver, Result.getName());
		}
		 catch (java.io.IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public void onTestSkipped(ITestResult Result)
	{
		System.out.println("Test is Failed"+Result.getName());
	}



}
