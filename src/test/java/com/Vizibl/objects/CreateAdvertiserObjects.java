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
	
	public WebElement getAdvertiser_Name() {
		return advertiser_Name;
	}
	public WebElement getAdvertiser_State() {
		return advertiser_State;
	}
	public WebElement getAdvertiser_Agency_ID() {
		return advertiser_Agency_ID;
	}
	public WebElement getAdvertiser_Account_Manager_ID() {
		return advertiser_Account_Manager_ID;
	}
	public WebElement getAdvertiser_Orgname() {
		return advertiser_Orgname;
	}
	public WebElement getAdvertiser_Website() {
		return advertiser_Website;
	}
	public WebElement getAdvertiser_Address1() {
		return advertiser_Address1;
	}
	public WebElement getAdvertiser_Address2() {
		return advertiser_Address2;
	}
	public WebElement getAdvertiser_Country() {
		return advertiser_Country;
	}
	public WebElement getAdvertiser_City() {
		return advertiser_City;
	}

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

	public WebElement getAdvertiser_Pincode() {
		return pincode;
	}

	@FindBy(id="user_address2")
	private WebElement advertiser_Address2;
	
	@FindBy(id="user_country")
	private WebElement advertiser_Country;
	@FindBy(id="user_city")
	private WebElement advertiser_City;
	
	@FindBy(id = "pincode")
	private WebElement pincode;
	
	@FindBy(id="create_adv")
	private WebElement Advertiser_create_button;

	public WebElement getAdvertiser_create_button() {
		return Advertiser_create_button;
	}
}
