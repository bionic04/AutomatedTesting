package main;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;

public class MainClass{
	WebDriver driver;
	HomeClass objhome;
	
	@BeforeTest
	public void Setup(){
		System.setProperty("webdriver.chrome.driver", "D:\\Programs\\chrome_driver2\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.asos.com/men/");
		driver.manage().window().maximize();
	}
	
	@Test (priority = 1)
	public void MainBar(){
		List<WebElement> mainBarElements = driver.findElements(By.xpath("//div[@class = '_8EFahPg']/div[2]/nav/div/div[@class = '_3C_NQPb']"));
		 for (WebElement element : mainBarElements){
			Boolean verify = element.isDisplayed();
			assertTrue(verify);
		 }
		 
	}
	
	@Test (priority = 2)
	public void searchProduct() throws InterruptedException{
		objhome = new HomeClass(driver);
		objhome.searchBarClick();
		driver.findElement(By.xpath("//*[@id=\"chrome-search\"]")).sendKeys("Winter Jackets");
		objhome.submitSearch();
	}
	
	@Test (priority = 3)
	public void savingJackets(){
		objhome = new HomeClass(driver);
		objhome.firstJacketSave();
		objhome.secondJacketSave();
	}
	
	@Test (priority = 4)
	public void savedProducts() throws InterruptedException{
		objhome = new HomeClass(driver);
		objhome.savedProductsClick();
		driver.findElement(By.xpath("//button [@class = '_1TlOB9h _2tvh469 _19qEA_b']/span[text() = 'Deliver to Belarus']")).click();
		driver.findElement(By.xpath("//button [@class = 'glYZgHa' and @data-testid = 'close-button']")).click();
		Thread.sleep(2000);
	}
	
	@Test (priority = 5)
	public void sizeSelectionAndConfirmation(){
		driver.findElement(By.xpath("//select [@aria-label = 'Size']/option [@value = '203490731']")).click();
		driver.findElement(By.xpath("//select [@aria-label = 'Size']/option [@value = '202162399']")).click();
		driver.findElement(By.xpath("//div [@class = 'productTile_twgqJ']/button [@class = 'toBagButton_mYSbq toBagButton_LHRGf']")).click();
	}
	
	@Test (priority = 6)
	public void cartActivity() throws InterruptedException{
		Actions actions = new Actions(driver);
		WebElement cartMenu = driver.findElement(By.xpath("//li [@class = '_3Wo6fpk']/div/div/div/button [@aria-controls = 'minibag-dropdown']/span [@type = 'bagFilled']"));
		actions.moveToElement(cartMenu).perform();
		driver.findElement(By.xpath("//*[@id=\"minibag-dropdown\"]/div/div/div/div[2]/div/div[3]/div[1]/a")).click();
		//driver.findElement(By.xpath("//div [@class = '_58IUcq4']/div/a [@class = '_1TlOB9h _2tvh469 _12h15d-' and @type = 'button']/span[@class = '_1M-cSy1']")).click();
	}
	
	@Test (priority = 7)
	public void cartCancel(){
		driver.findElement(By.xpath("//button [@class = 'bag-item-remove']")).click();
	}
	
	@Test (priority = 8)
	public void assertion(){
		WebElement first = driver.findElement(By.xpath("//button [@data-index =  '1']/span [@class = 'f3gYf7g']/span"));
		Assert.assertEquals(first.getAttribute("innerHTML"), "New in");
		
		WebElement second = driver.findElement(By.xpath("//button [@data-index =  '2']/span [@class = 'f3gYf7g']/span"));
		Assert.assertEquals(second.getAttribute("innerHTML"), "Clothing");
		
		WebElement third = driver.findElement(By.xpath("//button [@data-index =  '3']/span [@class = 'f3gYf7g']/span"));
		Assert.assertEquals(third.getAttribute("innerHTML"), "Dresses");
		
		WebElement fourth = driver.findElement(By.xpath("//button [@data-index =  '4']/span [@class = 'f3gYf7g']/span"));
		Assert.assertEquals(fourth.getAttribute("innerHTML"), "Shoes");
		
		WebElement fivth = driver.findElement(By.xpath("//button [@data-index =  '5']/span [@class = 'f3gYf7g']/span"));
		Assert.assertEquals(fivth.getAttribute("innerHTML"), "Accessories");
	}
	
	@Test (priority = 9)
	public void trendingbrandsBanner(){
		driver.findElement(By.xpath("//ul [@class = '_1gfpvjl _2Q6RfP3']/li[2]/a [@id = 'men-floor']")).click();
		driver.findElement(By.xpath("//img [@class = 'logoLinks__logos' and @alt = 'tommy hilfiger']")).isDisplayed();
	}
}
