package screenshot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Screenshot_demo {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
	ChromeDriver driver=new ChromeDriver();
//	load the urL
	driver.get("https://chercher.tech/practice/practice-dropdowns-selenium-webdriver");
	
	
	WebElement findElement = driver.findElement(By.xpath("//select[@id='first']"));
	Select drapSelect=new Select(findElement);
	drapSelect.selectByVisibleText("iphone");
	
}
}
