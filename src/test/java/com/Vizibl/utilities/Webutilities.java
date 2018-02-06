package com.Vizibl.utilities;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class Webutilities extends BaseClass {

	public String getattribute(WebElement element, String value) {
		String data = element.getAttribute(value);
		System.out.println(data);
		return data;
	}

	public void sleep() throws InterruptedException {
		Thread.sleep(3000);
	}

	public void navigate(String url) {
		String a = "window.open('about:blank','_blank');";
		((JavascriptExecutor) driver).executeScript(a);
		driver.navigate().to(url);
	}

	public void waitForPageToLoad() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public String getitle() {
		String Actual = driver.getTitle();
		return Actual;
	}

	public String gettext(WebElement element) {
		element.isDisplayed();
		String text = element.getText().trim();
		return text;

	}

	public void logOut() throws InterruptedException {
		actions.sendKeys(Keys.ESCAPE).build().perform();
		actions.moveToElement(homepageObjectes.getProfileName()).perform();
		actions.doubleClick(homepageObjectes.getLogOut()).perform();
		sleep();

	}

		public void window() throws InterruptedException {

		Set<String> śet = driver.getWindowHandles();
		Iterator<String> it = śet.iterator();
		String parentWindID = it.next();
		String a = "window.open('http://viziblbeta.datawrkz.com/','_blank');";
		((JavascriptExecutor) driver).executeScript(a);
		String data = gettext(commonObjects.getAdvertiser_Tiitle());
		Assert.assertEquals("Advertisers", data);
		driver.switchTo().window(parentWindID);
		System.out.println("exeuted");
	}

	public void login() throws Exception {
		// boolean result = false;
		try {
			click(mainpageObjects.getLogin_button());
			waitUntilVisibile(loginpageObjects.getUserName());
			sendkeys(loginpageObjects.getUserName(), Constants.username2);
			sendkeys(loginpageObjects.getPassWord(), Constants.password2);
			click(loginpageObjects.getRememberme_check());
			click(loginpageObjects.getSignIn_button());
			sleep();
			// result = true;
		} catch (Throwable t) {
			throw new Exception(t.getMessage());

		}
	}

	public void waitUntilVisibile(WebElement element) {
		WebDriverWait webDriverWait = new WebDriverWait(getwebdriver(), 10);
		webDriverWait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitUntilVisibile(List<WebElement> element) {
		WebDriverWait webDriverWait = new WebDriverWait(getwebdriver(), 10);
		webDriverWait.until(ExpectedConditions.visibilityOfAllElements(element));
	}

	public boolean verifyErrorMSg(List<WebElement> elements, String value) {
		String[] values = value.split(",");
		int count = 0;
		System.out.println(values.length);

		for (int j = 0; j < values.length; j++) {

			String excelMessage = values[j].toString().trim();
			System.out.println("excel : " + excelMessage);
			Iterator<WebElement> i = elements.iterator();
			while (i.hasNext()) {
				WebElement webelemen = i.next();
				String data = webelemen.getText().trim();
				if (data.equalsIgnoreCase(excelMessage)) {
					count++;
					System.out.println("actual: " + data);
				}
			}
			if (count == values.length) {
				return true;
			}

		}
		System.out.println("");
		return false;

	}

	public void scrollDown() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)", "");
	}

	public boolean verifyErrorMSg2(List<WebElement> elements, String value) {
		if (value != "") {
			for (WebElement element : elements) {
				System.out.println("result:" + element.getText().toString());
				if (element.getText().equalsIgnoreCase(value)) {
					return true;
				}
			}
		}
		return false;
	}

	public void sendkeys(WebElement element, String value) throws InterruptedException {
		if (value != null && element.isDisplayed()) {
			element.clear();
			element.sendKeys(value.toString());
		} else {
			element.clear();
		}
	}

	public void click(WebElement element) throws InterruptedException {
		try {
			if (element.isDisplayed()) {
				element.click();
			}
		} catch (Exception e) {
			Thread.sleep(1000);
			element.click();
		}
	}

	public boolean Isdisplayed(WebElement element) throws InterruptedException {
		try {
			if (element.isDisplayed()) {
				return true;
			}
		} catch (Exception e) {
			Thread.sleep(1000);
			e.printStackTrace();

		}
		return false;
	}

	public boolean isCheckBoxSelected(WebElement element) {
		try {
			if (element.isDisplayed()
					&& element.getAttribute("class").trim().equalsIgnoreCase("checkboxCustom checkedCustom")) {
				return true;
			} else if (element.isDisplayed()
					&& element.getAttribute("class").trim().equalsIgnoreCase("checkboxCustom")) {
				return false;
			}
		} catch (NoSuchElementException n) {
			n.printStackTrace();
		}
		return false;
	}

	public void IgnoreUnwantedPopups() {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
	}

	public String AlertHandling() {
		Alert alert = driver.switchTo().alert();
		String message = alert.getText();
		System.out.println("Pop up is" + message);
		alert.accept();
		return message;
	}

	public void selectByVisibleText(WebElement element, String text) {
		try {
			if (text != "" && element.isDisplayed()) {
				Select select = new Select(element);
				select.selectByVisibleText(text);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean verifyFieldValue(WebElement element) {
		if (element.getAttribute("value").equalsIgnoreCase("")) {
			return true;
		}
		return false;
	}

	public void refresh() {
		driver.navigate().refresh();
	}

	public void click(List<WebElement> elements, String value) {

		try {
			for (WebElement element : elements) {
				if (element.getAttribute("title").equalsIgnoreCase(value)) {
					element.click();
				}
			}
			Reporter.log("No such kind of mails" + value);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void selectingClient(List<WebElement> elements, String value, List<WebElement> elements2) {

		try {
			for (int i = 0; i < elements.size(); i++) {
				System.out.println(elements.get(i).getText());
				if (elements.get(i).getText().equalsIgnoreCase(value)) {

					elements2.get(i).click();
					System.out.println(i);
					break;
				}
			}
			Reporter.log("No such kind of Advertiser" + value);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void selectingClient2(List<WebElement> elements, String value) {
		for (int i = 0; i < elements.size(); i++) {
			try {
				if (elements.get(i).getText().equalsIgnoreCase(value)) {
					// String status=elements2.get(i).getAttribute("title");
					System.out.println("user existed in list");
					break;
				}
			} catch (Exception e) {
				System.out.println("no such kind of user");
				e.printStackTrace();
			}
		}
		Reporter.log("No such kind of Advertiser" + value);
	}

	public void selectingclient3(List<WebElement> elements, String value, List<WebElement> elements2) {

		for (int i = 0; i < elements.size(); i++) {

			if (elements.get(i).getText().equalsIgnoreCase(value)) {
				String status = elements2.get(i).getText();
				if (status.equalsIgnoreCase("Read-only")) {
					System.out.println("user status have read only");
				}
				System.out.println("user in list but status different as" + status);
			}
		}
		Reporter.log("No such kind of Advertiser" + value);
	}

	/*
	 * public boolean isDisplayed(WebElement element) { try{
	 * if(element.isDisplayed()) { return true; } return false; }
	 * 
	 * catch (Exception e) { e.printStackTrace(); } return false;
	 * 
	 * }
	 */
}
