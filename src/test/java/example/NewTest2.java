package example;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterTest;

public class NewTest2 {
	@DataProvider(name = "Authentication")

	public static Object[][] credentials() {
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

	@Test(dataProvider = "Authentication")
	public void test(String sUsername) {
		System.out.println("@Test1: " + sUsername + ", ");
	}

	@Test
	public void f1() {
		System.out.println("@Test2");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("@BeforeMethod");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("@AfterMethod");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("@BeforeClass");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("@AfterClass");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("@BeforeTest");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("@AfterTest");
	}

}
