package com.Vizibl.ui;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.Vizibl.utilities.BaseClass;
import com.Vizibl.utilities.Webutilities;

public class Registration extends BaseClass{

	Webutilities webutils = new Webutilities();
	@BeforeClass
	public void beforeClass() throws Exception {
		getbrowser();
		webutils.waitForPageToLoad();
		webutils.waitUntilVisibile(mainpageObjects.getRegister_Link());
		webutils.click(mainpageObjects.getRegister_Link());
		
	}
	@Test
	public void clienttype() throws Exception {
		
		webutils.chekingAllOptionsInDropedown(registrationObjects.getClientType(),"Select Client Type *; Advertiser;Agency;");
	}
	
	@Test
	
	public void selectCountry() {
		
		webutils.chekingAllOptionsInDropedown(registrationObjects.getCountry(), "Other Country;Andorra");
	}
}
