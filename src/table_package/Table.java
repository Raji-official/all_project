package table_package;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Table {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	ChromeDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
//	driver.get("https://letcode.in/table");
	
	
	
	driver.get("https://m.cricbuzz.com/cricket-series/6732/icc-cricket-world-cup-2023/points-table");
	
	WebElement high_won = driver.findElement(By.xpath("//table[@class='table']/tbody/tr/td[3]"));
	String text = high_won.getText();
	System.out.println(text);
	
	WebElement low_loss = driver.findElement(By.xpath("//table[@class='table']/tbody/tr/td[4]"));
	String text_1 = low_loss.getText();
	System.out.println(text_1);
	
	List<WebElement> findElements = driver.findElements(By.xpath("//table[@class='table']/tbody/tr/td"));
	for(WebElement ans:findElements) {
		System.out.println(ans.getText());
	}
	
	
//	 List<WebElement> headers = driver.findElements(By.xpath("//table[@id='simpletable']/thead/tr"));
//	 
//	 List<WebElement> body_row = driver.findElements(By.xpath("//table[@id='simpletable']/tbody/tr"));
//	 int size = body_row.size();
//	 System.out.println(size);
//	 
//
//      
//	for(WebElement header:headers) {
//		String text = header.getText();
//		System.out.println(text);
//	}
//	
//	List<WebElement> findElements = driver.findElements(By.xpath("//table[@id='simpletable']/tbody/tr"));
//	for (int i = 0; i < size; i++) {
//		
//		List<WebElement> findElements2 = driver.findElements(By.xpath("//table[@id='simpletable']/tbody/tr/td"));
//	
		
//		WebElement webElement = findElements.get(1).findElement(By.xpath("//table[@id='simpletable']/tbody/tr[1]/td[3]"));
//		String text_1 = webElement.getText();
//		System.out.println(text_1);	
		
//	}
	
}
}
