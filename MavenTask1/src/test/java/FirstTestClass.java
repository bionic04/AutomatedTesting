import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTestClass {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Programs\\chrome_driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
         
		// launch the browser and open the application url and maximize the browser window
		driver.get("https://www.lamoda.by/men-home");
		driver.manage().window().maximize();
		              
		// declare and initialize the variable to store the expected title of the webpage.
		String expectedTitle = "Купить мужскую одежду и обувь в интернет магазине Lamoda.by";
		              
		// fetch the title of the web page and save it into a string variable
		String actualTitle = driver.getTitle();
		              
		// compare the expected title of the page with the actual title of the page and print the result
		if (expectedTitle.equals(actualTitle))
		{
			System.out.println("Verification Successful - The correct title is displayed on the web page.");
		}
		else
		{
			System.out.println("Verification Failed - An incorrect title is displayed on the web page.");
		}
		
		WebElement womanpage = driver.findElement(By.linkText("Женщинам"));
		womanpage.click();
		driver.navigate().back();
		Thread.sleep(3000);
		
		// close the web browser
		driver.close();
		System.out.println("Test script executed successfully.");
		              
		// terminate the program
		System.exit(0);
		       }
		}
