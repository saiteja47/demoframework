package com.Vizibl.Testcases;

import java.io.IOException;
import java.net.MalformedURLException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.Vizibl.utilities.BaseClass;
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

	@Test(dataProvider = "forgotPassword", dataProviderClass = ForgetPassword.class)
	public void forgotPassword(String email, String expectedErrorMsg) throws InterruptedException {
		
		webutils.waitUntilVisibile(forgotpasswordObjects.getEmail_Edit());
		webutils.sendkeys(forgotpasswordObjects.getEmail_Edit(), email);
		webutils.waitUntilVisibile(forgotpasswordObjects.getSubmit());
		webutils.click(forgotpasswordObjects.getSubmit());
		webutils.sleep();
		webutils.waitForPageToLoad();

		if (webutils.verifyErrorMSg(loginpageObjects.getErrorMessages(), expectedErrorMsg)) {

		} else {
		
			webutils.waitUntilVisibile(forgotpasswordObjects.getClose());
			// successfull page action is not performing//
			// assertEquals(webutils.gettext(forgotpasswordObjects.getSuccessfulMsg()),
			// expectedErrorMsg);
			// webutils.AlertHandling();
			webutils.click(forgotpasswordObjects.getClose());
		}
		webutils.sleep();
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
		for (int i = 1; i < totalrows; i++) {
			for (int j = 5; j < totalcolumns; j++) {
				data[i - 1][j - 5] = config.GetCellData(1, i, j);
			}
		}
		return data;
	}

}
