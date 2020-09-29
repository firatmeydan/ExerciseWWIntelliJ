package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import utils.AppConstants;
import utils.ElementUtils;

public class HomePage {

	WebDriver driver;
	ElementUtils elementsUtil;

	By popUp = By.xpath("(//*[@class='Icon_icon__wrapper__3dIsp'])[20]");
	By findWorkshop = By.xpath("(//*[@class='MenuItem_menu-item__inner-wrapper__1trJ0'])[5]");

	public HomePage(WebDriver driver, ElementUtils elementUtils) {
		this.driver = driver;
		this.elementsUtil = elementUtils;
	}

	public void verifyTitle() {

		String actualTitle = elementsUtil.getPageTitle(driver);
		Assert.assertEquals(actualTitle, AppConstants.HOMEPAGE_TITLE);

	}

	public void closePopUp() {

		elementsUtil.clickOn(driver, popUp);

	}

	public void clickOnWorkshop() {

		elementsUtil.clickOn(driver, findWorkshop);

	}

}
