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

//	@Test(dataProvider = "creatingNewAdvertiser", dataProviderClass = CreateAdvertiser.class)
//	public void creatingNewAdvertiser(String ClientType, String orgName, String firstName, String lastName,
//			String email_id, String password, String password_confirmation, String contact_num, String website,
//			String address_line1, String address_line2, String country, String state, String city, String pincode)
//			throws InterruptedException {
//	
//		webutils.click(commonObjects.getMenu_Left(), "Advertiser");
//		webutils.selectByVisibleText(registrationObjects.getClientType(), ClientType);
//		webutils.sendkeys(registrationObjects.getOrganizationName(), orgName);
//		webutils.sendkeys(registrationObjects.getFirstName(), firstName);
//		webutils.sendkeys(registrationObjects.getLastName(), lastName);
//		webutils.sendkeys(registrationObjects.getEmail_id(), email_id);
//		webutils.sendkeys(registrationObjects.getPassword(), password);
//		webutils.sendkeys(registrationObjects.getPassword_confirmation(), password_confirmation);
//		webutils.sendkeys(registrationObjects.getContact_num(), contact_num);
//		webutils.sendkeys(registrationObjects.getWebsite(), website);
//		webutils.sendkeys(registrationObjects.getAddress_line1(), address_line1);
//		webutils.sendkeys(registrationObjects.getAddress_line2(), address_line2);
//		webutils.selectByVisibleText(registrationObjects.getCountry(), country);
//		webutils.sendkeys(registrationObjects.getState(), state);
//		webutils.sendkeys(registrationObjects.getCity(), city);
//		webutils.sendkeys(registrationObjects.getPincode(), pincode);
//		//webutils.click(registrationObjects.getSubmit_button());
//		webutils.click(registrationObjects.getCancel_button());
//
//	}

	@AfterClass
	public void afterClass() throws Exception {
		webutils.logOut();
		webutils.quit();
	}

}
