package com.pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GiftCards {
	
	public WebDriver driver;
	
	public GiftCards(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//ul[@class='_2sedU']//li[3]")
	WebElement Occasion;
	
	public void ChoseOccasion() {
		Occasion.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@FindBy(xpath="//input[@id='ip_2251506436']")
	WebElement Amount;
	
	@FindBy(xpath="//button[@class='_1IFIb _1fVSi action-button _1gIUf _1XfDi']")
	WebElement nextButton;
	
	public void enterAmount(String amt) {
		Amount.sendKeys(amt);
		if(nextButton.isEnabled()) {
		nextButton.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		else {
			System.out.println("Enter amount between 1,000 and 5,00,000");
		}
	}
	
	public boolean Isenabled() {
		return nextButton.isEnabled();
	}
	
	
	@FindBy(name="recipient_name")
	WebElement RecipientName;
	
	@FindBy(name="recipient_email")
	WebElement RecipientEmail;
	
	@FindBy(name="recipient_mobile_number")
	WebElement RecipientMobileNo;
	
	@FindBy(name="customer_name")
	WebElement CustomerName;
	
	@FindBy(name="customer_email")
	WebElement CustomerEmail;
	
	@FindBy(name="customer_mobile_number")
	WebElement CustomerMobileNo;
	
	@FindBy(name="customer_address")
	WebElement CustomerAddress;
	
	@FindBy(name="zip")
	WebElement Pincode;
	
	@FindBy(xpath="//div[@class='_1HVuH']")
	WebElement NotAvailableMsg;
	
	public void setRecipientName(String rname) {
		RecipientName.sendKeys(rname);
	}
	
	public void setRecipientEmail(String rmail) {
		RecipientEmail.sendKeys(rmail);
	}
	
	public void setRecipientMobNo(String rmob) {
		RecipientMobileNo.sendKeys(rmob);
	}
	
	public void setCustomerName(String cname) {
		CustomerName.sendKeys(cname);
	}
	
	public void setCustomerEmail(String cmail) {
		CustomerEmail.sendKeys(cmail);
	}
	
	public void setCustomerMobNo(String cmob) {
		CustomerMobileNo.sendKeys(cmob);
	}
	
	public void setCustomerAddress(String caddr) {
		CustomerAddress.sendKeys(caddr);
	}
	
	public void setPincode(String pin) throws InterruptedException {
		Pincode.sendKeys(pin);
		Thread.sleep(5000);
	}
	
	@FindBy(xpath="//form[@class='_1hMYQ']//button[@class='_3Hxyv _1fVSi action-button _1gIUf _1XfDi']")
	WebElement submitButton;
	
	@FindBy(xpath="//div[@class='_2wEGI']")			//h2[@class='_FCNL']
	WebElement confirmMsg;
	
	public void submit() {
		if(submitButton.isEnabled()) {
		Actions action=new Actions(driver);
		action.moveToElement(submitButton).click().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		else {
			System.out.println(NotAvailableMsg.getText());
		}
	}
	
		
	public String confirmationMsg() {
		return confirmMsg.getText();
	}
	
	public void getMessage(int opt) {
		switch(opt) {
		case 1:
			
			System.out.println(RecipientEmail.getAttribute("validationMessage"));
			break;
		case 2:
			System.out.println(RecipientMobileNo.getAttribute("validationMessage"));
			break;
		case 3:
			System.out.println("Enter the valid pincode");
			break;
		case 4:
			System.out.println(confirmMsg.getText());
			break;
		}
	}

}
