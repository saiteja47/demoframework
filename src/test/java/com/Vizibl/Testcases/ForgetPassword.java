package com.Vizibl.Testcases;

import static org.testng.Assert.assertTrue;
import java.net.MalformedURLException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.Vizibl.utilities.BaseClass;
import com.Vizibl.utilities.Constants;
import com.Vizibl.utilities.Dataprovider;
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

	@Test(dataProvider = "forgotPassword", dataProviderClass = Dataprovider.class, priority = 1)
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

	

}
