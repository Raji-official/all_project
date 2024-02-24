package com.link_check;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Valid_Link_Check {
public static void main(String[] args) {
	
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
//	driver.get("https://www.amazon.in/");

	   
    String homePage = "https://www.amazon.in/";
    String url = "";
    HttpURLConnection http = null;
    HttpsURLConnection https=null;
    int respCode = 200;
    
    driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    
    driver.get(homePage);
    
     List<WebElement> links = driver.findElements(By.tagName("a"));
    
    Iterator<WebElement> it = links.iterator();
    
    Iterator<WebElement> it1 = links.iterator();
    
    System.out.println(it);
    
    int valid_link_count=0;
    int broken_link_count=0;
    int excep=0;
    int empty=0;
        
   
    
    while(it.hasNext()){
        
        url = it.next().getAttribute("href");
        if(url == null || url.isEmpty()){
               System.out.println("URL empty");
               empty+=1;
               
            continue;
        }
        
        try {
        	http = (HttpURLConnection)(new URL(url).openConnection());
            
        	http.setRequestMethod("HEAD");
            
        	http.connect();
            
            respCode = http.getResponseCode();
            
            if(respCode == 200){              
                System.out.println(url+" is a valid link");
                valid_link_count+=1;   
                System.out.println(valid_link_count);       
            }
            else if (respCode>200 || respCode<500) {
            	 System.out.println(url+" is a broken link");
            	 broken_link_count+=1;
            	 System.out.println(broken_link_count);
			}else {
				System.out.println("newwork error");
			}         
        } catch (Exception e) {
			System.out.println("error");
			excep+=1;
		}
    }
  
    String brok=("broken link : "+ broken_link_count);  
    System.out.println(brok);
    String valid=("valid link : "+ valid_link_count);  
    System.out.println(valid);
    String exeptonString=("exepton error link : "+ excep);  
    System.out.println(exeptonString);
    
    String emptyurl=("empty url : "+ empty);  
    System.out.println(emptyurl);
    
    
    
    
	
}
}
