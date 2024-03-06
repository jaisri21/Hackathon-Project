package com.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.pageObject.BookShelves;
import com.pageObject.HomePage;

public class TS001_GettingTopThree_BookShelves extends BasePage{
	
	//WebDriver driver;
	HomePage hp;
	BookShelves book;
	String nameArr[]=new String[3];
	String priceArr[]=new String[3];
	
	@Test(priority=1)
	public void getTitle() {
		HomePage hp=new HomePage(driver);
		String actual=hp.getTitle();
		String expected="Buy Furniture Online and Get up to 50% Off | Shop Now - Urban Ladder";
		Assert.assertEquals(actual,expected);
	}
	
	@Test(priority=2)
	public void Clickable() {
		BasePage.getLogger().info("************Starts searching with empty string************");
		hp=new HomePage(driver);
		hp.search("");
		try {
		hp.navigationResult();
		}catch(Exception e) {
			BasePage.getLogger().info("************No result found for empty string************");
			System.out.println("Search box cannot be null");
		}
	}
	
	@Test(priority=3)
	public void getBookshelves() throws InterruptedException {
		hp=new HomePage(driver);
		book=new BookShelves(driver);
		BasePage.getLogger().info("************Starts searching************");
		hp.search("Bookshelves");
		hp.navigationResult();
		book.closeAd();
		BasePage.getLogger().info("************Choosing category as Bookshelves************");
		book.choseCategory();
		BasePage.getLogger().info("************Choosing price range below 15000************");
		book.chosePriceRange();
		BasePage.getLogger().info("************Excluding out of stock************");
		book.ExcludingStock();
		BasePage.getLogger().info("************sorting as high to low************");
		book.sortingProduct();
		for(int i=0;i<3;i++) {
			nameArr[i]=book.getName().get(i).getText();
			priceArr[i]=book.getPrice().get(i).getText();
		}
		BasePage.getLogger().info("************TOP 3 Bookshelves************");
		for(int i=0;i<nameArr.length;i++) {
			System.out.print(nameArr[i]+"-");
			System.out.println(priceArr[i]); 
		}
	}
	
}
