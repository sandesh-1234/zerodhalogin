package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotIDorPASS 
{
	@FindBy(xpath="//a[@href='/forgot']")private WebElement Forget;
	@FindBy(xpath="//img[@alt=\"Kite\"]")private WebElement Logo;
	@FindBy(xpath="//h2[text()='Forgot user ID or password?']")private WebElement text;
	@FindBy(xpath="//label[@for='radio-31']")private WebElement RemeberuserID;
	@FindBy(xpath="//label[@for='radio-32']")private WebElement ForgotuserID;
	
	public ForgotIDorPASS(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void ForgotIDpassword()
	{
		Forget.click();
	}
	
	public void Checklogo()
	{
		Logo.click();
	}
	public String heading()
	{
		return text.getText();
	}
	public void UID()
	{
		RemeberuserID.click();
	}
	public void FUID()
	{
		ForgotuserID.click();
	}

}
