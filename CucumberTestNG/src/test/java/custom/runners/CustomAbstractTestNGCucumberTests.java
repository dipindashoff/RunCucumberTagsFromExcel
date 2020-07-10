package custom.runners;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.CucumberFeatureWrapper;
import io.cucumber.testng.PickleEventWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

public class CustomAbstractTestNGCucumberTests {
	private TestNGCucumberRunner testNGCucumberRunner;

	@BeforeClass(alwaysRun = true)
	public void setUpClass() {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}

	@Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
	public void runScenario(PickleEventWrapper pickleWrapper, CucumberFeatureWrapper featureWrapper) throws Throwable {
		// the 'featureWrapper' parameter solely exists to display the feature file in a
		// test report
		testNGCucumberRunner.runScenario(pickleWrapper.getPickleEvent());
	}

	/**
	 * Returns two dimensional array of PickleEventWrapper scenarios with their
	 * associated CucumberFeatureWrapper feature.
	 *
	 * @return a two dimensional array of scenarios features.
	 */
	@DataProvider
	public Iterator<Object[]> scenarios() {
		ArrayList<Object[]> modifiedList = new ArrayList<>();
		if (testNGCucumberRunner == null) {
//			return new Object[0][0];
			return modifiedList.iterator();
		}
		// I added
//		Object[][] data = testNGCucumberRunner.provideScenarios();
//		
//		PickleEventWrapper pickleEventWrapper = (PickleEventWrapper) data[0][0];
//		CucumberFeatureWrapper cucumberFeatureWrapper = (CucumberFeatureWrapper) data[0][1];
		modifiedList = filterTheFeature(testNGCucumberRunner.provideScenarios());
//		return testNGCucumberRunner.provideScenarios();
		return modifiedList.iterator();
	}

	// data[0][0] ->> PickleEventWrapper -->Scenario
	// data[0][1] ->> CucumberFeatureWrapper -->Feature

	/**
	 * private method that will return an array list - contains the feature I want
	 * to execute
	 * 
	 * @return
	 */
	private ArrayList<Object[]> filterTheFeature(Object[][] data) {

		String featureValue = System.getProperty("FeatureName"); // perform pom.xml config settings changes

		if (featureValue == null || featureValue.isEmpty()) {
			return getFeatureList(data);
		}

		List<String> feaureList = Arrays.asList(featureValue.split(","));
//		List<String> feaureList  = Arrays.asList("Feature called test", "Feature called sample");
		ArrayList<Object[]> modifiedList = new ArrayList<>();

		if (data != null) {
			for (int i = 0; i < data.length; i++) {
				CucumberFeatureWrapper cucumberFeatureWrapper = (CucumberFeatureWrapper) data[i][1];

				if (feaureList.contains(cucumberFeatureWrapper.toString().trim().replaceAll("\"", ""))) {
					modifiedList.add(data[i]);
				}
			}
		}

		return modifiedList;
	}

	/**
	 * Returns a list of Object[]
	 * Copy contents from data[] to an ArrayList<Object[]>
	 * Used when VM args are not passed i.e no filter of features.
	 */
	private ArrayList<Object[]> getFeatureList(Object[][] data) {
		ArrayList<Object[]> modifiedList = new ArrayList<>();

		if (data != null) {
			for (int i = 0; i < data.length; i++) {
				modifiedList.add(data[i]);
			}
		}

		return modifiedList;
	}

	@AfterClass(alwaysRun = true)
	public void tearDownClass() {
		if (testNGCucumberRunner == null) {
			return;
		}
		testNGCucumberRunner.finish();
	}

}
