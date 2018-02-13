package testCases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Test1 {
	
	HashMap<Integer,String> al;

	@Test
	public void test1() throws Exception
	{
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://practice.automationtesting.in/shop/");
		
		List<WebElement> li =driver.findElements(By.xpath("//ul[@class='products masonry-done']/li/a/span[@class='onsale']//following-sibling::img"));
		
		for(int i=0;i<li.size();i++)
		{
			
		String s =	li.get(i).getAttribute("title2");
		System.out.println(s);
		 al = new HashMap<Integer,String>();
		al.put(i, s);
//		driver.findElement(By.xpath("//*[text()='"+s+"']")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN);
//		driver.findElement(By.xpath("//*[text()='"+s+"']")).click();
//		driver.findElement(By.xpath(".//*[@id='menu-item-40']/a")).click();
//		Thread.sleep(2000);
		
		}
	System.out.println(al);
//	for(int i=0;i<al.size();i++)
//	{
//		System.out.println(al.get(i));
//	}
		
		
	}
	

}

 class ExcelDemo
{
	 void readData()
	{
		
	}
}