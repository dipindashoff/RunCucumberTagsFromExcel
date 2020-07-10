package testrunner;

import custom.runners.CustomAbstractTestNGCucumberTestsWithTag;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/Features"},
		glue = {"stepdefinitions"},
		dryRun = false,
		monochrome = true,
		plugin = {"pretty","json:target/genericrunner.json"}
		//tags = {"@regression"}
		)
public class GenericRunnerWithTags extends CustomAbstractTestNGCucumberTestsWithTag {

}

//public class NewTest {
//  @Test
//  public void f() {
//  }
//}
