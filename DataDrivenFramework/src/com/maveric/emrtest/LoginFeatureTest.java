package com.maveric.emrtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.maveric.emrPages.OpenEMRDashBoardPage;
import com.maveric.emrPages.OpenEMRLoginPage;
import com.maveric.initialization.LaunchBrowser;
import com.maveric.utilities.ExcelUtilis;
import com.maveric.utilities.PropertiesHandler;

public class LoginFeatureTest extends LaunchBrowser {
	//Global variable
	

@Test (invocationCount=2)
	public void CheckTotalLinkCount() throws IOException {
	
	Properties prop= PropertiesHandler.getPropertiesDetails("Utilities/data.properties");
	
	
	String url=prop.getProperty("url");
	System.out.println(url);
	
	String userName=prop.getProperty("username");
	System.out.println(userName);
	
	String passWord=prop.getProperty("password");
	System.out.println(passWord);
	
	String language=prop.getProperty("language");
	System.out.println(language);
	
	String expectedLinkcount=prop.getProperty("expectedlinkcount");
	int expectedCount = Integer.parseInt(expectedLinkcount);
	System.out.println(expectedCount);
	
	driver.get(url);	     
	OpenEMRLoginPage.sendUserName(driver, userName);
	OpenEMRLoginPage.sendPassWord(driver, passWord);
	OpenEMRLoginPage.selectLanguage(driver,language);
	OpenEMRLoginPage.clickLoginButton(driver);
	OpenEMRDashBoardPage.waitForPresenceOfAboutText(wait);
	OpenEMRDashBoardPage.getTotalLinkCount(driver);
	OpenEMRLoginPage.getInvalidErrorText(driver);
	int a= OpenEMRDashBoardPage.getTotalLinkCount(driver);
	Assert.assertEquals(a, expectedCount, "Assertion on Link count");
	
	
	
	
	}
	@Test(priority=2)
	public void InvalidCredentialTest() throws IOException {

		Properties prop= PropertiesHandler.getPropertiesDetails("Utilities/data.properties");
		String url=prop.getProperty("url");
		System.out.println(url);
		
		String userName=prop.getProperty("negusername");
		System.out.println(userName);
		
		String passWord=prop.getProperty("negpassword");
		System.out.println(passWord);
		
		String language=prop.getProperty("language");
		System.out.println(language);
		
		String expectedText=prop.getProperty("negexpectedtitle");
		System.out.println(expectedText);
		
		
		driver.get("http://demo.openemr.io/d/openemr/interface/login/login.php?site=default");
		
		WebElement userEle= driver.findElement(By.id("authUser"));
		userEle.sendKeys(userName);
		
		WebElement npassEle = driver.findElement(By.xpath("//input[@placeholder='Password:']"));
		npassEle.sendKeys(passWord);
		
		WebElement logButton= driver.findElement(By.xpath("//button[@type='submit']"));
		logButton.click();
		
				
		WebElement invalidText=driver.findElement(By.xpath("//div[@class='well well-lg login-failure']"));
		String actualErrorText= invalidText.getText();
		System.out.println("Actual Title"+ actualErrorText);
		
		Assert.assertEquals(actualErrorText, expectedText, "INvalidCredentialsTest: ");
			
		WebElement msgEle= driver.findElement(By.xpath("//div[text()='Messages'] "));
		msgEle.click();
			
		driver.close();
		
	}
	
	@DataProvider(name="ValidCredentials")
	public Object[][] validDataForTest() throws IOException
	{
		
	Object[][] temp=ExcelUtilis.getSheetAsObjectForDataProvider("Utilities/OpenEMRData.xlsx", "ValidCredentials");
	
//	//i-no of times you want the TC to run
//	//j-no of parameters
//	
//	temp[0][0]="balaji0017@gmail.com";
//	temp[0][1]="Welcome@123";
//	temp[0][2]="English(Indian)";
//	
//	temp[1][0]="balajidinakaran1@gmail.com";
//	temp[1][1]="Welcome@123";
//	temp[1][2]="English(Indian)";
	
	return temp;
	
	}
	
	
	@Test(dataProvider="ValidCredentials")	
	
	public void validCredentialTest(String userName, String passWord, String language ) throws IOException {
			
		
		System.out.println(userName);
		System.out.println(passWord);
		System.out.println(language);
		
		Properties prop= PropertiesHandler.getPropertiesDetails("Utilities/data.properties");
		String url=prop.getProperty("url");
		System.out.println(url);
		
		String expectedTitle=prop.getProperty("expectedtitle");
		System.out.println(expectedTitle);
		
		
		driver.get("http://demo.openemr.io/d/openemr/interface/login/login.php?site=default");
		
		WebElement userEle=	driver.findElement(By.id("authUser"));
		userEle.sendKeys(userName);
		
		WebElement passEle = driver.findElement(By.xpath("//input[@placeholder='Password:']"));
		passEle.sendKeys(passWord);
		WebElement langEle=	driver.findElement(By.name("languageChoice"));
		
		
		Select select=new Select(langEle);
		select.selectByVisibleText(language);
		WebElement logButton= driver.findElement(By.xpath("//button[@type='submit']"));
		logButton.click();
		
		Wait wait= new WebDriverWait(driver,50); //50 to 120 s- pooling time is 0.5 sec or 500ms
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='About'] ")));
		
		String actualTitle=driver.getTitle();
		System.out.println("Actual Title"+ actualTitle);
		
		Assert.assertEquals(actualTitle, expectedTitle, "validCredentialsTest");
			WebElement msgEle= driver.findElement(By.xpath("//div[text()='Messages'] "));
			msgEle.click();
			driver.close();
	}

	
}
