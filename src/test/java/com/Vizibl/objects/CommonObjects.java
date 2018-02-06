package com.Vizibl.objects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;


public class CommonObjects {
	public CommonObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBys({ @FindBy(xpath = "//span[@class='title']") })
	private List<WebElement> menu_Left;
	
	@FindBy(xpath = "//span[@class='bog']") 
	private WebElement subjectOfMails;
	
	
	
	public WebElement getSubjectOfMails() {
		return subjectOfMails;
	}
	public WebElement getClientType() {
		return clientType;
	}
	public List<WebElement> getMenu_Left() {
		return menu_Left;
	}
	@FindBy(xpath=".//*[@id='demo_ac']/span")
private WebElement demoAccount_button;
	public WebElement getDemoAccount_button() {
		return demoAccount_button;
	}

	@FindBy(id = "identifierId")
	private WebElement username;
	@FindBy(xpath="//span[@class='RveJvd snByac']")
	private WebElement next;
	@FindBy(xpath="//input[@class='whsOnd zHQkBf']")
	private WebElement password;
	@FindBy(xpath="//span[@class='RveJvd snByac']")
	private WebElement passwordNext;
	@FindBy(xpath="//a[@class='gb_b gb_dc']")
	private WebElement googoleMenu;
	@FindBy(id = "gb23")
	private WebElement gmailIcon;
	
	@FindBys({ @FindBy(xpath = "//*[@class='zF']") })
	private List<WebElement> listOfMails;
	
	@FindBy(id = "gbqfq")
	private WebElement searchFunction;
	@FindBy(id = ":2x")
	private WebElement clientType;
	/*@FindBy(id = "type")
	private WebElement clientType;*/

	
	public WebElement getSearchFunction() {
		return searchFunction;
	}
	public WebElement getGoogoleMenu() {
		return googoleMenu;
	}
	public List<WebElement> getListOfMails() {
		return listOfMails;
	}
	public WebElement getGmailIcon() {
		return gmailIcon;
	}
	public WebElement getUsername() {
		return username;
	}
	public WebElement getNext() {
		return next;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getPasswordNext() {
		return passwordNext;
	}
	//menu iteams//
	@FindBy(xpath="//h3[@class='page-title']")
	private WebElement advertiser_Tiitle;



	public WebElement getAdvertiser_Tiitle() {
		return advertiser_Tiitle;
	}
	
	 }
		
	

