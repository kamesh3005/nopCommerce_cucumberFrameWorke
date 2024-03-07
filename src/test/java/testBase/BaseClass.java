package testBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {

	public static void selectclass(WebElement ele, String value) {
		Select sc = new Select(ele);
		sc.selectByVisibleText(value);

	}

}
