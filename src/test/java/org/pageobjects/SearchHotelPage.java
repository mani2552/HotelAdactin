package org.pageobjects;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchHotelPage extends BaseClass {
	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(how=How.XPATH,using="//td[text()='Search Hotel ']")
	private WebElement verifysearchhotelpage;

	public WebElement getVerifysearchhotelpage() {
		return verifysearchhotelpage;
	}
	@FindBy(how=How.XPATH,using="//select[@id='location']")
	private WebElement selectlocation;

	public WebElement getSelectlocation() {
		return selectlocation;
	}
	@FindBy(how=How.XPATH,using="//select[@id='hotels']")
	private WebElement selecthotels;

	public WebElement getSelecthotels() {
		return selecthotels;
	}
	@FindBy(how=How.XPATH,using="//select[@id='room_type']")
	private WebElement roomtype;

	public WebElement getRoomtype() {
		return roomtype;
	}
	@FindBy(how=How.XPATH,using="//select[@id='room_nos']")
	private WebElement roomnos;

	public WebElement getRoomnos() {
		return roomnos;
	}
	@FindBy(how=How.XPATH,using="//input[@id='datepick_in']")
	private WebElement checkindate;

	public WebElement getCheckindate() {
		return checkindate;
	}
	@FindBy(how=How.XPATH,using="//input[@id='datepick_out']")
	private WebElement checkoutdate;

	public WebElement getCheckoutdate() {
		return checkoutdate;
	}
	@FindBy(how=How.XPATH,using="//select[@id='adult_room']")
	private WebElement adultperroom;

	public WebElement getAdultperroom() {
		return adultperroom;
	}
	@FindBy(how=How.XPATH,using="//*[@id='child_room']")
	private WebElement childrenperroom;

	public WebElement getchildrenperroom() {
		return childrenperroom;
	}
	@FindBy(how=How.XPATH,using="//input[@id='Submit']")
	private WebElement clicksubmit;

	public WebElement getClicksubmit() {
		return clicksubmit;
	}
	
}
