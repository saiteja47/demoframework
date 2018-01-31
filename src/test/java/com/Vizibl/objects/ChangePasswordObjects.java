package com.Vizibl.objects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class ChangePasswordObjects {

	public ChangePasswordObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getChangePassword() {
		return changePassword;
	}

	public WebElement getCurrent_password() {
		return current_password;
	}

	public WebElement getNew_Password() {
		return new_Password;
	}

	public WebElement getConfirmation_Password() {
		return confirmation_Password;
	}

	public WebElement getSaveChanges() {
		return saveChanges;
	}

	public WebElement getCancle() {
		return cancle;
	}

	public WebElement getClose() {
		return close;
	}
	@FindBy(xpath = "//a[@class='fa fa-gear chg_pwd_click test']")
	private WebElement changePassword;
	
	
	@FindBy(id = "user_current_password")
	private WebElement current_password;

	@FindBy(id = "user_password")
	private WebElement new_Password;

	@FindBy(id = "user_password_confirmation")
	private WebElement confirmation_Password;

	@FindBy(xpath = "//input[@class='btn blue submit_pass']")
	private WebElement saveChanges;

	@FindBy(xpath = "//input[@class='btn default'] ")
	private WebElement cancle;

	@FindBy(xpath = "//button[@class='close'] ")
	private WebElement close;

	@FindBys({ @FindBy(xpath = "//div[@class='form-group']/abcd") })
	private List<WebElement> errorMessages;
	
	public  List<WebElement> getErrorMessages() {
		return errorMessages;
	}

}
