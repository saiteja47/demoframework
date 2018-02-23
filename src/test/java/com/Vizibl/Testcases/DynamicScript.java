package com.Vizibl.Testcases;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DynamicScript {
	WebDriver driver;
	String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://viziblbeta.datawrkz.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testDynamicScript() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.id("login_popup")).click();
		driver.findElement(By.id("user_email")).click();
		driver.findElement(By.id("user_email")).clear();
		driver.findElement(By.id("user_email")).sendKeys("Srinivasarao.r@datawrkz.com");
		driver.findElement(By.id("user_password")).clear();
		driver.findElement(By.id("user_password")).sendKeys("Datawrkz1");
		driver.findElement(By.id("sign_in_click")).click();
		driver.findElement(By.cssSelector("#demo_ac > span.title")).click();
		driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td[3]/a")).click();
		driver.findElement(By.cssSelector(
				"#edit_demo_account_n > div.modal-dialog > div.modal-content > div.modal-header > button.close"))
				.click();
		new Select(driver.findElement(By.name("DataTables_Table_0_length"))).selectByVisibleText("100");
		driver.findElement(By.xpath("(//a[@id='ad']/span)[2]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Advertiser')]")).click();
		driver.findElement(By.id("create_adv")).click();
		driver.findElement(By.id("create_adv")).click();
		assertEquals(driver.findElement(By.cssSelector("div.replace_adv_name_error.")).getText(),
				"Advertiser Name can't be blank");
		// assertEquals(driver.findElement(By.cssSelector("div.replace_adv_org_error.")).getText(),
		// "Organization Name can't be blank");
		assertEquals(driver.findElement(By.cssSelector("div.replace_adv_web_error.")).getText(),
				"Website can't be blank");
		driver.findElement(By.cssSelector("i.fa.fa-angle-down")).click();
		driver.findElement(By.linkText("Log Out")).click();
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

}
