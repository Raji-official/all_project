package com.igp_pac;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.accessibility.AccessibleExtendedTable;

import org.openqa.grid.web.servlet.LifecycleServlet;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.beust.jcommander.internal.Console;

public class Igp {
public static void main(String[] args) throws InterruptedException {
	
	


		System.setProperty("webdriver.chrome.driver",
				"./drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.igp.com/");

		driver.manage().window().maximize();
		

		driver.findElement(By.xpath("(//img[@class='selection-panel-img no-background'])[5]")).click();
		driver.findElement(By.xpath("//span[text()='Anniversary Cakes']")).click();
		
		
          List<WebElement> cakelist = driver.findElements(By.xpath("//div[@id='product-grid']"));
          List<WebElement> price = driver.findElements(By.xpath(" //span[@class='Paragraph-16-M--Semibold']"));
          
       
    	  for (WebElement webElement : cakelist) {
    	
    	Thread.sleep(1000);
    	System.out.println( webElement.getText());
    	}
          
          
          List<String> data=new ArrayList<String>();
          
     	for (int i = 0; i < price.size(); i++) {
     		
     		data.add(price.get(i).getText());
     		
		} 
     
     	 List<String> data1=new ArrayList<String>();
      	    
        for (String str : data) {
			String replace = str.replace("₹ "," ").trim();
			data1.add(replace);
		}      
        
        System.out.println(data1);
        
      	

        System.out.println(" + : " + data);
       
//        price
       
        List<Integer> intdata=new ArrayList<Integer>();
        
        for(String name : data1) {

            int num=Integer.parseInt(name);
            intdata.add(num);
            

        }
      
    
     
        
        
        
        System.out.println(intdata);
        
        Integer min = Collections.min( intdata);
        System.out.println(min);
        
        Integer max = Collections.max( intdata);
        System.out.println(max);
        
        
        
//        METHOD 2     METHOD 2            METHOD 2                 METHOD 2
       
             
         List<WebElement> list_of_products = driver.findElements(By.xpath("//p[@class='product-name product-name-revamp Paragraph-14-S--Semibold']"));
        
  
         List<WebElement> price1 = driver.findElements(By.xpath(" //span[@class='Paragraph-16-M--Semibold']"));
 		
 		
 		
 		String product_name;
		String product_price;
		int int_product_price;
		
		HashMap<Integer, String> map_final_products = new HashMap<Integer,String>();
		
		for(int i=0;i<list_of_products.size();i++) {
			product_name = list_of_products.get(i).getText();
			product_price = price1.get(i).getText();
			product_price = product_price.replace("₹ "," ").trim();
			int_product_price = Integer.parseInt(product_price);
			map_final_products.put(int_product_price,product_name);
		}
 		
 		
 		
 		
 		
 		Set<Integer> allkeys = map_final_products.keySet();
 		
		ArrayList<Integer> array_list_values_product_prices = new ArrayList<Integer>(allkeys);
		
		Collections.sort(array_list_values_product_prices);
		
        int high_price = array_list_values_product_prices.get(array_list_values_product_prices.size()-1);
		
		int low_price = array_list_values_product_prices.get(0);
		
	   System.out.println("High Product Price is: " + high_price + " Product name is: " + map_final_products.get(high_price));
		System.out.println("Low Product Price is: " + low_price + " Product name is: " + map_final_products.get(low_price));
		
        
        
        
    
   
   

        	   
}
}
