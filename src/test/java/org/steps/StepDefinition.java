package org.steps;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pageobjects.BookAHotelPage;
import org.pageobjects.BookingConfirmationPage;
import org.pageobjects.LoginPage;
import org.pageobjects.SearchHotelPage;
import org.pageobjects.SelectHotelPage;
import org.testng.Assert;

import io.cucumber.java.en.*;

public class StepDefinition extends BaseClass {
	public static BaseClass base = new BaseClass();
	public static WebDriver driver;
	public static LoginPage login;
	public static SearchHotelPage searchhotel;
	public static SelectHotelPage selecthotel;
	public static BookAHotelPage boookahotel;
	public static BookingConfirmationPage bookconfirmationpage;
	
	@Given("I have launched the browser")
	public void i_have_launched_the_browser() {
		try {   
			base.getDriver("Chrome");
			base.winMax();
			
		   System.out.println("Browser Launched Successfully");
		}catch(Exception e) {
			System.out.println("Browser Not Launched Successfully");
		    }
	    
	}

	@Given("I have navigated to the Adactin Hotel App login page")
	public void i_have_navigated_to_the_adactin_hotel_app_login_page() {
		base.getUrl("https://adactinhotelapp.com/index.php");

	}

	@When("I take a screenshot of the login page")
	public void i_take_a_screenshot_of_the_login_page() throws IOException {
      base.screenCapture("login_page");    
	}

	@When("I validate that the login page is launched successfully")
	public void i_validate_that_the_login_page_is_launched_successfully() {
		try {   
			login = new LoginPage();
			WebElement loginpageheader = login.getVerifyloginpage();

			if (loginpageheader.isDisplayed()) {
				System.out.println("Login page Displayed Successfully");
			}
			System.out.println("Login page Validation Successfully Happen");
		}catch(Exception e) {
			System.out.println("Login page is not Displayed");
		    }
	}

	@When("I get the page text to the console on loginpage")
	public void i_get_the_page_text_to_the_console_on_loginpage() {
		WebElement loginpageheader = login.getTextloginpage();
		String pageText = loginpageheader.getText();
		System.out.println("Text of element:" + pageText);
	}

	@When("I enter the valid username and password")
	public void i_enter_the_valid_username_and_password() {
		WebElement userName = login.getUserName();
		base.textSendByJava(userName, "mani7787");
		WebElement password = login.getPassword();
		base.textSendByJava(password, "Manis@2024");

	    
	}

	@When("I click on the login button")
	public void i_click_on_the_login_button() {
		WebElement loginbutton = login.getLogin();
		loginbutton.click();
	    System.out.println("Valid user Name and password entered Successfully");

	}

	@Then("I should be logged into the website successfully")
	public void i_should_be_logged_into_the_website_successfully() {
		try {   
		searchhotel = new SearchHotelPage();
		WebElement loginpageheader = searchhotel.getVerifysearchhotelpage();

		if (loginpageheader.isDisplayed()) {
			System.out.println("Login page Displayed Successfully");
		}
		System.out.println("Login page Validation Successfully Happen");
	}catch(Exception e) {
		System.out.println("Login page is not Displayed");
	    } 
	}

	@Then("I get the page text to the console on searchhotelpage")
	public void i_get_the_page_text_to_the_console_on_searchhotelpage() {
		WebElement loginpageheader = searchhotel.getVerifysearchhotelpage();
		String pageText = loginpageheader.getText();
		System.out.println("Text of element:" + pageText);
	    
	}

	@When("I take a screenshot of the searchhotelpage")
	public void i_take_a_screenshot_of_the_searchhotelpage() throws IOException {
	      base.screenCapture("Search_Hotel_page");    

	}

	@When("I select the location")
	public void i_select_the_location() throws InterruptedException {
		Thread.sleep(2000);
        WebElement selctlocation = searchhotel.getSelectlocation();
        selectByValue(selctlocation, "Melbourne");
	    
	}

	@When("I select the hotel")
	public void i_select_the_hotel() throws InterruptedException {
		Thread.sleep(2000);
        WebElement selecthotel = searchhotel.getSelecthotels();
        selectByValue(selecthotel, "Hotel Sunshine");
	    
	}

	@When("I select the room type")
	public void i_select_the_room_type() throws InterruptedException {
		Thread.sleep(2000);
        WebElement selectroomtype = searchhotel.getRoomtype();
        selectByValue(selectroomtype, "Standard");
	    
	}

	@When("I select the number of rooms")
	public void i_select_the_number_of_rooms() throws InterruptedException {
		Thread.sleep(2000);
        WebElement selectnorooms = searchhotel.getRoomnos();
        selectByValue(selectnorooms, "2");
	    
	}
	
	@When("I enter the check-in date")
	public void i_enter_the_check_in_date() throws InterruptedException {
		Thread.sleep(2000);
        WebElement checkindate = searchhotel.getCheckindate();
		base.textSendByJava(checkindate, "09/11/2024");
	    
	}

	@When("I enter the check-out date")
	public void i_enter_the_check_out_date() throws InterruptedException {
		Thread.sleep(2000);
        WebElement checkindate = searchhotel.getCheckoutdate();
		base.textSendByJava(checkindate, "10/11/2024");
	    
	}

	@When("I select the number of adults per room")
	public void i_select_the_number_of_adults_per_room() throws InterruptedException {
		Thread.sleep(2000);
        WebElement adultsperroom = searchhotel.getAdultperroom();
        selectByVisibleText(adultsperroom, "2 - Two");
	    
	}

	@When("I select the number of children per room")
	public void i_select_the_number_of_children_per_room() throws InterruptedException {
		Thread.sleep(2000);
        WebElement childrenperroom = searchhotel.getchildrenperroom();
        selectByVisibleText(childrenperroom, "1 - One");
	}

	@When("I click on the search button")
	public void i_click_on_the_search_button() throws InterruptedException {
		Thread.sleep(2000);
        WebElement searchbutton = searchhotel.getClicksubmit();
        searchbutton.click();
	}

	@Then("I should be on the select hotel page")
	public void i_should_be_on_the_select_hotel_page() {
		try {   
			selecthotel = new SelectHotelPage();
			WebElement selecthotelheader = selecthotel.getverifySelecthotelpage();

			if (selecthotelheader.isDisplayed()) {
				System.out.println("selecthotel page Displayed Successfully");
			}
			System.out.println("selecthotel Validation Successfully Happen");
		}catch(Exception e) {
			System.out.println("selecthotel is not Displayed");
		}
	}
	@Then("I get the page text to the console on select hotel page")
	public void i_get_the_page_text_to_the_console_on_select_hotel_page() {
		WebElement selecthotelpage = selecthotel.getverifySelecthotelpage();
		String pageText = selecthotelpage.getText();
		System.out.println("Text of element:" + pageText);
	}

	@When("I take a screenshot of the current page on select hotel page")
	public void i_take_a_screenshot_of_the_current_page_on_select_hotel_page() throws IOException {
	      base.screenCapture("Select_Hotel_page");    
	}

	@When("I select the hotel by clicking on the radio button")
	public void i_select_the_hotel_by_clicking_on_the_radio_button() {
        WebElement selectcheckboxbutton = selecthotel.getSelectcheckbox();
        selectcheckboxbutton.click();
	    
	}

	@When("I click on the continue button")
	public void i_click_on_the_continue_button() {
		 WebElement clickoncontinue = selecthotel.getClickcontinue();
		 clickoncontinue.click();
	}

	@Then("I should be on the book a hotel page")
	public void i_should_be_on_the_book_a_hotel_page() {
		try {   
			boookahotel = new BookAHotelPage();
			WebElement bookahotel = boookahotel.getVerifybookahotelpage();

			if (bookahotel.isDisplayed()) {
				System.out.println("bookahotel page Displayed Successfully");
			}
			System.out.println("bookahotel page Validation Successfully Happen");
		}catch(Exception e) {
			System.out.println("bookahotel page is not Displayed");
		}
	}

	@Then("I get the page text to the console on book a hotel page")
	public void i_get_the_page_text_to_the_console_on_book_a_hotel_page() {
		WebElement bookhotelpage = boookahotel.getVerifybookahotelpage();
		String pageText = bookhotelpage.getText();
		System.out.println("Text of element:" + pageText);
	    
	}

	@When("I take a screenshot of the current page on book a hotel page")
	public void i_take_a_screenshot_of_the_current_page_on_book_a_hotel_page() throws IOException {
		base.screenCapture("book_a_Hotel_page");
	}

	@When("I enter the first name")
	public void i_enter_the_first_name() {
		WebElement scrolltofirstname = boookahotel.getEnterfirstname();
		scrollToElement(scrolltofirstname);
		WebElement firstname = boookahotel.getEnterfirstname();
		base.textSendByJava(firstname, "Manikandan");
	}

	@When("I enter the last name")
	public void i_enter_the_last_name() {
		WebElement lastname = boookahotel.getEnterlastname();
		base.textSendByJava(lastname, "Murugesan");
	    
	}

	@When("I enter the billing address")
	public void i_enter_the_billing_address() {
		WebElement address = boookahotel.getEnterbillingaddress();
		base.textSendByJava(address, "Thanjavur");
	    
	}

	@When("I enter the credit card number")
	public void i_enter_the_credit_card_number() {
		WebElement creditcardno = boookahotel.getEntercreditcardno();
		base.textSendByJava(creditcardno, "5486964732157182");
	}

	@When("I enter the CVV")
	public void i_enter_the_cvv() {
		WebElement cvvno = boookahotel.getEntercvvno();
		base.textSendByJava(cvvno, "818");
	    
	}

	@When("I select the credit card type")
	public void i_select_the_credit_card_type() throws InterruptedException {
		Thread.sleep(2000);
        WebElement creditcardtype = boookahotel.getselectccctype();
        selectByValue(creditcardtype, "VISA");
	}

	@When("I select the expiry date")
	public void i_select_the_expiry_date() throws InterruptedException {
		Thread.sleep(2000);
        WebElement creditcardexpmonth = boookahotel.getSelectmonth();
        selectByValue(creditcardexpmonth, "6");
		Thread.sleep(2000);
        WebElement creditcardexpyear = boookahotel.getSelectyear();
        selectByValue(creditcardexpyear, "2028");
	}
	@When("I click on the book now button")
	public void i_click_on_the_book_now_button() {
        WebElement booknowbutton = boookahotel.getBooknowbutton();
        booknowbutton.click();
	}

	@Then("I should be on the booking confirmation page")
	public void i_should_be_on_the_booking_confirmation_page() {
		try {   
			Thread.sleep(5000);
			bookconfirmationpage = new BookingConfirmationPage();
			WebElement bookconfiramtionpage = bookconfirmationpage.getVerifybookingconfirmationpage();

			if (bookconfiramtionpage.isDisplayed()) {
				System.out.println("bookconfiramtion page  Displayed Successfully");
			}
			System.out.println("bookconfiramtion page Validation Successfully Happen");
		}catch(Exception e) {
			System.out.println("bookconfiramtion page is not Displayed");
		}
	}

	@Then("I get the page text to the console on booking confirmation page")
	public void i_get_the_page_text_to_the_console_on_booking_confirmation_page() {
		WebElement bookingconfirmationpage = bookconfirmationpage.getVerifybookingconfirmationpage();
		String pageText = bookingconfirmationpage.getText();
		System.out.println("Text of element:" + pageText);
	    
	}

	@When("I take a screenshot of the current page on booking confirmation page")
	public void i_take_a_screenshot_of_the_current_page_on_booking_confirmation_page() throws IOException {
		base.screenCapture("booking_Confirmation_Hotel_page");   
	}

	@And("I verify that all the given booking details are correct")
	public void i_verify_that_all_the_given_booking_details_are_correct() throws InterruptedException {
		try { 
		WebElement scrolltoorderno  = bookconfirmationpage.getOrderno();
		scrollToElement(scrolltoorderno);
		WebElement verifyorderno  = bookconfirmationpage.getOrderno();
		if (verifyorderno.isDisplayed()) {
			System.out.println("Booking details Displayed Successfully");
		}
		System.out.println("Booking details Validation Successfully Happen");
	}catch(Exception e) {
		System.out.println("Booking Details is not Displayed");
	}
	}
     
	@When("I click on my itinerary")
	public void i_click_on_my_itinerary() throws InterruptedException {
		WebElement scrolltomyitinerary = bookconfirmationpage.getMyitinerary();
		scrollToElement(scrolltomyitinerary);
		WebElement myitinerary = bookconfirmationpage.getMyitinerary();
		myitinerary.click();
	}

	@Then("I select my booking and click on the cancel button")
	public void i_select_my_booking_and_click_on_the_cancel_button() {
		WebElement clickoncheckbox = bookconfirmationpage.getClickoncheckbox();
		clickoncheckbox.click();
		WebElement clickoncancelselected = bookconfirmationpage.getCancelselected();
		clickoncancelselected.click();
		
	}

	@Then("I handle the confirmation alert by clicking OK to cancel the booking")
	public void i_handle_the_confirmation_alert_by_clicking_ok_to_cancel_the_booking() {
		base.handleConfirmationAlert("accept");
	}

	@When("I take a screenshot of the cancellation confirmation")
	public void i_take_a_screenshot_of_the_cancellation_confirmation() throws IOException {
		base.screenCapture("Cancellation_Confirmation_page");
	}

	@When("I click on the logout button")
	public void i_click_on_the_logout_button() {
		WebElement clickonlogoutbutton = bookconfirmationpage.getclickonlogout();
		clickonlogoutbutton.click();
	}
	@Then("I should be logged out of the application")
	public void i_should_be_logged_out_of_the_application() {
		try {   
			bookconfirmationpage = new BookingConfirmationPage();
			WebElement loggedoutmessage = bookconfirmationpage.getlogoutmessage();

			if (loggedoutmessage.isDisplayed()) {
				System.out.println("I logged out and logged out message Displayed Successfully");
			}
			System.out.println("I logged out and logged out message Validation Successfully Happen");
		}catch(Exception e) {
			System.out.println("I am not logged out and logged out message is not Displayed");
		    }
	}
	@Then("I click on the login button again")
	public void i_click_on_the_login_button_again() {
		WebElement loginagain = bookconfirmationpage.getLoginagain();
		loginagain.click();
	    
	}

	@When("I take a screenshot of the current page")
	public void i_take_a_screenshot_of_the_current_page() throws IOException {
		base.screenCapture("Clicked_Login_again_loginpage_displayed");
	}
	@And("I enter Again the valid username and password")
	public void i_enter_again_the_valid_username_and_password() {
		WebElement userName = login.getUserName();
		base.textSendByJava(userName, "mani7787");
		WebElement password = login.getPassword();
		base.textSendByJava(password, "Manis@2024");
	}
	@And("I enter credentials Again the valid username and password")
	public void i_enter_credentials_again_the_valid_username_and_password() {
		WebElement userName = login.getUserName();
		base.textSendByJava(userName, "mani7787");
		WebElement password = login.getPassword();
		base.textSendByJava(password, "Manis@2024");
	}

	
	
}
