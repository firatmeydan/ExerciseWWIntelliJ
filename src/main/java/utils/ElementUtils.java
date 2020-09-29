package utils;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;
import base.OptionsManager;

public class ElementUtils {
	public WebDriver driver;
	Properties prop;
	BasePage basePage;
	WebDriverWait wait;
	WebElement element;

	public ElementUtils() {

		basePage = new BasePage();
		prop = basePage.init_properties();

	}

	public WebDriver launchBrowser(OptionsManager optionsManager) {
		optionsManager = new OptionsManager(prop);
		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver(optionsManager.getChromeOptions());
		} else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver(optionsManager.getFirefoxOptions());
		} else if (prop.getProperty("browser").equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		} else {
			System.out.println("A problem with the browser!!!");
		}
		deleteCookies(driver);
		maximize(driver);
		return driver;

	}

	public void deleteCookies(WebDriver driver) {
		driver.manage().deleteAllCookies();
	}

	public void launchURL(WebDriver driver, Properties prop) {
		try {
			driver.get(prop.getProperty("url"));
		} catch (Exception e) {

			System.out.println("A problem with URL!!!");
		}
	}

	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 *
	 * @param driver
	 * @return
	 */
	public String getPageTitle(WebDriver driver) {

		String title = null;

		title = driver.getTitle();
		System.out.println("\nPage title is: " + title + "\n");

		return title;
	}

	public String getPageTitleWithWait(WebDriver driver, String pageTitle) {

		String title = null;

		explicitWaitForTitle(driver, AppConstants.DEFAULT_TIMEOUT, pageTitle);

		title = driver.getTitle();
		System.out.println("Page title is: " + title);

		return title;
	}

	/**
	 * This method clicks on elements.
	 * 
	 * @param driver
	 * @param locator
	 */
	public void clickOn(WebDriver driver, By locator) {

		explicitWaitPresenceOfElement(driver, locator, AppConstants.DEFAULT_TIMEOUT);
		WebElement element = driver.findElement(locator);

		// element.click();
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);

	}

	/**
	 * This method sends keys to elements.
	 * 
	 * @param driver
	 * @param locator
	 * @param key
	 */
	public void sendKeys(WebDriver driver, By locator, String key) {

		explicitWaitPresenceOfElement(driver, locator, AppConstants.DEFAULT_TIMEOUT);
		driver.findElement(locator).sendKeys(key);

	}

	public void sendKeysAndSubmit(WebDriver driver, By locator, String key) {

		explicitWaitPresenceOfElement(driver, locator, AppConstants.DEFAULT_TIMEOUT);
		driver.findElement(locator).sendKeys(key);
		driver.findElement(locator).submit();

	}

	/**
	 * This method gets the text of the elements, verifies and returns string.
	 * 
	 * @param driver
	 * @param locator
	 * @param verifyText
	 * @return
	 */

	public String getTextOfElement(WebDriver driver, By locator) {

		String textOfElement = null;

		explicitWaitPresenceOfElement(driver, locator, AppConstants.DEFAULT_TIMEOUT);
		textOfElement = driver.findElement(locator).getText();

		return textOfElement;
	}

	public WebElement getElement(WebDriver driver, By locator) {
		WebElement element = null;

		element = driver.findElement(locator);

		return element;
	}

	public void quitBrowser(WebDriver driver) {
		try {
			driver.quit();
		} catch (Exception e) {

			System.out.println("A problem with quitting the browser");
		}
	}

	public void implicitWait(WebDriver driver, long second) {
		driver.manage().timeouts().implicitlyWait(second, TimeUnit.SECONDS);
	}

	public void explicitWaitPresenceOfElement(WebDriver driver, By locator, long second) {
		WebDriverWait wait = new WebDriverWait(driver, second);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void explicitWaitTextToBePresentInElement(WebDriver driver, By locator, long second, String textOfElement) {

		WebDriverWait wait = new WebDriverWait(driver, second);
		wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(locator), textOfElement));
	}

	public void explicitWaitForTitle(WebDriver driver, long second, String title) {

		WebDriverWait wait = new WebDriverWait(driver, second);
		wait.until(ExpectedConditions.titleIs(title));
	}

}
