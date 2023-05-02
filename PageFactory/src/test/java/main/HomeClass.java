package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomeClass {
	private WebDriver driver;
	//Find search bar on page
	@FindBy (xpath = "//input[@type='search' and @class ='Cyuazsm _1LCOtZ3 SJwm9Lx' and @placeholder = 'Search for items and brands']")
	private WebElement searchBar;
		
	//Submit search button
	@FindBy (xpath = "//button[@class='kH5PAAC _1KRfEms' and @type ='submit']")
	private WebElement submitButton;
		
	//First product chosen
	@FindBy (xpath = "//article [@id = 'product-202162385']/button [@type = 'button' and @class = 'mm1gcXw']")
	private WebElement firstJacketButton;
		
	//Second product chosen
	@FindBy (xpath = "//article [@id = 'product-203490725']/button [@type = 'button' and @class = 'mm1gcXw']")
	private WebElement secondJacketButton;
		
	//Save products for later
	@FindBy (xpath = "//li [@class = '_3Wo6fpk']/a [@class = '_6iPIuvw _2SSHFPv']/span [@class = '_26lJ0fq -rhP1cz gBrrjX4 _2nHArcS']")
	private WebElement savedItemsButton;
		
	//Saved products --> cart
	@FindBy (xpath = "//li [@class = '_3Wo6fpk']/a [@data-testid = 'miniBagIcon']/span [@type = 'bagUnfilled']")
	private WebElement cartButton;
		
	public HomeClass (WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		
	public void searchBarClick(){
		searchBar.click();
	}
		
	public void submitSearch(){
		submitButton.click();
	}
		
	public void firstJacketSave(){
		firstJacketButton.click();
	}
		
	public void secondJacketSave() {
		secondJacketButton.click();
	}
		
	public void savedProductsClick(){
		savedItemsButton.click();
	}
}
