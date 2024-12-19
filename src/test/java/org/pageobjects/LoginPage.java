package org.pageobjects;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass{
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(how=How.XPATH,using="//input[@id='username']")
	private WebElement userName;

	public WebElement getUserName() {
		return userName;
	}
	@FindBy(how=How.XPATH,using="//input[@id='password']")
	private WebElement password;

	public WebElement getPassword() {
		return password;
	}

	@FindBy(how=How.XPATH,using = "//input[@id='login']")
	private WebElement login;

	public WebElement getLogin() {
		return login;
	}
	@FindBy(how=How.XPATH,using = "//td[@class='login_title']")
	private WebElement verifyloginpage;

	public WebElement getVerifyloginpage() {
		return verifyloginpage;
	}
	@FindBy(how=How.XPATH,using = "//td[text()='Existing User Login - Build 1']")
	private WebElement textloginpage;

	public WebElement getTextloginpage() {
		return textloginpage;
	}
	
	
}
