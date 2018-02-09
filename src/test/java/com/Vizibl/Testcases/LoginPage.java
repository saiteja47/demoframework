package com.Vizibl.Testcases;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertEquals;
import java.net.MalformedURLException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.Vizibl.utilities.BaseClass;
import com.Vizibl.utilities.Constants;
import com.Vizibl.utilities.Excelconfig;
import com.Vizibl.utilities.Webutilities;

public class LoginPage extends BaseClass {

	Webutilities webutils = new Webutilities();

	@BeforeClass
	public void initiate() throws MalformedURLException, InterruptedException {
		getbrowser();
		webutils.waitForPageToLoad();
		webutils.waitUntilVisibile(mainpageObjects.getLogin_button());
		webutils.click(mainpageObjects.getLogin_button());
	}

	@Test(dataProvider = "adminLogin", priority = 1)
	public void adminLogin(String username, String password, String expectedResult) throws Exception {
		try {

			webutils.sendkeys(loginpageObjects.getUserName(), username);
			webutils.waitUntilVisibile(loginpageObjects.getPassWord());
			webutils.sendkeys(loginpageObjects.getPassWord(), password);
			webutils.waitUntilVisibile(loginpageObjects.getSignIn_button());
			webutils.click(loginpageObjects.getSignIn_button());
			Assert.assertTrue(webutils.verifyErrorMSg(loginpageObjects.getErrorMessages(), expectedResult));
			webutils.sleep();

		} catch (Exception n) {
			throw new Exception(n.getMessage());
		}
	}

	@Test(priority=2)
	public void rememberMe() throws Exception {
		try {

			webutils.waitUntilVisibile(loginpageObjects.getUserName());
			webutils.sendkeys(loginpageObjects.getUserName(), Constants.username2);
			webutils.sendkeys(loginpageObjects.getPassWord(), Constants.password2);
			webutils.getattribute(loginpageObjects.getPassWord(), "value");
			webutils.click(loginpageObjects.getRememberme_check());
			webutils.click(loginpageObjects.getSignIn_button());
			assertEquals("Vizibl", webutils.getitle());
			Reporter.log("Verfied the Title of the Vizibl page");
			webutils.window();

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@AfterClass
	public void afterClass() throws Exception {

		webutils.quit();
	}

	@DataProvider(name = "adminLogin")
	public static Object[][] adminLogin() throws Exception {
		Excelconfig config = new Excelconfig();
		int totalrows = config.getRowcount(0);
		int totalcolumns = config.getColumnCount("Login", 2);
		Object[][] data = new Object[totalrows - 2][totalcolumns - 5];
		for (int i = 2; i < totalrows; i++) {
			for (int j = 5; j < totalcolumns; j++) {
				data[i - 2][j - 5] = config.GetCellData(0, i, j);
			}
		}
		return data;
	}

}
