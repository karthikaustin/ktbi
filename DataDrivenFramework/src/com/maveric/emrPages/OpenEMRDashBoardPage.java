package com.maveric.emrPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenEMRDashBoardPage {
	private static By aboutLoc =By.xpath("//div[text()='About'] ");
	private static By linksLoc= By.tagName("a");
	public static void waitForPresenceOfAboutText(WebDriverWait wait)
	{
		//Wait wait= new WebDriverWait(driver,50); //50 to 120 s- pooling time is 0.5 sec or 500ms
		wait.until(ExpectedConditions.presenceOfElementLocated(aboutLoc));
	}

	public static String getTitleAfterAboutDisplay(WebDriver driver)
	{
		return driver.getTitle();
	}
	
	public static int getTotalLinkCount(WebDriver driver)
	{
		List<WebElement> linksEle= driver.findElements(By.tagName("a"));
		int linkCount= linksEle.size();
		return linkCount ;
	}
}
