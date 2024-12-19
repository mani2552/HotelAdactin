package org.pageobjects;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BookingConfirmationPage extends BaseClass{
	public BookingConfirmationPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(how=How.XPATH,using="//td[text()='Booking Confirmation ']")
	private WebElement verifybookingconfirmationpage;

	public WebElement getVerifybookingconfirmationpage() {
		return verifybookingconfirmationpage;
	}
	
	@FindBy(how=How.ID,using="booking_form")
	private WebElement bookingform;

	public WebElement getbookingform() {
		return bookingform;
	}
	@FindBy(how=How.ID,using="my_itinerary")
	private WebElement myitinerary;

	public WebElement getMyitinerary() {
		return myitinerary;
	}
	@FindBy(how=How.XPATH,using="//*[@id=\"total_price_1280415\"]")
	private WebElement totalprice;

	public WebElement getTotalprice() {
		return totalprice;
	}
	@FindBy(how=How.XPATH,using="//input[@name='ids[]']")
	private WebElement clickoncheckbox;

	public WebElement getClickoncheckbox() {
		return clickoncheckbox;
	}
	
	@FindBy(how=How.XPATH,using="//input[@name='cancelall']")
	private WebElement cancelselected;

	public WebElement getCancelselected() {
		return cancelselected;
	}
	@FindBy(how=How.XPATH,using="//a[normalize-space()='Logout']")
	private WebElement clickonlogout;

	public WebElement getclickonlogout() {
		return clickonlogout;
	}
	@FindBy(how=How.XPATH,using="//td[text()='You have successfully logged out. ']")
	private WebElement logoutmessage;

	public WebElement getlogoutmessage() {
		return logoutmessage;
	}
	@FindBy(how=How.XPATH,using="//a[text()='Click here to login again']")
	private WebElement loginagain;

	public WebElement getLoginagain() {
		return loginagain;
	}
	@FindBy(how=How.XPATH,using="//*[@id=\"order_no\"]")
	private WebElement orderno;

	public WebElement getOrderno() {
		return orderno;
	}
	
	
}
