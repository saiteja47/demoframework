package com.Vizibl.Testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Vizibl.utilities.BaseClass;
import com.Vizibl.utilities.Webutilities;

public class CreateAdvertiser extends BaseClass {

	Webutilities webutils = new Webutilities();

	@BeforeClass
	public void initiate() throws Exception {

		getbrowser();
		webutils.login();

	}

	@Test(dataProvider = "creatingNewAdvertiser", dataProviderClass = CreateAdvertiser.class)
	public void creatingNewAdvertiser(String ClientType, String orgName, String firstName, String lastName,
			String email_id, String password, String password_confirmation, String contact_num, String website,
			String address_line1, String address_line2, String country, String state, String city, String pincode)
			throws InterruptedException {
	
		webutils.click(commonObjects.getMenu_Left(), "Advertiser");
		webutils.sendkeys(createAdvertiserObjects.getAdvertiser_Name(), "value");
		webutils.selectByVisibleText(createAdvertiserObjects.getAdvertiser_State(), "");
		webutils.selectByVisibleText(createAdvertiserObjects.getAdvertiser_Agency_ID(), "");	
		webutils.selectByVisibleText(createAdvertiserObjects.getAdvertiser_Account_Manager_ID(), "");
		webutils.sendkeys(createAdvertiserObjects.getAdvertiser_Orgname(), "");
		webutils.sendkeys(createAdvertiserObjects.getAdvertiser_Website(), "");
		webutils.sendkeys(createAdvertiserObjects.getAdvertiser_Address1(), address_line1);
		webutils.sendkeys(createAdvertiserObjects.getAdvertiser_Address2(), address_line2);
		webutils.selectByVisibleText(createAdvertiserObjects.getAdvertiser_Country(), country);
		webutils.sendkeys(createAdvertiserObjects.getAdvertiser_City(), city);
		webutils.sendkeys(createAdvertiserObjects.getAdvertiser_State(), state);
		webutils.sendkeys(createAdvertiserObjects.getAdvertiser_Pincode(), pincode);
		webutils.click(createAdvertiserObjects.getAdvertiser_create_button());

	}

	@AfterClass
	public void afterClass() throws Exception {
		webutils.logOut();
		webutils.quit();
	}

}
