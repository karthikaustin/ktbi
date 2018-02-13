package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import pages.Login;
import pages.Shop;

public class TestCases {

	WebDriver driver;
	
	@Test
	public void test1()
	{
			driver = new FirefoxDriver();
			
			driver.get("http://practice.automationtesting.in");
			
			Login login = new Login(driver);
			Shop shop = new Shop(driver);
			
			
			login.login("raghulmec@gmail.com", "8Jayamanip8*");
			shop.shop_store();
	}
	
	
}
