package com.ajio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Ajio_website {
public static void main(String[] args) throws InterruptedException {
	
	
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//	driver.get("https://www.ajio.com/shop/sale?gad_source=1&gclid=Cj0KCQiA4Y-sBhC6ARIsAGXF1g6ctxIbPRnLWL-o35m9UJtbJ8-voRitihQS-RHXz4ECINvoaLSi7C0aAl-SEALw_wcB");

//	
//	Actions action=new Actions(driver);
//	
//	WebElement findElement = driver.findElement(By.xpath("//span[text()='HOME AND KITCHEN']"));
//	
//	
//	
//	action.moveToElement(findElement).build().perform();
//	
//	WebElement bed = driver.findElement(By.xpath("//a[text()='Bedsheets']"));
//
//	
//	
//	action.moveToElement(bed).build().perform();
//	Thread.sleep(1000);
//	bed.click();
//	
//	
//	List<WebElement> list_0f_bedprice= driver.findElements(By.xpath("//span[@class='price  ']"));
//
//	List<WebElement> list_0f_bedname = driver.findElements(By.xpath("//div[@class='nameCls']"));
//	
//	String bedname;
//	String bedprice;
//	int integer_product_price;
//	
//	HashMap<Integer, String> data_map = new HashMap<Integer, String>();
//	
//	for (int i = 0; i < list_0f_bedname.size(); i++) {
//		bedname=list_0f_bedname.get(i).getText();
//		bedprice=list_0f_bedprice.get(i).getText();
//	    bedprice= bedprice.replace("₹", "").trim();
//	    bedprice=bedprice.replace(",","").trim();
//	    System.out.println(bedprice);
//	    integer_product_price=Integer.parseInt(bedprice);
//	   
//	    data_map.put( integer_product_price, bedname);
//		
//	}
//	
//
//	Set<Integer> keySet = data_map.keySet();
//
//	ArrayList<Integer> product_price_list =new  ArrayList<Integer>(keySet);
//	System.out.println("product_price_list   :" +product_price_list);
//	
//	Collections.sort(product_price_list);
//	
//	Integer max_price = product_price_list.get(product_price_list.size()-1);
//	Integer min_price = product_price_list.get(0);
//	
//	   System.out.println("High Product Price is: " + max_price + " Product name is: " + data_map.get(max_price));
//		System.out.println("Low Product Price is: " + min_price + " Product name is: " + data_map.get(min_price));
//	
	driver.get("https://duckduckgo.com/");

	WebElement searchTextBox= driver.findElement(By.id("search_form_input_homepage"));

	// retrieving html attribute value using getAttribute() method
	String typeValue=searchTextBox.getAttribute("type");
	System.out.println("Value of type attribute: "+typeValue);

	String autocompleteValue=searchTextBox.getAttribute("autocomplete");
	System.out.println("Value of autocomplete attribute: "+autocompleteValue);

	// Retrieving value of attribute which does not exist
	String nonExistingAttributeValue=searchTextBox.getAttribute("nonExistingAttribute");
	System.out.println("Value of nonExistingAttribute attribute: "+nonExistingAttributeValue);
    

 
	    	
	    

	

	


	
	
}
}
