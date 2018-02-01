package com.Vizibl.objects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class RegistrationObjects {
	public RegistrationObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBys({ @FindBy(xpath = "//div[@class='form-group']/abcd") })
	private List<WebElement> errorMessages;
	
	public  List<WebElement> getErrorMessages() {
		return errorMessages;
	}

	public WebElement getOrganizationName() {
		return organizationName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getEmail_id() {
		return email_id;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getPassword_confirmation() {
		return password_confirmation;
	}

	public WebElement getContact_num() {
		return contact_num;
	}

	public WebElement getWebsite() {
		return website;
	}

	public WebElement getAddress_line1() {
		return address_line1;
	}

	public WebElement getCountry() {
		return country;
	}

	public WebElement getState() {
		return state;
	}

	public WebElement getPincode() {
		return pincode;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getCancel_button() {
		return cancel_button;
	}

	

	public WebElement getRegister() {
		return register;
	}

	@FindBy(id = "type")
	private WebElement clientType;

	public WebElement getClientType() {
		return clientType;
	}

	@FindBy(id = "adv_name")
	private WebElement adv_name;

	public WebElement getAdv_name() {
		return adv_name;
	}

	@FindBy(id = "org_name")
	private WebElement organizationName;

	@FindBy(id = "first_name")
	private WebElement firstName;

	
	public WebElement getFirstName() {
		return firstName;
	}

	@FindBy(id = "last_name")
	private WebElement lastName;

	@FindBy(id = "email_id")
	private WebElement email_id;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(id = "password_confirmation")
	private WebElement password_confirmation;

	@FindBy(id = "contact_num")
	private WebElement contact_num;

	@FindBy(id = "website")
	private WebElement website;

	@FindBy(id = "address_line1")
	private WebElement address_line1;
	
	public WebElement getAddress_line2() {
		return address_line2;
	}

	@FindBy(id = "address_line2")
	private WebElement address_line2;

	@FindBy(id = "country")
	private WebElement country;

	@FindBy(id = "state")
	private WebElement state;

	@FindBy(id = "pincode")
	private WebElement pincode;

	@FindBy(id = "city")
	private WebElement city;

	@FindBy(id = "cancel_button")
	private WebElement cancel_button;

	@FindBy(id = "submit_button")
	private WebElement register;
	
	//webelement for cretion completed window//
	
	@FindBy(xpath = "//button[@type='button']")
	private WebElement close_button;

	public WebElement getClose_button() {
		return close_button;
	}
	
	@FindBy(id="close_button")
	private WebElement cross_button;

	public WebElement getCross_button() {
		return cross_button;
	}

}
