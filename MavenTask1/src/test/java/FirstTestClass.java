import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class FirstTestClass {
	
	WebDriver driver;
	@BeforeSuite
	public void Setup() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D:\\Programs\\chrome_driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.lamoda.by/men-home");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test(priority = 1)
	public void TitleTest() throws InterruptedException{
		String expectedtitle = "Купить мужскую одежду и обувь в интернет магазине Lamoda.by";
		String actualtitle = driver.getTitle();
		Assert.assertEquals(actualtitle,expectedtitle);
		try{
				driver.findElement(By.className("_root_clp6c_2 _label_clp6c_17 _root_8m6xk_2 _mainLogo_8m6xk_15 _logo_ruiv4_38 _root_8m6xk_2 _mainLogo_8m6xk_15 _logo_ruiv4_38")).isDisplayed();
		}
		catch(WebDriverException e){
				System.out.println("There is no such element on this page");
		}
	}
	
	@Test(priority = 2)
	public void LinkTest() throws InterruptedException{
		WebElement clothes = driver.findElement(By.linkText("Женщинам"));
		clothes.click();
		driver.navigate().back();
		Thread.sleep(3000);
	}
	
	@Test(priority = 3)
	public void ButTest() throws InterruptedException{
		driver.findElement(By.linkText("Бесконтактная доставка!")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority = 4)
	public void SearchTest() throws InterruptedException{
		driver.findElement(By.xpath("/html/body/div[1]/div/header/div[3]/div/div/div/div/input")).sendKeys("Nike кроссовки");
		driver.findElement(By.xpath("//*[@id=\"vue-root\"]/div/header/div[3]/div/div/div/div/button")).click();

		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0,350)");

		Boolean Display = driver.findElement(By.xpath("//*[@id=\"RTLABR085001\"]/div[1]/a")).isDisplayed();
		System.out.println("Element displayed is :"+Display);
	}
	
	@Test(priority = 5)
	public void SneakerTest() throws InterruptedException{
	//also tests button
		driver.findElement(By.xpath("//*[@id=\"RTLABR085001\"]/div[1]/a")).click();
		Thread.sleep(2000);
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0,350)");
		Select NikeC = new Select(driver.findElement(By.xpath("//*[@id=\"vue-root\"]/div/main/div/div[3]/div[2]/div/div[2]/div[1]/div/div[1]")));
		NikeC.selectByVisibleText("34,5 RUS 5 US");
		driver.findElement(By.xpath("//*[@id=\"vue-root\"]/div/main/div/div[3]/div[2]/div/div[3]/div/div[1]/button")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority = 6)
	public void SocialLinkTest() throws InterruptedException {
	//back to mainpage
		driver.findElement(By.xpath("//*[@id=\"vue-root\"]/div/header/div[2]/a")).click();
		Thread.sleep(3000);
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(3000);
		WebElement vk = driver.findElement(By.xpath("//*[@id=\"vue-root\"]/div/div[1]/footer/div[1]/div[1]/details[1]/div/div/div/a[1]"));
		//hyperlink to social
		vk.click();
	}
}