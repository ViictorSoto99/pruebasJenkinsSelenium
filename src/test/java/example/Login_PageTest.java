package example;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import browser.Browser;

public class Login_PageTest {
	static WebDriver driver;
	static int numTestEjecLogin = 0;
	
	@DataProvider(name = "Authentication")
	public static Object[][] data() {
		ArrayList<String> data = new ArrayList<String>();
		int j = 2;
		for (int i = 1; i < j; i++) {
			String fila = utils.Read_Excel.dataLogin(0, i, 0);
			j++;
			if (!fila.equals("")) {
				data.add("" + i);
			} else {
				j = 0;
			}
		}
		
		Object[][] dataObject = new Object[data.size()][1];

		for (int i = 0; i < data.size(); i++){
			dataObject[i][0] = data.get(i);
		}
		return dataObject;
	}

	@BeforeClass
	public static void start() {			
		driver = Browser.browser();
		driver.manage().window().maximize();
		driver.get("https://vaxtpmde69.proteccion.com.co/wps/portal/proteccion");
	}

	@BeforeMethod
	public void home() {
		numTestEjecLogin++;
		driver.navigate().refresh();
		Assert.assertTrue(driver.findElements(By.linkText("Zona transaccional")).size() > 0, "No estas en el sitio web de protección");
	}

	@Test(dataProvider = "Authentication")
	public void loginTest(String fila) {
		System.out.println("-----------------------------------------Test: " + fila);
	}

	@AfterMethod
	public void sign_off() {
		driver.navigate().refresh();
	}

	@AfterClass
	public static void end() {
		driver.close();
	}
}
