package tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.BasePage;
import pages.WorkshopPage;
import utils.ElementUtils;

public class WorkshopPageTest {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	ElementUtils elementUtils;
	WorkshopPage workshopPage;

	@BeforeTest
	public void setUp() {

		basePage = new BasePage();
		prop = basePage.init_properties();
		driver = basePage.init_driver();
		elementUtils = new ElementUtils();
		elementUtils.launchURL(driver, prop);
		workshopPage = new WorkshopPage(driver, elementUtils, prop);
		workshopPage.handleHomePage();

	}
	
	@Test(priority = 1, description = "Verify title of second page")
	public void workshopPage1() {

		workshopPage.verifyWorkshopPageTitle();

	}

	@Test(priority = 2, description = "enter the zipcode, submit it, print the first result \n	and click on the first result")
	public void workshopPage2() {

		workshopPage.enterZipCode();
		workshopPage.printTitleOfFirstResultAndDistance();

	}
	
	@Test(priority = 3, description = "Verify the title of the first searched result")
	public void workshopPage3() {
		workshopPage.clickOnFirstResult();
		workshopPage.verifyTitleOfFirstResult();
	}

	@AfterTest
	public void tearDown() {
		elementUtils.quitBrowser(driver);
	}
	
}
