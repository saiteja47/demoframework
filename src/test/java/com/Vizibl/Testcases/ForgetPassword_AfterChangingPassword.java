package com.Vizibl.Testcases;

import java.io.IOException;
import java.net.MalformedURLException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.Vizibl.utilities.BaseClass;
import com.Vizibl.utilities.Excelconfig;
import com.Vizibl.utilities.Webutilities;

public class ForgetPassword_AfterChangingPassword extends BaseClass{
	
	Webutilities webutils = new Webutilities();
	
	@BeforeClass
	public void initiate() throws MalformedURLException, InterruptedException {
		getbrowser();
		webutils.click(mainpageObjects.getLogin_button());
	}

	@Test(dataProvider="afterChangingPassword")
	public void forgetPassword_AfterChangingPassword(String username , String password,String expectedResult) throws Exception {
		
		webutils.waitUntilVisibile(loginpageObjects.getUserName());
		webutils.sendkeys(loginpageObjects.getUserName(), username);
		webutils.waitUntilVisibile(loginpageObjects.getPassWord());
		webutils.sendkeys(loginpageObjects.getPassWord(), password);
		webutils.waitUntilVisibile(loginpageObjects.getSignIn_button());
		webutils.click(loginpageObjects.getSignIn_button());
		webutils.sleep();
	
			if((webutils.verifyErrorMSg(loginpageObjects.getErrorMessages(), expectedResult))) {
			
			}
			else {
		
		System.out.println("login successful");
		webutils.logOut();
		
		}
		webutils.sleep();
	}
	
	@DataProvider(name = "afterChangingPassword")

	public static Object[][] afterChangingPassword() throws IOException {
		Excelconfig config = new Excelconfig();
		int totalrows = config.getRowcount(4);
		System.out.println(totalrows);
		int totalcolumns = config.getColumnCount("afterChangingPassword", 2 );
		System.out.println(totalcolumns);
		Object[][] data = new Object[totalrows - 2][totalcolumns - 5];
		for (int i = 2; i < totalrows; i++) {
			for (int j = 5; j < totalcolumns; j++) {
				data[i - 2][j - 5] = config.GetCellData(4, i, j);
			}
		}
		return data;
	}
}
