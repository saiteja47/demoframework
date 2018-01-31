package com.Vizibl.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.interactions.Actions;

import com.Vizibl.objects.AdvertiserPageObjects;
import com.Vizibl.objects.AwaitingApprovalPageObjects;
import com.Vizibl.objects.ChangePasswordObjects;
import com.Vizibl.objects.CommonObjects;
import com.Vizibl.objects.CreateAdvertiserObjects;
import com.Vizibl.objects.ForgetPasswordObjects;
import com.Vizibl.objects.HomePageObjects;
import com.Vizibl.objects.LoginpageObjects;
import com.Vizibl.objects.MainPageObjects;
import com.Vizibl.objects.RegistrationObjects;

public class BaseClass {

	protected static WebDriver driver = null;
	protected static LoginpageObjects loginpageObjects = null;
	protected static ForgetPasswordObjects forgotpasswordObjects = null;
	protected static HomePageObjects homepageObjectes = null;
	protected static MainPageObjects mainpageObjects = null;
	protected static ChangePasswordObjects changepasswordObjects = null;
	protected static RegistrationObjects registrationObjects = null;
	protected static CreateAdvertiserObjects createAdvertiserObjects = null;
	protected static CommonObjects commonObjects = null;
	protected static AwaitingApprovalPageObjects awaitingApprovalPageObjects = null;
	protected static AdvertiserPageObjects advertiserPageObjects = null;
	protected static Actions actions = null;

	public void getbrowser() throws InterruptedException {

		if (Constants.browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", Constants.chromePath);
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--start-maximized");
			driver = new ChromeDriver(chromeOptions);
		} else if (Constants.browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", Constants.geckoPath + "geckodriver");
			// driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		driver.get(Constants.url);
		Thread.sleep(500);
		loginpageObjects = new LoginpageObjects(driver);
		forgotpasswordObjects = new ForgetPasswordObjects(driver);
		homepageObjectes = new HomePageObjects(driver);
		mainpageObjects = new MainPageObjects(driver);
		changepasswordObjects = new ChangePasswordObjects(driver);
		registrationObjects = new RegistrationObjects(driver);
		createAdvertiserObjects = new CreateAdvertiserObjects(driver);
		commonObjects = new CommonObjects(driver);
		awaitingApprovalPageObjects = new AwaitingApprovalPageObjects(driver);
		advertiserPageObjects = new AdvertiserPageObjects(driver);
		actions = new Actions(getwebdriver());

	}

	public WebDriver getwebdriver() {
		return driver;
	}

	public void quit() throws Exception {
		driver.quit();
		Thread.sleep(2000);
	}

}
