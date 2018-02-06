package com.Vizibl.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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


@FindBy(id="user_emails")
private WebElement email_Edit;

@FindBy(id="cancel_forgot_password")
private WebElement cancel_forgotpassword;

@FindBy(xpath="//input[@class='btn blue pull-right m-icon-swapright m-icon-white']")
private WebElement submit;


public WebElement getCancel_forgot_password() {
	return cancel_forgotpassword;
}


public WebElement getSubmit() {
	return submit;
}


@FindBy(id="message_registration")
private WebElement successfulMsg;

@FindBy(xpath="//button[@type='button']")
private WebElement close;


public WebElement getCancel_forgotpassword() {
	return cancel_forgotpassword;
}


public WebElement getSuccessfulMsg() {
	return successfulMsg;
}


public WebElement getClose() {
	return close;
}
}