package com.Vizibl.objects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAdvertiserObjects {

	public CreateAdvertiserObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	
	@FindBy(xpath="//a[class='btn green fa fa-plus']")
	private WebElement advertiser_button;
	
	public WebElement getAdvertiser_button() {
		return advertiser_button;
	}
	
	
	//Advertiser creation page //
	
	@FindBy(id="user_name_appnexus")
	private WebElement advertiser_Name;
	
	@FindBy(id="state")
	private WebElement advertiser_State;
	
	@FindBy(id="agency_id")
	private WebElement advertiser_Agency_ID;

	@FindBy(id="account_manager_id")
	private WebElement advertiser_Account_Manager_ID;

	@FindBy(id="organization_name")
	private WebElement advertiser_Orgname;

	@FindBy(id="user_website")
	private WebElement advertiser_Website;

	@FindBy(id="user_address1")
	private WebElement advertiser_Address1;

	@FindBy(id="user_address2")
	private WebElement advertiser_Address2;
	
	@FindBy(id="user_country")
	private WebElement advertiser_Country;
	@FindBy(id="user_city")
	private WebElement advertiser_City;
	
	
	
	
}
