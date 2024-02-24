package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Webpage {
	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
//		load the urL
		driver.get("https://letcode.in/frame");
		driver.manage().window().maximize()	;
		
		driver.switchTo().frame(0);
		WebElement fname= driver.findElement(By.xpath("//input[@name=\"fname\"]"));
		fname.sendKeys("raji");
//		driver.findElement(By.xpath("")).sendKeys("raji");
		
				driver.switchTo().frame(1);
		driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("rajfernanto764@gmail.com");
		driver.switchTo().parentFrame();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name=\"lname\"]")).sendKeys("ranjithraj");
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()=\"Watch tutorial\"]")).click();
		
		
		
		
		}
}
