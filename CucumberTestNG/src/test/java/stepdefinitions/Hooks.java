package stepdefinitions;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.Before;

public class Hooks {
	
	@Before
	public static void setUp(Scenario scenario) {
		System.out.println("Inside @Before hooks");
	}

}
