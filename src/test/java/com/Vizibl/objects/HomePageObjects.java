package com.Vizibl.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class HomePageObjects {

	
	public HomePageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);	
		}

	@FindBy(xpath = "//span[@class='username username-hide-on-mobile']")
	private WebElement profileName;

	
	@FindBy(xpath="//a[@class=\"fa fa-key test\"]")
	private WebElement logOut;
	
	@FindBy(xpath="//a[@class='fa fa-refresh clear_cache_click']")
	private WebElement cachClear;

	// Change Password Window//

	public WebElement getCachClear() {
		return cachClear;
	}

	public WebElement getProfileName() {
		return profileName;
	}

	

	public WebElement getLogOut() {
		return logOut;
	}
}
