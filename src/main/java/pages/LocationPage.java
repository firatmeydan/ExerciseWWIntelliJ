package pages;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.ElementUtils;

public class LocationPage extends WorkshopPage {
	WebDriver driver;
	ElementUtils elementUtils;
	Properties prop;

	By firstResult = By.xpath("(//*[@class='linkUnderline-1_h4g'])[1]");
	DayOfWeek date= LocalDate.now().getDayOfWeek();
	String today=(date.getDisplayName(TextStyle.SHORT, Locale.ENGLISH)).toUpperCase();
	String xpath="(//*[contains(text(), '" + today + "')]/parent::div)//*[@class='meetingTime-1g52A']";
	By hours = By.xpath(xpath);
	By namesOfPeople = By.xpath("((//*[@class='day-NhBOb'])[2]//span[2])");

	public LocationPage(WebDriver driver, ElementUtils elementUtils, Properties prop) {
		super(driver, elementUtils, prop);
		this.driver = driver;
		this.elementUtils = elementUtils;
		this.prop = prop;
	}

	public void printHoursOfOperation() {

		try {
			List<WebElement> list = driver.findElements(hours);

			System.out.println("Today's (" + today + ") Hours of Operations\n-------------------------------------");

			for (WebElement webElement : list) {
				System.out.println(webElement.getText());
			}
		} catch (Exception e) {

			System.err.println("There is a problem with LocationPage printHoursOfOperation method!");
		}

	}

	public void numberOfMeetingsPerPerson() {

		try {
			List<WebElement> list = driver.findElements(namesOfPeople);

			String[] names = new String[list.size()];

			int a = 0;

			for (WebElement webElement : list) {
				names[a] = webElement.getText();
				a++;
			}

			int n = names.length;

			Map<String, Integer> map = new HashMap<String, Integer>();

			for (int i = 0; i < n; i++) {
				map.put(names[i], map.get(names[i]) == null ? 1 : map.get(names[i]) + 1);
			}

			System.out.println(
					"\nName of each person and the number of his/her meeting on MON\n-------------------------------");
			for (int i = 0; i < n; i++) {
				
				if (map.get(names[i]) != -1) {
					
					System.out.println(names[i] + " " + map.get(names[i]));
					
					map.put(names[i], -1);
				}
			}
			System.out.println("\n*************** END ******************");
		} catch (Exception e) {

			System.err.println("There is aproblem with LocationPage numberOfMeetingPerPerson method!");
		}

	}

	public void handleWorkshopPage() {
		try {
			handleHomePage();
			enterZipCode();
			clickOnFirstResult();
		} catch (Exception e) {

			System.err.println("There is a problem with LocationPage handleWorkshopPage method!");
		}
	}

}
