package com.Vizibl.Testcases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.Vizibl.utilities.BaseClass;
import com.Vizibl.utilities.Excelconfig;

public class Testcase extends BaseClass {
	@BeforeClass
	public void beforeclass() {
		
		System.setProperty("webdriver.chrome.driver","E:\\Vizibl\\utilities\\chromedriver.exe");
		driver = new ChromeDriver();
//		ChromeOptions chromeOptions = new ChromeOptions();
//		chromeOptions.addArguments("--start-maximized");
//		driver = new ChromeDriver(chromeOptions);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://viziblbeta.datawrkz.com/");
		driver.findElement(By.id("login_popup")).click();
	}
	@Test(dataProvider = "adminLogin")
	public void testLogin(String username, String password) throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.id("user_email")).click();
		driver.findElement(By.id("user_email")).clear();
		driver.findElement(By.id("user_email")).sendKeys(username);
		driver.findElement(By.id("user_password")).clear();
		driver.findElement(By.id("user_password")).sendKeys(password);
		driver.findElement(By.id("sign_in_click")).click();
		
	}

	@DataProvider(name = "adminLogin")
	public static Object[][] adminLogin() throws Exception {
		Excelconfig config = new Excelconfig();
		int totalrows = config.getRowcount(0);
		int totalcolumns = config.getColumnCount("Login", 2);
		Object[][] data = new Object[totalrows - 2][totalcolumns - 6];
		for (int i = 2; i < totalrows; i++) {
			for (int j = 5; j < totalcolumns - 1; j++) {
				data[i - 2][j - 5] = config.GetCellData(0, i, j);
			}
		}
		return data;
	}
}
