package com.Vizibl.Testcases;

import static org.testng.Assert.assertEquals;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.Vizibl.utilities.BaseClass;
import com.Vizibl.utilities.Excelconfig;
import com.Vizibl.utilities.Webutilities;

public class ChangePassword extends BaseClass {

	Webutilities webutils = new Webutilities();

	@BeforeClass
	public void initiate() throws Exception {

		getbrowser();
		webutils.login();
		webutils.waitForPageToLoad();
		actions.moveToElement(homepageObjectes.getProfileName()).perform();
		assertEquals(changepasswordObjects.getChangePassword().getText(), "Change Password");
		actions.doubleClick(changepasswordObjects.getChangePassword()).perform();
	
	}

	@Test(dataProvider = "ChangePassword")
	public void changePassword(String currentPassword, String newPassword, String confirmPassword,
			String expectedResult) throws InterruptedException {

		try {
			
			webutils.waitUntilVisibile(changepasswordObjects.getCurrent_password());
			webutils.sendkeys(changepasswordObjects.getCurrent_password(), currentPassword);
			webutils.sendkeys(changepasswordObjects.getNew_Password(), newPassword);		
			webutils.sendkeys(changepasswordObjects.getConfirmation_Password(), confirmPassword);
			webutils.click(changepasswordObjects.getSaveChanges());
			webutils.sleep();
			Assert.assertTrue(webutils.verifyErrorMSg(changepasswordObjects.getErrorMessages(), expectedResult));
		} catch (Exception e) {
	
			e.printStackTrace();
		}
	}
	@Test
	public void validChangePassword() {
	
		
	}
	@AfterClass
	public void afterClass() throws Exception {
		webutils.logOut();
		webutils.quit();
	}

	@DataProvider(name = "ChangePassword")
	public static Object[][] Changepassword() throws IOException {
		Excelconfig config = new Excelconfig();
		int totalrows = config.getRowcount(2);
		 System.out.println(totalrows);
		int totalcolumns = config.getColumnCount("ChangePassword", 1);
		 System.out.println(totalcolumns);
		Object[][] data = new Object[totalrows - 1][totalcolumns - 5];
		for (int i = 1; i < totalrows; i++) {
			for (int j = 5; j < totalcolumns; j++) {
				data[i - 1][j - 5] = config.GetCellData(2, i, j);
			}
		}
		return data;
	}

}
