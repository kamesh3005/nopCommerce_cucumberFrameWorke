package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClass;

public class RegistationPage extends BasePage {

	public RegistationPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//a[@class='ico-register']")
	WebElement link_registation;
	@FindBy(id = "gender-male")
	WebElement mailButton;
	@FindBy(id = "FirstName")
	WebElement firstName;
	@FindBy(id = "LastName")
	WebElement lastname;
	@FindBy(xpath = "//select[@name='DateOfBirthDay']")
	WebElement day;
	@FindBy(xpath = "//select[@name='DateOfBirthMonth']")
	WebElement month;
	@FindBy(xpath = "//select[@name='DateOfBirthYear']")
	WebElement year;
	@FindBy(id = "Email")
	WebElement emailId;
	@FindBy(id = "Company")
	WebElement companyName;
	@FindBy(id = "Password")
	WebElement pass;
	@FindBy(id = "ConfirmPassword")
	WebElement conformPass;
	@FindBy(id = "register-button")
	WebElement registerButton;

	public void clcikRegistationLink() {

		link_registation.click();
	}

	public void clickGender() {
		mailButton.click();

	}

	public void sendNames(String name1, String name2) {

		firstName.sendKeys(name1);
		lastname.sendKeys(name2);
	}

	public void setDataofBirth() {
		BaseClass.selectclass(day, "30");
		BaseClass.selectclass(month, "May");
		BaseClass.selectclass(year, "1994");

	}

	public void setEmailId(String email) {
		emailId.sendKeys(email);

	}

	public void setCompanyname(String compName) {

		companyName.sendKeys(compName);
	}

	public void setPasswords(String pass1, String pass2) {

		pass.sendKeys(pass1);
		conformPass.sendKeys(pass2);
	}

	public void clickRegistation() {

		registerButton.click();
	}

}
