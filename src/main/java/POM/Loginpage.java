package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage
{
    @FindBy(xpath="//input[@id='userid']")private WebElement username;
	
	@FindBy(xpath="//input[@id='password']")private WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")private WebElement submit;
	
	@FindBy(xpath="//input[@id='pin']")private WebElement pin;
	
	@FindBy(xpath="//button[@class=\"button-orange wide\"]")private WebElement cont;

	
	
	public Loginpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterUsername(String Userid)
	{
		username.sendKeys(Userid);
	}
	
	public void enterPassword(String Pass)
	{
		password.sendKeys(Pass);
	}
	
	public void clickOnSubmit()
	{
		submit.click();
	}
	
	public void enterPin(String Pin)
	{
		pin.sendKeys(Pin);
	}
	
	public void clickoncontineu()
	{
		cont.click();
	}

}
