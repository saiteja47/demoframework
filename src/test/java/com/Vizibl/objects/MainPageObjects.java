package com.Vizibl.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vizibl.utilities.Webutilities;

public class MainPageObjects extends Webutilities{
	
	public MainPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath ="//a[@id='login_popup']")
	private WebElement login_button;

	public WebElement getLogin_button() {
		return login_button;
	}
	
	@FindBy(id ="dialog_adv")
	private WebElement register_Link;

	public WebElement getRegister_Link() {
		return register_Link;
	}

}
