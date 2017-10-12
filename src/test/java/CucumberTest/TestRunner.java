package CucumberTest;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features={"Features/00-Login.feature"}	
		,glue={"StepDefinition"}
		,tags={"@Failed_Login"}
		,dryRun= true
		)
public class TestRunner {

}
