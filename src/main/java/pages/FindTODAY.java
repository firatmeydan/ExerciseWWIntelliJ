package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.Locale;

public class FindTODAY {

    public static void main(String[] args) {

        WebDriver driver=new ChromeDriver();

        driver.get("https://www.weightwatchers.com/us/find-a-workshop/1180510/ww-studio-flatiron-new-york-ny");

        DayOfWeek date=LocalDate.now().getDayOfWeek();
        String today=(date.getDisplayName(TextStyle.SHORT, Locale.ENGLISH)).toUpperCase();
        String xpath="(//*[contains(text(), '" +
                today +
                "')]/parent::div)//*[@class='meetingTime-1g52A']";

    }
}
