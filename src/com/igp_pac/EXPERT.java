package com.igp_pac;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.xml.stream.XMLReporter;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EXPERT {


	public static void main(String[] args) {
		
		
		String s_search_string = "Tv";
		String url = "https://www.flipkart.com";
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get(url);
//		Reporter.log("Chrome Invoked and navigated to URL: " + url + "<br>", true);
		
		//Checking page is navigated with the expected title
		driver.findElement(By.xpath("//span[@role='button']")).click();
		
	
		 
		//Clicking on Cross button
		WebElement sign_in_cross = driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']"));
		sign_in_cross.click();
//		Reporter.log("Sign In Window Closed." + "<br>", true);
		
		//Check Search Box is Displayed
		WebElement searchbx = driver.findElement(By.xpath("//input[@name ='q' and @type='text']"));
//		Assert.assertEquals(searchbx.isDisplayed(), true);
//		Reporter.log("Search Box is displayed." + "<br>", true);
		
		//Enter TV in Search text box
		searchbx.sendKeys(s_search_string);
		
		//Clicked on Search button
		driver.findElement(By.xpath("//button[@class='vh79eN']")).click();
		
		//Check if search Results is displayed-VALIDATION 1
		
//		Assert.assertEquals(txtbx_search_result_text.isDisplayed(), true);
		
		//Check if search Results is displayed-VALIDATION 2
		
 
		//Fetch All the Products Text
		List<WebElement> list_of_products = driver.findElements(By.xpath("//div[@class='_3wU53n']"));
		List<WebElement> list_of_products_price = driver.findElements(By.xpath("//div[@class='_1vC4OE _2rQ-NK']"));
		
		//Use of HashMaop to store Products and Their prices(after conversion to Integer)
		String product_name;
		String product_price;
		int int_product_price;
		HashMap<Integer, String> map_final_products = new HashMap<Integer,String>();
		for(int i=0;i<list_of_products.size();i++) {
			product_name = list_of_products.get(i).getText();//Iterate and fetch product name
			product_price = list_of_products_price.get(i).getText();//Iterate and fetch product price
			product_price = product_price.replaceAll("[^0-9]", "");//Replace anything wil space other than numbers
			int_product_price = Integer.parseInt(product_price);//Convert to Integer
			map_final_products.put(int_product_price,product_name);//Add product and price in HashMap
		}
	
 
		//Find the Highest and Lowest prices
		//One way is to fetch all values of the hashMap and then save it in the ArrayList
		//Then using Collections class in java, sort it. this we can easily get highest and lowest
		
		//Get all the keys from Hash Map
		Set<Integer> allkeys = map_final_products.keySet();
		ArrayList<Integer> array_list_values_product_prices = new ArrayList<Integer>(allkeys);
		
		//Sort the Prices in Array List using Collections class
		//this will sort in ascending order lowest at the top and highest at the bottom
		Collections.sort(array_list_values_product_prices);
		
		//Highest Product is
		int high_price = array_list_values_product_prices.get(array_list_values_product_prices.size()-1);
		
		//Low price is
		int low_price = array_list_values_product_prices.get(0);
		
	   System.out.println("High Product Price is: " + high_price + " Product name is: " + map_final_products.get(high_price));
		System.out.println("Low Product Price is: " + low_price + " Product name is: " + map_final_products.get(low_price));
		
		//Get List of All values from Hash Map. Right now we do not need it so commenting
		//Collection<String> allValues = map_final_products.values();
		//ArrayList<String> array_list_values_product_names = new ArrayList<String>(allValues);
	 
		
		
		
		
		
		
		
	}

}
