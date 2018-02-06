package com.Vizibl.objects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginpageObjects 
{
	public LoginpageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
  
	@FindBys({ @FindBy(xpath = "//abcd[@style='color: red']") })
	private List<WebElement> errorMessages;
	
	public  List<WebElement> getErrorMessages() {
		return errorMessages;
	}

	

	@FindBy(id="user_email")
	private  WebElement userName;
	
	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassWord() {
		return passWord;
	}

	

	public WebElement getSignIn_button() {
		return signIn_button;
	}

	public WebElement getRememberme_check() {
		return rememberme_check;
	}

	@FindBy(id="user_password")
	private WebElement passWord;
	
	
	
	@FindBy(id="sign_in_click") 
	private WebElement signIn_button;
	
	@FindBy(id="rem_me")
	private WebElement rememberme_check;
	
	
	@FindBy(id="session_popup")
	private WebElement cancle_button;
	
	//Forgot Password Webelements//
	
	
	public WebElement getCancle_button() {
		return cancle_button;
	}

	
	
	
	
}

