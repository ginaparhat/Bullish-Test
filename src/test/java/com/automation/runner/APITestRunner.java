package com.automation.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


/**
 * Runner class to run different scenarios based on tags
 * 
 * @author Guligeinap
 */
@RunWith(Cucumber.class)
@CucumberOptions(
			features = {"src//test//resources//features//"},
			glue = "com.automation.stepdef",
			tags = "@api",
			plugin = {"html:report/report.html","json:target/cucumber.json"}
		)
public class APITestRunner {

}
