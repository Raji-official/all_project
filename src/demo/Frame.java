package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frame {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
//		load the urL
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Rajan");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("Rajfernanto764@");	
//		driver.findElement(By.xpath("//button[@name='login']")).click()	;
		driver.findElement(By.name("login")).click();
	}
}
