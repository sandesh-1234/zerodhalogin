package POM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage
 {
	@FindBy(xpath="//input[@type='text']")private WebElement search;
	@FindBy(xpath="//ul[@class='omnisearch-results']//div//li[1]")private WebElement firstStock;
	@FindBy(xpath="//button[@data-balloon='Buy']")private WebElement buy;
	@FindBy(xpath="//span[text()='CNC']")private WebElement longterm;
	@FindBy(xpath="//input[@label='Qty.']")private WebElement quantity;
	@FindBy(xpath="(//label[@class=\"su-radio-label\"])[9]")private WebElement market;
	@FindBy(xpath="(//span[text()='Buy'])[2]")private WebElement buybutton;
	@FindBy(xpath="//label[@class=\"su-switch-control\"]")private WebElement switchtosell;
	@FindBy(xpath="(//span[text()='Sell'])[2]")private WebElement sellbutton;
	
	
	
	public MainPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void searchStock(String stockname)
	{
		search.sendKeys(stockname);
	}
	public void selectFirstStock(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(2000));
		wait.until(ExpectedConditions.visibilityOf(firstStock));
		Actions action=new Actions(driver);
		action.moveToElement(firstStock).perform();
	}
	public void clickOnBuy()
	{
		buy.click();
	}
	public void clickOnLongterm()
	{
		longterm.click();
	}
	public void sendQuantity(String Qun)
	{
		quantity.sendKeys(Qun);
	}
	public void clickOnMarket()
	{
		market.click();
	}
	public void clickOnBuyButton()
	{
		buybutton.click();
	}
	public void clickOnSwitch()
	{
		switchtosell.click();
	}
	public void clickOnsellButton()
	{
		sellbutton.click();
	}

}
