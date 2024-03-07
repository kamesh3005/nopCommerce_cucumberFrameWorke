package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		//features = {"./Features/login.feature"},
		//features = "@target/rerun.txt",
		features = {"./Features/Registation.feature"},

		glue = {"stepDefinition"},
		plugin = {	"pretty","html:reports/myreport.html"
				,"json:reports/myreport.json",
				"rerun:target/rerun.txt"},
		monochrome = true,
		dryRun = false,
		publish = true
		//tags = "@sanity"
				
		
		
		                   
		)


public class TestRunner {
	
	

}
