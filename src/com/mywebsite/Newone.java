package com.mywebsite;

	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.List;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;

	public class Newone {

		public static WebDriver driver;

		private static void browserLaunch() {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}

		private static void urlLaunch() {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			driver.get("https://www.myntra.com/");
		}

		private static void searchContent() {
			Actions act = new Actions(driver);

			WebElement mini = driver.findElement(By.xpath("(//a[@class='desktop-main'])[3]"));
			act.moveToElement(mini).build().perform();

			WebElement tshirt = driver.findElement(By.xpath("//a[text()='T-Shirts']"));
			act.moveToElement(tshirt).build().perform();
			act.click(tshirt).build().perform();
		}

		private static void totalNoOfProducts() {
			List<WebElement> price = driver.findElements(By.xpath("//div[@class='product-price']"));
			int prod = price.size();
			System.out.println("total no of products: " + prod);
		}

		private static void minProductPrice() {
			List<WebElement> discount = driver.findElements(By.xpath("//span[@class='product-discountedPrice']"));
			List<WebElement> pri = driver.findElements(By.xpath("//div[@class='product-price']"));
		
			List<Integer> values = new ArrayList<Integer>();

			
			for (int i = 0; i < pri.size(); i++) {
				
				
				String text = discount.get(i).getText();
				String replace = text.replace("Rs. ", "").trim();
				System.out.println(replace); 
				Integer int_val = Integer.valueOf(replace);
				if (values.add(int_val) || !values.add(int_val)) {
					values.add(int_val);
				}
				
				
			}
		
			Integer min = Collections.min(values);
			Integer max = Collections.max(values);
			System.out.println("minimum values" + min);
			System.out.println("maximum values" + max);
			

			
		
			
		}

		public static void main(String[] args) {
			browserLaunch();
			urlLaunch();
			searchContent();
			totalNoOfProducts();
			minProductPrice();

		}

	}



