package com.TestCases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pageObject.GiftCards;
import com.pageObject.HomePage;

public class TS003_FormFilling extends BasePage{
	
	HomePage hp;
	GiftCards gift;
	public static int opt=1;
	
	@Test(priority=1)
	public void getPageTitle() throws InterruptedException {
		HomePage hp=new HomePage(driver);
		hp.openGiftPage();
		//gift=new GiftCards(driver);
		String actual=driver.getTitle();
		Assert.assertEquals("Gift Card - Buy Gift Cards & Vouchers Online for Wedding, Birthday | Urban Ladder", actual);
	}

	@Test(priority=2)
	@Parameters("Amount1")
	public void amount1(String Amount1) throws InterruptedException {
	gift=new GiftCards(driver);
	BasePage.getLogger().info("************Choosing occasion as Anniversary/Birthday************");
	gift.ChoseOccasion();
	BasePage.getLogger().info("************Entering amount as 1000***********");
	gift.enterAmount(Amount1);
	
}
	@Test(priority=3)
	@Parameters("Amount2")
	public void amount2(String Amount2) throws InterruptedException {
		driver.navigate().refresh();
		GiftCards gift=new GiftCards(driver);
		BasePage.getLogger().info("************Choosing occasion as Anniversary/Birthday************");
		gift.ChoseOccasion();
		BasePage.getLogger().info("************Entering amount as 1000***********");
		gift.enterAmount(Amount2);
		
	}
	
	@Test(priority=4)
	@Parameters("Amount3")
	public void amount3(String Amount3) throws InterruptedException {
		driver.navigate().refresh();
		GiftCards gift=new GiftCards(driver);
		BasePage.getLogger().info("************Choosing occasion as Anniversary/Birthday************");
		gift.ChoseOccasion();
		BasePage.getLogger().info("************Entering amount as 1000***********");
		gift.enterAmount(Amount3);
		
	}
	
	@Test(priority=5,dataProvider="testData")
	public void giftcardForm(String rname,String rmail,String rmob,String cname,String cmail,String cmob,String cadd,String pin) throws InterruptedException {
		driver.navigate().refresh();
		GiftCards gift=new GiftCards(driver);
		BasePage.getLogger().info("************Choosing occasion as Anniversary/Birthday************");
		gift.ChoseOccasion();
		BasePage.getLogger().info("************Entering amount as 1000***********");
		gift.enterAmount("1000");
		BasePage.getLogger().info("************Filling the details in the form***********");
		gift.setRecipientName(rname);
		gift.setRecipientEmail(rmail);
		gift.setRecipientMobNo(rmob);
		gift.setCustomerName(cname);
		gift.setCustomerEmail(cmail);
		gift.setCustomerMobNo(cmob);
		gift.setCustomerAddress(cadd);
		gift.setPincode(pin);
		BasePage.getLogger().info("************Submitting the form************");
		gift.submit();
		BasePage.getLogger().info("************Printing the Confirmation Message************");
		gift.getMessage(opt);
		opt++;
	}
}
