package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddFund 
{
	@FindBy(xpath="//span[text()='Funds']")private WebElement fund;
	@FindBy(xpath="//button[@class='button-green']")private WebElement addfund;
	@FindBy(xpath="//input[@placeholder=\"Enter amount\"]")private WebElement ammount;


public AddFund(WebDriver driver)
{
	PageFactory.initElements(driver, this);
	
}
public void clickOnFund()
{
	fund.click();
}
public void clickOnAddFund()
{
	addfund.click();
}
public void enterAmount()
{
	ammount.sendKeys("1");
}

}