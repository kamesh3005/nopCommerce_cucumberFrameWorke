package stepDefinition;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import pageObject.LoginPage;
import pageObject.RegistationPage;
import utilities.DataReader;

public class LoginSteps {

	public WebDriver driver;
	public Logger logger;
	public ResourceBundle rb;
	public String br;
	public LoginPage lp;
	RegistationPage rp;
	List<HashMap<String, String>> datamap;

	@Before
	public void setup() {
		logger = LogManager.getLogger(this.getClass());
		rb = ResourceBundle.getBundle("config");
		br = rb.getString("browser");

	}

	@After
	public void tearDown(Scenario scenario) {
		System.out.println("Scenario status==============>" + scenario.getStatus());
		if (scenario.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
		driver.quit();
	}

	@Given("user launch browser")
	public void user_launch_browser() {

		if (br.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (br.equals("firfox")) {
			driver = new FirefoxDriver();
		} else {

			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@Given("open url {string}")
	public void open_url(String url) {
		driver.get(url);
		driver.manage().window().maximize();

	}

	@When("click to login menu")
	public void click_to_login_menu() {

		lp = new LoginPage(driver);
		lp.clickLoginlink();
		logger.info("***click on login link***");

	}

	@When("user enter email as {string} and password as {string}")
	public void user_enter_email_as_and_password_as(String email, String pwd) {
		lp = new LoginPage(driver);
		lp.setUsername(email);
		logger.info("***provided user name***");
		lp.setPassword(pwd);
		logger.info("***provided password***");

	}

	@When("click on login button")
	public void click_on_login_button() {
		lp = new LoginPage(driver);
		lp.clickLoginButton();
		logger.info("***click on login button***");

	}

	@Then("user navigate to my accout page")
	public void user_navigate_to_my_accout_page() {
		lp = new LoginPage(driver);
		boolean myaccoutLinkDisplay = lp.myaccoutLinkDisplay();
		Assert.assertTrue(myaccoutLinkDisplay);
		logger.info("***Test completed***");

	}

	// **************Registration Test***************************

	@When("click on register link")
	public void click_on_register_link() {
		rp = new RegistationPage(driver);
		rp.clcikRegistationLink();

	}

	@When("click on toggle gender")
	public void click_on_toggle_gender() {
		rp = new RegistationPage(driver);
		rp.clickGender();

	}

	@When("enetr the first name and last name")
	public void enetr_the_first_name_and_last_name() {
		rp = new RegistationPage(driver);
		rp.sendNames("charu", "mathi");

	}

	@When("Select the data of birth")
	public void select_the_data_of_birth() {
		rp = new RegistationPage(driver);
		rp.setDataofBirth();

	}

	@When("enter the email id")
	public void enter_the_email_id() {
		rp = new RegistationPage(driver);
		rp.setEmailId("charumathi@gmail.com");

	}

	@When("enter the company name")
	public void enter_the_company_name() {
		rp = new RegistationPage(driver);

		rp.setCompanyname("Infosys");
	}

	@When("enter password and conform password")
	public void enter_password_and_conform_password() {
		rp = new RegistationPage(driver);
		rp.setPasswords("Kamesh@30", "Kamesh@30");

	}

	@Then("click registation button")
	public void click_registation_button() {
		rp = new RegistationPage(driver);
		rp.clickRegistation();

	}

	// asLists DataTable
	@When("user enter emailand password")
	public void user_enter_emailand_password(DataTable dataTable) {

		List<List<String>> data = dataTable.asLists();
		lp = new LoginPage(driver);
		lp.setUsername(data.get(0).get(0));
		lp.setPassword(data.get(0).get(1));

	}

	// ***********Data Driven test using excel********************

	@Then("cheek user has navigates to MyAccount page by passing Email and Password with excel row {string}")
	public void cheek_user_has_navigates_to_my_account_page_by_passing_email_and_password_with_excel_row(String row) {

		datamap = DataReader.data(System.getProperty("user.dir") + "/testData/OpenCartLoginData.xlsx", "Sheet1");
		int index = Integer.parseInt(row) - 1;
		String email = datamap.get(index).get("UserName");
		String pwd = datamap.get(index).get("Password");
		String exp_res = datamap.get(index).get("Res");
		lp = new LoginPage(driver);
		lp.setUsername(email);
		lp.setPassword(pwd);
		lp.clickLoginButton();
		try {

			boolean targetPage = lp.myaccoutLinkDisplay();
			if (exp_res.equals("Valid")) {

				if (targetPage == true) {

					lp.clickLogout();
					Assert.assertTrue(true);

				} else {

					Assert.assertTrue(false);

				}
			}

			if (exp_res.equals("Invalid")) {
				if (targetPage == true) {
					lp.clickLogout();
					Assert.assertTrue(false);

				} else {

					Assert.assertTrue(true);

				}
			}

		} catch (Exception e) {
			Assert.assertTrue(false);

		}

	}

}
