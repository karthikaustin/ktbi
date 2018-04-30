package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	
	WebDriver driver;
	
	public Login(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
		@FindBy(xpath="//a[text()='My Account']") WebElement myaccount;
		@FindBy(xpath="//input[@id='username']") WebElement username;
		@FindBy(xpath="//input[@id='password']")WebElement password;
		@FindBy(xpath="//input[@name='login']") WebElement login_button;
		
	
	
	public void login(String uname,String pwd)
	{
		myaccount.click();
		username.sendKeys(uname);
		password.sendKeys(pwd);
		login_button.click();
		
	}
	
	
}
