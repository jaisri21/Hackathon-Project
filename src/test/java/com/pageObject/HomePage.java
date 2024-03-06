package com.pageObject;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class HomePage {

	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="search")
	WebElement SearchBox;
	
	@FindBy(id="search_button")
	WebElement SearchButton;
	
	public void search(String str) {
		SearchBox.sendKeys(str);
		SearchButton.click();
	}
	
	
	@FindBy(xpath="//h2//span[@class='key']")
	WebElement resultMsg;
	
	public String navigationResult() {
		return resultMsg.getText();
	}
	
	@FindBy(xpath="//li[@class='topnav_item livingunit']")
	WebElement living;
	
	@FindBy(xpath="//li[@class='topnav_item livingunit']//ul[@class='inline-list left']/li[1]")
	WebElement subOptions1;
	
	@FindBy(xpath="//li[@class='topnav_item livingunit']//ul[@class='inline-list left']/li[2]")
	WebElement subOptions2;
	
	@FindBy(xpath="//li[@class='topnav_item livingunit']//ul[@class='inline-list left']/li[3]")
	WebElement subOptions3;
	
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public String getAllOptions1() throws InterruptedException {
		living.click();
		Thread.sleep(2000);
		return subOptions1.getText();
	}
	
	public String getAllOptions2() {
		return subOptions2.getText();
	}
	
	public String getAllOptions3() {
		return subOptions3.getText();
	}
	
	@FindBy(xpath="//ul[@class='featuredLinksBar__linkContainer']//li[3]")
	WebElement giftPageLink;
	
	public void openGiftPage() throws InterruptedException {
		Actions action=new Actions(driver);
		action.moveToElement(giftPageLink).click().perform();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.titleContains("Gift Card - Buy Gift Cards & Vouchers Online for Wedding, Birthday | Urban Ladder"));
	}
}
