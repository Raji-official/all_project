package com.amazon;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class Amazon_project {
public static void main(String[] args) throws InterruptedException, IOException {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.amazon.in/");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	
	WebElement findElement = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
	Select location= new Select(findElement);
	location.selectByIndex(11);
	
	String inp="comic";
	driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(inp);
	
	
//
	Thread.sleep(3000);
	WebElement comic = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
	String inptext = comic.getText();
	System.out.println(inptext);

	
	
	 List<WebElement> findElements = driver.findElements(By.xpath("//input[@id='twotabsearchtextbox']//parent::div//parent::div//ancestor::header//following-sibling::div//div[@class='left-pane-results-container']"));
	
	for(WebElement data:findElements) {
		String text = data.getText();
		System.out.println(text);
		if(text.contains(inp)) {
		System.out.println("succes");
		Thread.sleep(1000);
		WebElement findElements2 = driver.findElement(By.xpath("(//input[@id='twotabsearchtextbox']//parent::div//parent::div//ancestor::header//following-sibling::div//div[text()='comic'])[1]"));
		 System.out.println(findElements2.getText());
		findElements2.click();
		Thread.sleep(1000);
		
		
		}
//		  Set<String> windowHandles = driver.getWindowHandles();
//	      for (String handle : windowHandles) {
//	          driver.switchTo().window(handle);
//	      }
		
		
		
		
//		driver.findElement(By.xpath("//span^[text()='Superman: Action Comics Vol. 2: Bulletproof (The New 52)']")).click();
		driver.findElement(By.xpath("//span[starts-with(text(), 'Superman')]")).click();

		
//		String url_title = driver.getTitle();
//		System.out.println(url_title);
//			
		 Set<String> windowHandles = driver.getWindowHandles();
		 
	      for (String handle : windowHandles) {
	          driver.switchTo().window(handle);
	      }
//
		
		driver.switchTo();
		String title = driver.getTitle();
		System.out.println(title);
		
		String substring = title.substring(0, 56);
		System.out.println(substring);
		
		WebElement findElement2 = driver.findElement(By.xpath("//span[@id='productTitle']"));
		String book_name = findElement2.getText();
		
		if(substring.equals(book_name)) {
		
			 driver.findElement(By.xpath("//input[@id='buy-now-button']")).click();

		}
		
		Thread.sleep(1000);
		TakesScreenshot screen=(TakesScreenshot)driver;
	    File decFile=screen.getScreenshotAs(OutputType.FILE);
	    File des=new File("C:\\Users\\Welcome\\eclipse-workspace\\Selenum_demo\\screenshot\\amazon.png");
	    FileHandler.copy(decFile, des);
		
		Thread.sleep(1000);
		driver.close();
		
		driver.quit();
		
		
	}
	
	
	
}
}
