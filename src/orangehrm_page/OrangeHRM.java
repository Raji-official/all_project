package orangehrm_page;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.implementation.EqualsMethod;

public class OrangeHRM {
public static void main(String[] args) throws InterruptedException, IOException {
	System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
	ChromeDriver driver=new ChromeDriver();
//	load the urL
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	
	Actions ac=new Actions(driver);
	
	WebElement findElement = driver.findElement(By.xpath("//p[text()='Username : Admin']"));
	String text1 = findElement.getText();  
	String substring1 = text1.substring(0,8);
	String user = text1.substring(11);

	WebElement findElement2 = driver.findElement(By.xpath("//p[text()='Password : admin123']"));
	String text2 = findElement2.getText();
	String substring2 = text2.substring(0,8);

	String pass = text2.substring(11);
	
	
	WebElement findElement3 = driver.findElement(By.xpath("//button[text()=' Login ']"));
	String login1 = findElement3.getText();
	
	
	WebElement label_1 = driver.findElement(By.xpath("//label[text()='Username']"));
	String  username = label_1.getText();
		
	WebElement label_2 = driver.findElement(By.xpath("//label[text()='Password']"));
	String password = label_2.getText();
	
	WebElement label3 = driver.findElement(By.xpath("//h5[text()='Login']"));
	String login = label3.getText();
		
	
	if(substring1.equals(username)) {
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(user);
	}else {
	System.out.println("username not pass");	
	}
	
	if(substring2.equals(password)) {
driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pass);
		System.out.println("pass data");
	}else {
	System.out.println("password not pass");	
	}
	
	if(login.equals(login1)) {
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
	}else {
	System.out.println(" login not worked");	
	}
	
	driver.findElementById("").click();
	
	driver.findElement(By.xpath("//span[text()='My Info']")).click();
	Thread.sleep(2000);
	TakesScreenshot screen=(TakesScreenshot)driver;
    File decFile=screen.getScreenshotAs(OutputType.FILE);
    File des=new File("C:\\Users\\Welcome\\eclipse-workspace\\Selenum_demo\\screenshot\\orangeHRM.png");
    FileHandler.copy(decFile, des);
    Thread.sleep(2000);
	WebElement menu = driver.findElement(By.xpath("//li[@class='oxd-userdropdown']"));
	ac.click(menu).build().perform();
	//a[text()='Logout']
	Thread.sleep(1000);
	WebElement logout = driver.findElement(By.xpath("//a[text()='Logout']"));
	ac.click(logout).build().perform();
	
	Thread.sleep(2000);
	
	String url_title = driver.getTitle();
	
	WebElement findElement4 = driver.findElement(By.xpath("//p[text()='OrangeHRM OS 5.5']"));
      	String orange = findElement4.getText();
      	String orange_1 = orange.substring(0,9);
      	
      	if(url_title.equals(orange_1)) {
    		driver.close();
    	}else {
    	System.out.println("username not pass");	
    	}
    	
	
}
}
