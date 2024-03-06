package com.stepDefinition;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.Factory.BaseClass;
import com.Utility.DataReader;
import com.pageObject.GiftCards;
import com.pageObject.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC004_FillingTheForm {

	WebDriver driver;
	HomePage hp;
	GiftCards gift;
	List<HashMap<String, String>> datamap;
	public static int opt=1;
	
	@Given("the homepage of the website having giftcard option")
	public void the_homepage_of_the_website_having_giftcard_option() {
		BaseClass.getLogger().info("--------------Home page--------------");
	    hp=new HomePage(BaseClass.getDriver());
	}

	@When("the user clicks the gift card option in the homepage")
	public void the_user_clicks_the_gift_card_option_in_the_homepage() throws InterruptedException {
		BaseClass.getLogger().info("--------------Clicking the gift card option--------------");
		hp.openGiftPage();
	}

	@Then("the user should be navigated to the giftcard page")
	public void the_user_should_be_navigated_to_the_giftcard_page() {
		BaseClass.getLogger().info("--------------Navigated to the gift card page--------------");
	    gift=new GiftCards(BaseClass.getDriver());
	}

	@When("the user clicks the Anniversary\\/Birthday in the occasion")
	public void the_user_clicks_the_anniversary_birthday_in_the_occasion() {
		BaseClass.getLogger().info("--------------Choosing Birthday/Anniversary as Occasion--------------");
	    gift.ChoseOccasion();
	}

	@When("enters the amount in the text and click the next button")
	public void enters_the_amount_in_the_text_and_click_the_next_button() {
		BaseClass.getLogger().info("--------------Entering the amount as 1000--------------");
		gift.enterAmount("1000");
	}

	
	@Given("the form section in the giftcard page")
	public void the_form_section_in_the_giftcard_page() {
		BaseClass.getLogger().info("--------------The heading of the form--------------");
	    System.out.println("3. Nice! So who is this lucky person?");
	}

	@Then("the user should fill the form with the data excel row {string}")
	public void the_user_should_fill_the_form_with_the_data_excel_row(String rows) throws InterruptedException {
		BaseClass.getLogger().info("--------------Filling the form from the test data available in the excel sheet--------------");
		datamap=DataReader.data("C:\\Users\\2303708\\eclipse-workspace\\HackathonProject\\testData\\TestData.xlsx", "Sheet1");
		int index=Integer.parseInt(rows)-1;
		gift.setRecipientName(datamap.get(index).get("RecipientName"));
		gift.setRecipientEmail(datamap.get(index).get("RecipientEmail"));
		gift.setRecipientMobNo(datamap.get(index).get("RecipientMobileNo"));
		gift.setCustomerName(datamap.get(index).get("CustomerName"));
		gift.setCustomerEmail(datamap.get(index).get("CustomerEmail"));
		gift.setCustomerMobNo(datamap.get(index).get("CustomerMobileNo"));
		gift.setCustomerAddress(datamap.get(index).get("CustomerAddress"));
		gift.setPincode(datamap.get(index).get("Pincode"));
		gift.submit();
	}
	
	@Then("the user should get the error or confirmation message")
	public void the_user_should_get_the_error_or_confirmation_message() {
		BaseClass.getLogger().info("--------------The Message after submitting the form--------------");
	    gift.getMessage(opt);
	    opt++;
	}

	@Then("the user should get the confirmation message")
	public void the_user_should_get_the_confirmation_message() {
		BaseClass.getLogger().info("--------------Confirmation message--------------");
	    System.out.println(gift.confirmationMsg());
	}

}
