package amazon_pac;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class Selenium_Amazon_project {
	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		WebElement findElement = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
		String text2 = findElement.getText();
		System.out.println(text2);

		Select location = new Select(findElement);
		System.out.println(location);
		location.selectByVisibleText("Books");

		String inp = "comic";
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(inp);

//
		Thread.sleep(3000);
		WebElement comic = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		String inptext = comic.getText();
		System.out.println(inptext);

		List<WebElement> findElements = driver.findElements(By.xpath(
				"//input[@id='twotabsearchtextbox']//parent::div//parent::div//ancestor::header//following-sibling::div//div[@class='s-suggestion-container']"));

		for (WebElement data : findElements) {
			String text = data.getText();
			System.out.println(text);
			if (text.equalsIgnoreCase(inp)) {
				System.out.println("succes");
				System.out.println(text);

				Actions actions = new Actions(driver);

				WebElement findElement3 = driver.findElement(By.xpath(
						"//input[@id='twotabsearchtextbox']//parent::div//parent::div//ancestor::header//following-sibling::div//div[@class='s-suggestion-container']//div[@aria-label='comic']"));

				findElement3.click();
				driver.findElement(By.xpath(
						"(//span[text()='Results']//parent::div//following::script//following::div//span[starts-with(text(), 'Superman')])"))
						.click();

				Set<String> windowHandles = driver.getWindowHandles();
				for (String handle : windowHandles) {
					driver.switchTo().window(handle);
				}
//

				driver.switchTo();
				
				String title = driver.getTitle();
				System.out.println(title);

				String substring = title.substring(0, 56);
				System.out.println(substring);

				WebElement findElement2 = driver.findElement(By.xpath("//span[@id='productTitle']"));
				String book_name = findElement2.getText();
				System.out.println(book_name);

				if (substring.equals(book_name)) {

					TakesScreenshot screen = (TakesScreenshot) driver;
					File decFile = screen.getScreenshotAs(OutputType.FILE);
					File des = new File(
							"C:\\Users\\Welcome\\eclipse-workspace\\Selenum_demo\\screenshot\\amazon_2.png");
					FileHandler.copy(decFile, des);

					driver.findElement(By.xpath("//input[@id='buy-now-button']")).click();

				} else {
					System.out.println("error");
				}
				Thread.sleep(1000);
				TakesScreenshot screen = (TakesScreenshot) driver;
				File decFile = screen.getScreenshotAs(OutputType.FILE);
				File des = new File("C:\\Users\\Welcome\\eclipse-workspace\\Selenum_demo\\screenshot\\amazon_1.png");
				FileHandler.copy(decFile, des);

				Thread.sleep(1000);
				driver.close();
				Thread.sleep(1000);
				driver.quit();

			}

		}

	}
}
