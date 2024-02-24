package mosuepakage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Mouse_1 {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.amazon.in/");
	
	Actions a=new Actions(driver);
	WebElement mini=driver.findElement(By.xpath("//a[text()=\"Amazon miniTV\"]"));
	
	
//	a.click(mini).build().perform();
	
//	a.contextClick(mini).build().perform();
	
	WebElement sign=driver.findElement(By.xpath("//span[text()=\"Hello, sign in\"]"));
	a.moveToElement(sign).build().perform();
	
	
	
}
}
