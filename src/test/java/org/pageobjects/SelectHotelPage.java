package org.pageobjects;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SelectHotelPage extends BaseClass{
	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(how=How.XPATH,using="//td[text()='Select Hotel ']")
	private WebElement verifyselecthotelpage;

	public WebElement getverifySelecthotelpage() {
		return verifyselecthotelpage;
	}
	@FindBy(how=How.XPATH,using="//input[@id='radiobutton_0']")
	private WebElement selectcheckbox;

	public WebElement getSelectcheckbox() {
		return selectcheckbox;
	}
	@FindBy(how=How.XPATH,using="//input[@id='continue']")
	private WebElement clickcontinue;

	public WebElement getClickcontinue() {
		return clickcontinue;
	}
	
}
