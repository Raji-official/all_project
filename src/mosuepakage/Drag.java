package mosuepakage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Drag {
public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	
	WebDriver driver=new ChromeDriver();
	driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
	
	Actions a=new Actions(driver);
	WebElement drag=driver.findElement(By.xpath("//div[@id=\"box3\"]"));
	WebElement drop=driver.findElement(By.xpath("//div[@id=\"box103\"]"));
	
	WebElement drag_1=driver.findElement(By.xpath("//div[@id=\"box7\"]"));
	WebElement drop_1=driver.findElement(By.xpath("//div[@id=\"box107\"]"));
	
	WebElement drag_2=driver.findElement(By.xpath("//div[@id=\"box1\"]"));
	WebElement drop_2=driver.findElement(By.xpath("//div[@id=\"box101\"]"));
	
	WebElement drag_3=driver.findElement(By.xpath("//div[@id=\"box6\"]"));
	WebElement drop_3=driver.findElement(By.xpath("//div[@id=\"box106\"]"));
	
	WebElement drag_4=driver.findElement(By.xpath("//div[@id=\"box2\"]"));
	WebElement drop_4=driver.findElement(By.xpath("//div[@id=\"box102\"]"));
	
	WebElement drag_5=driver.findElement(By.xpath("//div[@id=\"box4\"]"));
	WebElement drop_5=driver.findElement(By.xpath("//div[@id=\"box104\"]"));
	
	WebElement drag_6=driver.findElement(By.xpath("//div[@id=\"box5\"]"));
	WebElement drop_6=driver.findElement(By.xpath("//div[@id=\"box105\"]"));
	
	a.dragAndDrop(drag, drop).build().perform();
	a.dragAndDrop(drag_1,drop_1).build().perform();
	a.dragAndDrop(drag_2,drop_2).build().perform();
	a.dragAndDrop(drag_3,drop_3).build().perform();
	a.dragAndDrop(drag_4,drop_4).build().perform();
	a.dragAndDrop(drag_5,drop_5).build().perform();
	a.dragAndDrop(drag_6,drop_6).build().perform();
}
}
