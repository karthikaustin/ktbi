package com.maveric.emrPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class OpenEMRLoginPage2 {
	//private static By userNameLoc= By.id("authUser");
	private  By userNameLoc= By.cssSelector("#authUser");
	private  By passwordLoc= By.xpath("//input[@placeholder='Password:']");
	private  By loginLoc= By.xpath("//button[@type='submit']");
	private  By selectLanguageLoc = By.name("languageChoice");
	private  By errorLov= By.xpath("//div[@class='well well-lg login-failure']");
	private WebDriver driver;
	
	//for user name
public void sendUserName(String userName) 
	{
		
	WebElement userEle=	driver.findElement(userNameLoc);
	userEle.sendKeys(userName);
	}

// for password
public void sendPassWord(String passWord) 
	{
	WebElement passEle = driver.findElement(passwordLoc);
	passEle.sendKeys(passWord);
	}

public void selectLanguage(String language )
{
	WebElement langEle=	driver.findElement(selectLanguageLoc);
	
	
	Select select=new Select(langEle);
	select.selectByVisibleText(language);
}
//for Login button
public void clickLoginButton() 
	{
	WebElement logButton= driver.findElement(loginLoc);
	logButton.click();

}

public String getInvalidErrorText()  
	{
	WebElement invalidText=driver.findElement(errorLov);
	String actualErrorText= invalidText.getText();
	return actualErrorText;
}
}

