package org.facebook;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class Facebook_mini_project {

	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
//		load the urL
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		
		
	
		
		String databaseemail="8438365085";
		String databasepassword="2608361";
		
		String emailid="gvdshgvhgdvhgdvfaadf";
		String password="1234456789";
		
		String title = driver.getTitle();
		System.out.println(title);
		String substring = title.substring(0, 8);
		System.out.println(substring);
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(emailid);
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(password);
		
        String fb="Facebook";
        if(substring.equals(fb)) {
        	System.out.println("enterd");
        	if(databaseemail.equals(emailid) && databasepassword.equals(password)) {
        
        		
        		System.out.println("EMAILID AND PASSWORD IS TRUE");
        		driver.findElement(By.xpath("//button[@type='submit']")).click();
        		
        }else {
        	
        	driver.findElement(By.xpath("//button[@type='submit']")).click();
        	Thread.sleep(2000);
        	
//        	Screenshot
        	TakesScreenshot screen=(TakesScreenshot)driver;
            File decFile=screen.getScreenshotAs(OutputType.FILE);
            File des=new File("C:\\Users\\Welcome\\eclipse-workspace\\Selenum_demo\\screenshot\\first_error.png");
            FileUtils.copyFileToDirectory(decFile, des);
        	
            Thread.sleep(1000);
            
            driver.navigate().back();
            
            driver.findElement(By.xpath("//a[text()='Create new account']")).click();
            Thread.sleep(1000);
            
            
            
            WebElement sing_up_text_1 = driver.findElement(By.xpath("//div[text()='Sign Up']"));
            String text = sing_up_text_1.getText();
            WebElement sing_up_text_2 = driver.findElement(By.xpath("//button[text()='Sign Up']"));
            String text2 = sing_up_text_2.getText();
            
            System.out.println(text);
            System.out.println(text2);
            Thread.sleep(2000);
            
            if(text.equals(text2)) {
            	  Thread.sleep(1000);
            	 WebElement firstname = driver.findElement(By.xpath("//input[@name='firstname']"));
            	 firstname.sendKeys("123456");
            	 System.out.println("first name");
            	 
            
            	
            }else {
            	driver.close();
            }
            
            Thread.sleep(1000);
            WebElement lastname = driver.findElement(By.xpath("//input[@name='lastname']"));
            lastname.sendKeys("raji232324");
            
            Thread.sleep(1000);
            
            WebElement mobile_email = driver.findElement(By.xpath(" //input[@name='reg_email__']"));
            mobile_email.sendKeys("960096rajifernanto");
            
            Thread.sleep(1000);
            
            WebElement newpassword = driver.findElement(By.xpath("//input[@id='password_step_input']"));
            newpassword.sendKeys("raj.[].///");
         
            Thread.sleep(1000);
            
            WebElement day = driver.findElement(By.xpath("//select[@id='day']"));
            Select new1= new Select(day);
            new1.selectByValue("26");
         
//            
            
            WebElement month = driver.findElement(By.xpath("//select[@title='Month']"));
            Select new2= new Select(month);
            new2.selectByIndex(0);
            
            
            WebElement year = driver.findElement(By.xpath("//select[@title='Year']"));
            Select new3= new Select(year);
            new3.selectByValue("1999");
         
            
            driver.findElement(By.xpath(" //input[@value='2']")).click();
            
          
            driver.findElement(By.xpath("//button[@name='websubmit']")).click();
            
            Thread.sleep(1000);
//        	Screenshot
        	TakesScreenshot screen_1=(TakesScreenshot)driver;
            File decFile_1=screen_1.getScreenshotAs(OutputType.FILE);
            File des_1=new File("C:\\Users\\Welcome\\eclipse-workspace\\Selenum_demo\\screenshot\\end_error.png");
            FileUtils.copyFileToDirectory(decFile_1, des_1); 
            
            
         
            driver.findElement(By.xpath(" //img[@class='_8idr img']")).click();
            Thread.sleep(1000);
            driver.quit();
        	
        }
		
		
			
		
		
		
	}
	
	
}
}