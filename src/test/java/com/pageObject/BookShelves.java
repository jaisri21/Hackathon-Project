package com.pageObject;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BookShelves {
	
	public WebDriver driver;
	
	public BookShelves(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[@class='close-reveal-modal hide-mobile']")
	WebElement close;
	
	@FindBy(xpath="//li[@data-group='category']")
	WebElement category;
	
	@FindBy(xpath="//input[@id='filters_primary_category_Bookshelves']")
	WebElement SelectingCategory;
	
	@FindBy(xpath="//li[@class='item' and @data-group='price']")
	WebElement priceCategory;
	
	@FindBy(id="price_limit_608-9222")
	WebElement priceRange;
	
	@FindBy(xpath="//div[@class='noUi-handle noUi-handle-upper']")
	WebElement upper_slider;
	
	@FindBy(xpath="//input[@id='filters_availability_In_Stock_Only']")
	WebElement ExcludeStock;
	
	@FindBy(xpath="//div[@data-group='sorting']")
	WebElement dropdown;
	
	@FindBy(xpath="//div[@class='grouplist sort']//li[@data-key='price_desc']")
	WebElement highToLow;
	
	@FindBy(xpath="//span[@class='name']")
	List<WebElement> name;
	
	@FindBy(xpath="//div[@class='price-number']//span")
	List<WebElement> price;
	
	public void closeAd() {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(close));
		close.click();
	}
	
	public void choseCategory() throws InterruptedException {
		category.click();
		SelectingCategory.click();
		Thread.sleep(5000);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	public void chosePriceRange() throws InterruptedException {
		Actions act=new Actions(driver);
		act.moveToElement(priceCategory).click().perform();
		Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", priceRange);
		Thread.sleep(5000);
		act.dragAndDropBy(upper_slider, 42, 0).perform();
	}
	
	public void ExcludingStock() throws InterruptedException {
		ExcludeStock.click();
		Thread.sleep(1000);
	}
	
	public void sortingProduct() throws InterruptedException {
		dropdown.click();
		Thread.sleep(3000);
		highToLow.click();
		Thread.sleep(3000);
	}
	
	public List<WebElement> getName(){
		return name;
	}
	
	public List<WebElement> getPrice(){
		return price;
	}

}
