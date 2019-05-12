package com.maveric.initialization;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class LaunchBrowser {

	public WebDriver driver;
	public WebDriverWait wait;
	
	@BeforeMethod
	@Parameters({"browser"})
	public void setUp(@Optional("ch")String browserName) {
		System.out.println(browserName);
		launchBrowser(browserName);
		
		
		
		driver= new ChromeDriver();
		wait= new WebDriverWait(driver, 50);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	public void launchBrowser(String browserName)
	{
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "driver/geckodriver.exe");
		System.setProperty("webdriver.ie.driver", "driver/IEDriverServer.exe");
		switch(browserName.toLowerCase())
		{
		case "ch":
		case "chromedriver":
		case "chrome driver":
			driver=new ChromeDriver();
			break;
		case "ff":
		case "firefox":
			driver=new FirefoxDriver();
			break;
		case "ie":
		case "internetexplorer":
		case "internet explorer":
			driver=new InternetExplorerDriver();
			break;
		default:
			driver=new ChromeDriver();
			break;
		}
	}
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
}
