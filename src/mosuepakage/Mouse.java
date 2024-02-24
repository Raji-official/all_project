package mosuepakage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Mouse {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	
	WebDriver driver=new ChromeDriver();
	driver.get("https://demo.automationtesting.in/Static.html");
	
	Actions a=new Actions(driver);

	WebElement drag=driver.findElement(By.xpath("//img[@id=\"angular\"]"));
	WebElement drag_1=driver.findElement(By.xpath("//img[@id=\"mongo\"]"));
	WebElement drag_2=driver.findElement(By.xpath("//img[@id=\"node\"]"));
	WebElement drop=driver.findElement(By.xpath("//div[@id=\"droparea\"]"));
	
	a.dragAndDrop( drag,drop).build().perform();
	a.dragAndDrop( drag_1,drop).build().perform();
	a.dragAndDrop( drag_2,drop).build().perform();

}
}
