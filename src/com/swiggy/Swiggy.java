package com.swiggy;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Swiggy {
	public static void main(String[] args) throws InterruptedException {
		
		
        
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.swiggy.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		
		driver.findElement(By.xpath("//button[@class='_1fiQt']")).click();
		driver.findElement(By.xpath("//a[@aria-label='restaurants curated for icecream']")).click();
		
		WebElement ice = driver.findElement(By.xpath("//div[text()='Havmor Havfunn Ice Cream']"));
		
		String icename = ice.getText();
		System.out.println(icename);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		
		WebElement add1_ice = driver.findElement(By.xpath(("//img[@src='https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_660/2b4259115600fbf39c966361fdc183f6']")));
		
		add1_ice.click();

		
			
		WebElement ice_add = driver.findElement(By.xpath("(//div[@class='_1RPOp'])[10]"));
		ice_add.click();
		
		Thread.sleep(2000);
		WebElement  view_cart= driver.findElement(By.xpath("//span[text()='View Cart']"));
		view_cart.click();
		Thread.sleep(2000);
		WebElement  LOG_IN= driver.findElement(By.xpath("//div[text()='LOG IN']"));
		LOG_IN.click();
		
		 String mobilenumber="9600968726";
		
		driver.findElement(By.xpath("//input[@id='mobile']")).sendKeys(mobilenumber);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
