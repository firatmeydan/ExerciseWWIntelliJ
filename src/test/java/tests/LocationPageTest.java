package tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BasePage;
import pages.LocationPage;
import utils.ElementUtils;

public class LocationPageTest {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	ElementUtils elementUtils;
	LocationPage locationPage;

	@BeforeTest
	public void setUp() {

		basePage = new BasePage();
		prop = basePage.init_properties();
		driver = basePage.init_driver();
		elementUtils = new ElementUtils();
		elementUtils.launchURL(driver, prop);
		locationPage = new LocationPage(driver, elementUtils,prop);
		locationPage.handleWorkshopPage();

	}
	
	@Test(priority = 1, description = "Printing today's hours of operation")
	public void location1() {
		locationPage.printHoursOfOperation();
	}
	
	@Test(priority=2, description="Printing names and number of meeting each person has")
	public void location2() {
		locationPage.numberOfMeetingsPerPerson();
	}

	@AfterTest
	public void tearDown() {
		elementUtils.quitBrowser(driver);
	}

}
