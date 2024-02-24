package frame_project;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Frame_demo_work {
public static void main(String[] args) throws InterruptedException, IOException {
	System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("https://demo.automationtesting.in/WebTable.html");
	driver.manage().window().maximize(); 
	Thread.sleep(3000);
	driver.findElement(By.xpath("//a[text()=\"Home\"]")).click();
	driver.navigate().back();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[text()=\"Home\"]")).click();
	driver.findElement(By.xpath("//input[@id='email']")).sendKeys("rajfernanto764@gmailcom");
	driver.findElement(By.xpath("//img[@src='enter.png']")).click();
	driver.navigate().back(); 
	driver.findElement(By.xpath("//input[@id='email']")).clear();
	
	driver.findElement(By.xpath("//input[@id='email']")).sendKeys("rajfernanto765@gmailcom");
	driver.findElement(By.xpath("//img[@src='enter.png']")).click();
	
//	screenshot  
	
	TakesScreenshot screen=(TakesScreenshot)driver;
    File decFile=screen.getScreenshotAs(OutputType.FILE);
    File des=new File("C:\\Users\\Welcome\\eclipse-workspace\\Mousepac\\screenshot\\demo.png");
    FileHandler.copy(decFile, des);
	
	
//	mouse move
	Actions a=new Actions(driver);
	WebElement sign=driver.findElement(By.xpath("//a[text()='SwitchTo']"));
	a.moveToElement(sign).build().perform();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//a[text()='Windows']")).click();
	
//	WebElement drop= driver.findElement(By.xpath("//ul[@class='dropdown-menu']"));
//	drop.click();
//	Select ans=new Select(drop);
//	ans.selectByVisibleText("windows");
	
	//a[text()="SwitchTo"]
//	 driver.findElement(By.xpath("//a[text()=\"Register\"]")).click();
//	
//	driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div/div/input")).sendKeys("Raji");
//	Thread.sleep(1000);
//	driver.navigate().back();
//	//a[text()="WebTable"]
//	driver.findElement(By.xpath("//a[text()=\"WebTable\"]")).click();
//	Thread.sleep(1000);
//	driver.navigate().back();

	
	
	
}
}
