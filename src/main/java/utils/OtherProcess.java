package utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OtherProcess {

	// public static void main(String[] args) {}

	static TakeCapture cp = new TakeCapture();

	public static void clickTransacciones(WebDriver driver) {
		driver.findElement(By.linkText("Protección - Fondo de Pensiones y Cesantías en Colombia")).click();
		if (driver.findElements(By.cssSelector(".lightBox__closeAction")).size() > 0) {
			driver.findElement(By.cssSelector(".lightBox__closeAction")).click();
		}
		driver.findElement(By.linkText("Ir a transacciones")).click();
	}

	public static boolean verificaServicio(WebDriver driver) {
		if (driver.findElements(By.cssSelector(".wpthemeControlBody.wpthemeClear")).size() > 0) {
			driver.findElement(By.cssSelector(".wpthemeControlBody.wpthemeClear")).getText()
					.equals("Este portlet no está disponible.");
			return false;
		} else {
			return driver.findElements(By.linkText("Volver a intentar")).size() == 0;
		}
	}

	public void cerrarMsj(WebDriver driver, String proceso, String module) {
		if (driver.findElements(By.cssSelector("div.div-confirm-btnaceptar")).size() > 0) {
			cp.capturarPantalla(proceso, module);
			driver.findElement(By.cssSelector("div.div-confirm-btnaceptar")).click();
		}
	}

	public String generateXPATH(WebElement childElement, String current) {
		String childTag = childElement.getTagName();
		if (childTag.equals("html")) {
			return "/html[1]" + current;
		}
		WebElement parentElement = childElement.findElement(By.xpath(".."));
		List<WebElement> childrenElements = parentElement.findElements(By.xpath("*"));
		int count = 0;
		for (int i = 0; i < childrenElements.size(); i++) {
			WebElement childrenElement = childrenElements.get(i);
			String childrenElementTag = childrenElement.getTagName();
			if (childTag.equals(childrenElementTag)) {
				count++;
			}
			if (childElement.equals(childrenElement)) {
				return generateXPATH(parentElement, "/" + childTag + "[" + count + "]" + current);
			}
		}
		return null;
	}

}
