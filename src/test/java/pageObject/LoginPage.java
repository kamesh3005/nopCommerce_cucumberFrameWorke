package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {

		super(driver);
	}

	@FindBy(xpath = "//a[@class='ico-login']")
	WebElement link_login;
	@FindBy(id = "Email")
	WebElement username;
	@FindBy(id = "Password")
	WebElement password;
	@FindBy(xpath = "//button[normalize-space()='Log in']")
	WebElement login_button;
	@FindBy(xpath = "//a[@class='ico-account']")
	WebElement myAccount_link;
	@FindBy(xpath = "//a[@class='ico-logout']")
	WebElement logOut_link;

	public void clickLoginlink() {

		link_login.click();
	}

	public void setUsername(String uName) {

		username.clear();
		username.sendKeys(uName);
	}

	public void setPassword(String pass) {

		password.clear();
		password.sendKeys(pass);
	}

	public void clickLoginButton() {

		login_button.click();
	}

	public boolean myaccoutLinkDisplay() {

		boolean displayed = myAccount_link.isDisplayed();

		return displayed;
	}

	public void clickLogout() {

		logOut_link.click();
	}

}
