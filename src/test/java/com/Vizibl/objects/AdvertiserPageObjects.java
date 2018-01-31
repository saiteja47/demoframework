package com.Vizibl.objects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class AdvertiserPageObjects {
	public AdvertiserPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	

	@FindBys({ @FindBy(xpath = "//*[@id='DataTables_Table_0']/tbody/tr/td[3]") })
	private List<WebElement> advertiserStatusList;
	@FindBys({ @FindBy(xpath = "//*[@id='DataTables_Table_0']/tbody/tr/td[2]") })
	private List<WebElement> advertiserNameList;
	@FindBys({ @FindBy(xpath = "//*[@id='DataTables_Table_0']/tbody/tr/td[4]") })
	private List<WebElement> advertiserSettingsList;
	@FindBys({ @FindBy(xpath = "//*[@id='DataTables_Table_0']/tbody/tr/td[5]") })
	private List<WebElement> advertiserEditList;
	@FindBys({ @FindBy(xpath = "//*[@id='DataTables_Table_0']/tbody/tr/td[6]") })
	private List<WebElement> advertiserUsersList;
	
	@FindBy(xpath=".//*[@id='DataTables_Table_0_length']/label/select")
	private WebElement recordpPerPage;
	
	public WebElement getRecordpPerPage() {
		return recordpPerPage;
	}
	public WebElement getAddAdvertiser_button() {
		return addAdvertiser_button;
	}
	public WebElement getRecordsPerPage() {
		return recordsPerPage;
	}


	@FindBy(xpath="//a[@class='btn green fa fa-plus']")
	private WebElement addAdvertiser_button;
	
	@FindBy(xpath="//select[@class='form-control input-sm']")
	private WebElement recordsPerPage;
	
	public List<WebElement> getAdvertiserStatusList() {
		return advertiserStatusList;
	}
	public List<WebElement> getAdvertiserNameList() {
		return advertiserNameList;
	}
	public List<WebElement> getAdvertiserSettingsList() {
		return advertiserSettingsList;
	}
	public List<WebElement> getAdvertiserEditList() {
		return advertiserEditList;
	}
	public List<WebElement> getAdvertiserUsersList() {
		return advertiserUsersList;
	}
	
}
