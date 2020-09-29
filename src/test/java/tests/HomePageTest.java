package tests;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BasePage;
import pages.HomePage;
import utils.ElementUtils;

public class HomePageTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	ElementUtils elementUtils;
	HomePage homepage;

	@BeforeTest
	public void setUp() {

		basePage = new BasePage();
		prop = basePage.init_properties();
		driver = basePage.init_driver();
		elementUtils = new ElementUtils();
		elementUtils.launchURL(driver, prop);
		homepage = new HomePage(driver, elementUtils);

	}

	@Test(priority = 1, description = "Verify homepage title and click on 'Find a Workshop'")
	public void homePage1() {
		homepage.verifyTitle();
		// homepage.closePopUp();
		homepage.clickOnWorkshop();

	}

	@AfterTest
	public void tearDown() {
		elementUtils.quitBrowser(driver);
	}

}
