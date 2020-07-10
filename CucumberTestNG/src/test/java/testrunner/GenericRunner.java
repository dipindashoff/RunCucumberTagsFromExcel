package testrunner;

import custom.runners.CustomAbstractTestNGCucumberTests;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/Features"},
		glue = {"stepdefinitions"},
		dryRun = false,
		monochrome = true,
		plugin = {"pretty","json:target/genericrunner.json"}
		//tags = {"@regression"}
		)
public class GenericRunner extends CustomAbstractTestNGCucumberTests {

}

//public class NewTest {
//  @Test
//  public void f() {
//  }
//}
