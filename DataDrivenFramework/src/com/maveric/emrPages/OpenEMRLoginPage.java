package com.maveric.emrPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class OpenEMRLoginPage {
	//private static By userNameLoc= By.id("authUser");
	private static By userNameLoc= By.cssSelector("#authUser");
	private static By passwordLoc= By.xpath("//input[@placeholder='Password:']");
	private static By loginLoc= By.xpath("//button[@type='submit']");
	private static By selectLanguageLoc = By.name("languageChoice");
	private static By errorLov= By.xpath("//div[@class='well well-lg login-failure']");
//for user name
public static void sendUserName(WebDriver driver, String userName) 
	{
		
	WebElement userEle=	driver.findElement(userNameLoc);
	userEle.sendKeys(userName);
	}

// for password
public static void sendPassWord(WebDriver driver, String passWord) 
	{
	WebElement passEle = driver.findElement(passwordLoc);
	passEle.sendKeys(passWord);
	}

public static void selectLanguage(WebDriver driver, String language )
{
	WebElement langEle=	driver.findElement(selectLanguageLoc);
	
	
	Select select=new Select(langEle);
	select.selectByVisibleText(language);
}
//for Login button
public static void clickLoginButton(WebDriver driver) 
	{
	WebElement logButton= driver.findElement(loginLoc);
	logButton.click();

}

public static String getInvalidErrorText(WebDriver driver)  
	{
	WebElement invalidText=driver.findElement(errorLov);
	String actualErrorText= invalidText.getText();
	return actualErrorText;
}
}

