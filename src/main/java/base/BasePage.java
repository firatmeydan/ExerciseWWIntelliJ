package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import utils.ElementUtils;


public class BasePage {
	WebDriver driver;
	Properties prop;
	ElementUtils elementUtils;
	OptionsManager optionsManager;

	public WebDriver init_driver() {
		
		elementUtils = new ElementUtils();
		driver = elementUtils.launchBrowser(optionsManager);
		
		elementUtils.deleteCookies(driver);
		elementUtils.maximize(driver);
		return driver;
	}

	public Properties init_properties() {
		prop = new Properties();
		String path = "./src/main/java/config/config.properties";

		try {
			FileInputStream ip = new FileInputStream(path);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			System.out.println("Some issue with config properties.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;

	}
}
