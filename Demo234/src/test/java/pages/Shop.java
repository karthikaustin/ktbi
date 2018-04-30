package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Shop {

	WebDriver driver;
	
	public Shop(WebDriver driver)
	{
		this.driver = driver;// demo testing for branch
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[text()='Shop']") WebElement shop_link;
	
	
	
	
	public void shop_store()
	{
		shop_link.click();
	}
	
}
