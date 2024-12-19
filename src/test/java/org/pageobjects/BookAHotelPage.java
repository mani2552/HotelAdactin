package org.pageobjects;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BookAHotelPage extends BaseClass {
	public BookAHotelPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(how=How.XPATH,using="//td[normalize-space()='Book A Hotel']")
	private WebElement verifybookahotelpage;

	public WebElement getVerifybookahotelpage() {
		return verifybookahotelpage;
	}
	@FindBy(how=How.XPATH,using="//input[@id='first_name']")
	private WebElement enterfirstname;

	public WebElement getEnterfirstname() {
		return enterfirstname;
	}
	@FindBy(how=How.XPATH,using="//input[@id='last_name']")
	private WebElement enterlastname;

	public WebElement getEnterlastname() {
		return enterlastname;
	}
	@FindBy(how=How.XPATH,using="//textarea[@id='address']")
	private WebElement enterbillingaddress;

	public WebElement getEnterbillingaddress() {
		return enterbillingaddress;
	}
	@FindBy(how=How.XPATH,using="//input[@id='cc_num']")
	private WebElement entercreditcardno;

	public WebElement getEntercreditcardno() {
		return entercreditcardno;
	}
	@FindBy(how=How.XPATH,using="//input[@id='cc_cvv']")
	private WebElement entercvvno;

	public WebElement getEntercvvno() {
		return entercvvno;
	}
	@FindBy(how=How.XPATH,using="//select[@id='cc_type']")
	private WebElement cctype;

	public WebElement getselectccctype() {
		return cctype;
	}
	@FindBy(how=How.XPATH,using="//select[@id='cc_exp_month']")
	private WebElement selectmonth;

	public WebElement getSelectmonth() {
		return selectmonth;
	}
	@FindBy(how=How.XPATH,using="//select[@id='cc_exp_year']")
	private WebElement selectyear;

	public WebElement getSelectyear() {
		return selectyear;
	}
	@FindBy(how=How.XPATH,using="//input[@id='book_now']")
	private WebElement booknowbutton;

	public WebElement getBooknowbutton() {
		return booknowbutton;
	}
	
	
}
