package com.Vizibl.objects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class ForgetPasswordObjects {

public ForgetPasswordObjects(WebDriver driver) {
	PageFactory.initElements(driver, this);
}


public WebElement getForgotPassword_button() {
	return forgotPassword_button;
}
@FindBy(xpath="//a[@class='btn default frgt_pwd_click']")
private WebElement forgotPassword_button;


public WebElement getEmail_Edit() {
	return email_Edit;
}
@FindBys({ @FindBy(xpath = "//div[@class='form-group']/abcd") })
private List<WebElement> errorMessages;

public  List<WebElement> getErrorMessages() {
	return errorMessages;
}

@FindBy(id="user_emails")
private WebElement email_Edit;

@FindBy(id="cancel_forgot_password")
private WebElement cancel_forgot_password;
@FindBy(xpath="//input[@class='btn blue pull-right m-icon-swapright m-icon-white']")
private WebElement submit;


public WebElement getCancel_forgot_password() {
	return cancel_forgot_password;
}


public WebElement getSubmit() {
	return submit;
}
}