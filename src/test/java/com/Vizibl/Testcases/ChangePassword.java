package com.Vizibl.Testcases;

import static org.testng.Assert.assertEquals;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.Vizibl.utilities.BaseClass;
import com.Vizibl.utilities.Dataprovider;
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

	@Test(dataProvider = "ChangePassword", dataProviderClass = Dataprovider.class)
	public void changePassword(String currentPassword, String newPassword, String confirmPassword,
			String expectedResult) throws InterruptedException {

		webutils.waitUntilVisibile(changepasswordObjects.getCurrent_password());
		webutils.sendkeys(changepasswordObjects.getCurrent_password(), currentPassword);
		webutils.sendkeys(changepasswordObjects.getNew_Password(), newPassword);
		webutils.sendkeys(changepasswordObjects.getConfirmation_Password(), confirmPassword);
		try {
			webutils.click(changepasswordObjects.getSaveChanges());
			webutils.sleep();
			webutils.waitUntilVisibile(changepasswordObjects.getCurrentPassworderrormsg());
			Assert.assertTrue(webutils.verifyErrorMSg(changepasswordObjects.getErrorMessages(), expectedResult));
		}
		catch (Exception e) {
			Assert.assertTrue(webutils.verifyErrorMSg(changepasswordObjects.getErrorMessages(), expectedResult));
		}
	}

	@Test(dataProvider = "validChangePassword", dataProviderClass = Dataprovider.class)
	public void validChangePassword(String currentPassword, String newPassword, String confirmPassword)
			throws Exception {

		try {
			webutils.waitUntilVisibile(changepasswordObjects.getCurrent_password());
			webutils.sendkeys(changepasswordObjects.getCurrent_password(), currentPassword);
			webutils.sendkeys(changepasswordObjects.getNew_Password(), newPassword);
			webutils.sendkeys(changepasswordObjects.getConfirmation_Password(), confirmPassword);
			try {
				webutils.click(changepasswordObjects.getSaveChanges());
				webutils.waitUntilVisibile(changepasswordObjects.getSuccessfulMsg());
				assertEquals(webutils.gettext(changepasswordObjects.getSuccessfulMsg()),
						"Password changed successfully...!!!");
			} catch (Exception e) {
				webutils.refresh();
				webutils.waitForPageToLoad();
				actions.moveToElement(homepageObjectes.getProfileName()).perform();
				assertEquals(changepasswordObjects.getChangePassword().getText(), "Change Password");
				actions.doubleClick(changepasswordObjects.getChangePassword()).perform();
				webutils.waitUntilVisibile(changepasswordObjects.getCurrent_password());
				webutils.sendkeys(changepasswordObjects.getCurrent_password(), currentPassword);
				webutils.sendkeys(changepasswordObjects.getNew_Password(), newPassword);
				webutils.sendkeys(changepasswordObjects.getConfirmation_Password(), confirmPassword);
				webutils.click(changepasswordObjects.getSaveChanges());

			}
			
		} catch (Exception e) {
			webutils.waitUntilVisibile(changepasswordObjects.getCurrent_password());
			webutils.sendkeys(changepasswordObjects.getCurrent_password(), "Datawrkz12");
			webutils.sendkeys(changepasswordObjects.getNew_Password(), "Datawrkz1");
			webutils.sendkeys(changepasswordObjects.getConfirmation_Password(), "Datawrkz1");
			webutils.click(changepasswordObjects.getSaveChanges());
			webutils.waitUntilVisibile(changepasswordObjects.getSuccessfulMsg());
			assertEquals(webutils.gettext(changepasswordObjects.getSuccessfulMsg()),
					"Password changed successfully...!!!");
		}
	}

	@AfterClass
	public void afterClass() throws Exception {
		webutils.logOut();
		webutils.quit();
	}

}
