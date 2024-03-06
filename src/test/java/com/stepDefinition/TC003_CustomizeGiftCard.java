package com.stepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.Factory.BaseClass;
import com.pageObject.GiftCards;
import com.pageObject.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC003_CustomizeGiftCard {
	
	WebDriver driver;
	HomePage home;
	GiftCards gift;
	
	@Given("the homepage of the website")
	public void the_homepage_of_the_website() {
		BaseClass.getLogger().info("--------------The home page of the website--------------");
	    home=new HomePage(BaseClass.getDriver());
	    Assert.assertEquals("Buy Furniture Online and Get up to 50% Off | Shop Now - Urban Ladder",home.getTitle() );
	}

	@When("the user clicks the gift cards")
	public void the_user_clicks_the_gift_cards() throws InterruptedException {
		BaseClass.getLogger().info("--------------Clicking the gift card option--------------");
	   home.openGiftPage();
	}

	@When("choose an Occasion as Birthday\\/Anniversary")
	public void choose_an_occasion_as_birthday_anniversary() {
		BaseClass.getLogger().info("--------------Choosing Birthday/Anniversary as occasion--------------");
		gift=new GiftCards(BaseClass.getDriver());
	    gift.ChoseOccasion();
	}

	@When("customize the gift card by entering the amount as {string}")
	public void customize_the_gift_card_by_entering_the_amount_as(String string) {
		BaseClass.getLogger().info("--------------Entering the amount in the amount text--------------");
	   gift.enterAmount(string);
	}

	@Then("verify that the next button is enabled are not")
	public void verify_that_the_next_button_is_enabled_are_not() {
		BaseClass.getLogger().info("-------------Checking the button is enabled or not--------------");
	    System.out.println(gift.Isenabled());
	}


}
