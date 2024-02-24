package com.myntra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Myntra_web {

	public static void main(String[] args) throws InterruptedException {

	
		

		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/kids?f=Categories%3ATshirts%3A%3AGender%3Aboys%2Cboys%20girls&plaEnabled=false");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Actions action = new Actions(driver);

		WebElement findElement = driver.findElement(By.xpath("(//a[@class='desktop-main'])[1]"));
		action.moveToElement(findElement).build().perform();

		driver.findElement(By.xpath("(//a[text()='T-Shirts'])[1]")).click();

		List<WebElement> product_name = driver.findElements(By.xpath("//h3[@class='product-brand']"));
		List<WebElement> product_price = driver.findElements(By.xpath("//span[@class='product-discountedPrice']"));
	

	
		for (WebElement webElement : product_name) {
 			System.out.println(webElement.getText());
		}
 
		String name;
		String priceString;
		int price;
		Map<Integer, String> arr = new LinkedHashMap<Integer, String>();

		for (int i = 0; i < product_price.size(); i++) {
			name = product_name.get(i).getText();
			priceString = product_price.get(i).getText().replace("Rs. ", "").trim();	
			price = Integer.parseInt(priceString);
			System.out.println(price);
			
			
     		arr.put(price, name);

			
		

		}
		System.out.println(arr);
		
	     


		Set<Integer> keySet = arr.keySet();

		System.out.println(keySet);
		
		ArrayList<Integer> pri = new ArrayList<Integer>(keySet);
		System.out.println(pri);
		

		Collections.sort(pri);
		System.out.println(pri);
		int min = pri.get(0);
		int max = pri.get(pri.size() - 1);

		System.out.println("min :" + min);
		System.out.println("max :" + max);
		System.out.println("min :" + min + "  product name   : " + arr.get(min));
		System.out.println("max :" + max + "  product name   :" + arr.get(max));

		

//      
		
		
		
		
	}


}
