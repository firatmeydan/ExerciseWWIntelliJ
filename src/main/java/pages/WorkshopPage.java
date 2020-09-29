package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import utils.AppConstants;
import utils.ElementUtils;

public class WorkshopPage extends HomePage {

	WebDriver driver;
	ElementUtils elementUtils;
	Properties prop;

	String nameFirstResult;
	String nameDisplayedResult;
	String distanceFirstResult;

	By searchBox = By.id("location-search");
	By submitZip = By.id("location-search-cta");
	By distance = By.xpath("(//*[@class='distance-OhP63'])[1]");
	By firstResult = By.xpath("(//*[@class='linkUnderline-1_h4g'])[1]");
	By displayedResult = By.className("locationName-1jro_");

	public WorkshopPage(WebDriver driver, ElementUtils elementUtils, Properties prop) {
		super(driver, elementUtils);
		this.driver = driver;
		this.elementUtils = elementUtils;
		this.prop = prop;
	}

	public void verifyWorkshopPageTitle() {
		
			String actualTitle = elementUtils.getPageTitleWithWait(driver, AppConstants.WORKSHOPSPAGE_TITLE);
			Assert.assertEquals(actualTitle, AppConstants.WORKSHOPSPAGE_TITLE);
		
	}

	public void enterZipCode() {

		elementUtils.sendKeysAndSubmit(driver, searchBox, prop.getProperty("zipcode"));

	}

	public void printTitleOfFirstResultAndDistance() {
		nameFirstResult = elementUtils.getTextOfElement(driver, firstResult);
		distanceFirstResult = elementUtils.getTextOfElement(driver, distance);

		System.out.println(
				"\nName and the distance of the first result: " + nameFirstResult + " " + distanceFirstResult + "\n");

	}

	public void clickOnFirstResult() {
		
		elementUtils.clickOn(driver, firstResult);

	}

	public void verifyTitleOfFirstResult() {

		nameDisplayedResult = elementUtils.getTextOfElement(driver, displayedResult);
		Assert.assertEquals(nameFirstResult, nameDisplayedResult);

	}

	public void handleHomePage() {
		clickOnWorkshop();
	}

}
