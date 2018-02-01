package com.Vizibl.Testcases;

import java.io.IOException;
import java.net.MalformedURLException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.Vizibl.utilities.BaseClass;
import com.Vizibl.utilities.Excelconfig;
import com.Vizibl.utilities.VariableData;
import com.Vizibl.utilities.Webutilities;

@Listeners(com.Vizibl.utilities.SampleListeners.class)
public class Registration extends BaseClass {
	Webutilities webutils = new Webutilities();

	@BeforeClass
	public void initiate() throws MalformedURLException, InterruptedException {
		getbrowser();
		webutils.waitUntilVisibile(mainpageObjects.getRegister_Link());
		webutils.click(mainpageObjects.getRegister_Link());

	}

	@Test(dataProvider = "advertiserRegistration", dataProviderClass = Registration.class, priority = 1)
	public void advertiserRegistration(String ClientType, String orgName, String firstName, String lastName,
			String email_id, String password, String password_confirmation, String contact_num, String website,
			String address_line1, String address_line2, String country, String state, String city, String pincode,
			String action, String Expected) throws Exception {
		try {
			
			webutils.waitForPageToLoad();
			webutils.selectByVisibleText(registrationObjects.getClientType(), ClientType);
			webutils.sendkeys(registrationObjects.getOrganizationName(), orgName);
			webutils.sendkeys(registrationObjects.getFirstName(), firstName);
			webutils.sendkeys(registrationObjects.getLastName(), lastName);
			webutils.sendkeys(registrationObjects.getEmail_id(), email_id);
			webutils.sendkeys(registrationObjects.getPassword(), password);
			webutils.sendkeys(registrationObjects.getPassword_confirmation(), password_confirmation);
			webutils.sendkeys(registrationObjects.getContact_num(), contact_num);
			webutils.sendkeys(registrationObjects.getWebsite(), website);
			webutils.sendkeys(registrationObjects.getAddress_line1(), address_line1);
			webutils.sendkeys(registrationObjects.getAddress_line2(), address_line2);
			webutils.selectByVisibleText(registrationObjects.getCountry(), country);
			webutils.sendkeys(registrationObjects.getState(), state);
			webutils.sendkeys(registrationObjects.getCity(), city);
			webutils.sendkeys(registrationObjects.getPincode(), pincode);
			if (action.trim().equalsIgnoreCase("cancel")) {
			webutils.click(registrationObjects.getCancel_button());
			webutils.waitUntilVisibile(mainpageObjects.getRegister_Link());
			webutils.click(mainpageObjects.getRegister_Link());
			}
			else {
				webutils.click(registrationObjects.getRegister());
				Assert.assertTrue(webutils.verifyErrorMSg(registrationObjects.getErrorMessages(), Expected));
				
			}
			
			/*if (action.trim().equalsIgnoreCase("cancel")) {
				Assert.assertTrue(webutils.verifyErrorMSg(registrationObjects.getErrorMessages(), Expected));
				webutils.sleep();
				webutils.click(registrationObjects.getCancel_button());
				webutils.waitUntilVisibile(registrationObjects.getCancel_button());
				webutils.click(registrationObjects.getCancel_button());
				webutils.waitUntilVisibile(mainpageObjects.getRegister_Link());
				webutils.click(mainpageObjects.getRegister_Link());
			} else if (action.trim().equalsIgnoreCase("submit")) {
				 	try {	webutils.Isdisplayed(registrationObjects.getRegister())
					
						webutils.click(registrationObjects.getRegister());
				
						Assert.assertTrue(webutils.verifyErrorMSg(registrationObjects.getErrorMessages(), Expected));
				
				}*/
				 	
				 	
//				webutils.waitUntilVisibile(registrationObjects.getCancel_button());
//				webutils.sleep();
//				if (webutils.Isdisplayed(registrationObjects.getCancel_button())) {
//
//					webutils.click(registrationObjects.getCancel_button());
//				} else {
//					Assert.assertTrue(webutils.verifyErrorMSg(registrationObjects.getErrorMessages(), Expected));
//					webutils.waitUntilVisibile(registrationObjects.getCancel_button());
//				}
			
		} catch (Exception e) {
//				throw new Exception(e.getMessage());
				e.printStackTrace();
		}
	}

	@Test(priority = 2)
	public void verfyingUserAccountInDemoAccounts() throws Exception {
		/* verfying user account in Demo accounts */
		try {
			webutils.login();
			webutils.waitUntilVisibile(commonObjects.getMenu_Left());
			webutils.click(commonObjects.getDemoAccount_button());
			webutils.waitUntilVisibile(awaitingApprovalPageObjects.getRecordpPerPage());
			webutils.selectByVisibleText(awaitingApprovalPageObjects.getRecordpPerPage(), VariableData.pageRecords);
			webutils.selectingClient(awaitingApprovalPageObjects.getGetAwaitingForApprovalList(),
					VariableData.nameOfClient, awaitingApprovalPageObjects.getEdit_button());
			webutils.waitUntilVisibile(awaitingApprovalPageObjects.getStatus_dropedown());
			webutils.selectByVisibleText(awaitingApprovalPageObjects.getStatus_dropedown(), VariableData.status);
			/* clicking on change status */
			// webutils.click(awaitingApprovalPageObjects.getChangeStatus());
			Reporter.log("VerfingAccount is sucessfull");

		} catch (Exception e1) {
			throw new Exception(e1.getMessage());
		}

	}

	@Test(priority = 3)
	public void verfyingUserAccountInAdvertisers() throws Exception {
		/* checking user account in advertisers list */
		// webutils.login();
		webutils.waitUntilVisibile(commonObjects.getMenu_Left());
		webutils.click(commonObjects.getMenu_Left(), "Advertiser");
		webutils.selectByVisibleText(advertiserPageObjects.getRecordpPerPage(), VariableData.pageRecords);
		webutils.selectingclient3(advertiserPageObjects.getAdvertiserNameList(), "Decibel",
				advertiserPageObjects.getAdvertiserStatusList());
		Reporter.log("Uesr is existing in Advertiser ");
		System.out.println("test case passed");
	}

	@Test(priority = 4)
	public void mailconformation() {

	}

	@AfterClass
	public void afterClass() throws Exception {
		webutils.quit();
	}

	@DataProvider(name = "advertiserRegistration")
	public static Object[][] advertiserRegistration() throws IOException {
		Excelconfig config = new Excelconfig();
		int totalrows = config.getRowcount(3);
		// System.out.println(totalrows);
		int totalcolumns = config.getColumnCount("advertiserRegistration", 1);
		// System.out.println(totalcolumns);
		Object[][] data = new Object[totalrows - 1][totalcolumns - 5];
		for (int i = 1; i < totalrows; i++) {
			for (int j = 5; j < totalcolumns; j++) {
				data[i - 1][j - 5] = config.GetCellData(3, i, j);
			}
		}
		return data;
	}

}
