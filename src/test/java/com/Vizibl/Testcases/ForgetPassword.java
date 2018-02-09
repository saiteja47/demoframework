package com.Vizibl.Testcases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.net.MalformedURLException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.Vizibl.utilities.BaseClass;
import com.Vizibl.utilities.Constants;
import com.Vizibl.utilities.Excelconfig;
import com.Vizibl.utilities.Webutilities;

public class ForgetPassword extends BaseClass {

	Webutilities webutils = new Webutilities();

	@BeforeClass
	public void initiate() throws MalformedURLException, InterruptedException {

		getbrowser();
		webutils.click(mainpageObjects.getLogin_button());
		webutils.waitUntilVisibile(forgotpasswordObjects.getForgotPassword_button());
		webutils.click(forgotpasswordObjects.getForgotPassword_button());
	}

	@Test(dataProvider = "forgotPassword", dataProviderClass = ForgetPassword.class, priority = 1)
	public void invalidForgetPassword(String email, String expectedErrorMsg) throws InterruptedException {

		webutils.waitUntilVisibile(forgotpasswordObjects.getEmail_Edit());
		webutils.sendkeys(forgotpasswordObjects.getEmail_Edit(), email);
		webutils.waitUntilVisibile(forgotpasswordObjects.getSubmit());
		webutils.click(forgotpasswordObjects.getSubmit());
		webutils.sleep();
		webutils.waitForPageToLoad();
		assertTrue(webutils.verifyErrorMSg(loginpageObjects.getErrorMessages(), expectedErrorMsg));

	}
	@Test(priority=2)
	public void validForgetPassword() throws Exception {
		
		webutils.waitUntilVisibile(forgotpasswordObjects.getEmail_Edit());
		webutils.sendkeys(forgotpasswordObjects.getEmail_Edit(), Constants.username2);
		webutils.waitUntilVisibile(forgotpasswordObjects.getSubmit());
		webutils.click(forgotpasswordObjects.getSubmit());
		webutils.sleep();
		webutils.waitForPageToLoad();
		webutils.click(forgotpasswordObjects.getCancel_forgotpassword());
		
	}

	@AfterClass
	public void afterClass() throws Exception {
		webutils.quit();
	}

	@DataProvider(name = "forgotPassword")

	public static Object[][] ForgotPassword() throws IOException {
		Excelconfig config = new Excelconfig();
		int totalrows = config.getRowcount(1);
		int totalcolumns = config.getColumnCount("forgotPassword", 1);
		Object[][] data = new Object[totalrows - 1][totalcolumns - 5];
		for (int i = 1; i < totalrows ; i++) {
			for (int j = 5; j < totalcolumns; j++) {
				data[i - 1][j - 5] = config.GetCellData(1, i, j);
			}
		}
		return data;
	}

}
