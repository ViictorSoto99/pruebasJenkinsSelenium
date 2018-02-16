package example;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class NewTest {
	private WebDriver driver;

	@Test
	public void testEasy1() {
		driver.get("http://demo.guru99.com/test/guru99home/");
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("Demo Guru99 Page"));
	}
	
	@Test
	public void testEasy2() {
		driver.get("http://demo.guru99.com/test/guru99home/");
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("123123"), "mal1");
	}
	
	@Test
	public void testEasy3() {
		driver.get("http://demo.guru99.com/test/guru99home/");
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("Demo Guru99 Page"));
	}
	
	@Test
	public void testEasy4() {
		driver.get("http://demo.guru99.com/test/guru99home/");
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("123123"), "mal2");
	}
	
	@Test
	public void testEasy5() {
		driver.get("http://demo.guru99.com/test/guru99home/");
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("Demo Guru99 Page"));
	}
	
	@Test
	public void testEasy6() {
		driver.get("http://demo.guru99.com/test/guru99home/");
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("123213"), "mal3");
	}

	@BeforeClass
	public void beforeTest() {
		driver = browser.Browser.browser();
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}