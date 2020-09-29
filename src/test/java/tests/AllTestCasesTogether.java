package tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BasePage;
import pages.HomePage;
import pages.LocationPage;
import pages.WorkshopPage;
import utils.ElementUtils;

public class AllTestCasesTogether {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	ElementUtils elementUtils;
	HomePage homepage;
	WorkshopPage workshopPage;
	LocationPage locationPage;

	@BeforeTest
	public void setUp() {

		basePage = new BasePage();
		prop = basePage.init_properties();

		driver = basePage.init_driver();

		elementUtils = new ElementUtils();
		elementUtils.launchURL(driver, prop);
		homepage = new HomePage(driver, elementUtils);
		workshopPage = new WorkshopPage(driver, elementUtils, prop);
		locationPage = new LocationPage(driver, elementUtils,prop);

	}

	@Test(priority = 1, description = "Verify homepage title and click on 'Find a Workshop'")
	public void homePage1() {
		homepage.verifyTitle();
		// homepage.closePopUp();
		homepage.clickOnWorkshop();

	}

	@Test(priority = 2, description = "Verify title of second page")
	public void workshopPage1() {

		workshopPage.verifyWorkshopPageTitle();

	}

	@Test(priority = 3, description = "enter the zipcode, submit it, print the first result \n	and click on the first result")
	public void workshopPage2() {

		workshopPage.enterZipCode();
		workshopPage.printTitleOfFirstResultAndDistance();

	}

	@Test(priority = 4, description = "Verify the title of the first searched result")
	public void workshop3() {
		workshopPage.clickOnFirstResult();
		workshopPage.verifyTitleOfFirstResult();
	}

	@Test(priority = 5, description = "Printing today's hours of operation")
	public void location1() {
		locationPage.printHoursOfOperation();
	}
	
	@Test(priority=6, description="Printing names and number of meeting each person has")
	public void location2() {
		locationPage.numberOfMeetingsPerPerson();
	}

	@AfterTest
	public void tearDown() {
		elementUtils.quitBrowser(driver);
	}

}
