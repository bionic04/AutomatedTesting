package test;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(test.TestListeners.class)

public class SiteTest{
	Logger tstlog = (Logger) LogManager.getLogger(SiteTest.class);
	
	WebDriver driver;
	@BeforeSuite
	public void Setup() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D:\\Programs\\chrome_driver2\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.lamoda.by/men-home");
		tstlog.info("Connected succeed.");
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
		tstlog.info("Button Женщинам pressed");
		driver.navigate().back();
		Thread.sleep(3000);
	}
	
	@Test(priority = 3)
	public void ButTest() throws InterruptedException{
		driver.findElement(By.linkText("Бесконтактная доставка!")).click();
		tstlog.info("linktext бексонтактная доставка pressed");
		Thread.sleep(3000);
	}
	
	@Test(priority = 4)
	public void SearchTest() throws InterruptedException{
		driver.findElement(By.xpath("//*[@class=\"_root_lw8ys_2\"]//*[@type=\"text\"]")).sendKeys("Nike кроссовки");
		driver.findElement(By.xpath("//*[@class=\"_root_1su1z_2\"]//*[@type=\"button\"]")).click();
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0,350)");

		Boolean Display = driver.findElement(By.xpath("//*[@class=\"x-product-card__link x-product-card__hit-area\"]//a[@href=\"/p/rtlabx754401/shoes-nike-krossovki/\"]")).isDisplayed();
		System.out.println("Element displayed is :"+Display);
		tstlog.info("find sneakers");
	}
	
	@Test(priority = 5)
	public void SneakerTest() throws InterruptedException{
	//also tests button
		driver.findElement(By.xpath("//*[@class=\"x-product-card__link x-product-card__hit-area\"]//a[@href=\"/p/rtlabx754401/shoes-nike-krossovki/\"]")).click();
		Thread.sleep(2000);
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0,350)");
		Select NikeC = new Select(driver.findElement(By.xpath("//*[@class=\"_select_1pcah_10\"]//div[text()=\"Выберите размер\"]")));
		NikeC.selectByVisibleText("35,5 RUS 6 US");
		driver.findElement(By.xpath("//*[@class=\"_root_lky3q_42 _addToCart_1l1jf_80 _addToCartSticky_1l1jf_85\"]//span[text()=\"Добавить в корзину\"]")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority = 6)
	public void SocialLinkTest() throws InterruptedException{
	//back to mainpage
		driver.findElement(By.xpath("//*[@class=\"_root_ruiv4_2\"]//a[@aria-label=\"Главная\"]")).click();
		Thread.sleep(3000);
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(3000);
		WebElement vk = driver.findElement(By.xpath("//*[@class=\"x-footer\"]//a[@aria-label=\"vk\"]"));
		//hyperlink to social
		vk.click();
	}
}
