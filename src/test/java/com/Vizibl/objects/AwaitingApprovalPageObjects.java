package com.Vizibl.objects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class AwaitingApprovalPageObjects {

		public AwaitingApprovalPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		@FindBys({ @FindBy(xpath = ".//*[@id='DataTables_Table_0']/tbody/tr/td[3]") })
		private List<WebElement> getAwaitingForApprovalList;
		
		public List<WebElement> getGetAwaitingForApprovalList() {
			return getAwaitingForApprovalList;
		}
		
		@FindBy(xpath=".//*[@id='DataTables_Table_0_length']/label/select")
		private WebElement recordpPerPage;
		public WebElement getRecordpPerPage() {
			return recordpPerPage;
		}
		@FindBy(id="change_status_demo")
		private WebElement readOnly_button;
		
		@FindBys({ @FindBy(xpath = ".//*[@id='DataTables_Table_0']/tbody/tr/td[3]/a") })
		private List<WebElement> edit_button;
		public WebElement getReadOnly_button() {
			return readOnly_button;
		}

		public List<WebElement> getEdit_button() {
			return edit_button;
		}
		@FindBy(xpath="//select[@name='status']")
		private WebElement status_dropedown;
		
		@FindBy(id="confirmed_status")
		private WebElement changeStatus;
		public WebElement getStatus_dropedown() {
			return status_dropedown;
		}

		public WebElement getChangeStatus() {
			return changeStatus;
		} 	
		
		
}	
