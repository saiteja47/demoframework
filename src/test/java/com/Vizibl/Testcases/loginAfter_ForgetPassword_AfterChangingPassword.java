package com.Vizibl.Testcases;

import static org.testng.Assert.assertTrue;
import java.net.MalformedURLException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.Vizibl.utilities.BaseClass;
import com.Vizibl.utilities.Dataprovider;
import com.Vizibl.utilities.Webutilities;

public class loginAfter_ForgetPassword_AfterChangingPassword extends BaseClass {

	/* Manual steps should complete before this class */

	Webutilities webutils = new Webutilities();

	@BeforeClass
	public void initiate() throws MalformedURLException, InterruptedException {
		getbrowser();
		webutils.click(mainpageObjects.getLogin_button());
	}

	@Test(dataProvider = "afterChangingPassword", dataProviderClass = Dataprovider.class)
	public void forgetPassword_AfterChangingPassword(String username, String password, String expectedResult)
			throws Exception {

		webutils.waitUntilVisibile(loginpageObjects.getUserName());
		webutils.sendkeys(loginpageObjects.getUserName(), username);
		webutils.waitUntilVisibile(loginpageObjects.getPassWord());
		webutils.sendkeys(loginpageObjects.getPassWord(), password);
		webutils.waitUntilVisibile(loginpageObjects.getSignIn_button());
		webutils.click(loginpageObjects.getSignIn_button());
		webutils.sleep();
		try {
			assertTrue(webutils.verifyErrorMSg(loginpageObjects.getErrorMessages(), expectedResult));
		} catch (Exception e) {
			System.out.println("login successful");
			webutils.logOut();
		}
		webutils.sleep();
	}
}
