package java_executed;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;

import net.bytebuddy.asm.Advice.Argument;
import org.openqa.selenium.support.ui.Select;
public class Java_execute_demo {
public static void main(String[] args) throws InterruptedException {
System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("https://www.cowin.gov.in/");
	driver.manage().window().maximize();
	JavascriptExecutor jse =(JavascriptExecutor) driver;
	
	
	jse.executeScript("window.scrollBy(0, 300);");
	driver.findElement(By.id("mat-select-4")).click();
	driver.findElement(By.xpath("(//span[@class='mat-option-text'])[32]")).click();
	
	driver.findElement(By.id("mat-select-6")).click();
	driver.findElement(By.xpath("(//span[@class='mat-option-text'])[4]")).click(); 
	
	driver.findElement(By.xpath("//button[text() 'Search']")).click();
	


	
}
}
