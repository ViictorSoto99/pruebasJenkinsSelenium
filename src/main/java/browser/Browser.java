package browser;

import java.awt.Toolkit;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.Read_Excel;

public class Browser {

	public static WebDriver browser() {
		String navegador = Read_Excel.dataConfiguration(0, 1, 0);
		WebDriver driver = null;

		switch (navegador) {
		case "Chrome":
			driver = chrome();
			break;

		case "MozillaFirefox":
			driver = mozilla();
			break;
		}
		
		int number = Integer.parseInt(Read_Excel.dataConfiguration(0, 1, 2));
		if (number > 1) {
			Point point = new Point(Toolkit.getDefaultToolkit().getScreenSize().width * (number - 1), 0);
			driver.manage().window().setPosition(point);
		}
		
		return driver;
	}

	private static WebDriver chrome() {
		String driverNav = "webdriver.chrome.driver";
		String direcDriver = "utilidades\\driver\\Chrome\\chromedriver.exe";
		System.setProperty(driverNav, direcDriver);

		WebDriver driver = new ChromeDriver();
		return driver;
	}

	private static WebDriver mozilla() {
		String driverNav = "webdriver.gecko.driver";
		String direcDriver = "utilidades\\driver\\Firefox\\geckodriver.exe";
		System.setProperty(driverNav, direcDriver);
		WebDriver driver = new FirefoxDriver();
		return driver;
	}

}
